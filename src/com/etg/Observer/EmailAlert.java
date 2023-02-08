package com.etg.Observer;

public class EmailAlert extends Alert implements IAlert{

    public EmailAlert(ISubscriber subscriber) {
        super(subscriber);
    }

    @Override
    public void sendAlert(String pizzaname) {
        this.notifier.sendAlert(pizzaname);
        System.out.println("Sending alert to " + this.subscriber.getName().toUpperCase() + " via EMAIL \n about the new pizza called: " + pizzaname);
    }
}
