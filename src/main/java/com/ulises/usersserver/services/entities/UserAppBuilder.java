package com.ulises.usersserver.services.entities;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.ulises.usersserver.constants.Constants.USERNAME_CONTEXT_KEY;

public final class UserAppBuilder {
    protected String username;
    protected String password;
    protected List<SimpleGrantedAuthority> role;
    protected Context context;
    protected Date creationDate;
    protected App app;
    private String email;

    private UserAppBuilder() {
        this.role = new ArrayList<>();
    }

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

    public UserAppBuilder withRole(List<SimpleGrantedAuthority> role) {
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
        userApp.setEmail(email);
        userApp.setUsername(username);
        userApp.setPassword(password);
        userApp.setRole(role);
        userApp.setContext(context);
        userApp.setCreationDate(creationDate);
        userApp.setApp(app);
        userApp.setId(this.username + USERNAME_CONTEXT_KEY + this.context.getName());
        return userApp;
    }
}
