package com.ingredients.ms.ingredientsmicroservice.service;

import com.ingredients.ms.ingredientsmicroservice.entity.Ingredient;

public interface BaseEntityService <T, D> {

    T save(D entity);

    T findById(Long id);

    Iterable<T> findAll(String token);

    void delete(Long id);

    T update(Long id, D entity);

}