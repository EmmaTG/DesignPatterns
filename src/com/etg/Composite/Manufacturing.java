package com.etg.Composite;

public class Manufacturing implements IDivision{
    @Override
    public String workToBeDone() {
        System.out.println("Manufacturing begun");
        return null;
    }
}
