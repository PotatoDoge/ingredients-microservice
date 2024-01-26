package com.ingredients.ms.ingredientsmicroservice.util.mapper;

import com.ingredients.ms.ingredientsmicroservice.dto.IngredientDto;
import com.ingredients.ms.ingredientsmicroservice.entity.Ingredient;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper {

    public Ingredient mapDtoToEntity(IngredientDto ingredientDto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientDto.getName());
        ingredient.setQuantity(ingredientDto.getQuantity());
        ingredient.setPrice(ingredientDto.getPrice());
        ingredient.setUnit(ingredientDto.getUnit());
        return ingredient;
    }

    public IngredientDto mapEntityToDto(Ingredient ingredient) {
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setName(ingredient.getName());
        ingredientDto.setQuantity(ingredient.getQuantity());
        ingredientDto.setPrice(ingredient.getPrice());
        ingredientDto.setUnit(ingredient.getUnit());
        return ingredientDto;
    }
}
