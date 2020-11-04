package pl.SeVeT.bankApp.utils;

import com.j256.ormlite.stmt.QueryBuilder;
import pl.SeVeT.bankApp.data.dao.AdminDao;
import pl.SeVeT.bankApp.data.dao.ClientDao;
import pl.SeVeT.bankApp.data.dataUtils.DataManager;
import pl.SeVeT.bankApp.data.model.users.Admin;
import pl.SeVeT.bankApp.data.model.users.Client;

import java.sql.SQLException;

public class Login {
//TODO: Make generic

    public static Client logAsClient(String login, String password) throws SQLException {
        ClientDao clientDao = new ClientDao(DataManager.getConnectionSourece());
        QueryBuilder<Client, String> queryBuilder = clientDao.getQueryBuilder(Client.class);
        Client client;

        client = clientDao.getDao(Client.class).queryForFirst(queryBuilder.where()
                .eq("LOGIN", login).prepare());
        if (client != null)
            if (client.getPassword().equals(password)) return client;
        return null;
    }

    public static Admin logAsAdmin(String login, String password) throws SQLException {
        AdminDao adminDao = new AdminDao(DataManager.getConnectionSourece());
        QueryBuilder<Admin, String> queryBuilder = adminDao.getQueryBuilder(Admin.class);
        Admin admin;

        admin = adminDao.getDao(Admin.class).queryForFirst(queryBuilder.where()
                .eq("LOGIN", login).prepare());
        if (admin != null)
            if (admin.getPassword().equals(password)) return admin;
        return null;
    }
}
