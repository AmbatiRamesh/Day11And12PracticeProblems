package com.bridgelabz.object;
import java.util.Scanner;
class Bank {
    private String accountno;
    private String name;
    private long balance;
    Scanner scanner = new Scanner(System.in);
    void openAccount() {
        System.out.print("Enter Account No: ");
        accountno = scanner.next();
        System.out.print("Enter Name: ");
        name = scanner.next();
        System.out.print("Enter Balance: ");
        balance = scanner.nextLong();
    }
    void showAccount() {
        System.out.println(accountno + "," + name + ","+ balance);
    }
    void deposit() {
        long amount;
        System.out.println("Enter Amount You Want to Deposit : ");
        amount = scanner.nextLong();
        balance = balance + amount;
    }
    void withdrawal() {
        long amount;
        System.out.println("Enter Amount You Want to withdraw : ");
        amount = scanner.nextLong();
        if (balance >= amount) {
            balance = balance - amount;
        } else {
            System.out.println("Less Balance..Transaction Failed..");
        }
    }
    boolean search(String account) {
        if (accountno.equals(account)) {
            showAccount();
            return (true);
        }
        return (false);
    }
}
public class BankAmountWithdraw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How Many Customer You Want to Input : ");
        int n = scanner.nextInt();
        Bank[] bank1 = new Bank[n];
        for (int i = 0; i < bank1.length; i++) {
            bank1[i] = new Bank();
            bank1[i].openAccount();
        }
        int ch;
        do {
            System.out.println("Main Menu1. Display All 2. Search By Account 3. Deposit4. Withdrawal 5.Exit ");
            System.out.println("Ur Choice :");
            ch = scanner.nextInt();
            switch (ch) {
                case 1:
                    for (Bank bank : bank1) {
                        bank.showAccount();
                    }
                    break;
                case 2:
                    System.out.print("Enter Account No. You Want to Search...: ");
                    String account = scanner.next();
                    boolean found = false;
                    for (Bank bank : bank1) {
                        found = bank.search(account);
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search Failed..Account Not Exist..");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account No : ");
                    account = scanner.next();
                    found = false;
                    for (Bank bank : bank1) {
                        found = bank.search(account);
                        if (found) {
                            bank.deposit();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search Failed..Account Not Exist..");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account No : ");
                    account = scanner.next();
                    found = false;
                    for (Bank bank : bank1) {
                        found = bank.search(account);
                        if (found) {
                            bank.withdrawal();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search Failed..Account Not Exist..");
                    }
                    break;
                case 5:
                    System.out.println("Good Bye..");
                    break;
            }

        }
        while(ch != 5);
        }
    }