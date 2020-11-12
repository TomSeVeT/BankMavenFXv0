package pl.SeVeT.bankApp.controllers.client;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.SeVeT.bankApp.controllers.admin.EditAccountController;
import pl.SeVeT.bankApp.controllers.admin.ManageAccountsController;
import pl.SeVeT.bankApp.modelFx.accounts.AccountModel;
import pl.SeVeT.bankApp.modelFx.operations.MoneyTransferModel;
import pl.SeVeT.bankApp.modelFx.users.ClientModel;
import pl.SeVeT.bankApp.utils.Fxml;

public class MainClientController {

    @FXML
    private ClientMenuController clientMenuController;

    @FXML
    private AccountInfoController accountInfoController;

    @FXML
    private ClientInfoController clientInfoController;

    @FXML
    private ChangeClientPasswordController changeClientPasswordController;

    @FXML
    private SendTransferController sendTransferController;

    @FXML
    private TransferHistoryController transferHistoryController;

    @FXML
    private BorderPane clientBorderPane;

    private Stage primaryStage;

    private ClientModel clientModel;

    private AccountModel accountModel;

    private MoneyTransferModel moneyTransferModel;

    @FXML
    public void initialize() {
        clientMenuController.setMainController(this);
        clientModel = new ClientModel();
        accountModel = new AccountModel();
        moneyTransferModel = new MoneyTransferModel();
    }

    public void setAccountInfoControllerView() {
        Object[] temp = Fxml.loadFXML_getController(ClientMenuController.ACCOUNT_INFO);
        clientBorderPane.setCenter((BorderPane) temp[0]);
        accountInfoController = (AccountInfoController) temp[1];
        accountInfoController.setMainClientController(this);
        accountInfoController.init();
    }

    public void setChangePasswordControllerView() {
        Object[] temp = Fxml.loadFXML_getController(ClientMenuController.CHANGE_PASSWORD);
        clientBorderPane.setCenter((BorderPane) temp[0]);
        changeClientPasswordController = (ChangeClientPasswordController) temp[1];
        changeClientPasswordController.setMainClientController(this);
    }

    public void setClientInfoControllerView() {
        Object[] temp = Fxml.loadFXML_getController(ClientMenuController.CLIENT_INFO);
        clientBorderPane.setCenter((BorderPane) temp[0]);
        clientInfoController = (ClientInfoController) temp[1];
        clientInfoController.setMainClientController(this);
        clientInfoController.init();

    }

    public void setSendTransferControllerView() {
        Object[] temp = Fxml.loadFXML_getController(ClientMenuController.SEND_TRANSFER);
        clientBorderPane.setCenter((BorderPane) temp[0]);
        sendTransferController = (SendTransferController) temp[1];
        sendTransferController.setMainClientController(this);
    }

    public void setTransferHistoryControllerView() {
        Object[] temp = Fxml.loadFXML_getController(ClientMenuController.TRANSFER_HISTORY);
        clientBorderPane.setCenter((BorderPane) temp[0]);
        transferHistoryController = (TransferHistoryController) temp[1];
        transferHistoryController.setMainClientController(this);
        transferHistoryController.init();
    }



    public ClientModel getClientModel() {
        return clientModel;
    }

    public AccountModel getAccountModel() {
        return accountModel;
    }

    public MoneyTransferModel getMoneyTransferModel() {
        return moneyTransferModel;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
