package pl.SeVeT.bankApp.controllers.admin;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import pl.SeVeT.bankApp.modelFx.users.AdminModel;
import pl.SeVeT.bankApp.modelFx.users.ClientModel;
import pl.SeVeT.bankApp.utils.Fxml;

public class MainAdminController {

    @FXML
    private AdminMenuController adminMenuController;

    @FXML
    private ManageAccountsController manageAccountsController;

    @FXML
    private ManageAdminsController manageAdminsController;

    @FXML
    private NewAccountController newAccountController;

    @FXML
    private NewAdminController newAdminController;

    @FXML
    private EditAdminController editAdminController;

    @FXML
    private EditAccountController editAccountController;

    @FXML
    private BorderPane adminBorderPane;

    private AdminModel adminModel;
    private ClientModel clientModel;

    @FXML
    public void initialize(){
        adminMenuController.setMainController(this);

        clientModel = new ClientModel();
        adminModel = new AdminModel();
    }

    public void setManageAccountsControllerView(){
        Object[] temp =  Fxml.loadFXML_getController(AdminMenuController.MANAGE_ACCOUNTS);
        adminBorderPane.setCenter((BorderPane)temp[0]);
        manageAccountsController = (ManageAccountsController) temp[1];
        manageAccountsController.setMainAdminController(this);
        manageAccountsController.init();
    }

    public void setManageAdminsControllerView(){
        Object[] temp =  Fxml.loadFXML_getController(AdminMenuController.MANAGE_ADMINS);
        adminBorderPane.setCenter((BorderPane)temp[0]);
        manageAdminsController = (ManageAdminsController) temp[1];
        manageAdminsController.setMainAdminController(this);
        manageAdminsController.init();
    }

    public void setNewAccountControllerView(){
        Object[] temp =  Fxml.loadFXML_getController(ManageAccountsController.NEW_ACCOUNT);
        adminBorderPane.setCenter((BorderPane)temp[0]);
        newAccountController = (NewAccountController) temp[1];
        newAccountController.setMainAdminController(this);
    }
    public void setNewAdminControllerView(){
        Object[] temp =  Fxml.loadFXML_getController(ManageAdminsController.NEW_ADMIN);
        adminBorderPane.setCenter((BorderPane)temp[0]);
        newAdminController = (NewAdminController) temp[1];
        newAdminController.setMainAdminController(this);
    }
    public void setEditAdminControllerView() {
        Object[] temp = Fxml.loadFXML_getController(ManageAdminsController.EDIT_ADMIN);
        adminBorderPane.setCenter((BorderPane)temp[0]);
        editAdminController = (EditAdminController) temp[1];
        editAdminController.setMainAdminController(this);
        adminModel.setChosenAdmin(adminModel.getSelectedAdmin());
        editAdminController.init();
    }
    public void setEditAccountControllerView(){
        Object[] temp = Fxml.loadFXML_getController(ManageAccountsController.EDIT_ACCOUNT);
        adminBorderPane.setCenter((BorderPane)temp[0]);
        editAccountController = (EditAccountController) temp[1];
        editAccountController.setMainAdminController(this);
        clientModel.setChoosenClient(clientModel.getSelectedClient());
        editAccountController.init();
    }

    public void setView(String fxmlPatch){
        adminBorderPane.setCenter(Fxml.loadFXML(fxmlPatch));
    }


    public ClientModel getClientModel() {
        return clientModel;
    }

    public AdminModel getAdminModel() {
        return adminModel;
    }



}
