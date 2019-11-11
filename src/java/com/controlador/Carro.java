
package com.controlador;

import com.dao.DaoLibro;
import com.modelo.Carrito;
import com.modelo.Libro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Nombre de la clase: Carro
 * Fecha: 09-11-2019
 * Version: 1.0
 * Copyright: Denis Valladares
 * @author Denis Valladares
 */
public class Carro extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int idLibro = Integer.parseInt(request.getParameter("idLibro"));
        String accion = request.getParameter("accion");
        HttpSession ses = request.getSession();
        DaoLibro dao = new DaoLibro();
        List<Libro> ls;
        List<Carrito> arreglo = new ArrayList();
        if(accion.equals("agregar")){
            int cantidad = Integer.parseInt(request.getParameter("cant"));
            if(ses.getAttribute("carrito")==null){
                    try {
                       ls = dao.verLibro(idLibro);
                       for(Libro l:ls){
                           Carrito c = new Carrito();
                           c.setIdLibro(idLibro);
                           c.setNombre(l.getNombre());
                           c.setAutor(l.getAutor().getNombre());
                           c.setEditorial(l.getEditorial().getNombre());
                           c.setPrecio(l.getPrecio());
                           c.setCantidad(cantidad);
                           c.setSubtotal(cantidad*l.getPrecio());
                           arreglo.add(c);
                       }
                       ses.setAttribute("carrito", arreglo);
                       out.print("Se agregó exitosamente al carrito");
                    } catch (Exception e) {
                        out.print("Error: "+e.getMessage());
                    }
               } else {
                List<Carrito> list = (ArrayList) ses.getAttribute("carrito");
                boolean band = false;
                for (Carrito c : list){
                    if (idLibro!=c.getIdLibro()) {
                        band=true;
                    } else {
                        band=false;
                        c.setCantidad(c.getCantidad()+cantidad);
                        out.print("Se agregó de nuevo el libro");
                    }
                }
                if(band){
                    try {
                            ls = new ArrayList();
                            ls = dao.verLibro(idLibro);
                            for (Libro l : ls) {
                                Carrito ca = new Carrito();
                                ca.setIdLibro(l.getIdLibro());
                                ca.setNombre(l.getNombre());
                                ca.setAutor(l.getAutor().getNombre());
                                ca.setEditorial(l.getEditorial().getNombre());
                                ca.setPrecio(l.getPrecio());
                                ca.setCantidad(cantidad);
                                ca.setSubtotal(cantidad * l.getPrecio());
                                list.add(ca);
                                out.print("Se agregó otro exitosamente al carrito");
                                ses.setAttribute("carrito", list);
                            }
                            
                        } catch (Exception e) {
                            out.print("Error: " + e.getMessage());
                        }
                }
            }

        }
        if(accion.equals("eliminar")){
            
                List<Carrito> list = (ArrayList) ses.getAttribute("carrito");
                for (Carrito c : list){
                    if (idLibro!=c.getIdLibro()) {
                        list.remove(c);
                        ses.setAttribute("carrito", list);
                        out.print("Se elimininó satisfactoriamente");
                    } 
                }
            
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
        processRequest(request, response);
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
        processRequest(request, response);
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
