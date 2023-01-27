package com.etg.Composite;

import java.util.ArrayList;

// Composite: element with sub-elements
public class PizzaProduction implements IDivision{

    ArrayList<IDivision> divisions = new ArrayList<>();

    @Override
    public String workToBeDone() {
        System.out.println("THe pizza cooking process has begun:");
        for (IDivision div : divisions){
            div.workToBeDone();
        }
        return null;
    }
    public void addDivision(IDivision division){
        divisions.add(division);
    }

    public ArrayList<IDivision> getSubDivision(){
        return divisions;
    }
}
