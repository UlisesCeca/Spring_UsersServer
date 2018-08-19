package com.ulises.usersserver.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected String username;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date creationDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<SimpleGrantedAuthority> role;

    /*private String id;
    private String name;
    private String surname;
    private int age;
    private Date birth;
    private Address address;
    private String phone;
    private String email;*/

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

    public List<SimpleGrantedAuthority> getRole() {
        return role;
    }

}
