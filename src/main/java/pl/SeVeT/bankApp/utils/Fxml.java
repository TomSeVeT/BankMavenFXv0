package pl.SeVeT.bankApp.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class Fxml {
    public static Pane loadFXML(String fxmlPatch) {
        FXMLLoader loader = new FXMLLoader(Fxml.class.getResource(fxmlPatch));
        try {
            return loader.load();
        } catch (Exception e) {
            Dialogs.errorDialog(e.getMessage());
        }
        return null;
    }

    public static Object[] loadFXML_getController(String fxmlPatch) {
        FXMLLoader loader = new FXMLLoader(Fxml.class.getResource(fxmlPatch));
        Pane pane;
        Object controller;
        try {
            pane = loader.load();
            controller = loader.getController();

            return new Object[]{pane, controller};
        } catch (Exception e) {
            Dialogs.errorDialog(e.getMessage());
        }
        return null;
    }
}
