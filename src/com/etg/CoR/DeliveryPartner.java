package com.etg.CoR;

public class DeliveryPartner extends IComplaintResolution{

    public DeliveryPartner() {
    }

    @Override
    public void logComplaint(Complaint complaint) {
        if ( (complaint.complaint_category == CATEGORY.PACKAGING) || (complaint.complaint_category == CATEGORY.DELIVERY) ||
                (this.nextDepartment == null) ){
            System.out.println("Complaint logged with out delivery partner");
            numberOfComplaints.add(complaint);
            complaint.resolveComplaint();
        } else {
            this.nextDepartment.logComplaint(complaint);
        }
    }
}
