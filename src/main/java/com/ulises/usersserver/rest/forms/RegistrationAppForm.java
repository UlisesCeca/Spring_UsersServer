package com.ulises.usersserver.rest.forms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter @Setter
public final class RegistrationAppForm {
    @NotNull(message = "Username must not be empty.")
    @Length(min=5, max=15, message = "Username's length must be 5-15 characters long.")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Username's must only contain letters and digits.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String username;

    @NotNull(message = "Email must not be empty.")
    @Length(min=5, max=40, message = "Email's length must be 5-40 characters long.")
    @Email(message = "You must introduce a valid email.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String email;

    @NotNull(message = "Password must not be empty")
    @Length(min=5, max=20, message = "password's length must be 5-20 characters long.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotNull(message = "Password's check must not be empty")
    @Length(min=5, max=20, message = "passwordCheck's length must be 5-20 characters long.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String passwordCheck;
}