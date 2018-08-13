package com.ulises.usersserver.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ulises.usersserver.services.entities.Address;
import com.ulises.usersserver.services.entities.Context;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    @NotNull(message = "internalID must not be null")
    protected String internalID;
    @NotNull(message = "username must not be null")
    protected String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected String password;
    @NotNull(message = "context must not be null")
    protected Context context;
    protected Date creationDate;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    protected List<SimpleGrantedAuthority> role;
    /*private String id;
    private String name;
    private String surname;
    private int age;
    private Date birth;
    private Address address;
    private String phone;
    private String email;*/
}
