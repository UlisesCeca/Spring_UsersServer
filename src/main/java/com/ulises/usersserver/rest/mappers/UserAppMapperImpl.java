package com.ulises.usersserver.rest.mappers;

import com.ulises.usersserver.rest.dto.UserAppDTO;
import com.ulises.usersserver.rest.dto.UserAppDTOBuilder;
import com.ulises.usersserver.services.entities.UserApp;
import com.ulises.usersserver.services.entities.UserAppBuilder;
import org.springframework.stereotype.Component;

@Component
public class UserAppMapperImpl implements UserAppMapper {
    @Override
    public UserApp map(UserAppDTO dto) {
        return UserAppBuilder.builder()
                .username(dto.getUsername())
                .creationDate(dto.getCreationDate())
                .internalID(dto.getInternalID())
                .build();
    }

    @Override
    public UserAppDTO map(UserApp entity) {
        return UserAppDTOBuilder.builder()
                .username(entity.getUsername())
                .creationDate(entity.getCreationDate())
                .internalID(entity.getInternalID())
                .role(entity.getRole())
                .build();
    }
}
