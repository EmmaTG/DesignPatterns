package com.etg.Memento;

import com.etg.Command.Command;
import com.etg.Command.History;

import java.util.ArrayList;

public class ReservationSystem {
    // Originator
    private ArrayList<Reservation> reservations;
    private History history;
    private UndoCommand command;

    public ReservationSystem(History history, UndoCommand undo) {
        this.history = history;
        this.command = undo;
        this.reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation){
        this.reservations.add(reservation);
    }

    public void save(){
        this.history.createBackup(new Snapshot(this,this.reservations));
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void undo(){
        this.command.execute();
    }

    @Override
    public String toString() {
        return "Reservations=" + reservations + "\n";
    }
}
