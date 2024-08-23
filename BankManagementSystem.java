package bankmanagementsystem;

import java.util.Scanner;

public class BankManagementSystem {

    public static void main(String[] args) {
         Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        Deposit deposit = new Deposit(bank);
        Withdrawal withdrawal = new Withdrawal(bank);

        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Balance Inquiry");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter account type (Savings/Current): ");
                    String accountType = scanner.nextLine();
                    System.out.print("Enter account holder name: ");
                    String accountHolderName = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter CNIC: ");
                    String cnic = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    bank.createAccount(accountType, accountHolderName, initialBalance, cnic, phoneNumber, address);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    int depositAccountNumber = scanner.nextInt();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); 
                    deposit.depositAmount(depositAccountNumber, depositAmount);
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    int withdrawAccountNumber = scanner.nextInt();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();
                    withdrawal.withdrawAmount(withdrawAccountNumber, withdrawAmount);
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    int balanceAccountNumber = scanner.nextInt();
                    scanner.nextLine();
                    Account balanceAccount = bank.getAccount(balanceAccountNumber);
                    if (balanceAccount != null) {
                        balanceAccount.displayBalance();
                    } else {
                        System.out.println("Invalid account number. Cannot display balance.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the banking management system.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
    }
    

