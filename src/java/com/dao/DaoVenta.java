
package com.dao;

import com.conexion.Conexion;
import com.modelo.DetalleEnvio;
import com.modelo.Envio;
import com.modelo.Venta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class DaoVenta extends Conexion {
    
    
    public void insertarEnvio(Envio v) throws Exception{
        try {
            conectar();
            String sql = "INSERT INTO `envio`(`costoEnvio`, `destino`, `borradoLogico`) VALUES (?,?,1)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setDouble(1, v.getCostoEnvio());
            pre.setString(2, v.getDestino());
            pre.executeUpdate();
            pre.close();
        } catch (Exception e) {
            throw e;
        }finally{
            desconectar();
        }
    }
    
    public int sacaridEnvio(Envio v) throws Exception{
        int idEnvio = 0;
        try {
            conectar();
            String sql2 = "SELECT idEnvio FROM envio WHERE costoEnvio=? AND destino=?";
            ResultSet rs;
            PreparedStatement pre2 = this.getCon().prepareStatement(sql2);
            pre2.setDouble(1, v.getCostoEnvio());
            pre2.setString(2, v.getDestino());
            rs = pre2.executeQuery();
            while(rs.next()){
                idEnvio = rs.getInt("idEnvio");
            }
            pre2.close();
            rs.close();
        } catch (Exception e) {
        }finally{
            desconectar();
        }
        return idEnvio;
    }
    
    public void insertarDetalleEnvio(DetalleEnvio v) throws Exception{
        try {
            conectar();
            String sql3 = "INSERT INTO `detalleenvio`(`idEnvio`, `idEstadoEnvio`, `tiempoEnvio`, `borradoLogico`) VALUES (?,?,?,1)";
            PreparedStatement pre3 = this.getCon().prepareStatement(sql3);
            pre3.setInt(1, this.sacaridEnvio(v.getEnvio()));
            pre3.setInt(2, 1);
            pre3.setString(3, "2 dias");
            pre3.executeUpdate();
            pre3.close();
        } catch (Exception e) {
        }finally{
            desconectar();
        }
    }
    
    public int sacarIdDetalle(Envio v) throws Exception{
        int idDetalleEnvio = 0;
        try {
            conectar();
            String sql4 = "SELECT idDetalleEnvio FROM detalleenvio WHERE idEnvio=?";
            ResultSet rs2;
            PreparedStatement pre4 = this.getCon().prepareStatement(sql4);
            pre4.setInt(1, this.sacaridEnvio(v));
            rs2 = pre4.executeQuery();
            while(rs2.next()){
                idDetalleEnvio = rs2.getInt("idDetalleEnvio");
            }
            pre4.close();
            rs2.close();
            
        } catch (Exception e) {
        }finally{
            desconectar();
        }
        return idDetalleEnvio;
    }
    public void insertarVenta(Venta v) throws Exception{
        try {
            conectar();
            String sql5 = "INSERT INTO `venta`(`idCliente`, `idLibro`, `fecha`, `cantidad`, `totalPagar`, `idDetalleEnvio`, `borradoLogico`) VALUES (?,?,?,?,?,?,1)";
            PreparedStatement pre5 = this.getCon().prepareStatement(sql5);
            pre5.setInt(1,v.getCliente().getIdCliente() );
            pre5.setInt(2, v.getLibro().getIdLibro());
            pre5.setString(3, v.getFecha());
            pre5.setInt(4, v.getCantidad());
            pre5.setDouble(5, v.getTotalPagar());
            pre5.setInt(6, this.sacarIdDetalle(v.getEnvio()));
            pre5.executeUpdate();
            pre5.close();
                
        } catch (Exception e) {
            throw e;
        }finally{
            desconectar();
        }
    }
}
