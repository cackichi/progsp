package lab4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ClientUDP {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket();
             Scanner scanner = new Scanner(System.in)) {

            InetAddress serverAddress = InetAddress.getByName("localhost");

            System.out.print("Введите x: ");
            double x = scanner.nextDouble();
            System.out.print("Введите y: ");
            double y = scanner.nextDouble();
            System.out.print("Введите z: ");
            double z = scanner.nextDouble();

            String data = x + "," + y + "," + z;
            byte[] sendBuffer = data.getBytes(StandardCharsets.UTF_8);

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, 8080);
            socket.send(sendPacket);

            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            socket.receive(receivePacket);

            String result = new String(receivePacket.getData(), 0, receivePacket.getLength(), StandardCharsets.UTF_8);
            System.out.println("Ответ сервера: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
