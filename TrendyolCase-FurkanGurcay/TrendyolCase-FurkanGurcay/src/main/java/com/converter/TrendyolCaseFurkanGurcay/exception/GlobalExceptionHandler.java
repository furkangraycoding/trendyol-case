package com.converter.TrendyolCaseFurkanGurcay.exception;

import com.converter.TrendyolCaseFurkanGurcay.dto.LoggerDTO;
import com.converter.TrendyolCaseFurkanGurcay.model.Logger;
import com.converter.TrendyolCaseFurkanGurcay.service.LoggerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    private final LoggerService loggerService;

    @ExceptionHandler({LinkIsNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Logger> handleException(LinkIsNotValidException linkIsNotValidException) {
        Logger response = prepareErrorResponse(HttpStatus.BAD_REQUEST, linkIsNotValidException.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private Logger prepareErrorResponse(HttpStatus httpStatus, String message) {
        LoggerDTO response = new LoggerDTO();
        response.setThrowStatusCode(httpStatus.value());
        response.setThrowMessage(message);
        response.setThrowDate(LocalDate.now());
        return loggerService.save(response);

    }
}
