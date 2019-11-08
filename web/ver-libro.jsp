
<%@page import="com.modelo.Libro"%>
<%
    if(request.getParameter("l")!=null){
        
    
%>
<%-- 
    Document   : index
    Created on : 10-03-2019, 10:15:08 PM
    Author     : Admin
--%>
<%@page import="com.dao.DaoLibro"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
  <%
      DaoLibro daoL = new DaoLibro();
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
                        <input type="hidden" id="idLibro" value="<%= request.getParameter("l") %>"/>
                        <div class="row">
                            <div class="col-md-3">
                                <input type="number" class="form-control" id="cant" min="1"/>
                            </div>
                            <div class="col-md-4">
                                <button class="btn btn-success btn-small " id="agregar"><i class="fas fa-cart-plus"></i> Agregar</button>
                            </div>
                            <div class="col-md-4">
                                <button class="btn btn-warning btn-small" style="color:white;" id="prestar"><i class="fas fa-id-badge"></i>  Prestar</button>                               
                            </div>
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
<script>
    $(document).ready(function() {
       $("#agregar").click(function(){
           if($("#cant").val()==""){
               const Toast = Swal.mixin({
                    toast: true,
                    position: 'top-end',
                    showConfirmButton: false,
                    timer: 3000
                  })

                  Toast.fire({
                    icon: 'error',
                    title: 'debe seleccionar una cantidad'
                  })
           }else{
               var idLibro = $("#idLibro").val();
           var cant = $("#cant").val();
          alert("diste click en id "+idLibro+"cantidad "+cant); 
           }
            
       });
    });
</script>