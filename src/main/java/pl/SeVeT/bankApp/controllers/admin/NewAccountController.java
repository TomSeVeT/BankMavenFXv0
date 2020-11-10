package pl.SeVeT.bankApp.controllers.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class NewAccountController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField loginField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField peselField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private DatePicker datePickerField;

    @FXML
    private Button clearButton;

    @FXML
    private Button createButton;

    @FXML
    private MainAdminController mainAdminController;

    @FXML
    void clearOnAction() {
        nameField.setText("");
        loginField.setText("");
        lastNameField.setText("");
        passwordField.setText("");
        peselField.setText("");
        addressField.setText("");
        phoneNumberField.setText("");
    }

    @FXML
    void createOnAction() {
        mainAdminController.getClientModel().addClient(nameField.getText(), lastNameField.getText(), loginField.getText(), passwordField.getText(),
                Long.parseLong(peselField.getText()), datePickerField.getValue(),
                addressField.getText(), phoneNumberField.getText());

    }

    public void setMainAdminController(MainAdminController mainAdminController) {
        this.mainAdminController = mainAdminController;
    }
}
