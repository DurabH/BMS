package bankmanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Bank {
private List<Account> accounts;
    private int accountCounter;

    public Bank() {
        accounts = new ArrayList<>();
        accountCounter = 1;
    }

    public void createAccount(String accountType, String accountHolderName, double initialBalance, String cnic, String phoneNumber, String address) {
        Account account;
        if (accountType.equalsIgnoreCase("savings")) {
            account = new SavingsAccount(accountCounter, accountHolderName, initialBalance, cnic, phoneNumber, address);
        } else if (accountType.equalsIgnoreCase("current")) {
            account = new CurrentAccount(accountCounter, accountHolderName, initialBalance, cnic, phoneNumber, address);
        } else {
            System.out.println("Invalid account type. Account creation failed.");
            return;
        }

        accounts.add(account);
        System.out.println("Account created successfully. Account number: " + accountCounter);
        accountCounter++;
    }

    public Account getAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }    
}
