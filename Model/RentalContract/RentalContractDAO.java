/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.RentalContract;

import DataBase.DataBase;
import Model.Customer.CustomerDAO;
import Model.Dao.DAO;
import Model.Vehicle.VehicleDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DYLAN
 */
public class RentalContractDAO extends DAO<RentalContractDTO> {

    public RentalContractDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(RentalContractDTO dto) throws SQLException {
        if (dto == null || validateFKCustomer(dto.getCustomer())|| !validateFKVehicle(dto.getVehicle())) {
            return false;
        }
        String query = "Call RentalContractCreate(?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, dto.getCustomer());
            stmt.setString(2, dto.getVehicle());
            stmt.setDouble(3, dto.getDailyRate());
            stmt.setDate(4, dto.getStartDate());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public RentalContractDTO read(Object id) throws SQLException {
        if (id == null || String.valueOf(id).trim().isEmpty()) {
            return null;
        }
        String query = "Call RentalContractRead(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(id));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new RentalContractDTO(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getDouble(4),
                            rs.getDate(5),
                            rs.getDate(6));

                }
            }
        }
        return null;
    }

    @Override
    public List<RentalContractDTO> readAll() throws SQLException {
        String query = "Call CustomerAll()";
        List<RentalContractDTO> list = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(new RentalContractDTO(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getDouble(4),
                            rs.getDate(5),
                            rs.getDate(6)));
                }
            }
        }
        return list;
    }

    @Override
    public boolean update(RentalContractDTO dto) throws SQLException {
        if (dto == null) {
            return false;
        }
        String query = "Call RentalContractUpdate(?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, dto.getId());
            stmt.setDate(2, dto.getEndDate());
            return stmt.executeUpdate() > 0;

        }
    }

    @Override
    public boolean delete(Object id) throws SQLException {
        if (id == null || String.valueOf(id).trim().isEmpty()) {
            return false;
        }
        String query = "Call CustomerDelete(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(id));
            return stmt.executeUpdate() > 0;

        }
    }
    
    public boolean validateFKCustomer(Object id) throws SQLException {
        return new CustomerDAO(DataBase.getConnection()).read(id) != null ;
    }
    
    public boolean validateFKVehicle(Object id) throws SQLException {
        return new VehicleDAO(DataBase.getConnection()).read(id) != null ;
    }


}
