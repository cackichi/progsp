package lab2.second_part;

import java.util.Scanner;

public class Client {
    private String name;
    private double balance;

    public void addBalance(Scanner scanner){
        System.out.println("Введите сумму для пополнения");
        balance += scanner.nextInt();
        System.out.println("Cчет успешно пополнен");
    }

    public void showBalance(){
        System.out.println("Ваш баланс - " + balance);
    }

    public Client(String name, double balance) {
        this.name = name;
        this.balance = balance;
        System.out.println("Добро пожаловать " + name + "\n" +
                "Ваш баланс - " + balance);
    }

    public Client() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
