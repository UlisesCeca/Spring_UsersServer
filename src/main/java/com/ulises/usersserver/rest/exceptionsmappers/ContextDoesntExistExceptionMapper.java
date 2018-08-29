package com.ulises.usersserver.rest.exceptionsmappers;

import com.ulises.usersserver.services.exceptions.ContextDoesntExistException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class ContextDoesntExistExceptionMapper implements ExceptionMapper<ContextDoesntExistException> {
    @Override
    public Response toResponse(ContextDoesntExistException e) {
        return Response.status(Response.Status.NOT_FOUND)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity("")
                .build();
    }
}