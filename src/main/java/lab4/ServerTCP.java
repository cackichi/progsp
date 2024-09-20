package lab4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    public static void main(String[] args) {
        int port = 8080;

        try(ServerSocket socket = new ServerSocket(port)){
            System.out.println("Сервер запущен");

            while (true) {
                try (Socket clientSocket = socket.accept();
                     ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
                     ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream())){
                    System.out.println("Клиент подключен");

                    while (true) {
                        try {
                            int[][] matrix = (int[][]) objectInputStream.readObject();
                            int[] result = findMinRowMaxCol(matrix);

                            objectOutputStream.writeObject(result);
                            objectOutputStream.flush();
                        } catch (ClassNotFoundException e) {
                            System.err.println("Ошибка при чтении объекта с клиента: " + e.getMessage());
                        } catch (IOException e) {
                            System.out.println("Соединение с клиентом закрыто.");
                            break;
                        }
                    }

                }
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int[] findMinRowMaxCol(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int rowInd = -1;
        int colInd = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                    rowInd = i;
                }
                if(matrix[i][j] > max){
                    max = matrix[i][j];
                    colInd = j;
                }
            }
        }
        return new int[]{rowInd,colInd};
    }
}
