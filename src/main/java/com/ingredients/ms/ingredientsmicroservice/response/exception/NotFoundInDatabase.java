package com.ingredients.ms.ingredientsmicroservice.response.exception;

public class NotFoundInDatabase extends RuntimeException{

    public NotFoundInDatabase(String message){
        super(message);
    }
}