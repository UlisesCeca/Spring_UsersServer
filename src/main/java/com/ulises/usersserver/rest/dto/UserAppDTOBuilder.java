package com.ulises.usersserver.rest.dto;

import java.util.Date;

public class UserAppDTOBuilder {
    private String username;
    private String internalID;
    private Date creationDate;

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

    public UserAppDTO build() {
        final UserAppDTO userAppDTO = new UserAppDTO();
        userAppDTO.setInternalID(this.internalID);
        userAppDTO.setUsername(this.username);
        userAppDTO.setCreationDate(this.creationDate);
        return userAppDTO;
    }
}