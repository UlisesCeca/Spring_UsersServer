package com.ulises.usersserver.services;

import com.ulises.usersserver.services.entities.User;
import com.ulises.usersserver.services.exceptions.EmailAlreadyExistsException;
import com.ulises.usersserver.services.exceptions.PhoneAlreadyExistsException;
import com.ulises.usersserver.services.exceptions.UserAlreadyExistsException;
import com.ulises.usersserver.services.exceptions.UserIsEmptyException;
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
    public void register(User user) {
        if(user.getUsername() == null)
            throw new UserIsEmptyException();
        else if(this.userRepository.existsByUsernameAndContext(user.getUsername(), user.getContext().getName()))
            throw new UserAlreadyExistsException();
        else if(user.getEmail() != null &&
                this.userRepository.existsByEmailAndContext(user.getEmail(), user.getContext().getName()))
            throw new EmailAlreadyExistsException();
        else if(user.getPhone() != null &&
                this.userRepository.existsByPhoneAndContext(user.getPhone(), user.getContext().getName()))
            throw new PhoneAlreadyExistsException();
        else
            this.userRepository.insert(user);
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
