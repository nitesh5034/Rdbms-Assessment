package com.main;

import java.util.Scanner;

import com.dao.PatientDao;
import com.dao.AppointmentDao;
import com.dao.BillDao;
import com.model.Patient;
import com.model.Appointment;
import com.model.Bill;
import com.service.BillingService;

public class DentalSystemApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PatientDao patientDAO = new PatientDao();
        AppointmentDao appointmentDAO = new AppointmentDao();
        BillDao billDAO = new BillDao();
        BillingService billingService = new BillingService();

        while (true) {

            System.out.println("\n==== Dental Clinic System ====");
            System.out.println("1. Book Appointment");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    try {
                        // 🔹 Patient Input
                        System.out.print("Enter Patient Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Phone: ");
                        String phone = sc.nextLine();

                        Patient patient = new Patient(name, phone);
                        int patientId = patientDAO.addPatient(patient);

                        // 🔹 Appointment Input
                        System.out.print("Enter Service: ");
                        String service = sc.nextLine();

                        System.out.print("Enter Date: ");
                        String date = sc.nextLine();

                        System.out.print("Enter Cost: ");
                        double cost = sc.nextDouble();

                        Appointment appointment = new Appointment(patientId, service, date, cost);
                        int appointmentId = appointmentDAO.addAppointment(appointment);

                        // 🔹 Billing
                        double tax = billingService.calculateTax(cost);
                        double medicine = billingService.getMedicineCost();
                        double discount = billingService.getDiscount();
                        double total = billingService.calculateTotal(cost);

                        Bill bill = new Bill(
                                appointmentId,
                                cost,
                                tax,
                                medicine,
                                discount,
                                total
                        );

                        billDAO.addBill(bill);

                        // 🔹 Output
                        System.out.println("\n===== INVOICE =====");
                        System.out.println("Patient: " + name);
                        System.out.println("Service: " + service);
                        System.out.println("Cost: " + cost);
                        System.out.println("Tax: " + tax);
                        System.out.println("Medicine: " + medicine);
                        System.out.println("Discount: " + discount);
                        System.out.println("TOTAL: " + total);
                        System.out.println("===================");

                    } catch (Exception e) {
                        System.out.println("Error: Invalid Input!");
                        sc.nextLine(); // clear buffer
                    }
                    break;

                case 2:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}