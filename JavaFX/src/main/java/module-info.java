module com.example.javafx_03 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.javafx_03 to javafx.fxml;
    exports com.example.javafx_03;
}