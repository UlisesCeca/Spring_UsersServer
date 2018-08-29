package com.ulises.usersserver.rest.mappers;

import com.ulises.usersserver.rest.forms.PasswordEmailRecoveryForm;
import com.ulises.usersserver.services.entities.UserWithEmail;

public interface UserWithEmailMapper {
    UserWithEmail map(final PasswordEmailRecoveryForm form);
}
