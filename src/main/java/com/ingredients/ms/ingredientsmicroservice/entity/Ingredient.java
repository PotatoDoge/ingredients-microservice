package com.ingredients.ms.ingredientsmicroservice.entity;

import com.ingredients.ms.ingredientsmicroservice.util.enums.Unit;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String notes;


}
