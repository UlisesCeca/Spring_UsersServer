package com.ulises.usersserver.services;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpHeaders;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
public class HttpServiceImpl implements HttpService {
    @Override
    public Response post(String endpoint, Object body, HttpHeaders headers, MultiValueMap<String, String> parameters) {
        JSONObject json = new JSONObject(body);
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(endpoint);
        RestTemplate restTemplate;
        ResponseEntity<String> response;
        HttpEntity<String> entity;

        factory.setReadTimeout(10000);
        factory.setConnectTimeout(10000);
        if(headers == null)
            headers = new HttpHeaders();
        if(parameters != null)
            builder.queryParams(parameters);
        restTemplate = new RestTemplate(factory);
        entity = new HttpEntity<>(json.toString(), headers);
        try {
            response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.POST, entity, String.class);

            return Response.status(response.getStatusCodeValue())
                    .entity(response.getBody())
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        } catch (HttpClientErrorException e) {
            return Response.status(e.getStatusCode().value())
                    .entity(e.getResponseBodyAsString())
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        }
    }

    @Override
    public boolean checkStatusIsOK(int status) {
        return status >= 200 && status < 300;
    }
}
