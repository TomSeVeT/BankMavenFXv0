package pl.SeVeT.bankApp.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.util.Optional;

public class Dialogs {

    public static void aboutDialog(){
        Alert aboutAlert = new Alert(Alert.AlertType.INFORMATION);
        aboutAlert.setTitle("O programie");
        aboutAlert.setHeaderText("Autorem programu jest SeVeT");
        aboutAlert.setContentText("Wszystkie prawa zastrzeżone.\n" +
                "Kontakt: xsevetx@gmail.com");
        aboutAlert.showAndWait();
    }
    public static Optional<ButtonType> exitDialog(){
        Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION);
        exitAlert.setTitle("Zakończenie programu");
        exitAlert.setHeaderText("Czy chcesz wyjść z programu?");
            ((Button)exitAlert.getDialogPane().lookupButton(ButtonType.OK)).setText("TAK");
            ((Button)exitAlert.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("NIE");
        return exitAlert.showAndWait();
    }
    public static Optional<ButtonType> logoutDialog(){
        Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION);
        exitAlert.setTitle("Wylogowanie");
        exitAlert.setHeaderText("Czy napewno chcesz się wylogować?");
        return exitAlert.showAndWait();
    }
    public static Optional<ButtonType> saveDialog(){
        Alert saveAlert = new Alert(Alert.AlertType.CONFIRMATION);
        saveAlert.setTitle("Zapisywanie");
        saveAlert.setHeaderText("Czy chcesz zapisać zmiany?");
        return saveAlert.showAndWait();
    }

    public static void errorDialog(String message){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("Błąd!");
        errorAlert.setHeaderText("Skontaktuj się z SeVeT'em!\nxsevetx@gmail.com");
        TextField messageField = new TextField();
        messageField.setText(message);
        errorAlert.getDialogPane().setContent(messageField);
        errorAlert.showAndWait();
    }

    public static void loginError() {
        Alert loginErrorAlert = new Alert(Alert.AlertType.ERROR);
        loginErrorAlert.setTitle("Nie zalogowano!");
        loginErrorAlert.setHeaderText("Podano błędny login lub hasło!");
        loginErrorAlert.getDialogPane().setContent(new TextField("Jeśli wpisałeś poprawne dane, skontaktuj się z SeVeT'em"));
        loginErrorAlert.showAndWait();
    }
}
