package com.pablo.javafxconsultalocalidad;

import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PrimaryController {
    @FXML
    private TableView<Empleado> tabla;
    @FXML
    private TableColumn<Empleado, Integer> colId;
    private String localidad;
    @FXML
    private TextField textoLoc;
    private ArrayList<Empleado> empleados;
    @FXML
    private void initialize(){
        
    }
    @FXML
    public void listenerBotonLocalidad(){
        try {
            localidad = textoLoc.getText();
            System.out.println(localidad);
            empleados= new GetEmpleadosBD().getEmpleadosLocalidad(localidad);
            ObservableList<Empleado> observableEmple = FXCollections.observableArrayList(empleados);
            tabla.setItems(observableEmple);
            System.out.println(empleados.toString());
        } catch (SQLException ex) {
            System.getLogger(PrimaryController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    private void mostrarEmpleados(){
    } 
}
