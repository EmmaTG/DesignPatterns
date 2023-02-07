package com.etg.Memento;

import com.etg.Command.Command;
import com.etg.Command.History;

import java.util.ArrayList;

public class ReservationSystem {
    // Originator
    private ArrayList<Reservation> reservations;
    private History history;

    public ReservationSystem(History history) {
        this.history = history;
        this.reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation){
        this.reservations.add(reservation);
    }

    public void createSnapshot(){
        this.history.createBackup(new Snapshot(this,this.reservations));
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return "Reservations=" + reservations + "\n";
    }
}
