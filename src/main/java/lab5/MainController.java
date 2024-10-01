package lab5;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainController extends Application {
    @FXML
    private ListView<String> lastNameListView;
    @FXML
    private ListView<String> firstNameListView;
    @FXML
    private ListView<String> middleNameListView;
    @FXML
    private TextField inputField;
    @FXML
    private Button addButton;
    @FXML
    private Button sortButton;
    @FXML
    private CheckBox selectLastNameCheckBox;
    @FXML
    private CheckBox selectMiddleNameCheckBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lab5/main.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Управление списками");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void initialize(){
        addButton.setOnAction(event -> handleAdd(inputField));
        sortButton.setOnAction(event -> handleShowSorted(selectLastNameCheckBox.isSelected(), selectMiddleNameCheckBox.isSelected()));
    }

    @FXML
    private void handleAdd(TextField inputField) {
        String input = inputField.getText().trim();
        if (input.isEmpty()) {
            showAlert("Ошибка", "Поле ввода пустое. Введите 'Фамилия Имя Отчество'.");
            return;
        }

        String[] parts = input.split(" ");
        if (parts.length != 3) {
            showAlert("Ошибка", "Введите корректно: 'Фамилия Имя Отчество'.");
            return;
        }

        lastNameListView.getItems().add(parts[0]);
        firstNameListView.getItems().add(parts[1]);
        middleNameListView.getItems().add(parts[2]);

        inputField.clear();
    }

    @FXML
    private void handleShowSorted(boolean selectLastName, boolean selectMiddleName) {
        List<String> selectedItems = new ArrayList<>();

        if (selectLastName) {
            selectedItems.addAll(lastNameListView.getItems());
        }

        if (selectMiddleName) {
            selectedItems.addAll(middleNameListView.getItems());
        }

        if (selectedItems.isEmpty()) {
            showAlert("Ошибка", "Не выбраны флажки для сортировки.");
            return;
        }

        Collections.sort(selectedItems);
        showSortedDialog(selectedItems);
    }

    private void showSortedDialog(List<String> sortedItems) {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Отсортированные значения");

        ButtonType okButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(okButtonType);

        ListView<String> listView = new ListView<>();
        listView.getItems().addAll(sortedItems);
        dialog.getDialogPane().setContent(listView);

        dialog.showAndWait();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
