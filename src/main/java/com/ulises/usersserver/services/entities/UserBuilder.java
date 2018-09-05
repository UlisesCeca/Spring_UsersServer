package com.ulises.usersserver.services.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.ulises.usersserver.constants.Constants.USERNAME_CONTEXT_KEY;

public final class UserBuilder {
    private String username;
    private String password;
    private List<Role> role;
    private Context context;
    private Date creationDate;
    private App app;

    private UserBuilder() { this.role = new ArrayList<>(); }

    public static UserBuilder anUser() {
        return new UserBuilder();
    }

    public UserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withRole(List<Role> role) {
        this.role = role;
        return this;
    }

    public UserBuilder withContext(Context context) {
        this.context = context;
        return this;
    }

    public UserBuilder withCreationDate(Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public UserBuilder withApp(App app) {
        this.app = app;
        return this;
    }

    public User build() {
        User user = new User();
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setRoles(this.role);
        user.setContext(this.context);
        user.setCreationDate(this.creationDate);
        user.setApp(this.app);
        user.setId(this.username + USERNAME_CONTEXT_KEY + this.context.getName());
        return user;
    }
}
