package com.pablo.javafxconsultalocalidad;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController {

    @FXML
    private TableView<Empleado> tabla;
    @FXML
    private TableColumn<Empleado, Integer> colId;
    @FXML
    private TableColumn<Empleado, String> colape;
    @FXML
    private TableColumn<Empleado, String> colofi;
    @FXML
   // private TableColumn<Empleado, Date> colfecha;
    private String localidad;
    @FXML
    private ComboBox box;
    private ArrayList<Empleado> empleados;
    ArrayList<String> localidades;

    @FXML
    private void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colape.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colofi.setCellValueFactory(new PropertyValueFactory<>("oficio"));
        //colfecha.setCellValueFactory(new PropertyValueFactory<>("fecha alta"));
        try {
            localidades = new GetEmpleadosBD().getLocalidades();
        } catch (SQLException ex) {
            System.getLogger(PrimaryController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        box.setItems(FXCollections.observableArrayList(localidades));
    }

    @FXML
    public void listenerBotonLocalidad() {
        localidad = box.getValue().toString();
        try {
            empleados = new GetEmpleadosBD().getEmpleadosLocalidad(localidad);
        } catch (SQLException ex) {
            System.getLogger(PrimaryController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        ObservableList<Empleado> observableEmple = FXCollections.observableArrayList(empleados);
        tabla.setItems(observableEmple);
    }
    
}
