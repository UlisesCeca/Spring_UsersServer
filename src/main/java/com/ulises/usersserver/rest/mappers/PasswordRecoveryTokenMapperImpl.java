package com.ulises.usersserver.rest.mappers;

import com.ulises.usersserver.rest.forms.PasswordEmailRecoveryFinalForm;
import com.ulises.usersserver.services.entities.PasswordRecoveryToken;
import com.ulises.usersserver.services.entities.PasswordRecoveryTokenBuilder;
import com.ulises.usersserver.services.entities.UserWithEmailBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public final class PasswordRecoveryTokenMapperImpl implements PasswordRecoveryTokenMapper{
    private final PasswordEncoder passwordEncoder;

    @Autowired
    PasswordRecoveryTokenMapperImpl(final PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public PasswordRecoveryToken map(final PasswordEmailRecoveryFinalForm form) {
        return PasswordRecoveryTokenBuilder.aPasswordRecoveryToken()
                .withToken(form.getToken())
                .withUser(UserWithEmailBuilder.anUserWithEmail()
                        .withUsername(form.getUsername())
                        .withContext(form.getContext())
                        .withPassword(this.passwordEncoder.encode(form.getPassword()))
                        .withEmail(form.getEmail())
                        .build())
                .build();
    }
}
