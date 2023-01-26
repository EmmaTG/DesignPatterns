package com.etg.Composite;

public class Delivery  implements IDivision{

    @Override
    public String workToBeDone() {
        System.out.println("Delivery in progress");
        return null;
    }
}
