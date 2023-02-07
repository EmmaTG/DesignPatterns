package com.etg.Command;

import com.etg.Memento.Snapshot;
import com.etg.Memento.UndoCommand;

import java.util.Stack;

public class History {

    private Stack<Snapshot> backup;

    public History() {
        this.backup = new Stack<>();
    }

    public void createBackup(Snapshot snapshot){
        System.out.println("*****SAVE: Saving reservations list");
        this.backup.push(snapshot);
    }

    public void undo(){
        System.out.println("*****UNDO: undoing last added reservations");
        if (this.backAvailable())
            this.backup.pop().restore();
    }

    private boolean backAvailable(){
        return this.backup.size()>0;
    }

}
