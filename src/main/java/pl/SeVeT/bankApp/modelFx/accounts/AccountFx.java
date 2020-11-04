package pl.SeVeT.bankApp.modelFx.accounts;

import javafx.beans.property.*;
import javafx.collections.ObservableList;
import pl.SeVeT.bankApp.modelFx.operations.MoneyTransferFx;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

public class AccountFx {

    private IntegerProperty id = new SimpleIntegerProperty();
    private ObjectProperty<BigInteger> accNumber = new SimpleObjectProperty<>();
    private ObjectProperty<BigDecimal> balance = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> creationDate = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> lastLoginDate = new SimpleObjectProperty<>();
    private ListProperty<MoneyTransferFx> moneyTransfers = new SimpleListProperty<>();


    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public BigInteger getAccNumber() {
        return accNumber.get();
    }

    public ObjectProperty<BigInteger> accNumberProperty() {
        return accNumber;
    }

    public void setAccNumber(BigInteger accNumber) {
        this.accNumber.set(accNumber);
    }

    public BigDecimal getBalance() {
        return balance.get();
    }

    public ObjectProperty<BigDecimal> balanceProperty() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance.set(balance);
    }

    public LocalDate getCreationDate() {
        return creationDate.get();
    }

    public ObjectProperty<LocalDate> creationDateProperty() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate.set(creationDate);
    }

    public LocalDate getLastLoginDate() {
        return lastLoginDate.get();
    }

    public ObjectProperty<LocalDate> lastLoginDateProperty() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDate lastLoginDate) {
        this.lastLoginDate.set(lastLoginDate);
    }

    public ObservableList<MoneyTransferFx> getMoneyTransfers() {
        return moneyTransfers.get();
    }

    public ListProperty<MoneyTransferFx> moneyTransfersProperty() {
        return moneyTransfers;
    }

    public void setMoneyTransfers(ObservableList<MoneyTransferFx> moneyTransfers) {
        this.moneyTransfers.set(moneyTransfers);
    }
}
