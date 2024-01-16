module LMSA {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    requires mysql.connector.java;
    requires org.xerial.sqlitejdbc;
    requires java.sql;
    opens org.example;
}