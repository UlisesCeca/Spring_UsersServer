package com.ulises.usersserver.rest.exceptionsmappers;

import com.ulises.usersserver.services.exceptions.TokenExpiredException;
import org.json.JSONObject;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public final class TokenExpiredExceptionMapper implements ExceptionMapper<TokenExpiredException> {
    @Override
    public Response toResponse(TokenExpiredException e) {
        return Response.status(Response.Status.NOT_FOUND)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(new JSONObject().put("error", e.getClass().getSimpleName()).toMap())
                .build();
    }
}