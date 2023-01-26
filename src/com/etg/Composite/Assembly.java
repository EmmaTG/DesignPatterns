package com.etg.Composite;

public class Assembly implements IDivision{
    @Override
    public String workToBeDone() {
        System.out.println("Assembly begun");
        return null;
    }
}
