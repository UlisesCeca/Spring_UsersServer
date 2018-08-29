package com.ulises.usersserver.services.entities;

import java.util.Date;

public final class PasswordRecoveryTokenBuilder {
    private String username;
    private Date expiration;
    private String token;
    private User user;

    private PasswordRecoveryTokenBuilder() {
    }

    public static PasswordRecoveryTokenBuilder aPasswordRecoveryToken() {
        return new PasswordRecoveryTokenBuilder();
    }

    public PasswordRecoveryTokenBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public PasswordRecoveryTokenBuilder withExpiration(Date expiration) {
        this.expiration = expiration;
        return this;
    }

    public PasswordRecoveryTokenBuilder withToken(String token) {
        this.token = token;
        return this;
    }

    public PasswordRecoveryTokenBuilder withUser(User user) {
        this.user = user;
        return this;
    }

    public PasswordRecoveryToken build() {
        PasswordRecoveryToken passwordRecoveryToken = new PasswordRecoveryToken();
        passwordRecoveryToken.setUsername(username);
        passwordRecoveryToken.setExpiration(expiration);
        passwordRecoveryToken.setToken(token);
        passwordRecoveryToken.setUser(user);
        return passwordRecoveryToken;
    }
}
