package com.etg.Decorator;

public class CalzoneDecorator extends PizzaProductionDecorator {

    public CalzoneDecorator(IPizzaProduction pizzaProduction) {
        super(pizzaProduction);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Fold pizza in half");
    }

    @Override
    public void cook() {
        super.cook();
    }
}
