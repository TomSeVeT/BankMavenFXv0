package pl.SeVeT.bankApp.controllers.client;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TransferHistoryController {

    @FXML
    private TableView<?> transferHistoryTable;

    @FXML
    private TableColumn<?, ?> dateColumn;

    @FXML
    private TableColumn<?, ?> reciverNameColumn;

    @FXML
    private TableColumn<?, ?> reciverAccountNumberColumn;

    @FXML
    private TableColumn<?, ?> amountColumn;

    @FXML
    private TableColumn<?, ?> titleColumn;

    @FXML
    MainClientController mainClientController;

    public void setMainClientController(MainClientController mainClientController) {
        this.mainClientController = mainClientController;
    }

    public void init() {
        mainClientController.getMoneyTransferModel().init();
    }
}
