package com.ingredients.ms.ingredientsmicroservice.service.impl;

import com.ingredients.ms.ingredientsmicroservice.dto.IngredientDto;
import com.ingredients.ms.ingredientsmicroservice.entity.Ingredient;
import com.ingredients.ms.ingredientsmicroservice.repository.IngredientRepository;
import com.ingredients.ms.ingredientsmicroservice.response.exception.NotFoundInDatabase;
import com.ingredients.ms.ingredientsmicroservice.service.BaseEntityService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class IngredientService implements BaseEntityService<Ingredient, IngredientDto> {

    private final IngredientRepository ingredientRepository;

    @Override
    public Ingredient save(IngredientDto entity) {
        return null;
    }

    @Override
    public Ingredient findById(String id) {
        Ingredient ingredient = ingredientRepository.findByIngredientCode(id);
        if(ingredient == null){
            log.info("Ingredient not found with code:{}", id);
            throw new NotFoundInDatabase("Ingredient not found with that code in the database");
        }
        log.info("Ingredient found with code:{}", id);

        return ingredient;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        if(ingredients.isEmpty()){
            log.info("No ingredients found in database");
            throw new NotFoundInDatabase("There were no ingredients found in the database");
        }
        log.info("Ingredients found in database");
        return ingredients;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Ingredient update(Long id, IngredientDto entity) {
        return null;
    }
}
