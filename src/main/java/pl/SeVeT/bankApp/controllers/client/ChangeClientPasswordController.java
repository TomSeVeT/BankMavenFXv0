package pl.SeVeT.bankApp.controllers.client;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import pl.SeVeT.bankApp.utils.Dialogs;

public class ChangeClientPasswordController {

    @FXML
    private PasswordField actualPasswordField;

    @FXML
    private PasswordField newPasswordField;

    @FXML
    private PasswordField confirmNewPasswordField;

    @FXML
    private MainClientController mainClientController;

    @FXML
    void changePasswordOnAction() {
        if( actualPasswordField.getText(). equals (mainClientController.getClientModel().getLoggedClient().getPassword()) ){

            if(newPasswordField.getText().equals(confirmNewPasswordField.getText())){
                mainClientController.getClientModel().getLoggedClient().setPassword(newPasswordField.getText());
                mainClientController.getClientModel().update(mainClientController.getClientModel().getLoggedClient());
                Dialogs.passwordChanged();
            }else
                Dialogs.newPasswordNotEqual();

        }else
            Dialogs.wrongActualPassword();

    }

    public void setMainClientController(MainClientController mainClientController){
        this.mainClientController = mainClientController;
    }
}
