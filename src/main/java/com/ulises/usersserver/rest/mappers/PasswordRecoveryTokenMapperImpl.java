package com.ulises.usersserver.rest.mappers;

import com.ulises.usersserver.rest.forms.PasswordEmailRecoveryFinalForm;
import com.ulises.usersserver.services.entities.PasswordRecoveryToken;
import com.ulises.usersserver.services.entities.PasswordRecoveryTokenBuilder;
import org.springframework.stereotype.Component;

@Component
public class PasswordRecoveryTokenMapperImpl implements PasswordRecoveryTokenMapper{
    @Override
    public PasswordRecoveryToken map(final PasswordEmailRecoveryFinalForm form) {
        return PasswordRecoveryTokenBuilder.aPasswordRecoveryToken()
                .withToken(form.getToken().getToken())
                .withUser(form.getToken().getUser())
                //.withUsername(form.getToken().getUser().getInternalID())
                .build();
    }
}
