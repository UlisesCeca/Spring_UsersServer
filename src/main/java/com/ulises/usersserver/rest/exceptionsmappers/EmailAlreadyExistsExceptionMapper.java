package com.ulises.usersserver.rest.exceptionsmappers;

import com.ulises.usersserver.services.exceptions.EmailAlreadyExistsException;
import org.json.JSONObject;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;


public class EmailAlreadyExistsExceptionMapper implements ExceptionMapper<EmailAlreadyExistsException> {
    @Override
    public Response toResponse(EmailAlreadyExistsException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(new JSONObject().put("error", e.getClass().getSimpleName()).toMap())
                .build();
    }
}
