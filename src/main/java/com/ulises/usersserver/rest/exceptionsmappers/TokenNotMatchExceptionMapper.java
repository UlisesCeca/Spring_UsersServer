package com.ulises.usersserver.rest.exceptionsmappers;

import com.ulises.usersserver.services.exceptions.TokenNotMatchException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class TokenNotMatchExceptionMapper implements ExceptionMapper<TokenNotMatchException> {
    @Override
    public Response toResponse(TokenNotMatchException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity("")
                .build();
    }
}