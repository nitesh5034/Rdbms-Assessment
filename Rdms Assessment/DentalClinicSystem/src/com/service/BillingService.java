package com.service;

public class BillingService {

    public double calculateTax(double cost) {
        return cost * 0.18;
    }

    public double getMedicineCost() {
        return 200;
    }

    public double getDiscount() {
        return 100; 
    }

    public double calculateTotal(double cost) {
        double tax = calculateTax(cost);
        double medicine = getMedicineCost();
        double discount = getDiscount();

        return cost + tax + medicine - discount;
    }
}