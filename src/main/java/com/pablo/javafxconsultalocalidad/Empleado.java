/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pablo.javafxconsultalocalidad;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author pablo
 */
public class Empleado {
    private SimpleIntegerProperty id;
    private SimpleStringProperty apellido;
    private SimpleStringProperty oficio;

    public Empleado(int id, String apellido, String oficio) {
        setId(id);
        setApellido(apellido);
        setOficio(oficio);
    }
    public SimpleStringProperty apellidoProperty() {
        return apellido;
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public SimpleStringProperty oficioProperty() {
        return oficio;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public String getApellido() {
        return apellido.get();
    }

    public void setApellido(String apellido) {
        this.apellido = new SimpleStringProperty(apellido);
    }

    public String getOficio() {
        return oficio.get();
    }

    public void setOficio(String oficio) {
        this.oficio = new SimpleStringProperty(oficio);
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", apellido=" + apellido + ", oficio=" + oficio + '}';
    }
    
}
