package pl.SeVeT.bankApp.controllers.admin;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.SeVeT.bankApp.modelFx.users.ClientFx;

import java.time.LocalDate;

public class ManageAccountsController {

    public static final String NEW_ACCOUNT = "/fxml/admin/NewAccount.fxml";
    public static final String EDIT_ACCOUNT = "/fxml/admin/EditAccount.fxml";


    @FXML
    private MainAdminController mainAdminController;

    @FXML
    private TableView<ClientFx> accountsTable;

    @FXML
    private TableColumn<ClientFx, String> nameColumn;

    @FXML
    private TableColumn<ClientFx, String> lastNameColumn;

    @FXML
    private TableColumn<ClientFx, Number> peselColumn;

    @FXML
    private TableColumn<ClientFx, LocalDate> birthdayColumn;

    @FXML
    void deleteAccount() {
        mainAdminController.getClientModel().deleteSelectedClient();
        this.init();
    }

    @FXML
    void editAccount() {
        mainAdminController.setEditAccountControllerView();
    }

    @FXML
    void newAccount() {
        mainAdminController.setNewAccountControllerView();
    }

    @FXML
    void searchFieldKeyReleased() {

    }

    public MainAdminController getMainAdminController() {
        return mainAdminController;
    }

    public void setMainAdminController(MainAdminController mainAdminController) {
        this.mainAdminController = mainAdminController;
    }



    public void init() {
        mainAdminController.getClientModel().init();
        setAccountsTable();
        accountsTable.getSelectionModel().selectedItemProperty().addListener((ChangeListener) (observableValue, oldValue, newValue) -> mainAdminController.getClientModel()
                .setSelectedClient(accountsTable.getSelectionModel().getSelectedItem()));

    }

    private void setAccountsTable() {
        this.accountsTable.setItems(mainAdminController.getClientModel().getClientsList());
        this.nameColumn.setCellValueFactory(x-> x.getValue().firstNameProperty());
        this.lastNameColumn.setCellValueFactory(x-> x.getValue().lastNameProperty());
        this.peselColumn.setCellValueFactory(x->x.getValue().peselProperty());
        this.birthdayColumn.setCellValueFactory(x->x.getValue().birthDateProperty());
    }

}
