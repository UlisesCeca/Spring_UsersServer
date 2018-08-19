package com.ulises.usersserver.services;

import com.ulises.usersserver.services.entities.Email;
import com.ulises.usersserver.services.entities.EmailBuilder;
import com.ulises.usersserver.services.entities.User;
import com.ulises.usersserver.services.entities.UserApp;
import com.ulises.usersserver.services.exceptions.NoUserWithEmailException;
import com.ulises.usersserver.services.exceptions.UserAlreadyExistsException;
import com.ulises.usersserver.services.repositories.UserAppRepository;
import com.ulises.usersserver.services.repositories.UserRepository;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.InternalServerErrorException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.ulises.usersserver.constants.Constants.ENDPOINT_RECOVER_PASSWORD;
import static com.ulises.usersserver.constants.Constants.PASSWORD_RECOVERY_EMAIL_BODY;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAppRepository userAppRepository;
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
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).get();

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getRole());
    }
}
