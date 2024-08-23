 
package bankmanagementsystem;

abstract class Account {
    protected int accountNumber;
    protected String accountHolderName;
    protected double balance;
    protected String cnic;
    protected String phoneNumber;
    protected String address;

    public Account(int accountNumber, String accountHolderName, double initialBalance, String cnic, String phoneNumber, String address) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.cnic = cnic;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public abstract void withdraw(double amount);

    public void displayBalance() {
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Balance: " + balance);
        System.out.println("CNIC: " + cnic);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
    }
}

class SavingsAccount extends Account {
    private double minimumBalance;

    public SavingsAccount(int accountNumber, String accountHolderName, double initialBalance, String cnic, String phoneNumber, String address) {
        super(accountNumber, accountHolderName, initialBalance, cnic, phoneNumber, address);
        this.minimumBalance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        if (amount > 0) {
            double interest = amount * 0.01;
            balance += interest;
            System.out.println("Interest credited. New balance: " + balance);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            if (amount > 5000) {
                double serviceCharge = amount * 0.002;
                balance -= amount + serviceCharge;
                System.out.println("Withdrawal successful. Service charge deducted: " + serviceCharge);
            } else {
                balance -= amount;
                System.out.println("Withdrawal successful.");
            }

            if (amount > 50000) {
                double tax = amount * 0.025;
                balance -= tax;
                System.out.println("Tax deducted: " + tax);
            }

            double interestTax = balance * 0.005;
            balance -= interestTax;
            System.out.println("Interest tax deducted: " + interestTax);
            System.out.println("New balance: " + balance);
        } else {
            System.out.println("Insufficient funds. Withdrawal canceled.");
        }
    }
}

class CurrentAccount extends Account {
    public CurrentAccount(int accountNumber, String accountHolderName, double initialBalance, String cnic, String phoneNumber, String address) {
        super(accountNumber, accountHolderName, initialBalance, cnic, phoneNumber, address);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            if (amount > 5000) {
                double serviceCharge = amount * 0.002;
                balance -= amount + serviceCharge;
                System.out.println("Withdrawal successful. Service charge deducted: " + serviceCharge);
            } else {
                balance -= amount;
                System.out.println("Withdrawal successful.");
            }

            System.out.println("New balance: " + balance);
        } else {
            System.out.println("Insufficient funds. Withdrawal canceled.");
        }
    }
}
