package com.etg.Proxy;

import java.util.ArrayList;
import java.util.HashMap;

public class RecipeCache implements IStoredRecipes{
    private final IStoredRecipes service;
    private final HashMap<String,Recipe> cachedRecipes;
    private final HashMap<String,ArrayList<String>> cachedIngredients;
    private boolean needReset;

    public RecipeCache(IStoredRecipes service) {
        this.service = service;
        this.cachedRecipes = new HashMap<>();
        this.cachedIngredients = new HashMap<>();
    }

    @Override
    public ArrayList<String> getRecipeIngredients(String name) {
        ArrayList<String> ingredients = cachedIngredients.get(name);
        if ( (cachedIngredients.isEmpty()) || (ingredients == null) ){
            ingredients = this.service.getRecipeIngredients(name);
            cachedIngredients.put(name,ingredients);
        }
        return ingredients;
    }

    @Override
    public Recipe getRecipe(String name) {
        Recipe recipe = cachedRecipes.get(name);
        if ( (cachedRecipes.isEmpty()) || (recipe == null) ){
            recipe = this.service.getRecipe(name);
            cachedRecipes.put(name,recipe);
        }
        return recipe;
    }

    @Override
    public ArrayList<Recipe> listAllRecipes() {
        ArrayList<Recipe> allRecipes = new ArrayList<>();
        if (cachedRecipes.isEmpty() || needReset){
            allRecipes = service.listAllRecipes();
        }
        return allRecipes;
    }
}
