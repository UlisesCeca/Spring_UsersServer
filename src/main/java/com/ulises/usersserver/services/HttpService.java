package com.ulises.usersserver.services;

import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;

import javax.ws.rs.core.Response;

public interface HttpService {
    Response post(String endpoint, Object body, HttpHeaders headers, MultiValueMap<String, String> parameters);
    boolean checkStatusIsOK(int status);
}
