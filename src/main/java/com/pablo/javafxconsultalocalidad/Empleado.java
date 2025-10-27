/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pablo.javafxconsultalocalidad;

/**
 *
 * @author pablo
 */
public class Empleado {
    private int id;
    private String apellido;
    private String oficio;

    public Empleado(int id, String apellido, String oficio) {
        setId(id);
        setApellido(apellido);
        setOficio(oficio);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", apellido=" + apellido + ", oficio=" + oficio + '}';
    }
    
}
