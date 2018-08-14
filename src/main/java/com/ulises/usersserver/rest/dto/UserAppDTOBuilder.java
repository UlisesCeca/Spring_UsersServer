package com.ulises.usersserver.rest.dto;

import com.ulises.usersserver.services.entities.Context;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Date;
import java.util.List;

public class UserAppDTOBuilder {
    private String username;
    private Context context;
    protected List<SimpleGrantedAuthority> role;
    protected Date creationDate;

    public static UserAppDTOBuilder builder() {
    return new UserAppDTOBuilder();
}

    public UserAppDTOBuilder username(final String username) {
        this.username = username;
        return this;
    }


    public UserAppDTOBuilder creationDate(final Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public UserAppDTOBuilder context(final Context context) {
        this.context = context;
        return this;
    }


    public UserAppDTOBuilder role(final List<SimpleGrantedAuthority> role) {
        this.role = role;
        return this;
    }

    public UserAppDTO build() {
        final UserAppDTO userAppDTO = new UserAppDTO();
        userAppDTO.setUsername(this.username);
        userAppDTO.setContext(this.context);
        userAppDTO.setRole(this.role);
        userAppDTO.setCreationDate(this.creationDate);
        return userAppDTO;
    }
}