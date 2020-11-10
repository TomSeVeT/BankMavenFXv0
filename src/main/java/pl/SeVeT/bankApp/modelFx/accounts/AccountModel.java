package pl.SeVeT.bankApp.modelFx.accounts;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import pl.SeVeT.bankApp.data.dao.AccountDao;
import pl.SeVeT.bankApp.data.dataUtils.DataManager;


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
        /*AccountDao accountDao = new AccountDao(DataManager.getConnectionSourece());
        accountDao.refr;
        DataManager.closeDatabaseConnection();*/
    }
}
