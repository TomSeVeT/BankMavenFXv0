package pl.SeVeT.bankApp.data.model.users;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pl.SeVeT.bankApp.data.model.accounts.Account;

import java.time.LocalDate;

@DatabaseTable(tableName = "CLIENT")
public class Client implements User {

    @DatabaseField(generatedId = true, allowGeneratedIdInsert = true)
    private int id;

    @DatabaseField(columnName = "FIRST_NAME")
    private String firstName;

    @DatabaseField(columnName = "LAST_NAME")
    private String lastName;

    @DatabaseField(columnName = "LOGIN")
    private String login;

    @DatabaseField(columnName = "PASSWORD")
    private String password;

    @DatabaseField(columnName = "PESEL", width = 11)
    private long pesel;

    @DatabaseField(columnName = "BIRTH_DATE", dataType = DataType.SERIALIZABLE, format = "YYYY-MM-DD")
    private LocalDate birthDate;

    @DatabaseField(columnName = "ADDRESS")
    private String address;

    @DatabaseField(columnName = "PHONE_NUMBER")
    private String phoneNumber;

    @DatabaseField(columnName = "ACCOUNT_ID", foreign = true, foreignAutoRefresh = true)
    private Account account;

    public Client() {
    }

    public Client(String firstName, String lastName, String login, String password, long pesel, LocalDate birthDate, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.pesel = pesel;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
