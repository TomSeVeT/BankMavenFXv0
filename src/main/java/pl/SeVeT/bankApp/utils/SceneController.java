package pl.SeVeT.bankApp.utils;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pl.SeVeT.bankApp.controllers.LoginPaneController;

public class SceneController {
    public static final String MAIN_CLIENT_PANE_FXML = "/fxml/client/MainClientPane.fxml";
    public static final String MAIN_ADMIN_PANE_FXML = "/fxml/admin/MainAdminPane.fxml";
    public static final String LOGIN_PANE_FXML = "/fxml/LoginPane.fxml";


    public static Object setClientScene(Stage primaryStage) {
        Object[] temp = Fxml.loadFXML_getController(MAIN_CLIENT_PANE_FXML);
        Scene scene = new Scene((Pane) temp[0]);
        primaryStage.hide();
        primaryStage.setScene(scene);
        primaryStage.setTitle("BankApp Klient");
        primaryStage.show();
        return temp[1];
    }


    public static Object setAdminScene(Stage primaryStage) {
        Object[] temp = Fxml.loadFXML_getController(MAIN_ADMIN_PANE_FXML);
        Scene scene = new Scene((Pane) temp[0]);
        primaryStage.hide();
        primaryStage.setScene(scene);
        primaryStage.setTitle("BankApp Admin");
        primaryStage.show();
        return temp[1];
    }

    public static Object setLoginScene(Stage primaryStage){
        Object[] temp = Fxml.loadFXML_getController(LOGIN_PANE_FXML);
        Scene scene = new Scene((Pane) temp[0]);
        primaryStage.hide();
        primaryStage.setScene(scene);
        primaryStage.setTitle("BankApp Login");
        primaryStage.show();
        return temp[1];
    }

}
