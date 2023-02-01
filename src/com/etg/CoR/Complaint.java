package com.etg.CoR;

public class Complaint {

    CATEGORY complaint_category;
    String message;
    boolean resolved;

    public Complaint(CATEGORY complaint_category, String message) {
        this.complaint_category = complaint_category;
        this.message = message;
        this.resolved = false;
    }

    public void resolveComplaint(){
        System.out.println("Complaint: " + message.toUpperCase() + ", has been resolved");
        this.resolved = true;
    }
}
