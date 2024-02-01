package com.ingredients.ms.ingredientsmicroservice.service;

import com.ingredients.ms.ingredientsmicroservice.entity.Ingredient;

public interface BaseEntityService <T, D> {

    T save(D entity, String token);

    T findById(Long id, String token);

    Iterable<T> findAll(String token);

    void delete(Long id, String token);

    T update(Long id, D entity, String token);

}