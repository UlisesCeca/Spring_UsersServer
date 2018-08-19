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
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.ws.rs.InternalServerErrorException;

import static com.ulises.usersserver.constants.Constants.ENDPOINT_RECOVER_PASSWORD;

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
        int responseCode;

        if(!this.userAppRepository.existsByUsernameAndContextAndEmail(user.getUsername(), user.getContext(), user.getEmail()))
            throw new NoUserWithEmailException();

        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        email = EmailBuilder.builder()
                .to(user.getEmail())
                .from("Ulises Ceca <ulises@ulisesceca.com>")
                .context(user.getContext())
                .body("Prueba")
                .subject("Prueba")
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
