package com.ulises.usersserver.rest.exceptionsmappers;

import com.ulises.usersserver.services.exceptions.IDAlreadyExistsException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;


public class IDAlreadyExistsExceptionMapper implements ExceptionMapper<IDAlreadyExistsException> {
    @Override
    public Response toResponse(IDAlreadyExistsException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity("")
                .build();
    }
}