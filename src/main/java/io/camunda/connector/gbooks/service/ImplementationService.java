package io.camunda.connector.gbooks.service;

import org.springframework.http.HttpHeaders;
public class ImplementationService {


    public HttpHeaders getHeaders(String token) {
        var headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, "application/json");
        headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        return headers;
    }
}
