/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.RentalContract;

import Model.Customer.CustomerDAO;
import Model.Customer.CustomerMapper;
import Model.Mapper.Mapper;
import Model.Vehicle.VehicleDAO;
import Model.Vehicle.VehicleMapper;
import Utils.UtilDate;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DYLAN
 */
public class RentalContractMapper implements Mapper<RentalContract, RentalContractDTO>{

    @Override
    public RentalContractDTO toDTO(RentalContract ent) {
        return new RentalContractDTO(
                ent.getId(),
                ent.getCustomer().getId(),
                ent.getVehicle().getLicensePlate(),
                ent.getVehicle().getDailyRate(),
                UtilDate.toSqlDate(ent.getStartDate()) ,
                UtilDate.toSqlDate (ent.getEndDate())
        );
    }

    @Override
    public RentalContract toEnt(RentalContractDTO dto) {
        try {
            return new RentalContract(
                    dto.getId(),
                    new CustomerMapper().toEnt (new CustomerDAO(DataBase.DataBase.getConnection()).read(dto.getCustomer())),
                    new VehicleMapper().toEnt (new VehicleDAO(DataBase.DataBase.getConnection()).read(dto.getVehicle())),
                    UtilDate.toLocalDate(dto.getStartDate()),
                    UtilDate.toLocalDate(dto.getEndDate())
            );
        } catch (SQLException ex) {
            Logger.getLogger(RentalContractMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
