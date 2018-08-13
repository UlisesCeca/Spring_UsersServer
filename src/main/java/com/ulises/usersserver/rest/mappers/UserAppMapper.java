package com.ulises.usersserver.rest.mappers;

import com.ulises.usersserver.rest.dto.UserAppDTO;
import com.ulises.usersserver.rest.dto.UserAppDTOBuilder;
import com.ulises.usersserver.services.entities.UserApp;
import com.ulises.usersserver.services.entities.UserAppBuilder;
import org.springframework.stereotype.Component;

@Component
public class UserAppMapper {
    public UserApp map(UserAppDTO dto) {
        return UserAppBuilder.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .context(dto.getContext())
                .creationDate(dto.getCreationDate())
                .internalID(dto.getInternalID())
                .role(dto.getRole())
                .build();
    }

    public UserAppDTO map(UserApp entity) {
        return UserAppDTOBuilder.builder()
                .username(entity.getUsername())
                .creationDate(entity.getCreationDate())
                .internalID(entity.getInternalID())
                .build();
    }
}
