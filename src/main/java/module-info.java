module com.example.morefx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.morefx to javafx.fxml;
    exports com.example.morefx;
}