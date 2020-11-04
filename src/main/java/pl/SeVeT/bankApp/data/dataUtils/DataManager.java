package pl.SeVeT.bankApp.data.dataUtils;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import pl.SeVeT.bankApp.data.model.accounts.Account;
import pl.SeVeT.bankApp.data.model.operations.MoneyTransfer;
import pl.SeVeT.bankApp.data.model.users.Admin;
import pl.SeVeT.bankApp.data.model.users.Client;
import pl.SeVeT.bankApp.utils.Dialogs;

import java.io.IOException;
import java.sql.SQLException;

public class DataManager {
    private static ConnectionSource connectionSource;
    public static void initializeDatabase(){
        createConnectionSource();
        createTables();
        closeDatabaseConnection();
    }

    private static void createTables(){
        try {
            TableUtils.createTableIfNotExists(connectionSource, Client.class);
            TableUtils.createTableIfNotExists(connectionSource, Admin.class);
            TableUtils.createTableIfNotExists(connectionSource, Account.class);
            TableUtils.createTableIfNotExists(connectionSource, MoneyTransfer.class);
        } catch (SQLException e) {
            Dialogs.errorDialog(e.getMessage());
        }
    }

    private static void createConnectionSource() {
        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:data.db");
        } catch (SQLException e) {
            Dialogs.errorDialog(e.getMessage());;
        }
    }

    public static ConnectionSource getConnectionSourece(){
        if(connectionSource==null)
            createConnectionSource();

        return connectionSource;
    }

    public static void closeDatabaseConnection(){
        if(connectionSource!=null)
            try{
                connectionSource.close();
            }catch (IOException e){
                Dialogs.errorDialog(e.getMessage());
            }
    }
}
