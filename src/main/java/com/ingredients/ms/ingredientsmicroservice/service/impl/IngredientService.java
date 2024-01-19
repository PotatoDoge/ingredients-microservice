package com.ingredients.ms.ingredientsmicroservice.service.impl;

import com.ingredients.ms.ingredientsmicroservice.dto.IngredientDto;
import com.ingredients.ms.ingredientsmicroservice.entity.Ingredient;
import com.ingredients.ms.ingredientsmicroservice.service.BaseEntityService;

public class IngredientService implements BaseEntityService<Ingredient, IngredientDto> {
    @Override
    public Ingredient save(IngredientDto entity) {
        return null;
    }

    @Override
    public Ingredient findById(Long id) {
        return null;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Ingredient update(Long id, IngredientDto entity) {
        return null;
    }
}
