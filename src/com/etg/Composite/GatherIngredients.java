package com.etg.Composite;

public class GatherIngredients implements IDivision{
    @Override
    public String workToBeDone() {
        System.out.println("Ingredients for pizzas being collected");
        return null;
    }
}
