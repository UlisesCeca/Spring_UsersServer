package com.ulises.usersserver.services;

import com.ulises.usersserver.services.entities.User;
import com.ulises.usersserver.services.exceptions.UserNotFoundException;
import com.ulises.usersserver.services.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public void getUser(User user) {
        if(!this.userRepository.existsById(user.getUsername()))
            throw new UserNotFoundException();
    }
}
