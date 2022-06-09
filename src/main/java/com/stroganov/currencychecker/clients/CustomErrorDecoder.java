package com.stroganov.currencychecker.clients;

import com.stroganov.currencychecker.exceptions.BadRequestException;
import com.stroganov.currencychecker.exceptions.ForbiddenException;
import com.stroganov.currencychecker.exceptions.PageNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;

@Log4j2
public class CustomErrorDecoder implements ErrorDecoder {
    public static final String FORBIDDEN_MESSAGE = "No App ore wrong ID provided: ";
    @Value("${exception.feignException.message}")
    private String genericExceptionMessage;

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400: {
                log.error(response.status() + response.reason());
                return new BadRequestException(response.reason());
            }
            case 404: {
                log.error(response.status() + response.reason());
                return new PageNotFoundException(response.reason());
            }
            case 403: {
                log.error(response.status() + response.reason());
                return new ForbiddenException(FORBIDDEN_MESSAGE + response);
            }

            default: {
                log.error(response.status() + response.reason());
                return new Exception(genericExceptionMessage + " " + response.reason());
            }
        }
    }
}
