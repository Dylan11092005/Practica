/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author jprod
 */
public class UtilGui {    
    public static boolean validateFields(JComponent... components) {
        for (JComponent component : components) {
            if (component instanceof JTextField) {
                JTextField textField = (JTextField) component;
                if (textField.getText().trim().isEmpty()) {
                    return false;
                }
            } else if (component instanceof JComboBox) {
                JComboBox<?> comboBox = (JComboBox<?>) component;
                if (comboBox.getSelectedItem() == null || comboBox.getSelectedIndex() == -1) {
                    return false; // Si el JComboBox no tiene selección válida, la validación falla
                }
            }
            // Puedes agregar más casos si es necesario para otros tipos de componentes
        }
        return true;
    }
    
    public static void clearTxts(JComponent... components){
        for (JComponent component : components) {
            if (component instanceof JTextField) {
                JTextField textField = (JTextField) component;
                textField.setText("");
            } else if (component instanceof JComboBox) {
                JComboBox<?> comboBox = (JComboBox<?>) component;
                comboBox.setSelectedIndex(-1);
            }
            // Puedes agregar más casos si es necesario para otros tipos de componentes
        }
    }
    
    public static void SetEditableStateTxts(boolean value,JComponent... components){
        for (JComponent component : components) {
            if (component instanceof JTextField) {
                JTextField textField = (JTextField) component;
                textField.setEditable(value);
            } else if (component instanceof JComboBox) {
                JComboBox<?> comboBox = (JComboBox<?>) component;
                comboBox.setEnabled(value);
            }
            // Puedes agregar más casos si es necesario para otros tipos de componentes
        }
    }
    
    public static void changeStateButtons(JButton... btns) {
        for (JButton btn : btns) {
            btn.setEnabled(!btn.isEnabled());
        }
    }
}
