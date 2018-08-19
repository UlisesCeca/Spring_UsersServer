package com.ulises.usersserver.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class UserAppDTO extends UserDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }}
