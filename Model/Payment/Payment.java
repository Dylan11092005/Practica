/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Payment;

import Model.RentalContract.RentalContract;
import java.time.LocalDate;

/**
 *
 * @author jprod
 */
public class Payment {
    private int id;
    private RentalContract rentalContract;
    private double amount;
    private String paymentMethod;
    private LocalDate date;
    

    public int getId() {
        return id;
    }

    public RentalContract getRentalContract() {
        return rentalContract;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public LocalDate getDate() {
        return date;
    }

    protected Payment(int id,RentalContract rentalContract, double amount, String paymentMethod, LocalDate date) {
        this.id = id;
        this.rentalContract=rentalContract;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.date = date;
    }
    
    public Payment(double amount, String paymentMethod) {
        this.id=0;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.date = LocalDate.now();
    }
}
