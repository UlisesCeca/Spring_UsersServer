package com.ulises.usersserver.rest.endpoints;
import com.ulises.usersserver.rest.forms.PasswordEmailRecoveryFinalForm;
import com.ulises.usersserver.rest.forms.PasswordEmailRecoveryForm;
import com.ulises.usersserver.rest.forms.RegistrationAppForm;
import com.ulises.usersserver.rest.mappers.PasswordRecoveryTokenMapper;
import com.ulises.usersserver.rest.mappers.UserAppMapper;
import com.ulises.usersserver.rest.mappers.UserWithEmailMapper;
import com.ulises.usersserver.services.UserService;
import com.ulises.usersserver.services.exceptions.PasswordsDontMatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static com.ulises.usersserver.constants.Constants.*;

@Component
@Path(ENDPOINT_USERS)
public final class UserEndpoint {
    private final UserService userService;
    private final UserAppMapper userAppMapper;
    private final PasswordRecoveryTokenMapper passwordRecoveryTokenMapper;
    private final UserWithEmailMapper userWithEmailMapper;

    @Autowired
    UserEndpoint(final UserAppMapper userAppMapper, final PasswordRecoveryTokenMapper passwordRecoveryTokenMapper,
                 final UserWithEmailMapper userWithEmailMapper, final UserService userService) {
        this.userService = userService;
        this.userAppMapper = userAppMapper;
        this.passwordRecoveryTokenMapper = passwordRecoveryTokenMapper;
        this.userWithEmailMapper = userWithEmailMapper;
    }

    @PUT
    @Path(ENDPOINT_USERS_REGISTER_APP)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerApp(@Valid @NotNull(message = REQUEST_ERROR_NULL_BODY) final RegistrationAppForm form) {
        if(!form.getPassword().equals(form.getPasswordCheck()))
            throw new PasswordsDontMatchException();
        else this.userService.register(this.userAppMapper.map(form));
        return Response.created(null).build();
    }

    @POST
    @Path(ENDPOINT_USERS_FORGOT_PASSWORD_BY_EMAIL_1)
    @Produces(MediaType.APPLICATION_JSON)
    public Response recoverPasswordByEmailStep1(@Valid @NotNull(message = REQUEST_ERROR_NULL_BODY) final PasswordEmailRecoveryForm form) {
        this.userService.recoverPasswordByEmailStep1(this.userWithEmailMapper.map(form));
        return Response.noContent().build();
    }

    @PATCH
    @Path(ENDPOINT_USERS_FORGOT_PASSWORD_BY_EMAIL_2)
    @Produces(MediaType.APPLICATION_JSON)
    public Response recoverPasswordByEmailStep2(@Valid @NotNull(message = REQUEST_ERROR_NULL_BODY) final PasswordEmailRecoveryFinalForm form) {
        if(!form.getPassword().equals(form.getPasswordCheck()))
            throw new PasswordsDontMatchException();
        this.userService.recoverPasswordByEmailStep2(this.passwordRecoveryTokenMapper.map(form));
        return Response.noContent().build();
    }
}
