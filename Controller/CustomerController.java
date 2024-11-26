/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DataBase.DataBase;
import Model.Customer.Customer;
import Model.Customer.CustomerDAO;
import Model.Customer.CustomerDTO;
import Model.Customer.CustomerMapper;
import View.View;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author jprod
 */
public class CustomerController {
    private CustomerDAO dao;
    private final View view;
    private final CustomerMapper mapper;
    
    public CustomerController(View view) {
        this.view = view;
        mapper=new CustomerMapper();
        try {
            dao=new CustomerDAO(DataBase.getConnection());
        } catch (SQLException ex) {
            view.showError("Error al conectar con la Base de Datos");
        }
    }
    
    public void create(Customer customer){
        if(customer==null || !validateRequired(customer)) {
            view.showError("Faltan datos requeridos");
            return;
        }
        try {
            if (!validatePK(customer.getId())){
                view.showError("La cedula ingresada ya se encuentra registrada");
                return;
            }
            dao.create(mapper.toDTO(customer));
            view.showMessage("Datos guardados correctamente");
        } catch (SQLException ex) {
            view.showError("Ocurrio un error al guardar los datos: "+ ex.getMessage());
        }
    }
    
    public void read(){
        
    }
    
    public void readAll(){
        try {
            List<CustomerDTO> dtoList = dao.readAll();
            List<Customer> customerList = dtoList.stream()
                    .map(mapper::toEnt)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            view.showAll(customerList);
        } catch (SQLException ex) {
            view.showError("Error al cargar los datos: "+ ex.getMessage());
        }
    }
    
    public void update(Customer customer){
        if(customer==null || !validateRequired(customer)) {
            view.showError("Faltan datos requeridos");
            return;
        }
        try {
            if (validatePK(customer.getId())){
                view.showError("La cedula ingresada no se encuentra registrada");
                return;
            }
            dao.update(mapper.toDTO(customer));
        } catch (SQLException ex) {
            view.showError("Ocurrio un error al actualizar los datos: "+ ex.getMessage());
        }
    }
    
    public void delete(Customer customer){
        if(customer==null || !validateRequired(customer)) {
            view.showError("No hay ningun cliente cargado actualmente");
            return;
        }
        try {
            if (validatePK(customer.getId())){
                view.showError("La cedula ingresada no ya se encuentra registrada");
                return;
            }
            dao.delete(customer.getId());
        } catch (SQLException ex) {
            view.showError("Ocurrio un error al eliminar los datos: "+ ex.getMessage());
        }
    }
    
    public boolean validateRequired(Customer customer) {
        return !customer.getId().trim().isEmpty()&&
                !customer.getName().trim().isEmpty()&&
                !customer.getPhone().trim().isEmpty()&&
                !customer.getEmail().trim().isEmpty();
    }

    public boolean validatePK(String id) {
        try {
            return dao.validatePK(id);
        } catch (SQLException ex) {
            return false;
        }
    }
    
}
