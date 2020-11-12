package pl.SeVeT.bankApp.modelFx.accounts;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import pl.SeVeT.bankApp.data.dao.AccountDao;
import pl.SeVeT.bankApp.data.dao.MoneyTransferDao;
import pl.SeVeT.bankApp.data.dataUtils.DataManager;
import pl.SeVeT.bankApp.data.model.operations.MoneyTransfer;
import pl.SeVeT.bankApp.modelFx.users.ClientFx;
import pl.SeVeT.bankApp.utils.ConverterFx;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.math.BigInteger;


public class AccountModel {
    private ObjectProperty<AccountFx> activeAccount = new SimpleObjectProperty<>();

    public AccountFx getActiveAccount() {
        return activeAccount.get();
    }

    public ObjectProperty<AccountFx> activeAccountProperty() {
        return activeAccount;
    }

    public void setActiveAccount(AccountFx activeAccount) {
        this.activeAccount.set(activeAccount);
    }

    public void deposit(ClientFx selectedClient, BigDecimal amount){
        AccountDao accountDao = new AccountDao(DataManager.getConnectionSourece());
        activeAccount.getValue().setBalance(activeAccount.getValue().getBalance().add(amount));
        accountDao.createOrUpdate(ConverterFx.fxToAccount(activeAccount.getValue()));

        MoneyTransferDao moneyTransferDao = new MoneyTransferDao(DataManager.getConnectionSourece());
        MoneyTransfer moneyTransfer = new MoneyTransfer(amount , selectedClient.toString() ,
                selectedClient.getAccount().getAccNumber() ,"Wpłata w oddziale" ,
                selectedClient.getAccount().getAccNumber() ,"Wpłata w oddziale" ,
                ConverterFx.fxToAccount(selectedClient.getAccount()));
        moneyTransferDao.createOrUpdate(moneyTransfer);

        DataManager.closeDatabaseConnection();
    }

    public void withdraw(ClientFx selectedClient, BigDecimal amount){
        AccountDao accountDao = new AccountDao(DataManager.getConnectionSourece());
        activeAccount.getValue().setBalance(activeAccount.getValue().getBalance().subtract(amount));
        accountDao.createOrUpdate(ConverterFx.fxToAccount(activeAccount.getValue()));

        MoneyTransferDao moneyTransferDao = new MoneyTransferDao(DataManager.getConnectionSourece());
        MoneyTransfer moneyTransfer = new MoneyTransfer(amount.multiply(new BigDecimal(-1)) , selectedClient.toString() ,
                selectedClient.getAccount().getAccNumber() ,"Wypłata w oddziale" ,
                selectedClient.getAccount().getAccNumber() ,"Wypłata w oddziale" ,
                ConverterFx.fxToAccount(selectedClient.getAccount()));
        moneyTransferDao.createOrUpdate(moneyTransfer);

        DataManager.closeDatabaseConnection();    }
}
