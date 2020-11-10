package pl.SeVeT.bankApp.data.model.accounts;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import pl.SeVeT.bankApp.data.model.BaseModel;
import pl.SeVeT.bankApp.data.model.operations.MoneyTransfer;
import pl.SeVeT.bankApp.data.model.users.Client;
import pl.SeVeT.bankApp.utils.Generate;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@DatabaseTable(tableName = "ACCOUNT")
public class Account implements BaseModel {

    @DatabaseField(generatedId = true, allowGeneratedIdInsert = true)
    private int id;

    @DatabaseField(columnName = "ACC_NUMBER")
    private BigInteger accNumber;

    @DatabaseField(columnName = "BALANCE")
    private BigDecimal balance;

    @DatabaseField(columnName = "CREATION_DATE", dataType = DataType.SERIALIZABLE, format = "YYYY-MM-DD")
    private LocalDate creationDate;

    @DatabaseField(columnName = "LAST_LOGIN_DATE", dataType = DataType.SERIALIZABLE, format = "YYYY-MM-DD")
    private LocalDate lastLoginDate;

    @DatabaseField(columnName = "CLIENT", foreign = true, foreignAutoRefresh = true)
    private Client client;

    @ForeignCollectionField(columnName = "TRANSFER_COLLECTION", eager = true)
    private ForeignCollection<MoneyTransfer> moneyTransfers;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigInteger getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(BigInteger accNumber) {
        this.accNumber = accNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDate lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ForeignCollection<MoneyTransfer> getMoneyTransfers() {
        return moneyTransfers;
    }

    public void setMoneyTransfers(ForeignCollection<MoneyTransfer> moneyTransfers) {
        this.moneyTransfers = moneyTransfers;
    }

    public Account() {
    }

    public Account(Client client) {
        this.accNumber = Generate.accNumber();
        this.balance = BigDecimal.valueOf(0);
        this.creationDate = LocalDate.now();
        this.lastLoginDate = LocalDate.now();
        this.client = client;
    }
}
