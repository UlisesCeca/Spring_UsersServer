package com.example.ulises.template.Services;

import com.example.ulises.template.Services.Entities.User;
import com.example.ulises.template.Services.Exceptions.UserNotFoundException;
import com.example.ulises.template.Services.Repositories.UserRepository;
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
