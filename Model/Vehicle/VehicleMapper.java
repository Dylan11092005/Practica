/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Vehicle;

import Model.Mapper.Mapper;

/**
 *
 * @author DYLAN
 */
public class VehicleMapper implements Mapper<Vehicle, VehicleDTO>{

    @Override
    public VehicleDTO toDTO(Vehicle ent) {
        return new VehicleDTO(
                ent.getLicensePlate(),
                ent.getBrand(),
                ent.getModel(),
                ent.getYear(),
                ent.getDailyRate(),
                ent.isAvailable()
        );
    }

    @Override
    public Vehicle toEnt(VehicleDTO dto) {
        return new Vehicle(
                dto.getLicensePlate(),
                dto.getBrand(),
                dto.getModel(),
                dto.getYear(),
                dto.getDailyRate(),
                dto.isAvailable()
        );
    }
    
}
