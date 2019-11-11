
<%@page import="com.modelo.Libro"%>
<%
    if(request.getParameter("l")!=null){
    int idL=Integer.parseInt(request.getParameter("l").toString());
    
%>
<%-- 
    Document   : index
    Created on : 10-03-2019, 10:15:08 PM
    Author     : Admin
--%>
<%@page import="com.dao.DaoLibro"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Biblioteca Online</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <jsp:include page="layout/css1.jsp"></jsp:include>
  <script src="Recursos/js/ver-libro.js" type="text/javascript"></script>   
  <%
      DaoLibro daoL = new DaoLibro();
      HttpSession ses=request.getSession();
  %>
</head>

<body>
    <jsp:include page="layout/menu_pagep.jsp"></jsp:include>
    <div class="container mt-5">
   
            
                <% 
                    List<Libro> ls = daoL.verLibro(Integer.parseInt(request.getParameter("l")));                    
                    for(Libro l:ls){
                %>
                <div class="col-md-12">
                  <div class="text-center">
                    <h3><span><%= l.getNombre()%> </span></h3><br>
                  </div>
                </div>
                <div class="row">
                    <div class="col-md-2"></div>
                    <div class="col-md-5 p-3">
                    
                        <h5><strong>Autor: </strong><a href="autor.jsp?a=<%=  l.getAutor().getIdAutor() %>">  <%= l.getAutor().getNombre() %></a></h5>
                        <h5><strong>Genero: </strong><a href="genero.jsp?g=<%= l.getGenero().getIdGenero() %>"><%= l.getGenero().getNombre() %></a></h5>
                        <h5><strong>Fecha de Lanzamiento: </strong><%= l.getAnioLanzamiento() %></h5>
                        <h5><strong>Editorial: </strong><%= l.getEditorial().getNombre() %></h5>
                        <h5><strong>Edición: </strong><%= l.getEdicion() %></h5>
                        <h5><strong>Precio: </strong>$ <%= l.getPrecio() %></h5>
                        <input type="hidden" id="idLibro" value="<%= request.getParameter("l") %>"/>
                        <div class="row">
                            <div class="col-md-3">
                                <input type="number" class="form-control" id="cant" min="1"/>
                            </div>
                            <div class="col-md-4">
                                <button class="btn btn-success btn-small " id="agregar"><i class="fas fa-cart-plus"></i> Agregar</button>
                            </div>
                            
                            <%
                                if(ses.getAttribute("sis")!=null)  //Esta sesion trae el ID del Usuario logeado
                                  {
                               int id=Integer.parseInt(ses.getAttribute("sis").toString()); 

                              %>
                            <div class="col-md-4">
                                <a href="prestamo?u=<%= id %>&l=<%= idL %>" class="btn btn-warning btn-small" style="color:white;" id="prestar"><i class="fas fa-id-badge"></i>  Prestar</a>                               
                            </div>
                            
                             <%
                                }
                            %>
                        </div>
                        <div class="row"><p> </p></div>
                        <div class="row">
                            
                        </div>
                        <h5><strong>Sinpsis</strong></h5>
                        <p align="justify" ><%= l.getSinopsis() %></p>
                    </div>
                    <div class="col-md-4">
                        <img src="assets/img/libro/<%= l.getImagen() %>" alt="<%= l.getNombre()%>" class="img-fluid" />
                    </div>
                </div>
                <%
                     }
                %>
            
         
        
    </div>
    <jsp:include page="layout/footeer.jsp"></jsp:include>
</body>
</html>
<%
    }else{


%>

<%
    }
%>

