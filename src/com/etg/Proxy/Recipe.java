package com.etg.Proxy;

import java.util.ArrayList;

public class Recipe {

    String name;
    ArrayList<String> ingredients;
    ArrayList<String> method;

    public Recipe(String name) {
        this.name = name;
        this.ingredients = new ArrayList<>();
        this.method = new ArrayList<>();
    }

    public void addIngredient(String newIngredient){
        this.ingredients.add(newIngredient);
    }

    public void addLineToMethod(String step){
        this.method.add(step);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", method=" + method +
                '}';
    }
}
