package pl.SeVeT.bankApp.data.model.users;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "ADMIN")
public class Admin implements User {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "FIRST_NAME")
    private String firstName;

    @DatabaseField(columnName = "LAST_NAME")
    private String lastName;

    @DatabaseField(columnName = "LOGIN")
    private String login;

    @DatabaseField(columnName = "PASSWORD")
    private String password;

    public Admin() {
    }

    public Admin(String firstName, String lastName, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String alias) {
        this.firstName = alias;
    }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

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
}
