package com.ulises.usersserver.rest.exceptionsmappers;

import com.ulises.usersserver.rest.dto.ErrorDTO;
import com.ulises.usersserver.rest.dto.ErrorDTOBuilder;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import static com.ulises.usersserver.constants.Constants.REQUEST_ERROR_UNATHORIZED;

public class NotAuthorizedMapper implements ExceptionMapper<NotAuthorizedException> {
    @Override
    public Response toResponse(NotAuthorizedException e) {
        System.out.println("EEEEEEEEEEEEEEEEEE");
        final ErrorDTO errorDTO = ErrorDTOBuilder.builder()
                .message(REQUEST_ERROR_UNATHORIZED)
                .build();
        return Response.status(Response.Status.UNAUTHORIZED)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(errorDTO)
                .build();
    }
}