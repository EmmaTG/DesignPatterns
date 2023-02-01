package com.etg.Proxy;

import java.util.ArrayList;

public class RecipeManager {
    protected IStoredRecipes service;

    public RecipeManager(IStoredRecipes service) {
        this.service = service;
    }

    public Recipe findRecipe(String name){
        return this.service.getRecipe(name);
    }

    public ArrayList<String> getRecipeIngredients(String name){
        return this.service.getRecipeIngredients(name);
    }

    public ArrayList<Recipe> getAllRecipes(){
        return this.service.listAllRecipes();
    }
}
