package com.ulises.usersserver.rest.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserAppDTO extends UserDTO {
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("internal ID", this.internalID)
                .append("username", this.username)
                .append("role", this.role)
                .append("date", this.creationDate)
                .toString();
    }
}
