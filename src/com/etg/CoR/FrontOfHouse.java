package com.etg.CoR;

import java.util.ArrayList;

public class FrontOfHouse extends IComplaintResolution{

    public FrontOfHouse() {
    }

    @Override
    public void logComplaint(Complaint complaint) {
        if ( (complaint.complaint_category == CATEGORY.CUSTOMER_SERVICE) || (this.nextDepartment == null) ){
            System.out.println("Complaint logged with front of house department");
            numberOfComplaints.add(complaint);
            complaint.resolveComplaint();
        } else {
            this.nextDepartment.logComplaint(complaint);
        }
    }


}
