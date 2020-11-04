package pl.SeVeT.bankApp.utils;

import pl.SeVeT.bankApp.data.model.accounts.Account;
import pl.SeVeT.bankApp.data.model.operations.MoneyTransfer;
import pl.SeVeT.bankApp.data.model.users.Admin;
import pl.SeVeT.bankApp.data.model.users.Client;
import pl.SeVeT.bankApp.modelFx.accounts.AccountFx;
import pl.SeVeT.bankApp.modelFx.operations.MoneyTransferFx;
import pl.SeVeT.bankApp.modelFx.users.AdminFx;
import pl.SeVeT.bankApp.modelFx.users.ClientFx;

public class ConverterFx {

    public static ClientFx clientToFx(Client client){
        ClientFx clientFx = new ClientFx();
        clientFx.setId(client.getId());
        clientFx.setFirstName(client.getFirstName());
        clientFx.setLastName(client.getLastName());
        clientFx.setLogin(client.getLogin());
        clientFx.setPassword(client.getPassword());
        clientFx.setPesel(client.getPesel());
        clientFx.setBirthDate(client.getBirthDate());
        clientFx.setAddress(client.getAddress());
        clientFx.setPhoneNumber(client.getPhoneNumber());
        clientFx.setAccount(ConverterFx.accountToFx(client.getAccount()));
        return clientFx;
    }


    public static Client fxToClient(ClientFx clientFx){
        Client client = new Client();
        client.setId(clientFx.getId());
        client.setFirstName(clientFx.getFirstName());
        client.setLastName(clientFx.getLastName());
        client.setLogin(clientFx.getLogin());
        client.setPassword(clientFx.getPassword());
        client.setPesel(clientFx.getPesel());
        client.setBirthDate(clientFx.getBirthDate());
        client.setAddress(clientFx.getAddress());
        client.setPhoneNumber(clientFx.getPhoneNumber());
        client.setAccount(ConverterFx.fxToAccount(clientFx.getAccount()));
        return client;
    }

    public static AccountFx accountToFx(Account account) {
        AccountFx accountFx = new AccountFx();
        accountFx.setId(account.getId());
        accountFx.setAccNumber(account.getAccNumber());
        accountFx.setBalance(account.getBalance());
        accountFx.setCreationDate(account.getCreationDate());
        accountFx.setLastLoginDate(account.getLastLoginDate());
        return accountFx;
    }

    public static Account fxToAccount(AccountFx accountFx) {
        Account account = new Account();
        account.setId(accountFx.getId());
        account.setAccNumber(accountFx.getAccNumber());
        account.setBalance(accountFx.getBalance());
        account.setCreationDate(accountFx.getCreationDate());
        account.setLastLoginDate(accountFx.getLastLoginDate());
        return account;
    }

    public static MoneyTransferFx moneyTransferToFx(MoneyTransfer moneyTransfer) {
        MoneyTransferFx moneyTransferFx = new MoneyTransferFx();
            moneyTransferFx.setId(moneyTransfer.getId());
            moneyTransferFx.setAmount(moneyTransfer.getAmount());
            moneyTransferFx.setReciverName(moneyTransfer.getReciverName());
            moneyTransferFx.setReciverNumber(moneyTransfer.getReciverNumber());
            moneyTransferFx.setTimeStamp(moneyTransfer.getTimeStamp());
            moneyTransferFx.setTitle(moneyTransfer.getTitle());
        return moneyTransferFx;
    }

    public static AdminFx adminToFx(Admin admin){
        AdminFx adminFx = new AdminFx();
        adminFx.setId(admin.getId());
        adminFx.setLogin(admin.getLogin());
        adminFx.setPassword(admin.getPassword());
        adminFx.setName(admin.getFirstName());
        adminFx.setLastName(admin.getLastName());
        return adminFx;
    }

    public static Admin fxToAdmin(AdminFx adminFx){
        Admin admin = new Admin();
        admin.setId(adminFx.getId());
        admin.setLogin(adminFx.getLogin());
        admin.setPassword(adminFx.getPassword());
        admin.setFirstName(adminFx.getName());
        admin.setLastName(adminFx.getLastName());
        return admin;
    }
}
