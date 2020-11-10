package pl.SeVeT.bankApp.controllers.client;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AccountInfoController {

    @FXML
    private TextField ownerField;

    @FXML
    private TextField accNumberField;

    @FXML
    private TextField balanceField;

    @FXML
    private TextField lastLoginField;

    @FXML
    private TextField creationDateField;

    @FXML
    private MainClientController mainClientController;

    public void init() {
        this.ownerField.setText(mainClientController.getClientModel().getLoggedClient().getFirstName()
                .concat(" ")
                .concat(mainClientController.getClientModel().getLoggedClient().getLastName()));
        this.accNumberField.setText(mainClientController.getAccountModel().getActiveAccount().getAccNumber().toString());
        this.balanceField.setText(mainClientController.getAccountModel().getActiveAccount().getBalance().toString());
        this.lastLoginField.setText(mainClientController.getAccountModel().getActiveAccount().getLastLoginDate().toString());
        this.creationDateField.setText(mainClientController.getAccountModel().getActiveAccount().getCreationDate().toString());

    }

    public void setMainClientController(MainClientController mainClientController) {
        this.mainClientController = mainClientController;
    }
}
