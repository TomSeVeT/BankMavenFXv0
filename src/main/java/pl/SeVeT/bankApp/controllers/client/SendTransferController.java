package pl.SeVeT.bankApp.controllers.client;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.math.BigDecimal;

public class SendTransferController {

    @FXML
    private TextField reciverNameField;

    @FXML
    private TextField reciverAccountNumberField;

    @FXML
    private TextField amountField;

    @FXML
    private TextField titleField;

    @FXML
    MainClientController mainClientController;

    @FXML
    void sendTransferOnAction() {
        mainClientController.getMoneyTransferModel().sendTransfer(
                new BigDecimal(amountField.getText()),
                reciverNameField.getText(),
                reciverAccountNumberField.getText(),
                mainClientController.getClientModel().getLoggedClient().toString(),
                titleField.getText(),
                mainClientController.getAccountModel().getActiveAccount()
        );

    }

    public void setMainClientController(MainClientController mainClientController) {
        this.mainClientController = mainClientController;
    }
}
