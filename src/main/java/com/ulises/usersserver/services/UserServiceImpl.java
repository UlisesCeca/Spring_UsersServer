package com.ulises.usersserver.services;

import com.ulises.usersserver.repositories.*;
import com.ulises.usersserver.services.entities.*;
import com.ulises.usersserver.services.exceptions.*;
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

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserWithEmailRepository userWithEmailRepository;
    @Autowired
    private PasswordRecoveryTokensRepository passwordRecoveryTokensRepository;
    @Autowired
    private AppRepository appRepository;
    @Autowired
    private ContextsRepository contextsRepository;
    @Autowired
    private HttpService httpService;

    @Override
    public void register(UserWithEmail user) {
        Context context = this.contextsRepository.findById(user.getContext().getName()).orElseThrow(ContextDoesntExistException::new);
        App app = this.appRepository.findById(user.getApp().getName()).orElseThrow(AppDoesntExistException::new);

        user.setApp(app);
        user.setContext(context);

        if(this.userWithEmailRepository.existsById(user.getId()))
            throw new UserAlreadyExistsException();
        else if(this.userWithEmailRepository.existsByContextAndEmail(user.getContext(), user.getEmail()))
            throw new UserWithEmailAlreadyExistsException();
        else this.userWithEmailRepository.insert(user);
    }

    @Override
    public void recoverPasswordByEmail(final UserWithEmail user) {
        Email email;
        HttpHeaders headers;
        String body;

        if(!this.userWithEmailRepository.existsByUsernameAndContextAndEmail(user.getUsername(), user.getContext(), user.getEmail()))
            throw new NoUserWithEmailException();

        try {
            body = new String(Files.readAllBytes(Paths.get("assets/passwordrecoveryemail.html")));
        } catch (IOException e) {
            throw new InternalServerErrorException();
        }
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        email = EmailBuilder.anEmail()
                .withTo(user.getEmail())
                .withFrom(user.getApp().getName() + " <" + user.getApp().getMailDomain() + ">")
                .withContext(user.getContext())
                .withBody(body
                        .replace("[USERNAME]", user.getUsername())
                        .replace("[CONTEXT]", user.getContext().getName()))
                .withSubject("Password Recovery - " + user.getContext().getName())
                .build();

        if(!this.httpService.checkStatusIsOK(this.httpService.post(ENDPOINT_RECOVER_PASSWORD, email, headers, null).getStatus()))
            throw new InternalServerErrorException();
        else this.passwordRecoveryTokensRepository.insert(
                        PasswordRecoveryTokenBuilder.aPasswordRecoveryToken()
                            .withUsername(user.getId())
                            .withToken(Integer.toString(new Random().nextInt((999999 - 100000) + 1) + 100000))
                            .build()
            );
    }

    @Override
    public void recoverPasswordFinal(final PasswordRecoveryToken passwordRecoveryToken) {
        PasswordRecoveryToken token = this.passwordRecoveryTokensRepository.findById(passwordRecoveryToken.getUsername())
                .orElseThrow(TokenExpiredException::new);

        if(token.getToken().equalsIgnoreCase(passwordRecoveryToken.getToken()))
            this.passwordRecoveryTokensRepository.delete(token);
        else
            throw new TokenNotMatchException();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).orElseThrow(UserNotFoundException::new);

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getRole());
    }
}
