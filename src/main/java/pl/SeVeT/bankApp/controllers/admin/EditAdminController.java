package pl.SeVeT.bankApp.controllers.admin;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EditAdminController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private MainAdminController mainAdminController;

    @FXML
    void applyOnAction() {
        mainAdminController.getAdminModel().editChoosen();
    }

    public void init(){
        this.nameField.textProperty().bindBidirectional(mainAdminController.getAdminModel().getChosenAdmin().nameProperty());
        this.lastNameField.textProperty().bindBidirectional(mainAdminController.getAdminModel().getChosenAdmin().lastNameProperty());
        this.loginField.textProperty().bindBidirectional(mainAdminController.getAdminModel().getChosenAdmin().loginProperty());
        this.passwordField.textProperty().bindBidirectional(mainAdminController.getAdminModel().getChosenAdmin().passwordProperty());
    }

    public void setMainAdminController(MainAdminController mainAdminController) {
        this.mainAdminController = mainAdminController;
    }

}
