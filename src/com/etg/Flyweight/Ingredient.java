package com.etg.Flyweight;

public class Ingredient {
    IngredientType ingredientType;
    double x;
    double y;

    public Ingredient(IngredientType ingredientType, double x, double y) {
        this.ingredientType = ingredientType;
        this.x = x;
        this.y = y;
    }

    public double getCost(){
        return ingredientType.costOfIngredient();
    }
}
