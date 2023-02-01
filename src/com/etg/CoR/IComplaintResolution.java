package com.etg.CoR;

import java.util.ArrayList;

public abstract class IComplaintResolution {
    public static ArrayList<Complaint> numberOfComplaints = new ArrayList<>();
    protected IComplaintResolution nextDepartment;
    public void addNextHandler(IComplaintResolution nextDepartment) {
        this.nextDepartment = nextDepartment;
    }

    public double getNumberOfComplaints() {
        return numberOfComplaints.size();
    }

    abstract void logComplaint(Complaint complaint);
}
