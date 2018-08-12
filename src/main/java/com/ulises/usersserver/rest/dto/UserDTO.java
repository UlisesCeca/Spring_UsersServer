package com.ulises.usersserver.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ulises.usersserver.services.entities.Address;
import com.ulises.usersserver.services.entities.App;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String name;
    private String surname;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String role;
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
