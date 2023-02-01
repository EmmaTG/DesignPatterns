package com.etg.Proxy;

import java.util.ArrayList;

public class RecipeStore implements IStoredRecipes {

    @Override
    public ArrayList<String> getRecipeIngredients(String name) {
        System.out.println("GETTING INGREDIENTS FOR " + name + " FROM STORAGE");
        String ingredient1 = "Tomato";
        String ingredient2 = "Ham";
        String ingredient3 = "Cheese";
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add(ingredient1);
        if (!name.equals("Vegetarian")) {
            ingredients.add(ingredient2);
        }
        if (!name.equals("LactoseFree")) {
            ingredients.add(ingredient3);
        }
        return ingredients;
    }

    @Override
    public Recipe getRecipe(String name) {
        System.out.println("GETTING RECIPE (" + name + ") FROM STORAGE");
        Recipe recipe;
        if (name.equals("Vegetarian")){
            recipe = new Recipe("Vegetarian");
            recipe.addIngredient("Cheese");
            recipe.addIngredient("Tomato");
            recipe.addLineToMethod("Prep, no need to cook :P");
        }
        else if (name.equals("LactoseFree")){
            recipe = new Recipe("LactoseFree");
            recipe.addIngredient("Ham");
            recipe.addIngredient("Tomato");
            recipe.addLineToMethod("Prep no fun pizza");
        }
        else {
            recipe = new Recipe("Normal");
            recipe.addIngredient("Ham");
            recipe.addIngredient("Cheese");
            recipe.addIngredient("Tomato");
            recipe.addLineToMethod("Prep proper pizza");
        }
        return recipe;
    }

    @Override
    public ArrayList<Recipe> listAllRecipes() {
        System.out.println("GETTING RECIPES FROM STORAGE");
        ArrayList<Recipe> recipes = new ArrayList<>();
        Recipe recipe;
        recipe = new Recipe("Vegetarian");
        recipe.addIngredient("Cheese");
        recipe.addIngredient("Tomato");
        recipe.addLineToMethod("Prep, no need to cook :P");
        recipes.add(recipe);
        return recipes;
    }
}
