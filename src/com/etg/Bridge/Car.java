package com.etg.Bridge;
// Concrete implemntation 1

public class Car extends Vehicle{

    @Override
    String diagnoseProblem() {
        return "Problem with CAR";
    }

    @Override
    String doWork() {
        this.currentState = "Inprogress";
        String listOfWOrkDone = "";
        listOfWOrkDone += "Fixing main problem: " + diagnoseProblem() + "\n";
        listOfWOrkDone += "Rotating 4 tires\n";
        listOfWOrkDone += "Cleaning outSide\n";
        listOfWOrkDone += "Cleaning inside";
        this.addCost(260);
        return listOfWOrkDone;
    }
}
