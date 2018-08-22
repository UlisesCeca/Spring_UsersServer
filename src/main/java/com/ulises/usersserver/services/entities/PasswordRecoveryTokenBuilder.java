package com.ulises.usersserver.services.entities;

public class PasswordRecoveryTokenBuilder {
    private String username;
    private String token;

    public static PasswordRecoveryTokenBuilder builder() {return new PasswordRecoveryTokenBuilder();}

    public PasswordRecoveryTokenBuilder username(final String username) {
        this.username = username;
        return this;
    }

    public PasswordRecoveryTokenBuilder token(final String token) {
        this.token = token;
        return this;
    }

    public PasswordRecoveryToken build() {
        PasswordRecoveryToken entity = new PasswordRecoveryToken();
        entity.setUsername(this.username);
        entity.setToken(this.token);
        return entity;
    }
}
