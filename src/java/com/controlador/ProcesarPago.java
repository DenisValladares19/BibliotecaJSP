
package com.controlador;

import com.dao.DaoVenta;
import com.modelo.Carrito;
import com.modelo.Cliente;
import com.modelo.DetalleEnvio;
import com.modelo.Envio;
import com.modelo.Libro;
import com.modelo.Venta;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Nombre de la clase: ProcesarPago
 * Fecha: 13-11-2019
 * Version: 1.0
 * Copyirght: Biblioteca Online
 * @author Denis Valladares
 */
public class ProcesarPago extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        boolean band = false;
        try {
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            String direccion = request.getParameter("direccion");
            DaoVenta dao = new DaoVenta();
            Venta v = new Venta();
            Envio e = new Envio();
            e.setCostoEnvio(2.99);
            e.setDestino(direccion);
            int idEnvio = 0;
            idEnvio = dao.sacaridEnvio(e);
            HttpSession ses = request.getSession();
            List<Carrito> ls = new ArrayList();
            ls = (ArrayList)ses.getAttribute("carrito");
            
            for(Carrito c:ls){
                Libro l = new Libro();
                l.setIdLibro(c.getIdLibro());
                Cliente cl = new Cliente();
                cl.setIdCliente(c.getIdCliente());
                v.setCantidad(c.getCantidad());
                v.setTotalPagar(c.getSubtotal());             
                Date fecha = new Date();
                v.setFecha(fecha.toString());
                dao.insertarVenta(v);
                band=true;
            } 
          if(band){
            out.print("Se completo la compra exitosamente");
            }  
        } catch (SQLException e) {
            out.print("error: "+e.toString());
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ProcesarPago.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ProcesarPago.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
