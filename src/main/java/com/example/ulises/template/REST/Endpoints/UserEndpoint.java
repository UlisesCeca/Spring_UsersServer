package com.example.ulises.template.REST.Endpoints;

import com.example.ulises.template.REST.DTO.UserDTO;
import com.example.ulises.template.Services.Entities.User;
import com.example.ulises.template.Services.UserService;
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
@Path("/users")
public class UserEndpoint {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService userService;

    @POST
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello(@Valid @NotNull(message = "testDTO must not be null") final UserDTO testDTO) {
        this.userService.getUser(this.modelMapper.map(testDTO, User.class));
        return Response.noContent().build();
    }

}
