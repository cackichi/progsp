package lab4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientTCP {
    public static void main(String[] args) {
        String addr = "localhost";
        int port = 8080;

        try(Socket socket = new Socket(addr,port)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Введите 'q' для выхода или любое другое значение для продолжения:");
                if (scanner.nextLine().equalsIgnoreCase("q")) {
                    System.out.println("Клиент завершает работу.");
                    socket.close();
                    break;
                }
                System.out.println("Количество строк:");
                int rows = scanner.nextInt();
                System.out.println("Количество столбцов:");
                int col = scanner.nextInt();

                int[][] matrix = new int[rows][col];

                System.out.println("Введите элементы");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < col; j++) {
                        matrix[i][j] = scanner.nextInt();
                    }
                }

                scanner.nextLine();

                objectOutputStream.writeObject(matrix);
                objectOutputStream.flush();

                int[] result = (int[]) objectInputStream.readObject();
                int rowMin = result[0];
                int colMax = result[1];

                System.out.println("Строка с минимальным элементом - " + (rowMin + 1));
                System.out.println("Столбец с максимальным элементом - " + (colMax + 1));
            }


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
