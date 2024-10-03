package lab7;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    Connection connection;

    public Student getStudentBySurnameAndFaculty(String surname, String faculty){
        Student student = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/lab7", "hotels", "hotels");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student WHERE surname = ? AND faculty = ?");
            preparedStatement.setString(1,surname);
            preparedStatement.setString(2,faculty);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                student = new Student(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("faculty"),
                        rs.getInt("year_of_study"),
                        rs.getLong("group_number"));
            }
            rs.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public ObservableList<Student> getAllStudent(){
        ObservableList<Student> students = FXCollections.observableArrayList();
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/lab7", "hotels", "hotels");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                students.add(new Student(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("faculty"),
                        rs.getInt("year_of_study"),
                        rs.getLong("group_number")));
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection failed");
        }
        return students;
    }

    public long saveStudent(Student student){
        long id = 0;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/lab7", "hotels", "hotels");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student (name, surname, faculty, year_of_study, group_number) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getSurname());
            preparedStatement.setString(3,student.getFaculty());
            preparedStatement.setInt(4,student.getYearOfStudy());
            preparedStatement.setLong(5,student.getGroupNumber());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();

            if (rs.next()){
                id = rs.getLong(1);
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection failed");
        }
        return id;
    }

    public void deleteStudent(long id){
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/lab7", "hotels", "hotels");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM student WHERE id = ?");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection failed");
        }
    }
}
