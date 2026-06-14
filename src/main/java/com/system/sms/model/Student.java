package com.system.sms.model;

public abstract class Student {
    private int studentId;
    private String name;
    private String email;
    private int attendance;
    private double grade;

    public Student(int studentId, String name, String email, int attendance, double grade) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.attendance = attendance;
        this.grade = grade;
    }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getAttendance() { return attendance; }
    public void setAttendance(int attendance) { this.attendance = attendance; }

    public double getGrade() { return grade; }
    public void setGrade(double grade) { this.grade = grade; }

    public abstract double calculateFee();

    public String getStudentType() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Email: %s, Type: %s, Attendance: %d%%, Grade: %.2f, Fee: ₹%.2f",
                studentId, name, email, getStudentType(), attendance, grade, calculateFee());
    }
}
