package com.ulises.usersserver.services.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.ulises.usersserver.constants.Constants.USERNAME_CONTEXT_KEY;

public final class UserWithEmailBuilder {
    private String username;
    private String password;
    private List<Role> role;
    private Context context;
    private Date creationDate;
    private App app;
    private String email;

    private UserWithEmailBuilder() {
        this.role = new ArrayList<>();
    }

    public static UserWithEmailBuilder anUserWithEmail() {
        return new UserWithEmailBuilder();
    }

    public UserWithEmailBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserWithEmailBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public UserWithEmailBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserWithEmailBuilder withRole(List<Role> role) {
        this.role = role;
        return this;
    }

    public UserWithEmailBuilder withContext(Context context) {
        this.context = context;
        return this;
    }

    public UserWithEmailBuilder withCreationDate(Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public UserWithEmailBuilder withApp(App app) {
        this.app = app;
        return this;
    }

    public UserWithEmail build() {
        UserWithEmail userWithEmail = new UserWithEmail();
        userWithEmail.setEmail(this.email);
        userWithEmail.setUsername(this.username);
        userWithEmail.setPassword(this.password);
        userWithEmail.setRoles(this.role);
        userWithEmail.setContext(this.context);
        userWithEmail.setCreationDate(this.creationDate);
        userWithEmail.setApp(this.app);
        userWithEmail.setId(this.username + USERNAME_CONTEXT_KEY + this.context.getName());
        return userWithEmail;
    }
}
