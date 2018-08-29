package com.ulises.usersserver.rest.exceptionsmappers;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.ArrayList;
import java.util.List;

public class ConstraintViolationMapper implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(final ConstraintViolationException exception) {
        List<String> errors = new ArrayList<>();
        for (ConstraintViolation constraintViolation : exception.getConstraintViolations()) {
            errors.add(constraintViolation.getMessage());
        }
        return Response.status(Response.Status.PRECONDITION_FAILED)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(errors)
                .build();
    }
}