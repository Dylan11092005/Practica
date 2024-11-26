/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Customer;

import java.time.LocalDate;
import java.time.Period;
import java.sql.Date;

/**
 *
 * @author jprod
 */

public class CustomerDTO {

    private final String id;
    private final String name;
    private final Date birthDate;
    private final String phone;
    private final String email;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public CustomerDTO(String id, String name, Date birthDate, String phone, String email) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
    }

}
