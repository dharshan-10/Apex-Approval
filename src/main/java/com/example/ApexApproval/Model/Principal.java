package com.example.ApexApproval.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Principal {
    public Principal( String applicationType, String location, String reason, long amount, int isApproved, String submittedFacultyName, String facultyId, String name) {

        ApplicationType = applicationType;
        Location = location;
        Reason = reason;
        Amount = amount;
        this.isApproved = isApproved;
        SubmittedFacultyName = submittedFacultyName;
        FacultyId = facultyId;
        Name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String ApplicationType;
    private String Location;
    private String Reason;
    private long Amount;
    private int isApproved = 0;
    private String SubmittedFacultyName;
    private String FacultyId;
    private String Name;


    // Getters and Setters
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getApplicationType() {
        return ApplicationType;
    }

    public void setApplicationType(String applicationType) {
        ApplicationType = applicationType;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public long getAmount() {
        return Amount;
    }

    public void setAmount(long amount) {
        Amount = amount;
    }

    public int getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(int isApproved) {
        this.isApproved = isApproved;
    }

    public String getSubmittedFacultyName() {
        return SubmittedFacultyName;
    }
    public Principal(){}

    public void setSubmittedFacultyName(String submittedFacultyName) {
        SubmittedFacultyName = submittedFacultyName;
    }

    public String getFacultyId() {
        return FacultyId;
    }

    public void setFacultyId(String facultyId) {
        FacultyId = facultyId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


}
