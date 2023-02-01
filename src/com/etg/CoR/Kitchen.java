package com.etg.CoR;

public class Kitchen extends IComplaintResolution{

    public Kitchen() {
    }
    @Override
    public void logComplaint(Complaint complaint) {
        if ( (complaint.complaint_category == CATEGORY.COOKING) || (this.nextDepartment == null) ){
            System.out.println("Complaint logged with the kitchen");
            numberOfComplaints.add(complaint);
            complaint.resolveComplaint();
        } else {
            this.nextDepartment.logComplaint(complaint);
        }
    }
}
