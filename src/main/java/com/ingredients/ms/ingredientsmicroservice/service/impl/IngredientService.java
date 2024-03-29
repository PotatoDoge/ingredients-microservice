package com.ingredients.ms.ingredientsmicroservice.service.impl;

import com.ingredients.ms.ingredientsmicroservice.auth.ExternalAuthenticationService;
import com.ingredients.ms.ingredientsmicroservice.dto.IngredientDto;
import com.ingredients.ms.ingredientsmicroservice.entity.Ingredient;
import com.ingredients.ms.ingredientsmicroservice.repository.IngredientRepository;
import com.ingredients.ms.ingredientsmicroservice.response.exception.NotFoundInDatabase;
import com.ingredients.ms.ingredientsmicroservice.response.exception.UnauthorizedUser;
import com.ingredients.ms.ingredientsmicroservice.service.BaseEntityService;
import com.ingredients.ms.ingredientsmicroservice.util.mapper.IngredientMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class IngredientService implements BaseEntityService<Ingredient, IngredientDto> {

    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;
    private final ExternalAuthenticationService authenticationService;

    @Override
    public Ingredient save(IngredientDto ingredientDto, String token) {
        boolean isAuthenticated = authenticationService.authenticateToken(token);
        if(!isAuthenticated){
            throw new UnauthorizedUser("Unauthorized user!");
        }
        Ingredient ingredient = ingredientMapper.mapDtoToEntity(ingredientDto);
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient findById(Long id, String token) {
        Ingredient ingredient = ingredientRepository.findById(id).orElse(null);
        if(ingredient == null){
            log.info("Ingredient not found with id: {}", id);
            throw new NotFoundInDatabase("Ingredient not found with that id in the database");
        }
        log.info("Ingredient found with code:{}", id);
        return ingredient;
    }

    @Override
    public Iterable<Ingredient> findAll(String token) {
        boolean isAuthenticated = authenticationService.authenticateToken(token);
        if(!isAuthenticated){
            throw new UnauthorizedUser("Unauthorized user!");
        }
        List<Ingredient> ingredients = ingredientRepository.findAll();
        if(ingredients.isEmpty()){
            log.info("No ingredients found in database");
            throw new NotFoundInDatabase("There were no ingredients found in the database");
        }
        log.info("Ingredients found in database");
        return ingredients;
    }

    @Override
    public void delete(Long id, String token) {
        Ingredient ingredient = ingredientRepository.findById(id).orElse(null);
        if(ingredient == null){
            log.info("Ingredient not found with id: {}", id);
            throw new NotFoundInDatabase("Ingredient not found with that id in the database");
        }
        ingredientRepository.deleteById(id);
        log.info("Ingredient with ID: {} was deleted successfully",id);
    }

    @Override
    public Ingredient update(Long id, IngredientDto ingredientDto, String token) {
        Ingredient ingredient = ingredientRepository.findById(id).orElse(null);
        if(ingredient == null){
            log.info("Ingredient not found with id: {}", id);
            throw new NotFoundInDatabase("Ingredient not found with that id in the database");
        }
        Ingredient toBeUpdated = ingredientMapper.mapDtoToEntity(ingredientDto);
        toBeUpdated.setId(id);
        Ingredient updatedIngredient = ingredientRepository.save(toBeUpdated);
        log.info("Ingredient with ID:{} was updated successfully",id);
        return updatedIngredient;
    }
}
