package com.ingredients.ms.ingredientsmicroservice.controller;

import com.ingredients.ms.ingredientsmicroservice.dto.IngredientDto;
import com.ingredients.ms.ingredientsmicroservice.response.HttpResponse;
import com.ingredients.ms.ingredientsmicroservice.service.impl.IngredientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;

import static java.time.LocalTime.now;
import static java.util.Map.of;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ingredients")
@AllArgsConstructor
public class IngredientsController {

    private final IngredientService ingredientService;

    @GetMapping
    public ResponseEntity<HttpResponse> getIngredients(){
        HttpResponse response = HttpResponse.
                builder()
                .data(of("ingredients",ingredientService.findAll()))
                .timestamp(now().toString())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("{ingredientId}")
    public ResponseEntity<HttpResponse> getIngredient(@PathVariable String ingredientId){
        HttpResponse response = HttpResponse.
                builder()
                .data(of("ingredient",ingredientService.findById(ingredientId)))
                .timestamp(now().toString())
                .build();
        return ResponseEntity.ok(response);
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
