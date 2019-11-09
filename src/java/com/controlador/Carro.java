
package com.controlador;

import com.dao.DaoLibro;
import com.modelo.Libro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
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
        String accion = request.getParameter("accion");
        HttpSession ses = request.getSession();
        DaoLibro dao = new DaoLibro();
        HashMap<String,Object> arreglo = new HashMap<>();
        List<Libro> ls = new ArrayList();
        
            if(ses.getAttribute("carrito")==null){
                try {
                   ls = dao.verLibro(idLibro);
                   for(Libro l:ls){
                       arreglo.put("id",idLibro);
                       arreglo.put("nombre",l.getNombre());
                       arreglo.put("editorial",l.getEditorial().getNombre());
                       arreglo.put("autor",l.getAutor().getNombre());
                       arreglo.put("imagen",l.getImagen());
                       arreglo.put("precio",l.getPrecio());
                       arreglo.put("cantidad",cantidad);
                       arreglo.put("subtotal",cantidad*l.getPrecio());
                   }
                   ses.setAttribute("carrito", arreglo);
                   out.print("Se agregó exitosamente al carrito");
                } catch (Exception e) {
                    out.print("Error: "+e.getMessage());
                }
            }else{
                HashMap<String,Object> arregloSes = (HashMap)ses.getAttribute("carrito");
                 for(Map.Entry entry: arreglo.entrySet()){
                   String key = (String)entry.getKey();
                   Object value = entry.getValue();
                   if(key.equals("id")&& value.equals(idLibro)){
                       out.print("Es el mismo del carrito");
                   }else{
                       out.print("No es el mismo del carrito");
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
