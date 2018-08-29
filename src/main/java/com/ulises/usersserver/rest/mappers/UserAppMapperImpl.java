package com.ulises.usersserver.rest.mappers;

import com.ulises.usersserver.rest.forms.RegistrationAppForm;
import com.ulises.usersserver.services.entities.AppBuilder;
import com.ulises.usersserver.services.entities.ContextBuilder;
import com.ulises.usersserver.services.entities.UserApp;
import com.ulises.usersserver.services.entities.UserAppBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

import static com.ulises.usersserver.constants.Constants.*;


@Component
public class UserAppMapperImpl implements UserAppMapper {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserApp map(final RegistrationAppForm form) {
        return UserAppBuilder.anUserApp()
                .withUsername(form.getUsername())
                .withPassword(this.passwordEncoder.encode(form.getPassword()))
                .withEmail(form.getEmail())
                .withApp(AppBuilder.anApp()
                    .withName(APP_NAME_ULIAPP)
                    .build())
                .withContext(ContextBuilder.aContext()
                    .withName(CONTEXT_NAME_ULIAPP)
                    .build())
                .withRole(Arrays.asList(new SimpleGrantedAuthority(ROLE_PREFIX + ROLE_ULISES)))
                .withCreationDate(new Date())
                .build();
    }
}
