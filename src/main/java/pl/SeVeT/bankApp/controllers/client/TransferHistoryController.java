package pl.SeVeT.bankApp.controllers.client;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.SeVeT.bankApp.modelFx.operations.MoneyTransferFx;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransferHistoryController {

    @FXML
    private TableView<MoneyTransferFx> transferHistoryTable;

    @FXML
    private TableColumn<MoneyTransferFx, LocalDate> dateColumn;

    @FXML
    private TableColumn<MoneyTransferFx, String> reciverNameColumn;

    @FXML
    private TableColumn<MoneyTransferFx, String> senderNameColumn;

    @FXML
    private TableColumn<MoneyTransferFx, BigDecimal> amountColumn;

    @FXML
    private TableColumn<MoneyTransferFx, String> titleColumn;

    @FXML
    MainClientController mainClientController;

    public void setMainClientController(MainClientController mainClientController) {
        this.mainClientController = mainClientController;
    }

    public void init() {
        this.transferHistoryTable.setItems(mainClientController.getMoneyTransferModel().getTransferList());
        this.dateColumn.setCellValueFactory(x -> x.getValue().timeStampProperty());
        this.reciverNameColumn.setCellValueFactory(x -> x.getValue().reciverNameProperty());
        this.senderNameColumn.setCellValueFactory(x -> x.getValue().senderNameProperty());
        this.amountColumn.setCellValueFactory(x -> x.getValue().amountProperty());
        this.titleColumn.setCellValueFactory(x -> x.getValue().titleProperty());

    }
}
