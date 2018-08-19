package com.ulises.usersserver.rest.exceptionsmappers;

import com.ulises.usersserver.rest.dto.ErrorDTOBuilder;
import org.json.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.ulises.usersserver.constants.Constants.REQUEST_ERROR_UNATHORIZED;


public class NotAuthorizedExceptionMapper implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response, AuthenticationException authException) throws IOException {
        JSONObject error = new JSONObject(
                ErrorDTOBuilder.builder()
                        .message(REQUEST_ERROR_UNATHORIZED)
                        .build()
        );
        response.addHeader("Content-Type", "application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().println(error);
    }
}