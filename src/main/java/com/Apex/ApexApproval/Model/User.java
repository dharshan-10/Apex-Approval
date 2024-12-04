package com.Apex.ApexApproval.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
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
    private String SubmitTo;

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

    public String getSubmitTo() {
        return SubmitTo;
    }

    public void setSubmitTo(String submitTo) {
        SubmitTo = submitTo;
    }
}
