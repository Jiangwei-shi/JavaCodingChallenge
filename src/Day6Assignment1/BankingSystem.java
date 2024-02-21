package Day6Assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class BankingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example loop for interaction, can be expanded for more functionality
        boolean quit = false;
        BankAccount account = null;
        while (!quit) {
            System.out.println("Choose an action: (1) Create Account (2) Deposit (3) Withdraw (4) Display Account (5) Quit");
            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    System.out.println("what kind of Account do you want? 1. SavingAccount 2.CurrentAccount");
                    int Choice = scanner.nextInt();
                    if(Choice == 1){
                        account = new SavingsAccount("AccountNumber",100,0.05);
                    } else if (Choice == 2) {
                        account = new CurrentAccount("AccountNumber",100,1);
                    }
                    break;
                case 2:
                    System.out.println("How many do you want to deposit?");
                    double depositValue = scanner.nextDouble();
                    account.deposit(depositValue);
                    break;
                case 3:
                    // Add logic to withdraw money
                    System.out.println("How many do you want to withdraw?");
                    double withdrawValue = scanner.nextDouble();
                    account.withdraw(withdrawValue);
                    break;
                case 4:
                        account.displayAccountDetails();
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
        scanner.close();
    }
}
