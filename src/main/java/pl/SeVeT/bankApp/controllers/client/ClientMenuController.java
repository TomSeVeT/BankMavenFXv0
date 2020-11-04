package pl.SeVeT.bankApp.controllers.client;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class ClientMenuController {

    public static final String ACCOUNT_INFO = "/fxml/client/AccountInfo.fxml";
    public static final String CHANGE_PASSWORD = "/fxml/ChangePassword.fxml";
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
        mainClientController.setView(ACCOUNT_INFO);
    }

    @FXML
    void viewChangePassword() {
        mainClientController.setView(CHANGE_PASSWORD);

    }

    @FXML
    void viewClientInfo() {
        mainClientController.setView(CLIENT_INFO);

    }

    @FXML
    void viewSendTransfer() {
        mainClientController.setView(SEND_TRANSFER);

    }

    @FXML
    void viewTransferHistory() {
        mainClientController.setView(TRANSFER_HISTORY);

    }

    @FXML
    void logout() {

    }
}
