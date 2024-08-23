package bankmanagementsystem;


public class Withdrawal {
    private Bank bank;

    public Withdrawal(Bank bank) {
        this.bank = bank;
    }

    
    public void withdrawAmount(int accountNumber, double amount) {
        Account withdrawAccount = bank.getAccount(accountNumber);
        if (withdrawAccount != null) {
            withdrawAccount.withdraw(amount);
        } else {
            System.out.println("Invalid account number. Withdrawal canceled.");
        }
    }
}
