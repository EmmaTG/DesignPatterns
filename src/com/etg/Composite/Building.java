package com.etg.Composite;

import java.util.ArrayList;

public class Building  implements IDivision{

    ArrayList<IDivision> divisions = new ArrayList<>();

    public Building(ArrayList<IDivision> divisions) {
        this.divisions = divisions;
    }

    @Override
    public String workToBeDone() {
        System.out.println("Building to commence: ");
        for (IDivision div : divisions){
            div.workToBeDone();
        }
        return null;
    }
}
