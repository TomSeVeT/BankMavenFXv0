package pl.SeVeT.bankApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pl.SeVeT.bankApp.controllers.LoginPaneController;
import pl.SeVeT.bankApp.data.dataUtils.DataManager;


public class Main extends Application {


    public static final String MAIN_PANE_FXML = "/fxml/LoginPane.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //TODO:cut to util.Fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource(MAIN_PANE_FXML));
        Pane mainPane = loader.load();
        Scene scene = new Scene(mainPane);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("BankAppLogin");
        primaryStage.show();
        LoginPaneController loginPaneController = loader.getController();
        loginPaneController.setPrimaryStage(primaryStage);
        DataManager.initializeDatabase();
    }
}
