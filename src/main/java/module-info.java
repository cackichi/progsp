module lab4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens lab4 to javafx.fxml;
    exports lab4;

    opens lab5 to javafx.fxml;
    exports lab5;

    opens lab6 to javafx.fxml;
    exports lab6;
}
