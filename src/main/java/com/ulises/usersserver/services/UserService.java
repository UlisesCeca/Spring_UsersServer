package com.ulises.usersserver.services;

import com.ulises.usersserver.services.entities.User;
import com.ulises.usersserver.services.entities.UserApp;
import com.ulises.usersserver.services.exceptions.UserAlreadyExistsException;
import com.ulises.usersserver.services.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static com.ulises.usersserver.constants.Constants.USERNAME_CONTEXT_KEY;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(UserApp user) {
        if(this.userRepository.existsById(user.getInternalID()))
            throw new UserAlreadyExistsException();
        else {
            user.setInternalID();
            user.setPassword(this.passwordEncoder.encode(user.getPassword()));
            this.userRepository.insert(user);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).get() ;

        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getRole());
    }
}
