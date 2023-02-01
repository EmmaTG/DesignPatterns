package com.etg.CoR;

public class Nondescript extends IComplaintResolution{

    public Nondescript() {
    }

    @Override
    public void logComplaint(Complaint complaint) {
        if ( (complaint.complaint_category == CATEGORY.OTHER) || (this.nextDepartment == null) ){
            System.out.println("Complaint has not been filed within a department. The manager will handle this!");
            numberOfComplaints.add(complaint);
            complaint.resolveComplaint();
        } else {
            this.nextDepartment.logComplaint(complaint);
        }
    }
}
