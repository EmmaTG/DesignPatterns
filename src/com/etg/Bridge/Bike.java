package com.etg.Bridge;
// Concrete implemntation 1

public class Bike extends Vehicle{

    @Override
    String doWork() {
        this.currentState = "Inprogress";
        String listOfWOrkDone = "";
        listOfWOrkDone += "Fixing main problem: " + diagnoseProblem() + "\n";
        listOfWOrkDone += "Rotating 2 tires\n";
        listOfWOrkDone += "Cleaning bike";

        this.currentState = "COMPLETED";
        this.addCost(150);
        return listOfWOrkDone;
    }

    @Override
    String diagnoseProblem() {
        return "Problem with bike";
    }
}
