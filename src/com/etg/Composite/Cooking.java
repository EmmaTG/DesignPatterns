package com.etg.Composite;

public class Cooking implements IDivision{

    @Override
    public String workToBeDone() {
        System.out.println("Pizza is beign cooked");
        return null;
    }
}
