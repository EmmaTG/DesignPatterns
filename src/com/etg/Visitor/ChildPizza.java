package com.etg.Visitor;

import java.util.ArrayList;

public class ChildPizza extends Element {

    public ChildPizza() {
        this.base = 10;
        this.sauce = 5;
        this.cheese = 10;
        this.toppings = new ArrayList<>();
        this.toppings.add("Ham");
    }

    @Override
    public double accept(Visitor v) {
        return v.calculateCostChild(this);
    }
}
