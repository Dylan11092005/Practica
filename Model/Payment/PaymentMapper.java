/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Payment;

import Model.Mapper.Mapper;
import Model.RentalContract.RentalContractDAO;
import Model.RentalContract.RentalContractMapper;
import Utils.UtilDate;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DYLAN
 */
public class PaymentMapper implements Mapper<Payment,PaymentDTO>{

    @Override
    public PaymentDTO toDTO(Payment ent) {
        return new PaymentDTO(
                ent.getId(),
                ent.getRentalContract().getId(),
                ent.getAmount(),
                ent.getPaymentMethod(),
                UtilDate.toSqlDate(ent.getDate()) 
                
        );
    }

    @Override
    public Payment toEnt(PaymentDTO dto) {
        try {
            return new Payment(
                    dto.getId(),
                    new RentalContractMapper().toEnt (new RentalContractDAO(DataBase.DataBase.getConnection()).read(dto.getRentalContract())),
                    dto.getAmount(),
                    dto.getPaymentMethod(),
                    UtilDate.toLocalDate(dto.getDate())
            );
        } catch (SQLException ex) {
            Logger.getLogger(PaymentMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
}
