package com.ulises.usersserver.rest.endpoints;

import com.ulises.usersserver.constants.Constants;
import com.ulises.usersserver.rest.dto.ResponseOKDTOBuilder;
import com.ulises.usersserver.rest.dto.UserAppDTO;
import com.ulises.usersserver.rest.mappers.UserAppMapper;
import com.ulises.usersserver.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    public Response register(@Valid @NotNull(message = REQUEST_ERROR_NULL_BODY) final UserAppDTO userAppDTO) {
        this.userService.register(this.userMapper.map(userAppDTO));
        return Response.ok(ResponseOKDTOBuilder.builder().message(RESPONSE_OK_USER_CREATED).build()).build();
    }
}
