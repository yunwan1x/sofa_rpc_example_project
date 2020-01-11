package com.alipay.sofa.rpc.samples.model;

public class Statics {

     private int staffNumber;
    private Staff firstStaff;

    public int getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(int staffNumber) {
        this.staffNumber = staffNumber;
    }

    public Staff getFirstStaff() {
        return firstStaff;
    }

    public void setFirstStaff(Staff firstStaff) {
        this.firstStaff = firstStaff;
    }

    private static Statics statics;

    private Statics(){

    }

    public static Statics createStatic(){
        if(statics==null)return new Statics();
        return statics;
    }
}
