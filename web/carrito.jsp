<%-- 
    Document   : carrito
    Created on : 11-09-2019, 10:30:53 AM
    Author     : SERVER
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Biblioteca Online</title>
        <jsp:include page="layout/css1.jsp"></jsp:include>
    </head>
    <body>
    <jsp:include page="layout/menu_pagep.jsp"></jsp:include>
    <br><br><br>
    <%
        HttpSession ses = request.getSession();
        if(ses.getAttribute("carrito")!=null){
          %>  
            
    <center><h3>Carrito de Compras</h3></center>
    <table class="table table-borderless">
        <thead class="table-dark">
            <th>Codigo</th>
            <th>Nombre</th>
            <th>Editorial</th>
            <th>Autor</th>
            <th>Precio</th>
            <th>Cantidad</th>
            <th>Subtotal</th>
            <th>Acción</th>
        </thead>
        <tbody>
            <%
                ArrayList ls = (ArrayList)ses.getAttribute("carrito");
                
                   for(Object l:ls){ 
                %>    
                <tr>
                    <td><%= ls.get(0) %></td>
                </tr>
                 <%   
               } 
            %>
        </tbody>
    </table>
            <%
        }else{
           %> 
           <center><h3>El Carrito esta vacio</h3></center>   
            <%
        }
    %>
    
    
    <jsp:include page="layout/footeer.jsp"></jsp:include>
    </body>
</html>
