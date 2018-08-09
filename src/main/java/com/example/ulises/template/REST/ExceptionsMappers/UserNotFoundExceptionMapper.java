package com.example.ulises.template.REST.ExceptionsMappers;

import com.example.ulises.template.REST.DTO.ErrorDTO;
import com.example.ulises.template.Services.Exceptions.UserNotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class UserNotFoundExceptionMapper implements ExceptionMapper<UserNotFoundException> {
    private final String USER_NOT_FOUND = "El usuario no ha sido encontrado";

    @Override
    public Response toResponse(UserNotFoundException e) {
        final ErrorDTO errorDTO = ErrorDTO.builder().
                error(USER_NOT_FOUND).
                build();
        return Response.status(Response.Status.NOT_FOUND).entity(errorDTO).build();
    }
}