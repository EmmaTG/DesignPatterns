package com.etg.Strategy;

import java.util.ArrayList;

public class CorrectMethod implements Method{

    @Override
    public ArrayList<String> buildPizza() {
        ArrayList<String> method = new ArrayList<>();
        method.add("Spin dough in hand until circular in shape");
        method.add("Spread tomato sauce onto dough");
        method.add("Add cheese on top of dough");
        method.add("Spread toppings out evenly");
        method.add("Cook in a wood fired pizza oven");
        return method;
    }
}
