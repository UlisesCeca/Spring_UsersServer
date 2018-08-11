package com.ulises.usersserver.rest.exceptionsmappers;

import com.ulises.usersserver.rest.dto.ErrorDTO;
import com.ulises.usersserver.services.exceptions.UserNotFoundException;
import com.ulises.usersserver.constants.Constants;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class UserNotFoundExceptionMapper implements ExceptionMapper<UserNotFoundException> {
    @Override
    public Response toResponse(UserNotFoundException e) {
        final ErrorDTO errorDTO = ErrorDTO.builder()
                .message(Constants.REQUEST_ERROR_USER_DOESNT_EXOST)
                .build();
        return Response.status(Response.Status.NOT_FOUND).entity(errorDTO).build();
    }
}