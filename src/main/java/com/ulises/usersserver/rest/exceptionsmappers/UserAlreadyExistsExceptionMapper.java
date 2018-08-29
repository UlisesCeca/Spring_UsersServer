package com.ulises.usersserver.rest.exceptionsmappers;
import com.ulises.usersserver.services.exceptions.UserAlreadyExistsException;
import org.json.JSONObject;
import org.springframework.util.StringUtils;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class UserAlreadyExistsExceptionMapper implements ExceptionMapper<UserAlreadyExistsException> {
    @Override
    public Response toResponse(UserAlreadyExistsException e) {
        System.out.println();
        return Response.status(Response.Status.BAD_REQUEST)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(new JSONObject().put("error", e.getClass().getSimpleName()).toMap())
                .build();
    }
}