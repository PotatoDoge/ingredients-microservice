package com.ingredients.ms.ingredientsmicroservice.service.impl;

import com.ingredients.ms.ingredientsmicroservice.dto.IngredientDto;
import com.ingredients.ms.ingredientsmicroservice.entity.Ingredient;
import com.ingredients.ms.ingredientsmicroservice.repository.IngredientRepository;
import com.ingredients.ms.ingredientsmicroservice.service.BaseEntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IngredientService implements BaseEntityService<Ingredient, IngredientDto> {

    private final IngredientRepository ingredientRepository;

    @Override
    public Ingredient save(IngredientDto entity) {
        return null;
    }

    @Override
    public Ingredient findById(String id) {
        return ingredientRepository.findByIngredientCode(id);
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
