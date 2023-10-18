import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("$" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("$" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public double checkBalance() {
        return balance;
    }
}

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double initialBalance = 1000.0;  // Initial balance
        BankAccount account = new BankAccount(initialBalance);

        System.out.println("Welcome to the ATM!");

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Quit");

            System.out.print("Please select an option (1/2/3/4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance is: $" + account.checkBalance());
                    break;

                case 2:
                    System.out.print("Enter the amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter the amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Have a nice day!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }
        }
    }
}
