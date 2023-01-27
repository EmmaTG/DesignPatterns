package com.etg.Decorator;

public class RollDecorator extends PizzaProductionDecorator {

    public RollDecorator(IPizzaProduction pizzaProduction) {
        super(pizzaProduction);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Roll dough into log");
    }

    @Override
    public void cook() {
        super.cook();
    }
}
