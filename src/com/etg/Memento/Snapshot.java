package com.etg.Memento;

import java.util.ArrayList;

public class Snapshot {

    private ReservationSystem originator;
    private ArrayList<Reservation> reservations;

    public Snapshot(ReservationSystem originator, ArrayList<Reservation> reservations) {
        this.originator = originator;
        this.reservations = new ArrayList<>();
        for (Reservation r : reservations){
            this.reservations.add(r.clone(r));
        }
    }

    public void restore(){
        this.originator.setReservations(this.reservations);
    }
}
