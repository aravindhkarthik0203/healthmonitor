module com.ak.healthmonitor {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.ak.healthmonitor to javafx.fxml;
    exports com.ak.healthmonitor;
}