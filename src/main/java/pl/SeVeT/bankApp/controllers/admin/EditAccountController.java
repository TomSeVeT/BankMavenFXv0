package pl.SeVeT.bankApp.controllers.admin;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

public class EditAccountController {

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
    private DatePicker datePicker;

    @FXML
    private MainAdminController mainAdminController;

    @FXML
    void applyOnAction() {
        mainAdminController.getClientModel().editChoosen();
    }
    public void init(){
        this.nameField.textProperty().bindBidirectional(mainAdminController.getClientModel().getChoosenClient().firstNameProperty());
        this.lastNameField.textProperty().bindBidirectional(mainAdminController.getClientModel().getChoosenClient().lastNameProperty());
        this.loginField.textProperty().bindBidirectional(mainAdminController.getClientModel().getChoosenClient().loginProperty());
        this.passwordField.textProperty().bindBidirectional(mainAdminController.getClientModel().getChoosenClient().passwordProperty());
        this.peselField.textProperty().bindBidirectional(mainAdminController.getClientModel().getChoosenClient().peselProperty(), new NumberStringConverter());
        this.addressField.textProperty().bindBidirectional(mainAdminController.getClientModel().getChoosenClient().addressProperty());
        this.phoneNumberField.textProperty().bindBidirectional(mainAdminController.getClientModel().getChoosenClient().phoneNumberProperty());
        this.datePicker.valueProperty().bindBidirectional(mainAdminController.getClientModel().getChoosenClient().birthDateProperty());


    }

    public void setMainAdminController(MainAdminController mainAdminController) {
        this.mainAdminController = mainAdminController;
    }

}