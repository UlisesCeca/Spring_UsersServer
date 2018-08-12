package com.ulises.usersserver.services;

import com.ulises.usersserver.services.entities.User;
import com.ulises.usersserver.services.exceptions.UserNotFoundException;
import com.ulises.usersserver.services.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public void getUser(User user) {

        this.userRepository.insert(User.builder().username("holita").build());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return null;//new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getRole());
    }
}
