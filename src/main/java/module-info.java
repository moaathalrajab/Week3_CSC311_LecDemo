module org.example.week3_csc311_lecdemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.week3_csc311_lecdemo to javafx.fxml;
    exports org.example.week3_csc311_lecdemo;
}