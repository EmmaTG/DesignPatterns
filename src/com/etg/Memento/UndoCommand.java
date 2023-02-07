package com.etg.Memento;

import com.etg.Command.Command;
import com.etg.Command.History;

import java.util.Stack;

public class UndoCommand implements Command {

    private History history;

    public UndoCommand(History history) {
        this.history = history;
    }

    @Override
    public void execute() {
        this.history.undo();
    }
}
