package com.ulises.usersserver.services.entities;

import java.util.Date;

public final class PasswordRecoveryTokenBuilder {
    private UserWithEmail user;
    private Date expiration;
    private Integer token;

    public static PasswordRecoveryTokenBuilder aPasswordRecoveryToken() {
        return new PasswordRecoveryTokenBuilder();
    }

    public PasswordRecoveryTokenBuilder withUser(UserWithEmail user) {
        this.user = user;
        return this;
    }

    public PasswordRecoveryTokenBuilder withExpiration(Date expiration) {
        this.expiration = expiration;
        return this;
    }

    public PasswordRecoveryTokenBuilder withToken(Integer token) {
        this.token = token;
        return this;
    }

    public PasswordRecoveryToken build() {
        PasswordRecoveryToken passwordRecoveryToken = new PasswordRecoveryToken();
        passwordRecoveryToken.setUser(user);
        passwordRecoveryToken.setExpiration(expiration);
        passwordRecoveryToken.setToken(token);
        return passwordRecoveryToken;
    }
}
