package com.example.ulises.template.REST.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    @NotNull(message = "username must not be null")
    private String username;
    @NotNull(message = "surname must not be null")
    private String surname;
    private String password;
}
