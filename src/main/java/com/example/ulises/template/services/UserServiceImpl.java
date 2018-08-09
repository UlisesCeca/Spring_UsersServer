package com.example.ulises.template.services;

import com.example.ulises.template.services.entities.User;
import com.example.ulises.template.services.exceptions.UserNotFoundException;
import com.example.ulises.template.services.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;


    @Override
    public void getUser(User user) {
        if(!this.userRepository.existsById(user.getUsername()))
            throw new UserNotFoundException();
    }
}
