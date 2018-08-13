package com.ulises.usersserver.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ulises.usersserver.services.entities.Context;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    @NotNull(message = "internalID must not be null")
    protected String internalID;
    @NotNull(message = "username must not be null")
    protected String username;
    @NotNull(message = "context must not be null")
    protected Date creationDate;
    protected List<SimpleGrantedAuthority> role;
    /*private String id;
    private String name;
    private String surname;
    private int age;
    private Date birth;
    private Address address;
    private String phone;
    private String email;*/

    public String getInternalID() {
        return this.internalID;
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

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setRole(List<SimpleGrantedAuthority> role) {
        this.role = role;
    }
}
