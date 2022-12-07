package com.banking;
import java.util.Scanner;

public class Account {
    String customerName;
    String customerId;
    int balance;
    int previousTransaction;

    //constructor
    Account(String cName, String cId) {
        customerName = cName;
        customerId = cId;
    }
    //methods

    public void deposit(int amount) {
        if(amount<=0) {
            System.out.println("Jumlah tidak valid. Masukkan jumlah yang valid.");
            return;
        }
        else {
            balance+=amount;
            previousTransaction=amount;
        }
    }

    public void withdraw(int amount) {
        if(amount<=0) {
            System.out.println("Jumlah tidak valid. Masukkan jumlah yang valid.");
            return;
        }
        else if(amount>balance) {
            System.out.println("\n" + "Anda tidak memiliki saldo yang cukup di akun Anda.");
            return;
        }
        else {
            balance-=amount;
            previousTransaction=-amount;
        }
    }

    /**
     * This method displays the remaining balance
     */
    public void checkBalance() {
        System.out.println("-------------------");
        System.out.println("Saldo = "+balance);
        System.out.println("-------------------");
    }

    /**
     * This method just shows the last transaction report
     */
    public void showPreviousTransaction() {
        if(previousTransaction<0) {
            System.out.println("Jumlah Penarikan : "+Math.abs(previousTransaction));

        }
        else if(previousTransaction>0){
            System.out.println("Jumlah Setoran : "+previousTransaction);
        }
        else {
            System.out.println("Tidak ada transaksi yang ditemukan!");
        }
    }
    /**
     * This method displays all the options to choose
     */
    public void showMenu() {
        System.out.println("Hi "+customerName + ", Selamat datang di online banking");
        System.out.println("ID : "+customerId);
        System.out.println();
        int option=0;

        do {
            System.out.println("==============================================.");
            System.out.println("Pilih Opsi.");
            System.out.println("1 - Cek Saldo");
            System.out.println("2 - Setoran");
            System.out.println("3 - Penarikan");
            System.out.println("4 - Cek Transaksi sebelumnya");
            System.out.println("5 - Keluar");
            System.out.println("==============================================.");


            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();

            switch(option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.println("\n" + "Masukkan jumlah yang akan disetorkan.");
                    int amount = sc.nextInt();
                    deposit(amount);
                    break;
                case 3:
                    System.out.println("\n" + "Masukkan jumlah yang akan ditarik.");
                    amount = sc.nextInt();
                    withdraw(amount);
                    break;
                case 4:
                    showPreviousTransaction();
                    break;
                case 5:
                    System.out.println("Keluar aplikasi..");
                    break;
                default:
                    System.out.println("Opsi tidak valid. Masukkan opsi yang valid.");
            }
        }while(option!=5);

        System.out.println("\n" + "Terima kasih telah menggunakan layanan kami!");

    }



}