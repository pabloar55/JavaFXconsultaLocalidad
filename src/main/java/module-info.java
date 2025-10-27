module com.pablo.javafxconsultalocalidad {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens com.pablo.javafxconsultalocalidad to javafx.fxml;
    exports com.pablo.javafxconsultalocalidad;
}
