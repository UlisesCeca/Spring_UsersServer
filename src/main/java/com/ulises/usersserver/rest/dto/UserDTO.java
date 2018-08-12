package com.ulises.usersserver.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ulises.usersserver.services.entities.Address;
import com.ulises.usersserver.services.entities.Context;
import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<SimpleGrantedAuthority> role;
    private String name;
    private String surname;
    private int age;
    private Date birth;
    private Address address;
    private String phone;
    private String email;
    private Context context;
}
