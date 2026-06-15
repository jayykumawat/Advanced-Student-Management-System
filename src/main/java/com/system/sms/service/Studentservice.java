package com.system.sms.service;
import java.util.HashMap;
import java.util.Map;
import com.system.sms.model.*;
import java.util.concurrent.ConcurrentHashMap;
public class Studentservice {
    private Map<Integer, Student> studentDatabase = new ConcurrentHashMap<>();

    private static Studentservice instanse;

    private Studentservice() {

    }

    public static synchronized Studentservice getInstance() {
        if (instanse == null) {
            instanse = new Studentservice();
        }
        return instanse;
    }

    public synchronized boolean addStudent(Student student) {
        if (student == null || studentDatabase.containsKey(student.getStudentId())) {
            return false;
        }
        studentDatabase.put(student.getStudentId(), student);
        System.out.println("✅ Student added: " + student.getName());
        return true;
    }

    public Student getStudent(int studentId) {
        return studentDatabase.get(studentId);
    }

    public Map<Integer, Student> getAllStudents() {
        return new HashMap<>(studentDatabase);
    }

    public synchronized boolean updateStudent(int studentId, Student updatedStudent) {
        if (!studentDatabase.containsKey(studentId)) {
            return false;
        }
        studentDatabase.put(studentId, updatedStudent);
        System.out.println("✅ Student updated: " + updatedStudent.getName());
        return true;
    }

    public synchronized boolean deleteStudent(int studentId) {
        if (!studentDatabase.containsKey(studentId)) {
            return false;
        }
        Student removed = studentDatabase.remove(studentId);
        System.out.println("✅ Student removed: " + removed.getName());
        return true;
    }

    public void searchStudentsByName(String nameQuery) {
        System.out.println("\n🔍 Search Results for: " + nameQuery);
        boolean found = false;
        for (Student student : studentDatabase.values()) {
            if (student.getName().toLowerCase().contains(nameQuery.toLowerCase())) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found!");
        }
    }

    public double getAverageAttendance() {
        if (studentDatabase.isEmpty()) return 0.0;

        int totalAttendance = 0;
        for (Student student : studentDatabase.values()) {
            totalAttendance += student.getAttendance();
        }
        return (double) totalAttendance / studentDatabase.size();
    }

    public double getAverageGrade() {
        if (studentDatabase.isEmpty()) return 0.0;

        double totalGrade = 0.0;
        for (Student student : studentDatabase.values()) {
            totalGrade += student.getGrade();
        }
        return totalGrade / studentDatabase.size();
    }

    public void getStudentTypeCount() {
        int hostelers = 0;
        int dayScholars = 0;

        for (Student student : studentDatabase.values()) {
            if (student instanceof HostelerStudent) {
                hostelers++;
            } else if (student instanceof DayScholarStudent) {
                dayScholars++;
            }
        }

        System.out.println("\n📊 Student Type Distribution:");
        System.out.println("Hostelers: " + hostelers);
        System.out.println("Day Scholars: " + dayScholars);
        System.out.println("Total: " + studentDatabase.size());
    }

    public void displayAllStudents() {
        if (studentDatabase.isEmpty()) {
            System.out.println("\n⚠️  No students in the system!");
            return;
        }

        System.out.println("\n📋 All Students:");
        System.out.println("=".repeat(100));
        for (Student student : studentDatabase.values()) {
            System.out.println(student);
        }
        System.out.println("=".repeat(100));
    }

    public int getTotalStudents() {
        return studentDatabase.size();
    }
}