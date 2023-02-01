package com.etg.Proxy;

import java.util.ArrayList;

public interface IStoredRecipes {

    ArrayList<String> getRecipeIngredients(String name);
    Recipe getRecipe(String name);
    ArrayList<Recipe> listAllRecipes();
}
