package com.ulises.usersserver.rest.mappers;

import com.ulises.usersserver.rest.forms.PasswordEmailRecoveryForm;
import com.ulises.usersserver.services.entities.UserWithEmail;
import com.ulises.usersserver.services.entities.UserWithEmailBuilder;
import org.springframework.stereotype.Component;

@Component
public class UserWithEmailMapperImpl implements UserWithEmailMapper {
    @Override
    public UserWithEmail map(PasswordEmailRecoveryForm form) {
        return UserWithEmailBuilder.anUserWithEmail()
                .withApp(form.getApp())
                .withUsername(form.getUsername())
                .withEmail(form.getEmail())
                .withContext(form.getContext())
                .build();
    }
}
