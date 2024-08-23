package bankmanagementsystem;

public class Deposit {
    private Bank bank;

    public Deposit(Bank bank) {
        this.bank = bank;
    }

    

    public void depositAmount(int accountNumber, double amount) {
        Account depositAccount = bank.getAccount(accountNumber);
        if (depositAccount != null) {
            depositAccount.deposit(amount);
        } else {
            System.out.println("Invalid account number. Deposit canceled.");
        }
    }
}
