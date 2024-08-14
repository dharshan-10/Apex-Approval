package com.Apex.ApexApproval.Model;

import jakarta.persistence.*;

@Entity
public class Dean {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String ApplicationType;
    private String Location;
    private String Reason;
    private long Amount;

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

    private Boolean isApproved=null;
    private String SubmittedFacultyName;
    private String FacultyId;

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

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }
}
