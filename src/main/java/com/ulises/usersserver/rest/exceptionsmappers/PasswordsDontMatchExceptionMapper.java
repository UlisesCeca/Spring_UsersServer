package com.ulises.usersserver.rest.exceptionsmappers;

import com.ulises.usersserver.rest.dto.ErrorDTO;
import com.ulises.usersserver.rest.dto.ErrorDTOBuilder;
import com.ulises.usersserver.services.exceptions.PasswordsDontMatchException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import static com.ulises.usersserver.constants.Constants.REQUEST_ERROR_PASSWORDS_DONT_MATCH;

public class PasswordsDontMatchExceptionMapper implements ExceptionMapper<PasswordsDontMatchException> {
    @Override
    public Response toResponse(PasswordsDontMatchException e) {
        final ErrorDTO errorDTO = ErrorDTOBuilder.builder()
                .message(REQUEST_ERROR_PASSWORDS_DONT_MATCH)
                .build();
        return Response.status(Response.Status.BAD_REQUEST)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(errorDTO)
                .build();
    }
}