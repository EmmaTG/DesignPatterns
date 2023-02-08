package com.etg.Observer;

public class PhoneAlert extends Alert implements IAlert{
    public PhoneAlert(Subscriber subscriber) {
        super(subscriber);
    }

    @Override
    public void sendAlert(String pizzaname) {
        System.out.println("Sending alert to " + this.subscriber.getName().toUpperCase() + " via PHONE \n about the new pizza called: " + pizzaname);
    }
}
