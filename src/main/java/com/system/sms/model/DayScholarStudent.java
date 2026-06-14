package com.system.sms.model;

public class DayScholarStudent extends Student{
    private String transportMode;
    private String locality;

    public DayScholarStudent(int studentId, String name, String email, int attendance, double grade, String transportMode,String locality) {
        super(studentId, name, email, attendance, grade);
        this.transportMode=transportMode;
        this.locality = locality;
    }
    public String getTransportMode() { return transportMode; }
    public void setTransportMode(String transportMode) { this.transportMode = transportMode; }

    public String getLocality() { return locality; }
    public void setLocality(String locality) { this.locality = locality; }

    @Override
    public double calculateFee() {
        double baseFee = 50000.0;
        double transportFee = 0.0;

        switch (transportMode.toLowerCase()) {
            case "bus":
                transportFee = 12000.0;
                break;
            case "own vehicle":
                transportFee = 5000.0;
                break;
            case "public transport":
                transportFee = 0.0;
                break;
            default:
                transportFee = 0.0;
        }

        double scholarship = 0.0;
        if (getAttendance() >= 90 && getGrade() >= 8.5) {
            scholarship = 0.20;
        } else if (getAttendance() >= 80 && getGrade() >= 7.5) {
            scholarship = 0.10;
        }

        double totalFee = baseFee + transportFee;
        return totalFee - (totalFee * scholarship);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Transport: %s, Locality: %s", transportMode, locality);
    }

}
