package com.ulises.usersserver.services.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Date;
import java.util.List;

@Document(collection = "Users")
@Getter @Setter
public class User {
    @Id
    protected String internalID;
    protected String username;
    protected String password;
    protected List<SimpleGrantedAuthority> role;
    protected Context context;
    protected Date creationDate;
    /*private String id;
    private String name;
    private String surname;
    private int age;
    private Date birth;
    private Address address;
    private String phone;
    private String email;*/
}
