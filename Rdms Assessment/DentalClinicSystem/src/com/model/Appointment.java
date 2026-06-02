package com.model;

public class Appointment {

    private int id;
    private int patientId;
    private String service;
    private String date;
    private double cost;

    public Appointment() {}

    public Appointment(int patientId, String service, String date, double cost) {
        this.patientId = patientId;
        this.service = service;
        this.date = date;
        this.cost = cost;
    }

    public Appointment(int id, int patientId, String service, String date, double cost) {
        this.id = id;
        this.patientId = patientId;
        this.service = service;
        this.date = date;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Appointment [id=" + id + ", patientId=" + patientId +
               ", service=" + service + ", date=" + date + ", cost=" + cost + "]";
    }
}