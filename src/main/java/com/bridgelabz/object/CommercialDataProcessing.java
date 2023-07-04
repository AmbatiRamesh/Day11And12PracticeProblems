package com.bridgelabz.object;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
    public class CommercialDataProcessing {
        static String name;
        static String name2;
        private static double stockPrice;
        private static double NumOfShares;
        static double balance = 5000;
        private static double totalBalance;
        static double totalValue;
        static long numberOfShareBuy;
        static Scanner scanner = new Scanner(System.in);
        static ArrayList<String> stock = new ArrayList<>();
        static ArrayList<Double> sharePrice = new ArrayList<>();
        static ArrayList<Double> numberOfShares = new ArrayList<>();
        static ArrayList<String> list1 = new ArrayList<>();
        static ArrayList<String> list2 = new ArrayList<>();
        static ArrayList<String> list3 = new ArrayList<>();
        public static String getName() {
            return name;
        }
        public static void setName(String name) {
            CommercialDataProcessing.name = name;
        }
        public static double getStockPrice() {
            return stockPrice;
        }
        public static void setStockPrice(double stockPrice) {
            CommercialDataProcessing.stockPrice = stockPrice;
        }
        public static double getNumOfShares() {
            return NumOfShares;
        }
        public static void setNumOfShares(double numberOfShares) {
            NumOfShares = numberOfShares;
        }
        public static void stockDetails() {
            System.out.println("Enter the stock name : ");
            name = scanner.next();
            stock.add(name);
            System.out.println("Enter the share price of one stock : ");
            stockPrice = scanner.nextDouble();
            sharePrice.add(stockPrice);
            System.out.println("Enter the stocks to buy that we want : ");
            NumOfShares = scanner.nextDouble();
            numberOfShares.add(NumOfShares);
        }
        public static void TotalValue() {
            System.out.println("Enter the number of stocks : ");
            int stock1 = scanner.nextInt();
            for (int i = 0; i < stock1; i++) {
                stockDetails();
                totalValue = numberOfShares.get(i) * 1 * sharePrice.get(i);
                System.out.println("Name of the stock :" + stock.get(i));
                System.out.println("The stock value: " + totalValue + "\n\n");
            }
        }
        public void newaccount() {
            System.out.println("Enter person name: ");
            name2 = scanner.next();
            list1.add(name2);
        }
        public void display() {
            System.out.println("Name of account holder:" + name2);
            System.out.println("current balance: " + balance);
        }
        public void buyandsell() {
            System.out.println("Select the stock below : \n" + stock.get(0) + "one share value is:" +
                    sharePrice.get(0) + "\n" + sharePrice.get(1) + "one share value is :" + sharePrice.get(1));
            String stockName1 = scanner.next();
            for (int i = 0; i < stock.size(); i++) {
                if (stockName1.equals(stock.get(i))) {
                    System.out.println("Enter the share u want to buy: ");
                    long numberofShareBuy = scanner.nextLong();
                    totalBalance = numberofShareBuy * (1 * sharePrice.get(i));
                    System.out.println("would you like to (buy =1) 1 or 2 (sell =2) ?");
                    int option = scanner.nextInt();
                    if (option == 1) {
                        if (balance >= totalBalance) {
                            balance = balance + totalBalance;
                            list3.add(stock.get(i));
                            System.out.println("you have but " + stock.get(i) + "stock");
                        } else {
                            System.out.println("\n" + name + "you can not buy share : " + totalBalance);
                            System.out.println("your balance is: " + balance);
                        }
                    } else if (option == 2) {
                        balance = balance + totalBalance;
                        System.out.println("you have selled " + stock.get(i) + "+stock");
                    } else
                        System.out.println("you can't buy or sell any stock");
                }
            }
        }
        public void addMultipleDematAccount() {
            System.out.println("how many accounts to add : ");
            long count = scanner.nextLong();
            for (long i = 0; i < count; i++) {
                newaccount();
                buyandsell();
                list2.add(String.valueOf(balance));
                display();
                System.out.println("\n");
                balance = 5000;
            }
        }
        public static void main(String[] args) {
            CommercialDataProcessing stock = new CommercialDataProcessing();
            stock.TotalValue();
            stock.newaccount();
            stock.buyandsell();
            stock.addMultipleDematAccount();
            stock.buyandsell();
            stock.display();
        }
}
