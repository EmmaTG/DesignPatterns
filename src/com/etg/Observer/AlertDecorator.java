package com.etg.Observer;

public class AlertDecorator implements IAlert{

    protected Notifier notifier;

    public AlertDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void sendAlert(String pizzaname) {
        this.notifier.sendAlert(pizzaname);
    }
}
