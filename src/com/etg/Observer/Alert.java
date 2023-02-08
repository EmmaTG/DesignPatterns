package com.etg.Observer;

abstract class Alert implements IAlert{
    ISubscriber subscriber;
    IAlert notifier;

    public Alert(ISubscriber subscriber) {
        this.subscriber = subscriber;
        this.notifier = subscriber.getNotifier();
    }
}
