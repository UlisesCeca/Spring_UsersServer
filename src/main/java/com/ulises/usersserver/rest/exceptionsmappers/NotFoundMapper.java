package com.ulises.usersserver.rest.exceptionsmappers;

import com.ulises.usersserver.rest.dto.ErrorDTO;
import com.ulises.usersserver.constants.Constants;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class NotFoundMapper implements ExceptionMapper<NotFoundException> {
    @Override
    public Response toResponse(NotFoundException e) {
        final ErrorDTO errorDTO = ErrorDTO.builder()
                .message(Constants.REQUEST_ERROR_NOT_FOUND)
                .build();
        return Response.status(Response.Status.NOT_FOUND)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(errorDTO)
                .build();
    }
}