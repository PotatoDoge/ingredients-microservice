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

    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;

    @NotNull(message = "Price should not be null")
    private BigDecimal price;

    private String store;

    @NotNull(message = "Unit must not be null")
    private Unit unit;

}
