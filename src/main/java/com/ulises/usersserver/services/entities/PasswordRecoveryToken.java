package com.ulises.usersserver.services.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;
import java.util.Random;

public class PasswordRecoveryToken {
    @Id
    private String user;

    @Indexed(name="expiration", expireAfterSeconds=300)
    private final Date expiration = new Date();

    private final String token =  Integer.toString(new Random().nextInt((999999 - 100000) + 1) + 100000);

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getExpiration() {
        return expiration;
    }

    public String getToken() {
        return token;
    }
}
