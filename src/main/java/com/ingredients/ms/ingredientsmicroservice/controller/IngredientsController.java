package com.ingredients.ms.ingredientsmicroservice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ingredients")
public class IngredientsController {

    @GetMapping
    public String getIngredients(){
        return "All ingredients";
    }

    @GetMapping("{ingredientId}")
    public String getIngredient(@PathVariable String ingredientId){
        return "One ingredient";
    }

    @GetMapping("{ingredientId}/test")
    public String xx(@PathVariable String ingredientId){
        return "TEST";
    }

    @PostMapping
    public String addIngredient(){
        return "Post ingredient";

    }

    @PutMapping("{ingredientId}")
    public String updateIngredient(@PathVariable String ingredientId){
        return "Update ingredient";
    }

    @DeleteMapping("{ingredientId}")
    public String deleteIngredient(@PathVariable String ingredientId){
        return "Delete ingredient";
    }

}
