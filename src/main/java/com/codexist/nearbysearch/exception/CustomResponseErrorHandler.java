package com.codexist.nearbysearch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class CustomResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        HttpStatus statusCode = (HttpStatus) response.getStatusCode();
        return (statusCode.is4xxClientError() || statusCode.is5xxServerError());
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        HttpStatus statusCode = (HttpStatus)response.getStatusCode();

        if (statusCode.is5xxServerError()) {
            System.err.println("Server Error: " + statusCode);
        } else if (statusCode.is4xxClientError()) {
            System.err.println("Client Error: " + statusCode);
            if (statusCode == HttpStatus.NOT_FOUND) {
                System.err.println("Error: Not Found");
            }
        }
    }
}