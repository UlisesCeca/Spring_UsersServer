package com.ulises.usersserver.services.entities;

public class PasswordRecoveryTokenBuilder {
    private String username;

    public static PasswordRecoveryTokenBuilder builder() {return new PasswordRecoveryTokenBuilder();}

    public PasswordRecoveryTokenBuilder username(final String username) {
        this.username = username;
        return this;
    }

    public PasswordRecoveryToken build() {
        PasswordRecoveryToken entity = new PasswordRecoveryToken();
        entity.setUsername(this.username);
        return entity;
    }
}
