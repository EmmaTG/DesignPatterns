package com.etg.Factory;

import java.util.Date;
// Common product interface
public abstract class IItem {

    boolean checkedOut = false;
    Date time_checked_out = null;
    double weight;
    double volume;
    long lease_duration;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public Date getTime_checked_out(){
        return this.time_checked_out;
    }

    public void setTime_checked_out(){
        this.time_checked_out = new Date();
    }

    public void setCheckedOut(boolean b){
        this.setTime_checked_out();
        this.checkedOut = b;
    }

    public boolean is_checked_out(){
        return this.checkedOut;
    }

    public Date get_returned_time(){
        if (this.is_checked_out()){
            Date check_out_time = this.getTime_checked_out();
            long return_time = this.getTime_checked_out().getTime() + (this.lease_duration*60*60*1000);
            return new Date(return_time);
        }
        return null;
    }

    @Override
    public String toString() {
        return "IItem{" +
                "checkedOut=" + checkedOut +
                ", time_checked_out=" + time_checked_out +
                ", weight=" + weight +
                ", volume=" + volume +
                ", lease_duration=" + lease_duration +
                '}';
    }
}
