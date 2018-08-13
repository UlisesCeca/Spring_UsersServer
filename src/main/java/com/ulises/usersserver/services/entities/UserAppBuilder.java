package com.ulises.usersserver.services.entities;

import java.util.Date;

public class UserAppBuilder {
    private String username;
    private Date creationDate;
    protected String internalID;
    protected String password;
    protected Context context;

    public static UserAppBuilder builder() {
        return new UserAppBuilder();
    }

    public UserAppBuilder username(final String username) {
        this.username = username;
        return this;
    }

    public UserAppBuilder password(final String password) {
        this.password = password;
        return this;
    }

    public UserAppBuilder username(final Context context) {
        this.context = context;
        return this;
    }


    public UserAppBuilder internalID(final String internalID) {
        this.internalID = internalID;
        return this;
    }

    public UserAppBuilder creationDate(final Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public UserApp build() {
        final UserApp userApp = new UserApp();
        userApp.setInternalID(this.internalID);
        userApp.setUsername(this.username);
        userApp.setCreationDate(this.creationDate);
        userApp.setPassword(this.password);
        userApp.setContext(this.context);
        return userApp;
    }
}
