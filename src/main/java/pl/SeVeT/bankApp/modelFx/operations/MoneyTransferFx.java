package pl.SeVeT.bankApp.modelFx.operations;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

public class MoneyTransferFx {
    private SimpleIntegerProperty id = new SimpleIntegerProperty();
    private SimpleObjectProperty<BigDecimal> amount = new SimpleObjectProperty<>();
    private SimpleStringProperty reciverName = new SimpleStringProperty();
    private SimpleObjectProperty<BigInteger> reciverNumber = new SimpleObjectProperty<>();
    private SimpleStringProperty senderName = new SimpleStringProperty();
    private SimpleObjectProperty<BigInteger> senderNumber = new SimpleObjectProperty<>();
    private SimpleObjectProperty<LocalDate> timeStamp = new SimpleObjectProperty<>();
    private SimpleStringProperty title = new SimpleStringProperty();

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public BigDecimal getAmount() {
        return amount.get();
    }

    public SimpleObjectProperty<BigDecimal> amountProperty() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount.set(amount);
    }

    public String getReciverName() {
        return reciverName.get();
    }

    public SimpleStringProperty reciverNameProperty() {
        return reciverName;
    }

    public void setReciverName(String reciverName) {
        this.reciverName.set(reciverName);
    }

    public BigInteger getReciverNumber() {
        return reciverNumber.get();
    }

    public SimpleObjectProperty<BigInteger> reciverNumberProperty() {
        return reciverNumber;
    }

    public void setReciverNumber(BigInteger reciverNumber) {
        this.reciverNumber.set(reciverNumber);
    }

    public String getSenderName() {
        return senderName.get();
    }

    public SimpleStringProperty senderNameProperty() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName.set(senderName);
    }

    public BigInteger getSenderNumber() {
        return senderNumber.get();
    }

    public SimpleObjectProperty<BigInteger> senderNumberProperty() {
        return senderNumber;
    }

    public void setSenderNumber(BigInteger senderNumber) {
        this.senderNumber.set(senderNumber);
    }

    public LocalDate getTimeStamp() {
        return timeStamp.get();
    }

    public SimpleObjectProperty<LocalDate> timeStampProperty() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp.set(timeStamp);
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }
}
