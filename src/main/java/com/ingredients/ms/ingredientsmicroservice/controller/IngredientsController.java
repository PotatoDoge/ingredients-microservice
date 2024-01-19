package com.ingredients.ms.ingredientsmicroservice.controller;

import com.ingredients.ms.ingredientsmicroservice.dto.IngredientDto;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
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

    @PostMapping
    public String addIngredient(@Valid @RequestBody IngredientDto ingredientDto){
        System.out.println(ingredientDto.toString());
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
