/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Customer;

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
public class CustomerDAO extends DAO<CustomerDTO> {

    public CustomerDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(CustomerDTO dto) throws SQLException {
        if (dto == null || !validatePK(dto.getId())) {
            return false;
        }
        String query = "Call CustomerCreate(?,?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, dto.getId());
            stmt.setString(2, dto.getName());
            stmt.setDate(3, dto.getBirthDate());
            stmt.setString(4, dto.getPhone());
            stmt.setString(5, dto.getEmail());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public CustomerDTO read(Object id) throws SQLException {
        if (id == null || String.valueOf(id).trim().isEmpty()) {
            return null;
        }
        String query = "Call CustomerRead(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(id));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new CustomerDTO(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getDate(3),
                            rs.getString(4),
                            rs.getString(5));
                }
            }
        }
        return null;
    }

    @Override
    public List<CustomerDTO> readAll() throws SQLException {
        String query = "Call CustomerReadAll()";
        List<CustomerDTO> list = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(new CustomerDTO(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getDate(3),
                            rs.getString(4),
                            rs.getString(5)));
                }
            }
        }
        return list;
    }

    @Override
    public boolean update(CustomerDTO dto) throws SQLException {
        if (dto == null) {
            return false;
        }
        String query = "Call CustomerUpdate(?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, dto.getId());
            stmt.setString(2, dto.getPhone());
            stmt.setString(3, dto.getEmail());
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

    public boolean validatePK(Object id) throws SQLException {
        return read(id) == null;
    }

}
