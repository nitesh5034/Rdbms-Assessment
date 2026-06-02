package com.model;

public class Bill {

    private int id;
    private int appointmentId;
    private double treatmentCost;
    private double tax;
    private double medicineCost;
    private double discount;
    private double total;

    public Bill() {}

    public Bill(int appointmentId, double treatmentCost, double tax,
                double medicineCost, double discount, double total) {
        this.appointmentId = appointmentId;
        this.treatmentCost = treatmentCost;
        this.tax = tax;
        this.medicineCost = medicineCost;
        this.discount = discount;
        this.total = total;
    }

    public Bill(int id, int appointmentId, double treatmentCost, double tax,
                double medicineCost, double discount, double total) {
        this.id = id;
        this.appointmentId = appointmentId;
        this.treatmentCost = treatmentCost;
        this.tax = tax;
        this.medicineCost = medicineCost;
        this.discount = discount;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public double getTreatmentCost() {
        return treatmentCost;
    }

    public void setTreatmentCost(double treatmentCost) {
        this.treatmentCost = treatmentCost;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getMedicineCost() {
        return medicineCost;
    }

    public void setMedicineCost(double medicineCost) {
        this.medicineCost = medicineCost;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Bill [id=" + id + ", appointmentId=" + appointmentId +
               ", total=" + total + "]";
    }
}