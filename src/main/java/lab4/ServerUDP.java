package lab4;

import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class ServerUDP {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(8080)) {
            byte[] receiveBuffer = new byte[1024];
            System.out.println("Сервер запущен и ожидает данных...");

            while (true) {
                DatagramPacket datagramPacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(datagramPacket);

                String receiveData = new String(datagramPacket.getData(), 0, datagramPacket.getLength(),
                        StandardCharsets.UTF_8);
                System.out.println("Получены параметры: " + receiveData);

                String[] splitData = receiveData.split(",");
                double x = Double.parseDouble(splitData[0]);
                double y = Double.parseDouble(splitData[1]);
                double z = Double.parseDouble(splitData[2]);

                double result = calc(x,y,z);

                saveFile(x,y,z,result);

                String resultStr =  "Результат - " + result;
                byte[] buff = resultStr.getBytes(StandardCharsets.UTF_8);
                InetAddress inetAddress = datagramPacket.getAddress();
                int inetPort = datagramPacket.getPort();
                DatagramPacket send = new DatagramPacket(buff,buff.length,inetAddress,inetPort);
                socket.send(send);
            }

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void saveFile(double x, double y, double z, double result) {
        try(FileWriter fileWriter = new FileWriter("src/main/java/lab4/lab.txt")){
            fileWriter.write("x = " + x + ",y = " + y + ", z = " + z + ", result = " + result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static double calc(double x, double y, double z){
        double inLogPart = Math.sqrt(Math.exp(x - y) + Math.pow(Math.abs(x),y) + z);
        double logPart = Math.log10(inLogPart);
        double rightSide = x - x*x*x/3 - x*x*x*x*x*x*x/7;

        return logPart * rightSide;
    }
}
