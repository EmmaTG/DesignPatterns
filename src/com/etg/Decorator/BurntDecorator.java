package com.etg.Decorator;

public class BurntDecorator extends PizzaProductionDecorator {
    public BurntDecorator(IPizzaProduction pizzaProduction) {
        super(pizzaProduction);
    }

    @Override
    public void assemble() {
        super.assemble();
    }

    @Override
    public void cook() {
        super.cook();
        System.out.println("Continue to cook until black! Eww!!");
    }
}
