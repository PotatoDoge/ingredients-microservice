package com.ingredients.ms.ingredientsmicroservice.response.exception;

public class UnauthorizedUser extends RuntimeException{

    public UnauthorizedUser(String message){
        super(message);
    }
}