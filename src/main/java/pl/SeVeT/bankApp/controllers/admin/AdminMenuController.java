package pl.SeVeT.bankApp.controllers.admin;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToggleGroup;
import pl.SeVeT.bankApp.utils.Dialogs;
import pl.SeVeT.bankApp.utils.SceneController;

import java.util.Optional;

public class AdminMenuController {
    public static final String MANAGE_ACCOUNTS = "/fxml/admin/ManageAccounts.fxml";
    public static final String MANAGE_ADMINS = "/fxml/admin/ManageAdmins.fxml";
    public static final String CHANGE_PASSWORD = "/fxml/admin/ChangeAdminPassword.fxml";

    @FXML
    private ToggleGroup adminButtons;

    @FXML
    private MainAdminController mainAdminController;

    @FXML
    private ManageAdminsController manageAdminsController;

    @FXML
    private ManageAccountsController manageAccountsController;


    public void setMainController(MainAdminController mainAdminController) {
        this.mainAdminController = mainAdminController;
    }


    @FXML
    public void viewManageAccounts() {
        mainAdminController.setManageAccountsControllerView();
    }

    @FXML
    public void viewManageAdmins() {
        mainAdminController.setManageAdminsControllerView();
    }

    @FXML
    public void viewChangePassword() {
        mainAdminController.setChangeAdminPasswordControllerView();
    }

    @FXML
    public void logout() {
        Optional<ButtonType> result = Dialogs.logoutDialog();
        if(result.get()==ButtonType.OK) {
            SceneController.setLoginScene(mainAdminController.getPrimaryStage(),mainAdminController.getPrimaryStage());
        }
    }

}
