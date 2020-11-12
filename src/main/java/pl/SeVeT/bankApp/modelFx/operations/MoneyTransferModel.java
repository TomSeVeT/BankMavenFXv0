package pl.SeVeT.bankApp.modelFx.operations;

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
import java.util.ArrayList;
import java.util.List;

public class MoneyTransferModel {
    private ObservableList<MoneyTransferFx> transferList = FXCollections.observableArrayList();

    public void init(BigInteger accNumber) {
        MoneyTransferDao moneyTransferDao = new MoneyTransferDao(DataManager.getConnectionSourece());
        this.transferList.clear();
        List<MoneyTransfer> tempTransferList;
        tempTransferList = moneyTransferDao.allQuery(MoneyTransfer.class);
        for (MoneyTransfer moneyTransfer : tempTransferList) {
            if(moneyTransfer.getSenderNumber().equals(accNumber)){
                moneyTransfer.setAmount(moneyTransfer.getAmount().multiply(new BigDecimal("-1")));
                transferList.add(ConverterFx.moneyTransferToFx(moneyTransfer));
            }else if (moneyTransfer.getReciverNumber().equals(accNumber))
                transferList.add(ConverterFx.moneyTransferToFx(moneyTransfer));
        }
        DataManager.closeDatabaseConnection();
    }

    public static boolean accountNumberExists(BigInteger accNumber){
        AccountDao accountDao = new AccountDao(DataManager.getConnectionSourece());
        return accountDao.queryByAccNumber(accNumber) != null;
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
        accountDao.createOrUpdate(ConverterFx.fxToAccount(accountFx));
        reciverAccount.setBalance(reciverAccount.getBalance().add(amount));
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
