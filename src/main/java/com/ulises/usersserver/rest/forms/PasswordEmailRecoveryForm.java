package com.ulises.usersserver.rest.forms;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ulises.usersserver.services.entities.App;
import com.ulises.usersserver.services.entities.Context;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter @Setter
public final class PasswordEmailRecoveryForm {
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

    @NotNull(message = "Context must not be empty.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Context context;
}
