package com.ulises.usersserver.rest.forms;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ulises.usersserver.services.entities.App;
import com.ulises.usersserver.services.entities.Context;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class PasswordEmailRecoveryForm {
    @NotNull(message = "Username must not be empty.")
    @Length(min=5, max=15, message = "Username's length must be 5-15 characters long.")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Username's must only contain letters and digits.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String username;

    @NotNull(message = "Email must not be empty.")
    @Length(min=5, max=35, message = "Email's length must be 5-35 characters long.")
    @Email(message = "You must introduce a valid email.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String email;

    @NotNull(message = "Context must not be empty.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Context context;

    @NotNull(message = "App must not be empty")
    private App app;

    public String getUsername() {
        return username;
    }

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
