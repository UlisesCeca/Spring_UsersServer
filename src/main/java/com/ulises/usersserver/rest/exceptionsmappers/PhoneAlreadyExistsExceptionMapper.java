package com.ulises.usersserver.rest.exceptionsmappers;

import com.ulises.usersserver.rest.dto.ErrorDTO;
import com.ulises.usersserver.services.exceptions.PhoneAlreadyExistsException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import static com.ulises.usersserver.constants.Constants.REQUEST_ERROR_PHONE_ALREADY_EXISTS;

public class PhoneAlreadyExistsExceptionMapper implements ExceptionMapper<PhoneAlreadyExistsException> {
    @Override
    public Response toResponse(PhoneAlreadyExistsException e) {
        final ErrorDTO errorDTO = ErrorDTO.builder()
                .message(REQUEST_ERROR_PHONE_ALREADY_EXISTS)
                .build();
        return Response.status(Response.Status.BAD_REQUEST)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(errorDTO)
                .build();
    }
}