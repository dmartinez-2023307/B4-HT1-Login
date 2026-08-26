package org.diegomartinez.system.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.diegomartinez.system.utils.AlertInformation;
import org.diegomartinez.system.utils.Validations;
import org.diegomartinez.system.utils.ViewFactory;

public class RegisterUserController implements Initializable {

    @FXML private TextField txtUser;
    @FXML private TextField txtName;
    @FXML private TextField txtLastName;
    @FXML private TextField txtEmail;
    @FXML private PasswordField pwdPassword;
    @FXML private PasswordField pwdConfirmPassword;
    
    private Validations validate = new Validations();
    private AlertInformation alertInfo = new AlertInformation();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicialización
    }

    @FXML
    public void onCancel(MouseEvent event) {
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewLogin();
    }

    @FXML
    public void onCreateUser(MouseEvent event) {
        
        String user = txtUser.getText().trim();
        String name = txtName.getText().trim();
        String lastName = txtLastName.getText().trim(); 
        String email = txtEmail.getText().trim();
        String password = pwdPassword.getText().trim();
        String confirmPassword = pwdConfirmPassword.getText().trim();

        // 2. Validar email
        if (!validate.validateEmail(email)) {
            alertInfo.viewAlert("ERROR", "Error de Email", "HAS INGRESADO UN EMAIL INCORRECTO", "Validación");
            return;
        }

        // 3. Validar campos vacíos
        if (validate.emptyText(user) || validate.emptyText(name) || 
            validate.emptyText(lastName) || validate.emptyText(email) || 
            validate.emptyText(password) || validate.emptyText(confirmPassword)) {
            
            alertInfo.viewAlert("ERROR", "Campos Vacíos", "DEJÓ CAMPOS VACÍOS EN EL FORMULARIO", "Validación");
            return;
        }

        // 4. Validar longitudes
        String msgField = "";
        
        if (!validate.validateLengthText(user, 25)) {
            msgField = "El campo Usuario no puede superar los 25 caracteres.";
        } else if (!validate.validateLengthText(name, 50)) {
            msgField = "El campo Nombres no puede superar los 50 caracteres.";
        } else if (!validate.validateLengthText(lastName, 50)) { 
            msgField = "El campo Apellidos no puede superar los 50 caracteres.";
        } else if (!validate.validateLengthText(email, 50)) {
            msgField = "El campo Email no puede superar los 50 caracteres.";
        } else if (!validate.validateLengthText(password, 35)) {
            msgField = "El campo Contraseña no puede superar los 35 caracteres.";
        }

        if (!msgField.isEmpty()) {
            alertInfo.viewAlert("WARNING", "Longitud de Campo", msgField, "Validación");
            return;
        }

        // 5. Validar contraseñas
        if (!validate.equalsText(password, confirmPassword)) {
            alertInfo.viewAlert("ERROR", "Error de Contraseña", "Sus contraseñas no coinciden", "Validación");
            return;
        }

        
        alertInfo.viewAlert("INFORMATION", "Éxito", "Usuario registrado correctamente", "Registro");
    }
}