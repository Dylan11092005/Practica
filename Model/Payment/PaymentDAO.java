/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Payment;

import DataBase.DataBase;
import Model.Customer.CustomerDAO;
import Model.Dao.DAO;
import Model.Payment.PaymentDTO;
import Model.RentalContract.RentalContractDAO;
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
public class PaymentDAO extends DAO<PaymentDTO> {

    public PaymentDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(PaymentDTO dto) throws SQLException {
        if (dto == null || !validateFKRentalContract(dto.getRentalContract())) {
            return false;
        }
        String query = "Call PaymentCreate(?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, dto.getRentalContract());
            stmt.setDouble(2, dto.getAmount());
            stmt.setString(3, dto.getPaymentMethod());
            stmt.setDate(4, dto.getDate());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public PaymentDTO read(Object id) throws SQLException {
        if (id == null || String.valueOf(id).trim().isEmpty()) {
            return null;
        }
        String query = "Call PaymentRead(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(id));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new PaymentDTO(
                            rs.getInt(1),
                            rs.getInt(2),
                            rs.getDouble(3),
                            rs.getString(4),
                            rs.getDate(5));
                }
            }
        }
        return null;
    }

    @Override
    public List<PaymentDTO> readAll() throws SQLException {
        String query = "Call PaymentAll()";
        List<PaymentDTO> list = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(new PaymentDTO(
                           rs.getInt(1),
                            rs.getInt(2),
                            rs.getDouble(3),
                            rs.getString(4),
                            rs.getDate(5)));
                }
            }
        }
        return list;
    }

    @Override
    public boolean delete(Object id) throws SQLException {
        if (id == null || String.valueOf(id).trim().isEmpty()) {
            return false;
        }
        String query = "Call PaymentDelete(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(id));
            return stmt.executeUpdate() > 0;

        }
    }
    
    public boolean validateFKRentalContract(Object id) throws SQLException {
        return new RentalContractDAO(DataBase.getConnection()).read(id) != null ;
    }
   

    @Override
    public boolean update(PaymentDTO dto) throws SQLException {
        return false;
    }
    
}
