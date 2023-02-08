package com.etg.Observer;

abstract class Alert implements IAlert{
    Subscriber subscriber;

    public Alert(Subscriber subscriber) {
        this.subscriber = subscriber;
    }
}
