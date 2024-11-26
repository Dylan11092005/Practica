/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.RentalContract;

import Model.Customer.Customer;
import Model.Vehicle.Vehicle;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author jprod
 */
public class RentalContract {
    private int id;
    private Customer customer;
    private Vehicle vehicle;
    private LocalDate startDate;
    private LocalDate endDate;

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
    
    public int getDaysOfRent(){
        return calculateDaysOfRent();
    }
    
    public double getRentalCost(){
        return calculateRentalCost(getDaysOfRent());
    }

    public void setEndDate() {
        if (this.endDate==null){
            this.endDate = LocalDate.now();
        }
        
    }

    protected RentalContract(int id, Customer customer, Vehicle vehicle, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.customer = customer;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public RentalContract(Customer customer, Vehicle vehicle) {
        this.id = 0;
        this.customer = customer;
        this.vehicle = vehicle;
        this.startDate = LocalDate.now();
        this.endDate = null;
    }
    
    private int calculateDaysOfRent(){
        if (endDate == null) {
            throw new IllegalArgumentException("La fecha de finalizacion no puede ser nula");
        }
        return Period.between(startDate, endDate).getDays();
    }
    
    private double calculateRentalCost(int days){        
        return days*vehicle.getDailyRate(); 
    }

}
