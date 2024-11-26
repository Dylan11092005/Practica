/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Customer;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author jprod
 */

public class Customer {
    private String id;
    private String name;
    private LocalDate birthDate;
    private String phone;
    private String email;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    
    public int getAge() {
        return calculateAge(birthDate);
    }
    
    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    private void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("El id no puede ser nulo o vacío");
        }
        this.id = id;
    }

    private void setName(String name) {
         if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        this.name = name;
    }

    private void setBirthDate(LocalDate birthDate) {
         if (birthDate == null) {
            throw new IllegalArgumentException("La fecha de nacimeinto no puede ser nulo");
         }
        this.birthDate = birthDate;
    }

    public final void setPhone(String phone) {
        if (phone == null || phone.isEmpty()) {
            throw new IllegalArgumentException("El telefono no puede ser nulo o vacío");
        }
        this.phone = phone;
    }

    public final void setEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("El correo no puede ser nulo o vacío");
        }
        this.email = email;
    }

    public Customer(String id, String name, LocalDate birthDate, String phone, String email) {
        setId(id);
        setName(name);
        setBirthDate(birthDate);
        setPhone(phone);
        setEmail(email);
    }
    
    public static int calculateAge(LocalDate birthDate) {
        if (birthDate == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula");
        }
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
    
    
}