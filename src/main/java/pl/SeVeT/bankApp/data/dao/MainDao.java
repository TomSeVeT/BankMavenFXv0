package pl.SeVeT.bankApp.data.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import pl.SeVeT.bankApp.data.dataUtils.DataManager;
import pl.SeVeT.bankApp.data.model.BaseModel;
import pl.SeVeT.bankApp.utils.Dialogs;

import java.sql.SQLException;
import java.util.List;

public abstract class MainDao {
    protected final ConnectionSource connectionSource;

    public MainDao(ConnectionSource connectionSource) { this.connectionSource = connectionSource; }

    public <T extends BaseModel, U> void createOrUpdate(BaseModel baseModel){
        Dao<T,U> dao = getDao((Class<T>)baseModel.getClass());
        try {
            dao.createOrUpdate((T)baseModel);
        } catch (SQLException e) {
            Dialogs.errorDialog(e.getMessage());
        }
    }

    public <T extends BaseModel, U> void refresh(BaseModel baseModel){
        Dao<T,U> dao = getDao((Class<T>)baseModel.getClass());
        try {
            dao.refresh((T)baseModel);
        } catch (SQLException e) {
            Dialogs.errorDialog(e.getMessage());
        }
    }

    public <T extends BaseModel, U> void delete(BaseModel baseModel){
        Dao<T,U> dao = getDao((Class<T>)baseModel.getClass());
        try {
            dao.delete((T)baseModel);
        } catch (SQLException e) {
            Dialogs.errorDialog(e.getMessage());
        }finally {
            DataManager.closeDatabaseConnection();
        }
    }

    public <T extends BaseModel, U> void deleteById(Class<T> klasa, Integer id){
        Dao<T,U> dao = getDao(klasa);
        try {
            dao.deleteById((U)id);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DataManager.closeDatabaseConnection();
        }
    }

    public <T extends BaseModel, U> List<T> allQuery(Class<T> klasa){
        Dao<T,U> dao = getDao(klasa);
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            Dialogs.errorDialog(e.getMessage());
        }
        return null;
    }


    public <T extends BaseModel,U> Dao<T,U> getDao(Class<T> klasa){
        try {
            return DaoManager.createDao(connectionSource, klasa);
        } catch (SQLException e) {
            Dialogs.errorDialog(e.getMessage());
        }
        return null;
    }

    public <T extends BaseModel,U> QueryBuilder<T,U> getQueryBuilder(Class<T> klasa){
        Dao<T,U> dao = getDao(klasa);
        return dao.queryBuilder();
    }

    public <T extends BaseModel, U> T findById(Class<T> klasa, Integer id){
        Dao<T,U> dao = getDao(klasa);
        try {
            return dao.queryForId((U)id);
        } catch (SQLException e) {
            Dialogs.errorDialog(e.getMessage());
        }
        return null;
    }


}
