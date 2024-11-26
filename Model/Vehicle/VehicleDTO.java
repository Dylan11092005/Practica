/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Vehicle;

/**
 *
 * @author jprod
 */
public class VehicleDTO {

    private final String licensePlate;
    private final String brand;
    private final String model;
    private final int year;
    private final double dailyRate;
    private final boolean available;

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public boolean isAvailable() {
        return available;
    }

    public VehicleDTO(String licensePlate, String brand, String model, int year, double dailyRate, boolean available) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.dailyRate = dailyRate;
        this.available = available;
    }

}
