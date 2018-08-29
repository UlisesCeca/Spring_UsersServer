package com.ulises.usersserver.rest.forms;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ulises.usersserver.services.entities.PasswordRecoveryToken;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class PasswordEmailRecoveryFinalForm {
    @NotNull(message = "User must not be empty.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private PasswordRecoveryToken token;

    @NotNull(message = "Password must not be empty")
    @Length(min=5, max=20, message = "Password's length must be 5-20 characters long.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotNull(message = "Password's check must not be empty")
    @Length(min=5, max=20, message = "Password's length must be 5-20 characters long.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String passwordCheck;

    public PasswordRecoveryToken getToken() {
        return token;
    }

    public void setToken(PasswordRecoveryToken token) {
        this.token = token;
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

    public void setPasswordCheck(String passwordCheck) {
        this.passwordCheck = passwordCheck;
    }
}
