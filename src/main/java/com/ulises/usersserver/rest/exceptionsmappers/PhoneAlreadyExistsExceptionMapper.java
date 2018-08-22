package com.ulises.usersserver.rest.exceptionsmappers;

import com.ulises.usersserver.services.exceptions.PhoneAlreadyExistsException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class PhoneAlreadyExistsExceptionMapper implements ExceptionMapper<PhoneAlreadyExistsException> {
    @Override
    public Response toResponse(PhoneAlreadyExistsException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity("")
                .build();
    }
}