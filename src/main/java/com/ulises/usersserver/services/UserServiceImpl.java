package com.ulises.usersserver.services;

import com.ulises.usersserver.repositories.*;
import com.ulises.usersserver.services.entities.*;
import com.ulises.usersserver.services.exceptions.*;
import org.springframework.http.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.InternalServerErrorException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static com.ulises.usersserver.constants.Constants.ENDPOINT_RECOVER_PASSWORD;

@Service
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;
    private final UsersAppRepository usersAppRepository;
    private final UsersWithEmailRepository usersWithEmailRepository;
    private final PasswordRecoveryTokensRepository passwordRecoveryTokensRepository;
    private final HttpService httpService;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImpl(final UsersRepository usersRepository, final UsersWithEmailRepository usersWithEmailRepository,
                           final PasswordRecoveryTokensRepository passwordRecoveryTokensRepository, final HttpService httpService,
                           final AppsRepository appsRepository, final ContextsRepository contextsRepository,
                           final UsersAppRepository usersAppRepository, final PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.usersWithEmailRepository = usersWithEmailRepository;
        this.passwordRecoveryTokensRepository = passwordRecoveryTokensRepository;
        this.httpService = httpService;
        this.usersAppRepository = usersAppRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(final UserApp userApp) {
        if(this.usersAppRepository.existsById(userApp.getId())) throw new UserAlreadyExistsException();
        else if(this.usersAppRepository.existsByContextAndEmail(userApp.getContext(), userApp.getEmail()))
            throw new UserWithEmailAlreadyExistsException();
        else this.usersAppRepository.save(userApp);
    }

    @Override
    public void recoverPasswordByEmailStep1(UserWithEmail user) {
        Email email;
        HttpHeaders headers;
        String body;
        PasswordRecoveryToken passwordRecoveryToken;

        user = this.usersWithEmailRepository.findByUsernameAndContextAndEmail(user.getUsername(), user.getContext(),
                user.getEmail()).orElseThrow(UserNotFoundException::new);
        try {
            body = new String(Files.readAllBytes(Paths.get("assets/passwordrecoveryemail.html")));
        } catch (IOException e) {
            throw new InternalServerErrorException();
        }

        passwordRecoveryToken = this.passwordRecoveryTokensRepository.findByUser(user).orElse(null);
        if(passwordRecoveryToken != null) this.passwordRecoveryTokensRepository.delete(passwordRecoveryToken);
        passwordRecoveryToken = PasswordRecoveryTokenBuilder.aPasswordRecoveryToken()
                .withUser(user)
                .withExpiration(new Date())
                .withToken(new Random().nextInt(2147483646 + 1 - 1000000000) + 1000000000)
                .build();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        email = EmailBuilder.anEmail()
                .withTo(user.getEmail())
                .withFrom(user.getApp().getName() + " <" + user.getApp().getMailDomain() + ">")
                .withContext(user.getContext())
                .withBody(body
                        .replace("[USERNAME]", user.getUsername())
                        .replace("[CONTEXT]", user.getContext().getName())
                        .replace("[TOKEN]", passwordRecoveryToken.getToken().toString()))
                .withSubject("Password Recovery - " + user.getContext().getName())
                .build();

        if (!this.httpService.checkStatusIsOK(this.httpService.post(ENDPOINT_RECOVER_PASSWORD, email, headers, null).getStatus()))
            throw new InternalServerErrorException();
        else this.passwordRecoveryTokensRepository.save(passwordRecoveryToken);
    }

    @Override
    @Transactional
    public void recoverPasswordByEmailStep2(PasswordRecoveryToken passwordRecoveryToken) {
        UserWithEmail userWithEmail = this.usersWithEmailRepository
                .findByUsernameAndContextAndEmail(passwordRecoveryToken.getUser().getUsername(), passwordRecoveryToken.getUser().getContext(),
                        passwordRecoveryToken.getUser().getEmail()).orElseThrow(UserNotFoundException::new);

        passwordRecoveryToken = this.passwordRecoveryTokensRepository.findByTokenAndUser(passwordRecoveryToken.getToken(),
                passwordRecoveryToken.getUser()).orElseThrow(TokenNotMatchException::new);

        this.passwordRecoveryTokensRepository.delete(passwordRecoveryToken);
        if(Duration.between(passwordRecoveryToken.getExpiration().toInstant(), Instant.now()).toMinutes() >= 10)
            throw new TokenExpiredException();
        userWithEmail.setPassword(this.passwordEncoder.encode(passwordRecoveryToken.getUser().getPassword()));
        this.usersWithEmailRepository.save(userWithEmail);
    }


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.usersRepository.findById(username).orElseThrow(UserNotFoundException::new);
        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        for (Role role : user.getRoles()){
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
    }
}
