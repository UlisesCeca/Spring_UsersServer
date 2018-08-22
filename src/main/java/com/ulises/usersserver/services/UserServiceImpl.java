package com.ulises.usersserver.services;

import com.ulises.usersserver.repositories.PasswordRecoveryTokensRepository;
import com.ulises.usersserver.services.entities.*;
import com.ulises.usersserver.services.exceptions.NoUserWithEmailException;
import com.ulises.usersserver.services.exceptions.UserAlreadyExistsException;
import com.ulises.usersserver.repositories.UserAppRepository;
import com.ulises.usersserver.repositories.UserRepository;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.InternalServerErrorException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import static com.ulises.usersserver.constants.Constants.ENDPOINT_RECOVER_PASSWORD;
import static com.ulises.usersserver.constants.Constants.USERNAME_CONTEXT_KEY;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAppRepository userAppRepository;
    @Autowired
    private PasswordRecoveryTokensRepository passwordRecoveryTokensRepository;
    @Autowired
    private HttpService httpService;

    @Override
    public UserApp register(final UserApp user) {
        if(this.userRepository.existsById(user.getInternalID()))
            throw new UserAlreadyExistsException();
        else
            this.userRepository.insert(user);
        return user;
    }

    @Override
    public void recoverPasswordByEmail(final UserApp user) {
        Email email;
        HttpHeaders headers;
        String body;

        if(!this.userAppRepository.existsByUsernameAndContextAndEmail(user.getUsername(), user.getContext(), user.getEmail()))
            throw new NoUserWithEmailException();

        try {
            body = new String(Files.readAllBytes(Paths.get("assets/passwordrecoveryemail.html")));
        } catch (IOException e) {
            throw new InternalServerErrorException();
        }
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        email = EmailBuilder.builder()
                .to(user.getEmail())
                .from(user.getContext().getName() + " <no-reply@" + user.getContext().getName().toLowerCase() + ".com>")
                .context(user.getContext())
                .body(body
                        .replace("[USERNAME]", user.getUsername())
                        .replace("[CONTEXT]", user.getContext().getName()))
                .subject("Password Recovery - " + user.getContext().getName())
                .build();

        if(!this.httpService.checkStatusIsOK(this.httpService.post(ENDPOINT_RECOVER_PASSWORD, email, headers, null).getStatus()))
            throw new InternalServerErrorException();
        else this.passwordRecoveryTokensRepository.insert(
                PasswordRecoveryTokenBuilder.builder()
                    .username(user.getUsername() + USERNAME_CONTEXT_KEY + user.getContext().getName())
                    .token(Integer.toString(new Random().nextInt((999999 - 100000) + 1) + 100000))
                    .build()
            );
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).get();

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getRole());
    }
}
