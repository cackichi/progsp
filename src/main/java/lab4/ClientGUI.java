package lab4;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Objects;

public class ClientGUI extends Application {
    @FXML
    private TextField ipField;
    @FXML
    private TextField portField;
    @FXML
    private TextField sendField;
    @FXML
    private Text answerLabel;
    private Socket socket;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("client.fxml")));
        stage.setTitle("Клиент");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void connect() {
        String ip = ipField.getText();
        int port = Integer.parseInt(portField.getText());

        try {
            socket = new Socket(ip, port);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            answerLabel.setText("Подключено к серверу");
        } catch (IOException e) {
            answerLabel.setText("Ошибка подключения: " + e.getMessage());
        }
    }

    @FXML
    public void send() {
        if (socket != null && !socket.isClosed()) {
            try {
                int numberToSend = Integer.parseInt(sendField.getText());
                objectOutputStream.writeObject(numberToSend);
                objectOutputStream.flush();

                String serverResponse = (String) objectInputStream.readObject();
                answerLabel.setText("Ответ от сервера: " + serverResponse);
            } catch (IOException | ClassNotFoundException e) {
                answerLabel.setText("Ошибка при отправке данных: " + e.getMessage());
            }
        } else {
            answerLabel.setText("Ошибка: Сокет закрыт. Подключитесь заново.");
        }
    }

    @Override
    public void stop() {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
                answerLabel.setText("Соединение закрыто");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
