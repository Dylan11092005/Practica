/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.RentalContract;

import Model.Customer.Customer;
import Model.Vehicle.Vehicle;
import java.sql.Date;
import java.time.Period;

/**
 *
 * @author jprod
 */
public class RentalContractDTO {

    private final int id;
    private final String customer;
    private final String vehicle;
    private final double dailyRate;
    private final Date startDate;
    private final Date endDate;

    public int getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public String getVehicle() {
        return vehicle;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public RentalContractDTO(int id, String customer, String vehicle, double dailyRate, Date startDate, Date endDate) {
        this.id = id;
        this.customer = customer;
        this.vehicle = vehicle;
        this.dailyRate = dailyRate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}
