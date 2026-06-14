package com.system.sms.model;

public class HostelerStudent extends Student {
    private String HostelBlock;
    private int RoomNumber;

    HostelerStudent(int studentId, String name, String email, int attendance, double grade,String hostelBlock,int RoomNumber){
        super(studentId,name,email,attendance,grade);
        this.HostelBlock=hostelBlock;
        this.RoomNumber=RoomNumber;
    }
    public String getHostelBlock() { return HostelBlock; }
    public void setHostelBlock(String hostelBlock) { this.HostelBlock = hostelBlock; }

    public int getRoomNumber(){return RoomNumber;}

    public void setRoomNumber(int RoomNumber){
        this.RoomNumber=RoomNumber;
    }

    @Override
    public double calculateFee() {
        double baseFee=50000.0;
        double hostelFee=30000.0;
        double messFeee=20000.0;

        double scholarship=0.0;

        if(getAttendance()>=90&&getGrade()>=8.5){
            scholarship=0.20;
        }
        else if(getAttendance()>=80&&getGrade()>=7.5){
            scholarship=0.10;
        }
        double totalfee=baseFee+hostelFee+messFeee;
        return totalfee-(totalfee*scholarship);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Hostel: %s-%d", HostelBlock,RoomNumber) ;
    }
}
