package pl.SeVeT.bankApp.controllers.admin;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import pl.SeVeT.bankApp.utils.Dialogs;

public class ChangeAdminPasswordController {

    @FXML
    private PasswordField actualPasswordField;

    @FXML
    private PasswordField newPasswordField;

    @FXML
    private PasswordField confirmNewPasswordField;

    @FXML
    private MainAdminController mainAdminController;

    @FXML
    void changePasswordOnAction() {
        if( actualPasswordField.getText(). equals (mainAdminController.getAdminModel().getLoggedAdmin().getPassword()) ){

            if(newPasswordField.getText().equals(confirmNewPasswordField.getText())){
                mainAdminController.getAdminModel().getLoggedAdmin().setPassword(newPasswordField.getText());
                mainAdminController.getAdminModel().update(mainAdminController.getAdminModel().getLoggedAdmin());
                Dialogs.passwordChanged();
            }else
                Dialogs.newPasswordNotEqual();

        }else
            Dialogs.wrongActualPassword();

    }

    public void setMainAdminController(MainAdminController mainAdminController){
        this.mainAdminController = mainAdminController;
    }
}
