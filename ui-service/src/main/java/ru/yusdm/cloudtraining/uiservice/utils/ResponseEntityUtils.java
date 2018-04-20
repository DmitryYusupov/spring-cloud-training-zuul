package ru.yusdm.cloudtraining.uiservice.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.OK;

public class ResponseEntityUtils {
    private ResponseEntityUtils() {

    }

    public static <T> T extractFromResponseEntity(ResponseEntity<T> responseEntity) {
        HttpStatus httpStatus = responseEntity.getStatusCode();
        threwErrorIfResponseStatusIsNotOK(httpStatus);
        return responseEntity.getBody();
    }

    public static void threwErrorIfResponseStatusIsNotOK(HttpStatus httpStatus) {
        if (!OK.equals(httpStatus)) {
            throw getExceptionIfSomethingWrong(httpStatus);
        }
    }

    private static RuntimeException getExceptionIfSomethingWrong(HttpStatus httpStatus) {
        return new RuntimeException("Something goes wrong, HttpStaus is " + httpStatus);
    }

}
