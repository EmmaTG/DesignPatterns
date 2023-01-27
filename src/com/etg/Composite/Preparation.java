package com.etg.Composite;

public class Preparation implements IDivision{
    @Override
    public String workToBeDone() {
        System.out.println("Preparing ingredients (cutting, grating etc.)");
        return null;
    }
}
