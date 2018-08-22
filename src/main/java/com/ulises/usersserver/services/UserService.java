package com.ulises.usersserver.services;

import com.ulises.usersserver.services.entities.PasswordRecoveryToken;
import com.ulises.usersserver.services.entities.UserApp;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserApp register(final UserApp user);
    void recoverPasswordByEmail(final UserApp user);
    void recoverPasswordFinal(final PasswordRecoveryToken passwordRecoveryToken);
}
