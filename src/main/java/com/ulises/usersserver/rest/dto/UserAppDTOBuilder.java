package com.ulises.usersserver.rest.dto;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Date;
import java.util.List;

public class UserAppDTOBuilder {
    private String username;
    private String internalID;
    private Date creationDate;
    private List<SimpleGrantedAuthority> role;

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

    public UserAppDTOBuilder internalID(final String internalID) {
        this.internalID = internalID;
        return this;
    }

    public UserAppDTOBuilder role(final List<SimpleGrantedAuthority> role) {
        this.role = role;
        return this;
    }

    public UserAppDTO build() {
        final UserAppDTO userAppDTO = new UserAppDTO();
        userAppDTO.setInternalID(this.internalID);
        userAppDTO.setUsername(this.username);
        userAppDTO.setCreationDate(this.creationDate);
        userAppDTO.setRole(this.role);
        return userAppDTO;
    }
}