package com.ulises.usersserver.services.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.ulises.usersserver.constants.Constants.USERNAME_CONTEXT_KEY;

public final class UserAppBuilder {
    private String username;
    private String password;
    private List<Role> role;
    private Context context;
    private Date creationDate;
    private App app;
    private String email;

    private UserAppBuilder() { this.role = new ArrayList<>(); }

    public static UserAppBuilder anUserApp() {
        return new UserAppBuilder();
    }

    public UserAppBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserAppBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserAppBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserAppBuilder withRole(List<Role> role) {
        this.role = role;
        return this;
    }

    public UserAppBuilder withContext(Context context) {
        this.context = context;
        return this;
    }

    public UserAppBuilder withCreationDate(Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public UserAppBuilder withApp(App app) {
        this.app = app;
        return this;
    }

    public UserApp build() {
        UserApp userApp = new UserApp();
        userApp.setEmail(this.email);
        userApp.setUsername(this.username);
        userApp.setPassword(this.password);
        userApp.setRoles(this.role);
        userApp.setContext(this.context);
        userApp.setCreationDate(this.creationDate);
        userApp.setApp(this.app);
        userApp.setId(this.username + USERNAME_CONTEXT_KEY + this.context.getName());
        return userApp;
    }
}
