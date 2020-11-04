package pl.SeVeT.bankApp.modelFx.users;

import javafx.beans.property.*;
import pl.SeVeT.bankApp.modelFx.accounts.AccountFx;

import java.time.LocalDate;

public class ClientFx {
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty firstName = new SimpleStringProperty();
    private StringProperty lastName = new SimpleStringProperty();
    private StringProperty login = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();
    private LongProperty pesel = new SimpleLongProperty();
    private ObjectProperty<LocalDate> birthDate = new SimpleObjectProperty<>();
    private StringProperty address = new SimpleStringProperty();
    private StringProperty phoneNumber = new SimpleStringProperty();
    private ObjectProperty<AccountFx> account = new SimpleObjectProperty<>();

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getLogin() {
        return login.get();
    }

    public StringProperty loginProperty() {
        return login;
    }

    public void setLogin(String login) {
        this.login.set(login);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public long getPesel() {
        return pesel.get();
    }

    public LongProperty peselProperty() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel.set(pesel);
    }

    public LocalDate getBirthDate() {
        return birthDate.get();
    }

    public Property<LocalDate> birthDateProperty() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate.set(birthDate);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public AccountFx getAccount() {
        return account.get();
    }

    public ObjectProperty<AccountFx> accountProperty() {
        return account;
    }

    public void setAccount(AccountFx account) {
        this.account.set(account);
    }
}
