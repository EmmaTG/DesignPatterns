package com.etg.Observer;

public class TextAlert extends Alert implements IAlert{

    public TextAlert(ISubscriber subscriber) {
        super(subscriber);
    }

    @Override
    public void sendAlert(String pizzaname) {
        this.notifier.sendAlert(pizzaname);
        System.out.println("Sending alert to " + this.subscriber.getName().toUpperCase() + " via TEXT \n about the new pizza called: " + pizzaname);
    }
}
