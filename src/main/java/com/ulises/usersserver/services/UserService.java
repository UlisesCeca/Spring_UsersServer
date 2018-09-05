package com.ulises.usersserver.services;

import com.ulises.usersserver.services.entities.PasswordRecoveryToken;
import com.ulises.usersserver.services.entities.UserApp;
import com.ulises.usersserver.services.entities.UserWithEmail;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void register(final UserApp userApp);
    void recoverPasswordByEmailStep1(UserWithEmail user);
    void recoverPasswordByEmailStep2(PasswordRecoveryToken passwordRecoveryToken);
}
