package com.ulises.usersserver.rest.dto;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Date;
import java.util.List;

public class UserAppDTOBuilder {
    private String username;
    private List<SimpleGrantedAuthority> role;
    private Date creationDate;
    private String email;

    public static UserAppDTOBuilder builder() {
    return new UserAppDTOBuilder();
}

    public UserAppDTOBuilder username(final String username) {
        this.username = username;
        return this;
    }

    public UserAppDTOBuilder email(final String email) {
        this.email = email;
        return this;
    }


    public UserAppDTOBuilder creationDate(final Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }


    public UserAppDTOBuilder role(final List<SimpleGrantedAuthority> role) {
        this.role = role;
        return this;
    }

    public UserAppDTO build() {
        final UserAppDTO userAppDTO = new UserAppDTO();
        userAppDTO.setUsername(this.username);
        userAppDTO.setRole(this.role);
        userAppDTO.setCreationDate(this.creationDate);
        userAppDTO.setEmail(this.email);
        return userAppDTO;
    }
}