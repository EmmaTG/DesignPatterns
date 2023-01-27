package com.etg.Composite;

public class Delivery  implements IDivision{

    @Override
    public String workToBeDone() {
        System.out.println("Delivery of Pizza is in progress");
        return null;
    }
}
