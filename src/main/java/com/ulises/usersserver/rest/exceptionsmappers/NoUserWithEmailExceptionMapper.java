package com.ulises.usersserver.rest.exceptionsmappers;

import com.ulises.usersserver.rest.dto.ErrorDTO;
import com.ulises.usersserver.rest.dto.ErrorDTOBuilder;
import com.ulises.usersserver.services.exceptions.NoUserWithEmailException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import static com.ulises.usersserver.constants.Constants.REQUEST_ERROR_USER_NOT_FOUND_WITH_EMAIL;

public class NoUserWithEmailExceptionMapper implements ExceptionMapper<NoUserWithEmailException> {
    @Override
    public Response toResponse(NoUserWithEmailException e) {
        final ErrorDTO errorDTO = ErrorDTOBuilder.builder()
                .message(REQUEST_ERROR_USER_NOT_FOUND_WITH_EMAIL)
                .build();
        return Response.status(Response.Status.NOT_FOUND)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(errorDTO)
                .build();
    }
}