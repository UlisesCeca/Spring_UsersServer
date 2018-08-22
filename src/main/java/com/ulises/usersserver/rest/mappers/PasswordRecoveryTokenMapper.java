package com.ulises.usersserver.rest.mappers;

import com.ulises.usersserver.rest.forms.PasswordEmailRecoveryFinalForm;
import com.ulises.usersserver.services.entities.PasswordRecoveryToken;

public interface PasswordRecoveryTokenMapper {
    PasswordRecoveryToken map(final PasswordEmailRecoveryFinalForm form);
}
