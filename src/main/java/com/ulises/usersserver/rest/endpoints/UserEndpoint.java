package com.ulises.usersserver.rest.endpoints;

import com.ulises.usersserver.rest.dto.ResponseOKDTO;
import com.ulises.usersserver.rest.dto.UserDTO;
import com.ulises.usersserver.services.entities.User;
import com.ulises.usersserver.services.UserService;
import com.ulises.usersserver.constants.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path(Constants.ENDPOINT_USERS)
public class UserEndpoint {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService userService;

    @POST
    @Path(Constants.ENDPOINT_USERS_REGISTER)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(@Valid @NotNull(message = Constants.REQUEST_ERROR_NULL_BODY) final UserDTO testDTO) {
        this.userService.register(this.modelMapper.map(testDTO, User.class));
        return Response.ok(ResponseOKDTO.builder().message(Constants.RESPONSE_OK_USER_CREATED).build()).build();
    }

}
