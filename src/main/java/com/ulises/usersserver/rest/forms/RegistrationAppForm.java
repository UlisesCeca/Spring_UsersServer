package com.ulises.usersserver.rest.forms;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class RegistrationAppForm {
    @NotNull(message = "username must not be null")
    @Length(min=5, max=15, message = "username's length must be 5-15 characters long")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String username;

    @NotNull(message = "password must not be null")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotNull(message = "password must not be null")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String passwordCheck;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordCheck() {
        return passwordCheck;
    }
}