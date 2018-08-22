package com.ulises.usersserver.services.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Random;

@Document(collection = "PasswordRecoveryTokens")
public class PasswordRecoveryToken {
    @Id
    private String username;

    @Indexed(name="expiration", expireAfterSeconds=300)
    private final Date expiration = new Date();

    private String token;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getExpiration() {
        return expiration;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
