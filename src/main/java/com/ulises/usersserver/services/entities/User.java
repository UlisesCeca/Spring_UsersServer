package com.ulises.usersserver.services.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Date;
import java.util.List;

@Document(collection = "Users")
@Data
public class User {
    private String username;
    private String password;
    private List<SimpleGrantedAuthority> role;
    private String id;
    private String name;
    private String surname;
    private int age;
    private Date birth;
    private Address address;
    private String phone;
    private String email;
    private Context context;
}
