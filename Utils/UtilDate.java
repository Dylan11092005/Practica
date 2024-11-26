/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
/**
 *
 * @author jprod
 */
public class UtilDate {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.getDefault());
    
    public static boolean validate(String date){
        if(date==null || date.trim().isEmpty()) 
            throw new IllegalArgumentException("La fecha no puede ser nula");
        try {
            LocalDate.parse(date,  DateTimeFormatter.ofPattern("dd/MM/yyyy")); 
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    
    public static java.sql.Date toSqlDate(LocalDate date){
        if(date==null) 
            throw new IllegalArgumentException("La fecha no puede ser nula");    
        return java.sql.Date.valueOf(date);
    }
    
    public static LocalDate toLocalDate(java.sql.Date date){
        if(date==null) 
            throw new IllegalArgumentException("La fecha no puede ser nula");
        return date.toLocalDate();
    }
    
    public static LocalDate toLocalDate(String date){
        if(date==null || date.trim().isEmpty()) 
            throw new IllegalArgumentException("La fecha no puede ser nula");
        try {
            return LocalDate.parse(date, DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de fecha inválido. Se esperaba 'dd/MM/yyyy'.");
        }
    }
    
    public static String toString(LocalDate date){
        if(date==null) 
            throw new IllegalArgumentException("La fecha no puede ser nula");
        return date.format(DATE_FORMATTER);
    }
}
