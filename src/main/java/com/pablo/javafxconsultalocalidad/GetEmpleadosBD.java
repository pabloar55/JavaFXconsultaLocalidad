/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pablo.javafxconsultalocalidad;

/**
 *
 * @author pablo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
public class GetEmpleadosBD {
    private final String URL = "jdbc:mysql://localhost:3306/bd_departamento";
    private Connection conexion;
    public GetEmpleadosBD() throws SQLException {
        this.conexion = getConexion();
    }
    
    public Connection getConexion() throws SQLException{
        return DriverManager.getConnection(URL, "root", "");
    }
    public ArrayList<Empleado> getEmpleadosLocalidad(String localidad) throws SQLException{
        String sql = "select e.id, e.apellido, e.oficio from empleados e join "
                + "departamentos d on e.dept_no=d.id where d.loc=?";
        PreparedStatement pstmt = conexion.prepareStatement(sql);
        pstmt.setString(1, localidad);
        pstmt.execute();
        ResultSet rs = pstmt.getResultSet();
        ArrayList<Empleado> empleados = new ArrayList<>();
        while (rs.next()){
            Empleado e = new Empleado(rs.getInt(1), 
                    rs.getString(2), rs.getString(3));
            empleados.add(e);           
        }
        return empleados;
    } 
}
