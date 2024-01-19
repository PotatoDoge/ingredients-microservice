package com.ingredients.ms.ingredientsmicroservice.entity;

import com.ingredients.ms.ingredientsmicroservice.util.Unit;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Ingredient {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    private String ingredientCode;

    private String name;

    private int quantity;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Unit unit;

}
