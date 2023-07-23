/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author dbpan
 */
public class MostrarPlanilla {

    private int id_planilla;
    private String fecha_creacion;

    public MostrarPlanilla() {
    }

    public MostrarPlanilla(int id_planilla, String fecha_creacion) {
        this.id_planilla = id_planilla;
        this.fecha_creacion = fecha_creacion;
    }

    public int getId_planilla() {
        return id_planilla;
    }

    public void setId_planilla(int id_planilla) {
        this.id_planilla = id_planilla;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public ArrayList<MostrarPlanilla> mostrar_planillas() {
        try {
            ArrayList<MostrarPlanilla> lista_planillas = new ArrayList<MostrarPlanilla>();
            PreparedStatement ps = Conexion.getConnection().prepareStatement("call sp_select_tbl_planilla");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_planilla = rs.getInt(1);
                String fecha_creacion = rs.getString(2);
                MostrarPlanilla obj_planilla = new MostrarPlanilla(id_planilla, fecha_creacion);
                lista_planillas.add(obj_planilla);
            }
            return lista_planillas;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
