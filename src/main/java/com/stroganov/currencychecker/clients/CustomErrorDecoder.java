package com.stroganov.currencychecker.clients;

import com.stroganov.currencychecker.exceptions.BadRequestException;
import com.stroganov.currencychecker.exceptions.ForbiddenException;
import com.stroganov.currencychecker.exceptions.PageNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Value;

public class CustomErrorDecoder implements ErrorDecoder {
    public static final String FORBIDDEN_MESSAGE = "No App ore wrong ID provided: ";
    @Value("${exception.feignException.message}")
    private String genericExceptionMessage;

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400:
                return new BadRequestException(response.reason());
            case 404:
                return new PageNotFoundException(response.reason());
            case 403:
                return new ForbiddenException(FORBIDDEN_MESSAGE + response.toString());

            default:
                return new Exception(genericExceptionMessage + " " + response.reason());
        }
    }
}
