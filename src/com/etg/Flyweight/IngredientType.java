package com.etg.Flyweight;

public class IngredientType {
    private String colour;
    private double cost;

    public IngredientType(String colour, double cost) {
        this.colour = colour;
        this.cost = cost;
    }

    public double costOfIngredient(){
        return this.cost;
    }
}
