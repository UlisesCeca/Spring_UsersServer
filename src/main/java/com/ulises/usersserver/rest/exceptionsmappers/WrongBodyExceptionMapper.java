package com.ulises.usersserver.rest.exceptionsmappers;

import com.ulises.usersserver.rest.dto.ErrorDTO;
import com.ulises.usersserver.services.exceptions.WrongBodyException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import static com.ulises.usersserver.constants.Constants.REQUEST_ERROR_BAD_REQUEST_BODY;

public class WrongBodyExceptionMapper implements ExceptionMapper<WrongBodyException> {
    @Override
    public Response toResponse(WrongBodyException e) {
        final ErrorDTO errorDTO = ErrorDTO.builder()
                .message(REQUEST_ERROR_BAD_REQUEST_BODY)
                .build();
        return Response.status(Response.Status.BAD_REQUEST).entity(errorDTO).build();
    }
}