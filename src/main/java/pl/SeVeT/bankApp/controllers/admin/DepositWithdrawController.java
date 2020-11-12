package pl.SeVeT.bankApp.controllers.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.converter.BigDecimalStringConverter;
import pl.SeVeT.bankApp.utils.Dialogs;

import java.math.BigDecimal;

public class DepositWithdrawController {

    @FXML
    private Label ownerLabel;

    @FXML
    private Label peselLabel;

    @FXML
    private Label balanceLabel;

    @FXML
    private TextField amountField;

    @FXML
    private MainAdminController mainAdminController;


    @FXML
    void depositOnAction() {
        mainAdminController.getAccountModel().deposit(
                mainAdminController.getClientModel().getSelectedClient(),
                new BigDecimal(amountField.getText().replaceAll(",","."))
                );
    }

    @FXML
    void withdrawOnAction() {
        if(new BigDecimal( amountField.getText().replaceAll(",",".") )
                .compareTo( mainAdminController.getAccountModel().getActiveAccount().getBalance()) > 0)
            Dialogs.balanceTooLow();
        else{
            mainAdminController.getAccountModel().withdraw(
                    mainAdminController.getClientModel().getSelectedClient(),
                    new BigDecimal(amountField.getText().replaceAll(",","."))
            );
        }

    }

    public void init(){
        mainAdminController.getAccountModel().setActiveAccount(mainAdminController.getClientModel().getSelectedClient().getAccount());
        ownerLabel.setText(mainAdminController.getClientModel().getSelectedClient().toString());

        peselLabel.setText(String.valueOf(mainAdminController.getClientModel().getSelectedClient().getPesel()));
        balanceLabel.textProperty().bindBidirectional(mainAdminController.getClientModel().getSelectedClient().getAccount().balanceProperty(), new BigDecimalStringConverter());
    }

    public void setMainAdminController(MainAdminController mainAdminController) {
        this.mainAdminController = mainAdminController;
    }

}
