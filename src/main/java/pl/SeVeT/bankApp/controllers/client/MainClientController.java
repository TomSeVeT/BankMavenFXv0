package pl.SeVeT.bankApp.controllers.client;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import pl.SeVeT.bankApp.modelFx.accounts.AccountModel;
import pl.SeVeT.bankApp.modelFx.users.ClientModel;
import pl.SeVeT.bankApp.utils.Fxml;

public class MainClientController {

    @FXML
    private ClientMenuController clientMenuController;

    @FXML
    private BorderPane clientBorderPane;

    private ClientModel clientModel;

    private AccountModel accountModel;

    @FXML
    public void initialize(){
        clientMenuController.setMainController(this);
        clientModel = new ClientModel();
        accountModel = new AccountModel();
    }

    public void setView(String fxmlPatch){
        clientBorderPane.setCenter(Fxml.loadFXML(fxmlPatch));
    }

    public ClientModel getClientModel() {
        return clientModel;
    }

    public AccountModel getAccountModel() {
        return accountModel;
    }
}
