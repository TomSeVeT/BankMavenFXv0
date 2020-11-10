package pl.SeVeT.bankApp.controllers.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NewAdminController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField loginField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button clearButton;

    @FXML
    private Button createButton;

    @FXML
    private MainAdminController mainAdminController;

    @FXML
    void clearOnAction() {
        nameField.setText("");
        lastNameField.setText("");
        loginField.setText("");
        passwordField.setText("");
    }


    @FXML
    void createOnAction() {
        mainAdminController.getAdminModel().addAdmin(nameField.getText(),
                lastNameField.getText(),
                loginField.getText(),
                passwordField.getText());
    }

    public void setMainAdminController(MainAdminController mainAdminController) {
        this.mainAdminController = mainAdminController;

    }
}
