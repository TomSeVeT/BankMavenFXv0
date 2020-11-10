package pl.SeVeT.bankApp.controllers.client;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ClientInfoController {

    @FXML
    private TextField ownerField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField birthDateField;

    @FXML
    private TextField peselField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private MainClientController mainClientController;

    public void init(){
        this.ownerField.setText(mainClientController.getClientModel().getLoggedClient().getFirstName()
                .concat(" ")
                .concat(mainClientController.getClientModel().getLoggedClient().getLastName()));
        this.addressField.textProperty().bindBidirectional(mainClientController.getClientModel().getLoggedClient().addressProperty());
        this.birthDateField.setText(mainClientController.getClientModel().getLoggedClient().getBirthDate().toString());
        this.peselField.setText(String.valueOf(mainClientController.getClientModel().getLoggedClient().getPesel()));
        this.phoneNumberField.textProperty().bindBidirectional(mainClientController.getClientModel().getLoggedClient().phoneNumberProperty());
    }

    @FXML
    void editAdressOnAction() {
        mainClientController.getClientModel().update(mainClientController.getClientModel().getLoggedClient());

    }

    @FXML
    void editPhoneNumberOnAction() {
        mainClientController.getClientModel().update(mainClientController.getClientModel().getLoggedClient());
        this.init();

    }

    public void setMainClientController(MainClientController mainClientController){
        this.mainClientController= mainClientController;
        this.init();
    }

}
