package by.home.kitchen.service;

import by.home.kitchen.domain.Recipe;

import java.util.List;

public interface IRecipeService {
    List<Recipe> findAll();

    void save(Recipe recipe);

    void save(List<Recipe> products);
}
