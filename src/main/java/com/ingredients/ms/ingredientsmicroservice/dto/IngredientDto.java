package com.ingredients.ms.ingredientsmicroservice.dto;

import com.ingredients.ms.ingredientsmicroservice.util.enums.Unit;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class IngredientDto {

    @NotBlank(message = "Name should not be empty")
    private String name;

    private String notes;
}
