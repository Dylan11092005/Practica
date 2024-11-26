/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Vehicle;

import Model.Dao.DAO;
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
public class VehicleDAO extends DAO<VehicleDTO> {

    public VehicleDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(VehicleDTO dto) throws SQLException {
        if (dto == null || !validatePK(dto.getLicensePlate())) {
            return false;
        }
        String query = "Call VehicleCreate(?,?,?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, dto.getLicensePlate());
            stmt.setString(2, dto.getBrand());
            stmt.setString(3, dto.getModel());
            stmt.setInt(4, dto.getYear());
            stmt.setDouble(5, dto.getDailyRate());
            stmt.setBoolean(6, dto.isAvailable());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public VehicleDTO read(Object id) throws SQLException {
        if (id == null || String.valueOf(id).trim().isEmpty()) {
            return null;
        }
        String query = "Call VehicleRead(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(id));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new VehicleDTO(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(4),
                            rs.getDouble(5),
                            rs.getBoolean(6));
                }
            }
        }
        return null;
    }

    @Override
    public List<VehicleDTO> readAll() throws SQLException {
        String query = "Call VehicleAll()";
        List<VehicleDTO> list = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(new VehicleDTO(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(4),
                            rs.getDouble(5),
                            rs.getBoolean(6)));
                }
            }
        }
        return list;
    }

    @Override
    public boolean update(VehicleDTO dto) throws SQLException {
        if (dto == null) {
            return false;
        }
        String query = "Call VehicleUpdate(?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, dto.getLicensePlate());
            stmt.setDouble(2, dto.getDailyRate());
            stmt.setBoolean(3, dto.isAvailable());
            return stmt.executeUpdate() > 0;

        }
    }

    @Override
    public boolean delete(Object id) throws SQLException {
        if (id == null || String.valueOf(id).trim().isEmpty()) {
            return false;
        }
        String query = "Call VehicleDelete(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(id));
            return stmt.executeUpdate() > 0;

        }
    }

    public boolean validatePK(Object id) throws SQLException {
        return read(id) == null;
    }

}
