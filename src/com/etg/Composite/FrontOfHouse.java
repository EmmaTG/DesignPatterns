package com.etg.Composite;

public class FrontOfHouse implements IDivision{

    @Override
    public String workToBeDone() {
        System.out.println("Customers is ordering their pizzas");
        return null;
    }
}
