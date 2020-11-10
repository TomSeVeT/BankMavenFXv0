package pl.SeVeT.bankApp.modelFx.users;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.SeVeT.bankApp.data.dao.AccountDao;
import pl.SeVeT.bankApp.data.dao.ClientDao;
import pl.SeVeT.bankApp.data.dataUtils.DataManager;
import pl.SeVeT.bankApp.data.model.accounts.Account;
import pl.SeVeT.bankApp.data.model.users.Client;
import pl.SeVeT.bankApp.utils.ConverterFx;
import pl.SeVeT.bankApp.utils.Generate;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

public class ClientModel {
    private ObjectProperty<ClientFx> loggedClient = new SimpleObjectProperty<>();
    private ObservableList<ClientFx> clientsList = FXCollections.observableArrayList();
    private ObjectProperty<ClientFx> selectedClient = new SimpleObjectProperty<>();
    private ObjectProperty<ClientFx> choosenClient = new SimpleObjectProperty<>();

    public void init() {
        ClientDao clientDao = new ClientDao(DataManager.getConnectionSourece());
        this.clientsList.clear();
        List<Client> tempClientList = clientDao.allQuery(Client.class);
        tempClientList.forEach(x -> {
            ClientFx clientFx = ConverterFx.clientToFx(x);
            clientsList.add(clientFx);
        });

    }

    public void addClient(String firstName, String lastName, String login, String password,
                          long pesel, LocalDate birthDate, String address, String phoneNumber) {

        Client client = new Client(
                firstName, lastName,
                login, password,
                pesel, birthDate
                , address, phoneNumber);

        Account clientAccount = new Account(client);

        while(!accountNumberUnique(clientAccount.getAccNumber())) {
            clientAccount.setAccNumber(Generate.accNumber());
        }

        client.setAccount(clientAccount);

        AccountDao accountDao = new AccountDao(DataManager.getConnectionSourece());
        accountDao.createOrUpdate(clientAccount);
        ClientDao clientDao = new ClientDao(DataManager.getConnectionSourece());
        clientDao.createOrUpdate(client);
        clientAccount.setClient(client);
        accountDao.createOrUpdate(clientAccount);
        DataManager.closeDatabaseConnection();
    }

    private boolean accountNumberUnique(BigInteger accNumber) {
        for (ClientFx clientFx : clientsList)
            if(clientFx.getAccount().getAccNumber().equals(accNumber)) return false;

        return true;
    }

    public void deleteSelectedClient() {
        ClientDao clientDao = new ClientDao(DataManager.getConnectionSourece());
        AccountDao accountDao = new AccountDao(DataManager.getConnectionSourece());
        accountDao.deleteById(Account.class, selectedClient.getValue().getAccount().getId());
        clientDao.deleteById(Client.class, this.selectedClient.getValue().getId());
        DataManager.closeDatabaseConnection();
    }

    public void update(ClientFx clientFx){
        ClientDao clientDao = new ClientDao(DataManager.getConnectionSourece());
        clientDao.createOrUpdate(ConverterFx.fxToClient(clientFx));
    }


    public ClientFx getLoggedClient() {
        return loggedClient.get();
    }

    public ObjectProperty<ClientFx> loggedClientProperty() {
        return loggedClient;
    }

    public ObservableList<ClientFx> getClientsList() {
        return clientsList;
    }

    public void setClientsList(ObservableList<ClientFx> clientsList) {
        this.clientsList = clientsList;
    }

    public void setLoggedClient(ClientFx loggedClient) {
        this.loggedClient.set(loggedClient);
    }

    public ClientFx getSelectedClient() {
        return selectedClient.get();
    }

    public ObjectProperty<ClientFx> selectedClientProperty() {
        return selectedClient;
    }

    public void setSelectedClient(ClientFx selectedClient) {
        this.selectedClient.set(selectedClient);
    }

    public ClientFx getChoosenClient() {
        return choosenClient.get();
    }

    public ObjectProperty<ClientFx> choosenClientProperty() {
        return choosenClient;
    }

    public void setChoosenClient(ClientFx choosenClient) {
        this.choosenClient.set(choosenClient);
    }



}
