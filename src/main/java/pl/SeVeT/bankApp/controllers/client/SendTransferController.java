package pl.SeVeT.bankApp.controllers.client;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pl.SeVeT.bankApp.modelFx.operations.MoneyTransferModel;
import pl.SeVeT.bankApp.utils.Dialogs;

import java.math.BigDecimal;
import java.math.BigInteger;

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
        if(mainClientController.getClientModel().getLoggedClient().getAccount().getBalance().compareTo(new BigDecimal(this.amountField.getText()))>=1)
        {
            if(MoneyTransferModel.accountNumberExists(new BigInteger(reciverAccountNumberField.getText())))
                {
                    mainClientController.getMoneyTransferModel().sendTransfer(
                        new BigDecimal(amountField.getText()),
                        reciverNameField.getText(),
                        reciverAccountNumberField.getText(),
                        mainClientController.getClientModel().getLoggedClient().toString(),
                        titleField.getText(),
                        mainClientController.getAccountModel().getActiveAccount()
                    );
                Dialogs.transferSended();
                }else Dialogs.wrongReciverNumber();
        } else
            Dialogs.balanceTooLow();
    }



    public void setMainClientController(MainClientController mainClientController) {
        this.mainClientController = mainClientController;
    }
}
