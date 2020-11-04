package pl.SeVeT.bankApp.modelFx.users;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.SeVeT.bankApp.data.dao.AdminDao;
import pl.SeVeT.bankApp.data.dataUtils.DataManager;
import pl.SeVeT.bankApp.data.model.users.Admin;
import pl.SeVeT.bankApp.utils.ConverterFx;

import java.util.List;

public class AdminModel {
    private ObjectProperty<AdminFx> loggedAdmin = new SimpleObjectProperty<>();
    private ObservableList<AdminFx> adminsList = FXCollections.observableArrayList();
    private ObjectProperty<AdminFx> selectedAdmin = new SimpleObjectProperty<>();
    private ObjectProperty<AdminFx> chosenAdmin = new SimpleObjectProperty<>();

    public void init(){
        AdminDao adminDao = new AdminDao(DataManager.getConnectionSourece());
        this.adminsList.clear();
        List<Admin> tempAdminList = adminDao.allQuery(Admin.class);
        tempAdminList.forEach(x->{
            AdminFx adminFx = ConverterFx.adminToFx(x);
            adminsList.add(adminFx);
        });
    }

    public void addAdmin(String name, String lastName, String login, String password) {
        Admin admin = new Admin(name, lastName, login, password);
        AdminDao adminDao = new AdminDao(DataManager.getConnectionSourece());
        adminDao.createOrUpdate(admin);
        DataManager.closeDatabaseConnection();
    }

    public void deleteSelectedAdmin() {
        AdminDao adminDao = new AdminDao(DataManager.getConnectionSourece());
        adminDao.deleteById(Admin.class, getSelectedAdmin().getId());
        DataManager.closeDatabaseConnection();
    }

    public void editChoosen() {
        AdminDao adminDao = new AdminDao(DataManager.getConnectionSourece());
        adminDao.createOrUpdate(ConverterFx.fxToAdmin(chosenAdmin.getValue()));
        DataManager.closeDatabaseConnection();
    }

        public static void addSeVeT(){
        AdminDao adminDao = new AdminDao(DataManager.getConnectionSourece());
        adminDao.createOrUpdate(new Admin("Tomasz","Sipel","SeVeT","sevet"));
    }

    public AdminFx getLoggedAdmin() {
        return loggedAdmin.get();
    }

    public ObjectProperty<AdminFx> loggedAdminProperty() {
        return loggedAdmin;
    }

    public void setLoggedAdmin(AdminFx loggedAdmin) {
        this.loggedAdmin.set(loggedAdmin);
    }

    public ObservableList<AdminFx> getAdminsList() {
        return adminsList;
    }

    public void setAdminsList(ObservableList<AdminFx> adminsList) {
        this.adminsList = adminsList;
    }

    public AdminFx getSelectedAdmin() {
        return selectedAdmin.get();
    }

    public ObjectProperty<AdminFx> selectedAdminProperty() {
        return selectedAdmin;
    }

    public void setSelectedAdmin(AdminFx selectedAdmin) {
        this.selectedAdmin.set(selectedAdmin);
    }

    public AdminFx getChosenAdmin() {
        return chosenAdmin.get();
    }

    public ObjectProperty<AdminFx> chosenAdminProperty() {
        return chosenAdmin;
    }

    public void setChosenAdmin(AdminFx chosenAdmin) {
        this.chosenAdmin.set(chosenAdmin);
    }


}
