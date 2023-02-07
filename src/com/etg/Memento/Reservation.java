package com.etg.Memento;

import java.util.Date;

public class Reservation {

    String name;
    Date dateTime;
    int people;

    public Reservation(String name, Date dateTime, int people) {
        this.name = name;
        this.dateTime = dateTime;
        this.people = people;
    }

    public Reservation clone(Reservation reservation){
        return new Reservation(reservation.name, reservation.dateTime, reservation.people);
    }

    @Override
    public String toString() {
        return "\nReservation{" +
                "name='" + name + '\'' +
                ", dateTime=" + dateTime +
                ", people=" + people +
                "}";
    }
}
