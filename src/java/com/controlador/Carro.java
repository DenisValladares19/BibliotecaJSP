/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author SERVER
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
        int cantidad = Integer.parseInt(request.getParameter("cant"));
        HttpSession ses = request.getSession();
        DaoLibro dao = new DaoLibro();
        List<Libro> ls = new ArrayList<Libro>();
        ArrayList arreglo = new ArrayList();
        if(ses.getAttribute("carrito")==null){
                try {
                   ls = dao.verLibro(idLibro);
                   for(Libro l:ls){
                       Carrito c = new Carrito();
                       c.setIdLibro(idLibro);
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
            }else{
                   ArrayList list = (ArrayList)ses.getAttribute("carrito");
                   for(int i = 0;i<list.size();i++){
                       if(list.get(0).equals(idLibro)){
                           out.print("es el mismo id");
                       } else {
                           out.print("es otro id");
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
