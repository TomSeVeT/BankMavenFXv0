package pl.SeVeT.bankApp.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.util.Optional;

public class Dialogs {

    public static void aboutDialog() {
        Alert aboutAlert = new Alert(Alert.AlertType.INFORMATION);
        aboutAlert.setTitle("O programie");
        aboutAlert.setHeaderText("Autorem programu jest SeVeT");
        aboutAlert.setContentText("Wszystkie prawa zastrzeżone.\n" +
                "Kontakt: xsevetx@gmail.com");
        aboutAlert.showAndWait();
    }

    public static Optional<ButtonType> exitDialog() {
        Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION);
        exitAlert.setTitle("Zakończenie programu");
        exitAlert.setHeaderText("Czy chcesz wyjść z programu?");
        ((Button) exitAlert.getDialogPane().lookupButton(ButtonType.OK)).setText("TAK");
        ((Button) exitAlert.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("NIE");
        return exitAlert.showAndWait();
    }

    public static Optional<ButtonType> logoutDialog() {
        Alert logoutAlert = new Alert(Alert.AlertType.CONFIRMATION);
        logoutAlert.setTitle("Wylogowanie");
        logoutAlert.setHeaderText("Czy napewno chcesz się wylogować?");
        return logoutAlert.showAndWait();
    }


    public static void errorDialog(String message) {
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

    public static void wrongActualPassword() {
        Alert wrongActualPasswordAlert = new Alert(Alert.AlertType.ERROR);
        wrongActualPasswordAlert.setTitle("Nie zmieniono hasła!!");
        wrongActualPasswordAlert.setHeaderText("Podano błędne aktualne hasło!");
        wrongActualPasswordAlert.getDialogPane().setContent(new TextField("Jeśli wpisałeś poprawne dane, skontaktuj się z SeVeT'em"));
        wrongActualPasswordAlert.showAndWait();
    }

    public static void newPasswordNotEqual() {
        Alert passwordsNotEqualAlert = new Alert(Alert.AlertType.ERROR);
        passwordsNotEqualAlert.setTitle("Nie zmieniono hasła!!");
        passwordsNotEqualAlert.setHeaderText("Nowe hasło powtórzone błędnie!!");
        passwordsNotEqualAlert.showAndWait();
    }

    public static void passwordChanged() {
        Alert passwordChangedAlert = new Alert(Alert.AlertType.INFORMATION);
        passwordChangedAlert.setTitle("Hasło zmienione!");
        passwordChangedAlert.setHeaderText("Pomyślnie zaktualizowano hasło!");
        passwordChangedAlert.showAndWait();
    }

    public static void accountNotFound() {
        Alert accountNotFoundAlert = new Alert(Alert.AlertType.ERROR);
        accountNotFoundAlert.setTitle("Odbiorca nie znaleziony!");
        accountNotFoundAlert.setHeaderText("Odbiorca o podanym numerze konta nie istnieje.");
        accountNotFoundAlert.showAndWait();

    }

    public static void balanceTooLow() {
        Alert balanceTooLowAlert = new Alert(Alert.AlertType.ERROR);
        balanceTooLowAlert.setTitle("Przelew nie został zlecony!");
        balanceTooLowAlert.setHeaderText("Nie posiadasz wystarczających środków na koncie");
        balanceTooLowAlert.showAndWait();
    }

    public static void transferSended(){
        Alert transferSendedAlert = new Alert(Alert.AlertType.INFORMATION);
        transferSendedAlert.setTitle("Przelew wykonany!");
        transferSendedAlert.setHeaderText("Przelew został zrealizowany pomyślnie!");
        transferSendedAlert.showAndWait();
    }

    public static void wrongReciverNumber() {
        Alert balanceTooLowAlert = new Alert(Alert.AlertType.ERROR);
        balanceTooLowAlert.setTitle("Przelew nie został zlecony!");
        balanceTooLowAlert.setHeaderText("Brak odbiorcy o podanym numerze konta!");
        balanceTooLowAlert.showAndWait();
    }
}
