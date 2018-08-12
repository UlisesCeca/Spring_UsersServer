package com.ulises.usersserver.rest.exceptionsmappers;

import com.ulises.usersserver.rest.dto.ErrorDTO;
import com.ulises.usersserver.services.exceptions.WrongParameterException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import static com.ulises.usersserver.constants.Constants.REQUEST_ERROR_BAD_REQUEST_PARAMETERS;

public class WrongParameterExceptionMapper implements ExceptionMapper<WrongParameterException> {
    @Override
    public Response toResponse(WrongParameterException e) {
        final ErrorDTO errorDTO = ErrorDTO.builder()
                .message(REQUEST_ERROR_BAD_REQUEST_PARAMETERS)
                .build();
        return Response.status(Response.Status.BAD_REQUEST).entity(errorDTO).build();
    }
}