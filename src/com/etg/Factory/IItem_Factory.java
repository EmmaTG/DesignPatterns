package com.etg.Factory;

//Factory: Base creator
public abstract class IItem_Factory {
    String item_type;

    public abstract IItem create_item();

    public boolean check_if_available(IItem item){
        return item.is_checked_out();
    }

    public String getItem_type(){
        return this.item_type;
    }

    boolean check_out_item(IItem item){
        if (check_if_available(item)) {
            if (item.getTime_checked_out() != null) {
                item.setTime_checked_out();
                item.setCheckedOut(true);
                return true;
            }
        }
        return false;
    }
}
