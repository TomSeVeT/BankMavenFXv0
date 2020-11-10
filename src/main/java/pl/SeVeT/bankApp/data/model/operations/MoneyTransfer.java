package pl.SeVeT.bankApp.data.model.operations;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pl.SeVeT.bankApp.data.model.BaseModel;
import pl.SeVeT.bankApp.data.model.accounts.Account;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@DatabaseTable(tableName = "MONEY_TRANSFER")
public class MoneyTransfer implements BaseModel {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "AMOUNT")
    private BigDecimal amount;

    @DatabaseField(columnName = "RECIVER_NAME")
    private String reciverName;

    @DatabaseField(columnName = "RECIVER_NUMBER")
    private BigInteger reciverNumber;

    @DatabaseField(columnName = "SENDER_NAME")
    private String senderName;

    @DatabaseField(columnName = "SENDER_NUMBER")
    private BigInteger senderNumber;

    @DatabaseField(columnName = "TIME_STAMP", dataType = DataType.SERIALIZABLE, format = "YYYY-MM-DD")
    private LocalDate timeStamp;

    @DatabaseField(columnName = "TITLE")
    private String title;

    @DatabaseField(columnName = "ACCOUNT", foreign = true)
    private Account account;

    public MoneyTransfer(BigDecimal amount, String reciverName, BigInteger reciverNumber, String senderName, BigInteger senderNumber, String title, Account account) {
        this.amount = amount;
        this.reciverName = reciverName;
        this.reciverNumber = reciverNumber;
        this.senderName = senderName;
        this.senderNumber = senderNumber;
        this.title = title;
        this.account = account;
        this.timeStamp = LocalDate.now();
    }

    public MoneyTransfer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigInteger getReciverNumber() {
        return reciverNumber;
    }

    public void setReciverNumber(BigInteger reciverNumber) {
        this.reciverNumber = reciverNumber;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public BigInteger getSenderNumber() {
        return senderNumber;
    }

    public void setSenderNumber(BigInteger senderNumber) {
        this.senderNumber = senderNumber;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReciverName() {
        return reciverName;
    }

    public void setReciverName(String reciverName) {
        this.reciverName = reciverName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
