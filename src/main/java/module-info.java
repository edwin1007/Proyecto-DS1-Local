module pruebalogin.pruebalogin {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.management;


    opens pruebalogin.pruebalogin to javafx.fxml;
    exports pruebalogin.pruebalogin;
    exports controlador;
    opens controlador to javafx.fxml;
}