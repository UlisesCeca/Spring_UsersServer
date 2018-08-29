package com.ulises.usersserver.services;

import com.ulises.usersserver.services.entities.PasswordRecoveryToken;
import com.ulises.usersserver.services.entities.UserWithEmail;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void register(UserWithEmail user);
    void recoverPasswordByEmail(final UserWithEmail user);
    void recoverPasswordFinal(final PasswordRecoveryToken passwordRecoveryToken);
}
