package com.etg.Flyweight;

import java.util.HashMap;
import java.util.Map;

public class IngredientFactory {

    static  Map<String, IngredientType> ingredients = new HashMap<>();

    public static IngredientType getIngredientType(String type, String color, double cost){
        IngredientType ingredient = ingredients.get(type);
        if (ingredient == null) {
            ingredient = new IngredientType(color, cost);
            ingredients.put(type,ingredient);
        }
        return ingredient;
    }
}
