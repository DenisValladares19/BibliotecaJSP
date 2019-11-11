
package com.dao;

import com.conexion.Conexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Nombre de la clase: DaoPrestamo
 * Fecha: 01-10-2019
 * Version: 1.0
 * Copyright: Biblioteca Online
 * @author Edgard Palacios 
 */
public class DaoPrestamo extends Conexion{
    
    //En este metodo se valida si el Cliente ya reaizo un Prestamo de X Libro
    public boolean validar(int idClie,int idLib) throws Exception
    {
         ResultSet rs = null;
         
         String sql = "SELECT * FROM solicitudprestamo where idCliente=? and idLibro=?";
        try 
        {
            conectar();
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, idClie);
            pre.setInt(2, idLib);
            rs = pre.executeQuery();
            while(rs.next())
            {
                return true;
            }
        } 
        catch (Exception e) 
        {
            throw e;
        }
        
        return false;
    }
    
    //En este Metodo se Ingresa la Solicitud del Prestamo
    public void insertarSoliPrestamo(int idClie,int idLib) throws ClassNotFoundException, SQLException, Exception
    {
        //Date fecha=new Date();
        try 
        {
            this.conectar();
            String sql="insert into solicitudprestamo(idCliente,idLibro,fecha)value(?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1,idClie);
            pre.setInt(2, idLib);
           // pre.setDate(3, fecha);
            pre.executeUpdate();  
            
            
        } catch (SQLException e) 
        {
           throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    
    
    
}