package com.ulises.usersserver.rest.mappers;

import com.ulises.usersserver.rest.forms.RegistrationAppForm;
import com.ulises.usersserver.services.entities.UserApp;

public interface UserAppMapper {
    UserApp map(final RegistrationAppForm form);
}
