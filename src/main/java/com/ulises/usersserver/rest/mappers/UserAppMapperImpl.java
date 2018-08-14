package com.ulises.usersserver.rest.mappers;

import com.ulises.usersserver.constants.Constants;
import com.ulises.usersserver.rest.dto.UserAppDTO;
import com.ulises.usersserver.rest.dto.UserAppDTOBuilder;
import com.ulises.usersserver.rest.forms.RegistrationAppForm;
import com.ulises.usersserver.services.entities.ContextBuilder;
import com.ulises.usersserver.services.entities.UserApp;
import com.ulises.usersserver.services.entities.UserAppBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

import static com.ulises.usersserver.constants.Constants.ROLE_PREFIX;
import static com.ulises.usersserver.constants.Constants.USERNAME_CONTEXT_KEY;


@Component
public class UserAppMapperImpl implements UserAppMapper {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserApp map(UserAppDTO dto) {
        return UserAppBuilder.builder()
                .username(dto.getUsername())
                .context(dto.getContext())
                .internalID(dto.getUsername() + USERNAME_CONTEXT_KEY + dto.getContext().getName())
                .build();
    }

    @Override
    public UserApp map(RegistrationAppForm form) {
        return UserAppBuilder.builder()
                .username(form.getUsername())
                .password(this.passwordEncoder.encode(form.getPassword()))
                .internalID(form.getUsername() + USERNAME_CONTEXT_KEY + Constants.CONTEXTS.ULIAPP.toString())
                .creationDate(new Date())
                .context(ContextBuilder.builder().name(Constants.CONTEXTS.ULIAPP.toString()).build())
                .role(Arrays.asList(new SimpleGrantedAuthority(ROLE_PREFIX + Constants.ROLES.ULIAPP.toString())))
                .build();
    }

    @Override
    public UserAppDTO map(UserApp entity) {
        return UserAppDTOBuilder.builder()
                .username(entity.getUsername())
                .creationDate(entity.getCreationDate())
                .context(entity.getContext())
                .role(entity.getRole())
                .build();
    }
}
