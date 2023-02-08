package com.etg.Observer;

public class AlertDecorator implements IAlert{

    protected Alert alertWrappee;

    public AlertDecorator(Alert alert) {
        this.alertWrappee = alert;
    }

    @Override
    public void sendAlert(String pizzaname) {
        this.alertWrappee.sendAlert(pizzaname);
    }
}
