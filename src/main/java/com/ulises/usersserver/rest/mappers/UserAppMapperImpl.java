package com.ulises.usersserver.rest.mappers;

import com.ulises.usersserver.rest.forms.RegistrationAppForm;
import com.ulises.usersserver.services.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.ulises.usersserver.constants.Constants.*;


@Component
public final class UserAppMapperImpl implements UserAppMapper {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    UserAppMapperImpl(final PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserApp map(final RegistrationAppForm form) {
        UserApp user = UserAppBuilder.anUserApp()
                .withUsername(form.getUsername())
                .withPassword(this.passwordEncoder.encode(form.getPassword()))
                .withEmail(form.getEmail())
                .withApp(AppBuilder.anApp()
                        .withName(APP_NAME_ULIAPP)
                        .build())
                .withContext(ContextBuilder.aContext()
                        .withName(CONTEXT_NAME_ULIAPP)
                        .build())
                .withCreationDate(new Date())
                .build();
        Role role = RoleBuilder.aRole()
                .withRole((ROLE_PREFIX + ROLE_ULISES))
                .withUser(user)
                .build();
        user.getRoles().add(role);

        return user;
    }
}
