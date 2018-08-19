package com.ulises.usersserver.services.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserApp extends User {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("internal ID", this.internalID)
                .append("username", this.username)
                .append("password", this.password)
                .append("role", this.role)
                .append("context", this.context)
                .append("date", this.creationDate)
                .append("email", this.email)
                .toString();
    }
}
