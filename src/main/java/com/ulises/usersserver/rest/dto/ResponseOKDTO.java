package com.ulises.usersserver.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseOKDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
