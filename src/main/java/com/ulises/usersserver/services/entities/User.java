package com.ulises.usersserver.services.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Users")
@Data
public class User {
    private String username;
    private String password;
    private String role;
    private String name;
    private String surname;
    private int age;
    private Date birth;
    private Address address;
    private String phone;
    private String email;
    private boolean banned;
    private Date suspendedUntil;
    private int suspendedTimes;
    private App[] apps;
}
