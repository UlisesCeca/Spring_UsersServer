package com.ulises.usersserver.services.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Date;
import java.util.List;

import static com.ulises.usersserver.constants.Constants.USERNAME_CONTEXT_KEY;

@Document(collection = "Users")
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


    public String getInternalID() {
        return this.username + USERNAME_CONTEXT_KEY + this.context.getName();
    }

    public void setInternalID() {
        this.internalID = this.username + USERNAME_CONTEXT_KEY + this.context.getName();
    }

    public void setInternalID(String internalID) {
        this.internalID = internalID;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SimpleGrantedAuthority> getRole() {
        return this.role;
    }

    public void setRole(List<SimpleGrantedAuthority> role) {
        this.role = role;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }


}
