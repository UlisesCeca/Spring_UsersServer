package com.ulises.usersserver.services;

import com.ulises.usersserver.services.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void getUser(User user);
}
