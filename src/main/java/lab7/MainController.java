package lab7;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.awt.*;

public class MainController extends Application {
    DatabaseConnection databaseConnection = new DatabaseConnection();
    @FXML
    private TextField nameField, surnameField, facultyField, yearOfStudyField, groupNumberField, surnameSearchField, facultySearchField;
    @FXML
    private TableView<Student> studentsTable, searchTable;
    private ObservableList<Student> students = FXCollections.observableArrayList();
    private ObservableList<Student> searches = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Student, Long> idStudentColumn, groupNumberStudentColumn,idSearchColumn, groupNumberSearchColumn;
    @FXML
    private TableColumn<Student, Integer> yearOfStudyStudentColumn, yearOfStudySearchColumn;
    @FXML
    private TableColumn<Student, String> nameStudentColumn, surnameStudentColumn, facultyStudentColumn, nameSearchColumn, surnameSearchColumn, facultySearchColumn;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lab7/students.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Университет");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void initialize(){
        idSearchColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameSearchColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameSearchColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        yearOfStudySearchColumn.setCellValueFactory(new PropertyValueFactory<>("yearOfStudy"));
        facultySearchColumn.setCellValueFactory(new PropertyValueFactory<>("faculty"));
        groupNumberSearchColumn.setCellValueFactory(new PropertyValueFactory<>("groupNumber"));

        idStudentColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameStudentColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameStudentColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        yearOfStudyStudentColumn.setCellValueFactory(new PropertyValueFactory<>("yearOfStudy"));
        facultyStudentColumn.setCellValueFactory(new PropertyValueFactory<>("faculty"));
        groupNumberStudentColumn.setCellValueFactory(new PropertyValueFactory<>("groupNumber"));

        students = databaseConnection.getAllStudent();
        studentsTable.setItems(students);
    }

    @FXML
    void delete(){
        if(studentsTable.getSelectionModel().isEmpty()){
            Alert noSelect = new Alert(Alert.AlertType.WARNING);
            noSelect.setHeaderText("Пустой выбор");
            noSelect.setTitle("Предупреждение");
            noSelect.setContentText("Вы ничего не выбрали для удаления");
            noSelect.showAndWait();
        } else {
            Student student = studentsTable.getSelectionModel().getSelectedItem();
            databaseConnection.deleteStudent(student.getId());
            students.removeAll(student);
            studentsTable.setItems(students);
        }
    }

    @FXML
    void save(){
        Student student = new Student();
        student.setName(nameField.getText());
        student.setSurname(surnameField.getText());
        student.setFaculty(facultyField.getText());
        student.setGroupNumber(Long.parseLong(groupNumberField.getText()));
        student.setYearOfStudy(Integer.parseInt(yearOfStudyField.getText()));


        nameField.clear();
        surnameField.clear();
        facultyField.clear();
        groupNumberField.clear();
        yearOfStudyField.clear();


        student.setId(databaseConnection.saveStudent(student));
        students.add(student);
        studentsTable.setItems(students);
    }

    @FXML
    void search(){
        searches.clear();
        Student student = databaseConnection.getStudentBySurnameAndFaculty(surnameSearchField.getText(), facultySearchField.getText());
        if(student == null) {
            Alert emptySearch = new Alert(Alert.AlertType.INFORMATION);
            emptySearch.setContentText("Поиск не дал результата");
            emptySearch.showAndWait();
        } else {
            searches.add(student);
        }
        searchTable.setItems(searches);
    }
}
