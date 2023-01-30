package com.etg.Flyweight;

import java.util.ArrayList;

public class SelfMadePizza {
    ArrayList<Ingredient> toppings = new ArrayList<>();

    public void addCheese(double x, double y){
        IngredientType type = IngredientFactory.getIngredientType("Cheese","Yellow",0.1);
        Ingredient cheese = new Ingredient(type,x,y);
        toppings.add(cheese);
    }

    public void addHam(double x, double y){
        IngredientType type = IngredientFactory.getIngredientType("Ham","Pink",0.2);
        Ingredient ham = new Ingredient(type,x,y);
        toppings.add(ham);

    }

    public void addTomato(double x, double y) {
        IngredientType type = IngredientFactory.getIngredientType("Tomato","Red",0.05);
        Ingredient tomato = new Ingredient(type,x,y);
        toppings.add(tomato);
    }

    public void addTruffle(double x, double y) {
        IngredientType type = IngredientFactory.getIngredientType("Truffle","Black",1.0);
        Ingredient truffle = new Ingredient(type,x,y);
        toppings.add(truffle);
    }

        public double costOfPizza(){
        double total_cost = 0.;
        for (Ingredient topping : toppings){
            total_cost += topping.getCost();
        }
        return total_cost;
    }
}
