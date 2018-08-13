package com.ulises.usersserver.services.entities;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Getter @Setter
public class UserApp extends User {
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("internal ID", this.internalID)
                .append("username", this.username)
                .append("password", this.password)
                .append("role", this.role)
                .append("context", this.context)
                .append("date", this.creationDate)
                .toString();
    }
}
