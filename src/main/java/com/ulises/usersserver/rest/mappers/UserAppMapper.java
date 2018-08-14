package com.ulises.usersserver.rest.mappers;

import com.ulises.usersserver.rest.dto.UserAppDTO;
import com.ulises.usersserver.rest.forms.RegistrationAppForm;
import com.ulises.usersserver.services.entities.UserApp;

public interface UserAppMapper {
    UserAppDTO map(final UserApp entity);
    UserApp map(final UserAppDTO dto);
    UserApp map(final RegistrationAppForm form);
}
