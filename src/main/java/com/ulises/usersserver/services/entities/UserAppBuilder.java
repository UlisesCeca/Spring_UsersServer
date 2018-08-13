package com.ulises.usersserver.services.entities;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Date;
import java.util.List;

public class UserAppBuilder {
    private String username;
    private String password;
    private List<SimpleGrantedAuthority> role;
    private Context context;
    private Date creationDate;
    protected String internalID;

    public static UserAppBuilder builder() {
        return new UserAppBuilder();
    }

    public UserAppBuilder username(final String username) {
        this.username = username;
        return this;
    }


    public UserAppBuilder internalID(final String internalID) {
        this.internalID = internalID;
        return this;
    }

    public UserAppBuilder password(final String password) {
        this.password = password;
        return this;
    }

    public UserAppBuilder context(final Context context) {
        this.context = context;
        return this;
    }

    public UserAppBuilder creationDate(final Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public UserAppBuilder role(final List<SimpleGrantedAuthority> role) {
        this.role = role;
        return this;
    }

    public UserApp build() {
        final UserApp userApp = new UserApp();
        userApp.setInternalID(this.internalID);
        userApp.setUsername(this.username);
        userApp.setPassword(this.password);
        userApp.setContext(this.context);
        userApp.setCreationDate(this.creationDate);
        userApp.setRole(this.role);
        return userApp;
    }
}
