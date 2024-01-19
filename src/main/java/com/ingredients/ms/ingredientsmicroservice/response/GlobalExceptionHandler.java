package com.ingredients.ms.ingredientsmicroservice.response;

import com.ingredients.ms.ingredientsmicroservice.response.exception.NotFoundInDatabase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import static java.time.LocalTime.now;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<HttpResponse> handleValidationException(MethodArgumentNotValidException ex) {

        BindingResult bindingResult = ex.getBindingResult();
        Map<String, String> validationErrors = new HashMap<>();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(HttpResponse.builder()
                .timestamp(now().toString())
                .message("Validation failed")
                .data(validationErrors)
                .build());
    }

    @ExceptionHandler(NotFoundInDatabase.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<HttpResponse> handleNotFoundInDatabase(NotFoundInDatabase ex) {
        HttpResponse response = HttpResponse.builder()
                .timestamp(now().toString())
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

}