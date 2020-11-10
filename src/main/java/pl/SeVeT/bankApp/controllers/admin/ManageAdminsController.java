package pl.SeVeT.bankApp.controllers.admin;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.SeVeT.bankApp.modelFx.users.AdminFx;

public class ManageAdminsController {

    public static final String NEW_ADMIN = "/fxml/admin/NewAdmin.fxml";
    public static final String EDIT_ADMIN = "/fxml/admin/EditAdmin.fxml";


    @FXML
    private MainAdminController mainAdminController;

    @FXML
    private TableView<AdminFx> adminTable;

    @FXML
    private TableColumn<AdminFx, String> loginColumn;

    @FXML
    private TableColumn<AdminFx, String> nameColumn;

    @FXML
    private TableColumn<AdminFx, String> lastNameColumn;

    @FXML
    public void init() {
        mainAdminController.getAdminModel().init();
        setAdminTable();
        adminTable.getSelectionModel().selectedItemProperty().addListener((ChangeListener) (observableValue, oldValue, newValue) -> mainAdminController.getAdminModel()
                .setSelectedAdmin(adminTable.getSelectionModel().getSelectedItem()));
    }

    private void setAdminTable() {
        this.adminTable.setItems(mainAdminController.getAdminModel().getAdminsList());
        this.loginColumn.setCellValueFactory(x -> x.getValue().loginProperty());
        this.nameColumn.setCellValueFactory(x -> x.getValue().nameProperty());
        this.lastNameColumn.setCellValueFactory(x -> x.getValue().lastNameProperty());
    }

    @FXML
    void deleteAdmin() {
        mainAdminController.getAdminModel().deleteSelectedAdmin();
        this.init();
    }

    @FXML
    void editAdmin() {
        mainAdminController.setEditAdminControllerView();
    }

    @FXML
    void newAdmin() {
        mainAdminController.setNewAdminControllerView();

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
}
