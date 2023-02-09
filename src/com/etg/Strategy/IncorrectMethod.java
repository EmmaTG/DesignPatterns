package com.etg.Strategy;

import java.util.ArrayList;

public class IncorrectMethod implements Method{

    @Override
    public ArrayList<String> buildPizza() {
        ArrayList<String> method = new ArrayList<>();
        method.add("Roll out and flatten into a square dough");
        method.add("Spread beschemel suace onto dough");
        method.add("No cheese on this pizza");
        method.add("Put each on individually in its own section of the pizza");
        method.add("Cook in an electric oven");
        return method;
    }
}
