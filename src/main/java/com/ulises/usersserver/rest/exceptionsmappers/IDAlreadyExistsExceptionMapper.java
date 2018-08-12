package com.ulises.usersserver.rest.exceptionsmappers;

import com.ulises.usersserver.rest.dto.ErrorDTO;
import com.ulises.usersserver.services.exceptions.IDAlreadyExistsException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import static com.ulises.usersserver.constants.Constants.REQUEST_ERROR_USER_ID_EXISTS;

public class IDAlreadyExistsExceptionMapper implements ExceptionMapper<IDAlreadyExistsException> {
    @Override
    public Response toResponse(IDAlreadyExistsException e) {
        final ErrorDTO errorDTO = ErrorDTO.builder()
                .message(REQUEST_ERROR_USER_ID_EXISTS)
                .build();
        return Response.status(Response.Status.BAD_REQUEST).entity(errorDTO).build();
    }
}