package com.ulises.usersserver.rest.endpoints;

import com.ulises.usersserver.constants.Constants;
import com.ulises.usersserver.rest.dto.ResponseOKDTO;
import com.ulises.usersserver.rest.dto.UserDTO;
import com.ulises.usersserver.services.UserService;
import com.ulises.usersserver.services.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import static com.ulises.usersserver.constants.Constants.ENDPOINT_USERS_REGISTER;
import static com.ulises.usersserver.constants.Constants.REQUEST_ERROR_NULL_BODY;
import static com.ulises.usersserver.constants.Constants.RESPONSE_OK_USER_CREATED;

@Component
@Path(Constants.ENDPOINT_USERS)
public class UserEndpoint {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService userService;

    @POST
    @Path(ENDPOINT_USERS_REGISTER)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(@Valid @NotNull(message = REQUEST_ERROR_NULL_BODY) final UserDTO userDTO,
                             @Context final UriInfo uriInfo) {
        this.userService.register(this.modelMapper.map(userDTO, User.class), uriInfo);
        return Response.ok(ResponseOKDTO.builder().message(RESPONSE_OK_USER_CREATED).build()).build();
    }
}
