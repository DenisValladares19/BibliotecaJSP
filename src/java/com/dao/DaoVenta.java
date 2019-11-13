
package com.dao;

import com.conexion.Conexion;
import com.modelo.Envio;
import com.modelo.Venta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class DaoVenta extends Conexion {
    
    
    public void insertarVenta(Envio en){
        try {
            conectar();
            String sql = "INSERT INTO `envio`(`costoEnvio`, `destino`, `borradoLogico`) VALUES (?,?,1)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setDouble(1, en.getCostoEnvio());
            pre.setString(2, en.getDestino());
            pre.executeUpdate();
            pre.close();
            
            String sql2 = "SELECT idEnvio FROM envio WHERE costoEnvio=? AND destino=?";
            ResultSet rs;
            int idEnvio = 0;
            PreparedStatement pre2 = this.getCon().prepareStatement(sql2);
            pre.setDouble(1, en.getCostoEnvio());
            pre.setString(2, en.getDestino());
            rs = pre2.executeQuery();
            while(rs.next()){
                idEnvio = rs.getInt("idEnvio");
            }
            pre2.close();
            rs.close();
            
            String sql3 = "INSERT INTO `detalleenvio`(`idEnvio`, `idEstadoEnvio`, `tiempoEnvio`, `borradoLogico`) VALUES (?,?,?,1)";
            PreparedStatement pre3 = this.getCon().prepareStatement(sql3);
            pre3.setInt(1, idEnvio);
            pre3.setInt(2, 1);
            pre3.setString(3, "2 dias");
            pre3.executeUpdate();
            pre3.close();
            
            String sql4 = "SELECT idDetalleEnvio FROM detalleenvio WHERE idEnvio=?";
            int idDetalleEnvio = 0;
            ResultSet rs2;
            PreparedStatement pre4 = this.getCon().prepareStatement(sql4);
            pre4.setInt(1, idEnvio);
            rs2 = pre4.executeQuery();
            while(rs2.next()){
                idDetalleEnvio = rs2.getInt("idDetalleEnvio");
            }
            pre4.close();
            rs2.close();
            
            String sql5 = "INSERT INTO `venta`(`idCliente`, `idLibro`, `fecha`, `cantidad`, `totalPagar`, `idDetalleEnvio`, `borradoLogico`) VALUES (?,?,?,?,?,?,1)";
            PreparedStatement pre5 = this.getCon().prepareStatement(sql5);
            
            
        } catch (Exception e) {
        }
    }
}
