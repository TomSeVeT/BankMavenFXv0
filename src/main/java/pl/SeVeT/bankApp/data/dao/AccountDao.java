package pl.SeVeT.bankApp.data.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import pl.SeVeT.bankApp.data.model.accounts.Account;
import pl.SeVeT.bankApp.utils.Dialogs;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

public class AccountDao extends MainDao {
    public AccountDao(ConnectionSource connectionSource) {
        super(connectionSource);
    }

    public Account queryByAccNumber(BigInteger accountNumber){
        Dao<Account,Void> dao = getDao(Account.class);
        QueryBuilder<Account,Void> queryBuilder = dao.queryBuilder();
        PreparedQuery<Account> preparedQuery;
        Account foundAccount = null;
        try {
             preparedQuery = queryBuilder.where().eq("ACC_NUMBER",accountNumber).prepare();
             foundAccount = dao.queryForFirst(preparedQuery);
        } catch (SQLException | NullPointerException e) {
            Dialogs.accountNotFound();
        }
        return foundAccount;

    }

}
