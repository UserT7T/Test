module com.example.aplication2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aplication2 to javafx.fxml;
    exports com.example.aplication2;
}