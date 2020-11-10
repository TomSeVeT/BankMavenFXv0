package pl.SeVeT.bankApp.controllers.client;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class ClientMenuController {

    public static final String ACCOUNT_INFO = "/fxml/client/AccountInfo.fxml";
    public static final String CHANGE_PASSWORD = "/fxml/client/ChangeClientPassword.fxml";
    public static final String CLIENT_INFO = "/fxml/client/ClientInfo.fxml";
    public static final String SEND_TRANSFER = "/fxml/client/SendTransfer.fxml";
    public static final String TRANSFER_HISTORY = "/fxml/client/TransferHistory.fxml";

    @FXML
    private MainClientController mainClientController;

    public void setMainController(MainClientController mainClientController) {
        this.mainClientController = mainClientController;
    }


    @FXML
    private ToggleGroup clientButtons;


    @FXML
    void viewAccountInfo() {
        mainClientController.setAccountInfoControllerView();
    }

    @FXML
    void viewChangePassword() {
        mainClientController.setChangePasswordControllerView();

    }

    @FXML
    void viewClientInfo() {
        mainClientController.setClientInfoControllerView();

    }

    @FXML
    void viewSendTransfer() {
        mainClientController.setSendTransferControllerView();

    }

    @FXML
    void viewTransferHistory() {
        mainClientController.setTransferHistoryControllerView();

    }

    @FXML
    void logout() {

    }
}
