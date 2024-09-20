package lab4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerGUI {
    public static void main(String[] args) {
        int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println(serverSocket);
            System.out.println("Сервер запущен");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                     ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream())) {

                    System.out.println("Клиент подключен");

                    int num = (int) objectInputStream.readObject();
                    String result;
                    switch (num) {
                        case 0 -> result = "ноль";
                        case 1 -> result = "один";
                        case 2 -> result = "два";
                        case 3 -> result = "три";
                        case 4 -> result = "четыре";
                        case 5 -> result = "пять";
                        case 6 -> result = "шесть";
                        case 7 -> result = "семь";
                        case 8 -> result = "восемь";
                        case 9 -> result = "девять";
                        case 10 -> result = "десять";
                        default -> result = "вводите от 0 до 10";
                    }

                    objectOutputStream.writeObject(result);
                    objectOutputStream.flush();

                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

