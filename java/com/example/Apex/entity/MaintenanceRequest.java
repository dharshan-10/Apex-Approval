package com.example.Apex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MaintenanceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String area;
    private String works;
    private String amount;
    private String submitTo;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
// Constructors

    public MaintenanceRequest() {
        // Default constructor needed by JPA
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getWorks() {
        return works;
    }

    public void setWorks(String works) {
        this.works = works;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSubmitTo() {
        return submitTo;
    }

    public void setSubmitTo(String submitTo) {
        this.submitTo = submitTo;
    }

    // toString(), equals(), and hashCode() methods

    @Override
    public String toString() {
        return "MaintenanceRequest{" +
                "id=" + id +
                ", area='" + area + '\'' +
                ", works='" + works + '\'' +
                ", amount='" + amount + '\'' +
                ", submitTo='" + submitTo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaintenanceRequest that = (MaintenanceRequest) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (area != null ? !area.equals(that.area) : that.area != null) return false;
        if (works != null ? !works.equals(that.works) : that.works != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        return submitTo != null ? submitTo.equals(that.submitTo) : that.submitTo == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + (works != null ? works.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (submitTo != null ? submitTo.hashCode() : 0);
        return result;
    }
}
