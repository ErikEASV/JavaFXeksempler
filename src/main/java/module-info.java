module com.example.javafxlabel {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxlabel to javafx.fxml;
    exports com.example.javafxlabel;
}