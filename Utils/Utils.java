/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.time.LocalDate;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author jprod
 */
public class Utils {
    public static boolean validateWrappers(Object... wrappers) {
        for (Object wrapper : wrappers) {
            if (wrapper==null) return false;
            if (wrapper instanceof String wrap) 
                if (wrap.trim().isEmpty()) 
                    return false;
            // Puedes agregar más casos si es necesario para otros tipos de componentes
        }
        return true;
    }
}
