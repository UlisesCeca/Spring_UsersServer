package com.ulises.usersserver.services.entities;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.ulises.usersserver.constants.Constants.USERNAME_CONTEXT_KEY;

public final class UserWithEmailBuilder {
    protected String username;
    protected String password;
    protected List<SimpleGrantedAuthority> role;
    protected Context context;
    protected Date creationDate;
    protected App app;
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

    public UserWithEmailBuilder withRole(List<SimpleGrantedAuthority> role) {
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
        userWithEmail.setEmail(email);
        userWithEmail.setUsername(username);
        userWithEmail.setPassword(password);
        userWithEmail.setRole(role);
        userWithEmail.setContext(context);
        userWithEmail.setCreationDate(creationDate);
        userWithEmail.setApp(app);
        userWithEmail.setId(this.username + USERNAME_CONTEXT_KEY + this.context.getName());
        return userWithEmail;
    }
}
