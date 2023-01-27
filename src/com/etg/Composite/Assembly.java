package com.etg.Composite;

import java.util.ArrayList;

public class Assembly implements IDivision{

    ArrayList<IDivision> divisions = new ArrayList<>();

    public Assembly(ArrayList<IDivision> divisions) {
        this.divisions = divisions;
    }

    @Override
    public String workToBeDone() {
        System.out.println("Assembling pizza: ");
        for (IDivision div : divisions){
            div.workToBeDone();
        }
        return null;
    }
}
