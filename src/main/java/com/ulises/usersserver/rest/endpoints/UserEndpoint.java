package com.ulises.usersserver.rest.endpoints;

import com.ulises.usersserver.constants.Constants;
import com.ulises.usersserver.rest.forms.PasswordEmailRecoveryForm;
import com.ulises.usersserver.rest.forms.RegistrationAppForm;
import com.ulises.usersserver.rest.mappers.UserAppMapper;
import com.ulises.usersserver.services.UserServiceImpl;
import com.ulises.usersserver.services.exceptions.PasswordsDontMatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.Base64;

import static com.ulises.usersserver.constants.Constants.*;


@Component
@Path(Constants.ENDPOINT_USERS)
public class UserEndpoint {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserAppMapper userMapper;

    @POST
    @Path(ENDPOINT_USERS_REGISTER_APP)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerApp(@Valid @NotNull(message = REQUEST_ERROR_NULL_BODY) final RegistrationAppForm form,
                                @Context HttpHeaders headers) {
        if(!form.getPassword().equals(form.getPasswordCheck()))
            throw new PasswordsDontMatchException();
        /*System.out.println(new String(
                                    Base64.getMimeDecoder().decode(
                                    headers.getRequestHeader(HttpHeaders.AUTHORIZATION).get(0)
                                    .split("Basic ")[1].getBytes()))
                                    .split(":")[0]);*/
        return Response.created(null).build();
    }

    @POST
    @Path(ENDPOINT_USERS_FORGOT_PASSWORD_BY_EMAIL)
    @Produces(MediaType.APPLICATION_JSON)
    public Response recoverPasswordByEmail(@Valid @NotNull(message = REQUEST_ERROR_NULL_BODY) final PasswordEmailRecoveryForm form) {
        this.userService.recoverPasswordByEmail(this.userMapper.map(form));
        return Response.noContent().build();
    }
}
