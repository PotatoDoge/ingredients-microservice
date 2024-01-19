package com.ingredients.ms.ingredientsmicroservice.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class HttpResponse {

    private String timestamp;
    private String message;
    private String developerMessage;
    private Map<?,?> data;

}