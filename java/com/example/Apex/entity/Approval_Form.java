package com.example.Apex.entity;

public class Approval_Form {
    private String applicationType;
    private String applicationReason;
    private double applicationAmount;

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public String getApplicationReason() {
        return applicationReason;
    }

    public void setApplicationReason(String applicationReason) {
        this.applicationReason = applicationReason;
    }

    public double getApplicationAmount() {
        return applicationAmount;
    }

    public void setApplicationAmount(double applicationAmount) {
        this.applicationAmount = applicationAmount;
    }
}
