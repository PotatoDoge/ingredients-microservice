package com.ingredients.ms.ingredientsmicroservice.service;

import com.ingredients.ms.ingredientsmicroservice.entity.Ingredient;

public interface BaseEntityService <T extends Ingredient, D> {

    T save(D entity);

    T findById(String id);

    Iterable<T> findAll();

    void delete(Long id);

    T update(Long id, D entity);

}