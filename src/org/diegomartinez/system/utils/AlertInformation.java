/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author informatica
 */

package org.diegomartinez.system.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertInformation {

    // Constructor vacío público
    public AlertInformation() {
    }

    /**
     * Muestra una alerta de JavaFX configurada con los parámetros recibidos.
     * 
     * @param tipo      Tipo de alerta en formato String (ej. "INFORMATION", "WARNING", "ERROR", "CONFIRMATION")
     * @param titulo    El título de la ventana de la alerta
     * @param mensaje   El mensaje principal (contenido) de la alerta
     * @param encabezado El texto de encabezado de la alerta
     */
    public void viewAlert(String tipo, String titulo, String mensaje, String encabezado) {
        
        // Variable local de tipo AlertType donde se guardará el resultado del switch
        AlertType tipoAlerta;

        // Switch para determinar el tipo de alerta de JavaFX
        tipoAlerta = switch (tipo.toUpperCase()) {
            case "INFORMATION" -> AlertType.INFORMATION;
            case "WARNING" -> AlertType.WARNING;
            case "ERROR" -> AlertType.ERROR;
            case "CONFIRMATION" -> AlertType.CONFIRMATION;
            case "NONE" -> AlertType.NONE;
            default -> AlertType.NONE;
        };

        // Creación y configuración de la alerta de JavaFX
        Alert alert = new Alert(tipoAlerta);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(mensaje);
        
        // Mostrar la alerta y esperar a que el usuario la cierre
        alert.showAndWait();
    }
}
