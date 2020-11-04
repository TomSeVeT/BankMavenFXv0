package pl.SeVeT.bankApp.controllers;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.SeVeT.bankApp.controllers.admin.MainAdminController;
import pl.SeVeT.bankApp.controllers.client.MainClientController;
import pl.SeVeT.bankApp.data.model.users.Admin;
import pl.SeVeT.bankApp.data.model.users.Client;
import pl.SeVeT.bankApp.modelFx.users.AdminModel;
import pl.SeVeT.bankApp.utils.ConverterFx;
import pl.SeVeT.bankApp.utils.Dialogs;
import pl.SeVeT.bankApp.utils.Login;
import pl.SeVeT.bankApp.utils.SceneController;

import java.sql.SQLException;
import java.util.Optional;

public class LoginPaneController {

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button exitButton;

    @FXML
    private Button logInButton;

    @FXML
    private Button logInAdminButton;

    @FXML
    private MainAdminController mainAdminController;

    @FXML
    private MainClientController mainClientController;


    private Stage primaryStage;


    @FXML
    void exitButtonOnAction() {
        Optional<ButtonType> result = Dialogs.exitDialog();
        if (result.get() != ButtonType.OK) {
            return;
        }
        Platform.exit();
        System.exit(666);
    }

    @FXML
    void logInAdminButtonOnAction(ActionEvent event) throws SQLException {
        //AdminModel.addSeVeT();
        Admin loggedAdmin = Login.logAsAdmin(loginField.getText(),passwordField.getText());
        if(loggedAdmin!=null){
        mainAdminController = (MainAdminController) SceneController.setAdminScene(primaryStage);
        mainAdminController.getAdminModel().setLoggedAdmin(ConverterFx.adminToFx(loggedAdmin));}
        else Dialogs.loginError();
    }

    @FXML
    void logInButtonOnAction(ActionEvent event) throws SQLException {
        Client loggedClient = Login.logAsClient(loginField.getText(),passwordField.getText());
        if(loggedClient!=null){
            mainClientController = (MainClientController) SceneController.setClientScene(primaryStage);
            mainClientController.getClientModel().setLoggedClient(ConverterFx.clientToFx(loggedClient));
            mainClientController.getAccountModel().setActiveAccount(ConverterFx.accountToFx(loggedClient.getAccount()));}
        else Dialogs.loginError();
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage=primaryStage;

    }
}
