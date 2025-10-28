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
import java.sql.Statement;
import java.util.ArrayList;
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
        String sql = "select e.id, e.apellido, e.oficio, e.fecha_alta from empleados e join "
                + "departamentos d on e.dept_no=d.id where d.loc=?";
        PreparedStatement pstmt = conexion.prepareStatement(sql);
        pstmt.setString(1, localidad);
        pstmt.execute();
        ResultSet rs = pstmt.getResultSet();
        ArrayList<Empleado> empleados = new ArrayList<>();
        while (rs.next()){
            Empleado e = new Empleado(rs.getInt(1), 
                    rs.getString(2), rs.getString(3)/*, rs.getDate(4)*/);
            empleados.add(e);           
        }
        return empleados;
    }
    public ArrayList<String> getLocalidades() throws SQLException {
        ArrayList<String> localidades = new ArrayList<>();
        String sql = "select loc from departamentos";
        Statement st = conexion.createStatement();
        st.execute(sql);
        ResultSet rs = st.getResultSet();
        while (rs.next()){
            localidades.add(rs.getString(1));
        }
        return localidades;
    }
}
