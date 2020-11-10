package pl.SeVeT.bankApp.modelFx.operations;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.SeVeT.bankApp.data.dao.AccountDao;
import pl.SeVeT.bankApp.data.dao.MoneyTransferDao;
import pl.SeVeT.bankApp.data.dataUtils.DataManager;
import pl.SeVeT.bankApp.data.model.accounts.Account;
import pl.SeVeT.bankApp.data.model.operations.MoneyTransfer;
import pl.SeVeT.bankApp.modelFx.accounts.AccountFx;
import pl.SeVeT.bankApp.utils.ConverterFx;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class MoneyTransferModel {
    private ObservableList<MoneyTransferFx> transferList = FXCollections.observableArrayList();

    public void init() {
        MoneyTransferDao moneyTransferDao = new MoneyTransferDao(DataManager.getConnectionSourece());
        this.transferList.clear();
        DataManager.closeDatabaseConnection();
    }

    public void sendTransfer(BigDecimal amount, String reciverName, String reciverNumber,
                             String senderName, String title, AccountFx accountFx){
        AccountDao accountDao = new AccountDao(DataManager.getConnectionSourece());

        Account reciverAccount = accountDao.queryByAccNumber(new BigInteger(reciverNumber));
        MoneyTransfer tempMoneyTransfer = new MoneyTransfer(amount,reciverName,new BigInteger(reciverNumber),
                senderName,accountFx.getAccNumber(),title, ConverterFx.fxToAccount(accountFx));
        MoneyTransferDao moneyTransferDao = new MoneyTransferDao(DataManager.getConnectionSourece());
        accountDao.refresh(tempMoneyTransfer.getAccount());
        moneyTransferDao.createOrUpdate(tempMoneyTransfer);
        accountFx.setBalance(accountFx.getBalance().subtract(amount));
        accountFx.getMoneyTransfers().add(ConverterFx.moneyTransferToFx(tempMoneyTransfer));
        accountDao.createOrUpdate(ConverterFx.fxToAccount(accountFx));
        reciverAccount.setBalance(reciverAccount.getBalance().add(amount));
        reciverAccount.getMoneyTransfers().add(tempMoneyTransfer);
        accountDao.createOrUpdate(reciverAccount);
        DataManager.closeDatabaseConnection();
    }


    public ObservableList<MoneyTransferFx> getTransferList() {
        return transferList;
    }

    public void setTransferList(ObservableList<MoneyTransferFx> transferList) {
        this.transferList = transferList;
    }

}
