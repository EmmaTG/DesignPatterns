package com.etg.Fascade;

public class Delivery {
    String deliveryAddress;

    public Delivery(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void deliverFood(){
        System.out.println("Deliver food to " + deliveryAddress);
    }
}
