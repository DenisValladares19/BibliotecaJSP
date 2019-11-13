<%-- 
    Document   : finalizarCompra
    Created on : 11-11-2019, 08:28:10 PM
    Author     : Admin
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="com.modelo.Carrito"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.modelo.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.DaoCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<%
    HttpSession ses = request.getSession();
    if(ses.getAttribute("sis")!=null){
    int idCliente = Integer.parseInt(ses.getAttribute("sis").toString());
    DaoCliente daoc = new DaoCliente();
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Biblioteca Onile</title>
        <jsp:include page="layout/css1.jsp"></jsp:include>
    </head>
    <body>
    <jsp:include  page="layout/menu_pagep.jsp"></jsp:include>
    <br>
    <div class="container">
        <center><h3>Finalizar compra</h3></center>
        <form action="procesarPago" method="post">
            <div class="row mt-5">
                <div class="col-md-2"></div>
                <div class="col-md-4">
                    <center><h5>Datos Personales</h5></center>
                    <%
                        List<Cliente> ls = new ArrayList();
                               ls = daoc.listarCliente(idCliente);
                        for(Cliente c:ls){
                    %>
                    
                    <label class="label">Nombre</label>
                    <input name="nombre" value="<%=c.getNombre() %>"  class="form-control" required="true"/>
                    <label class="label">Apellido</label>
                    <input name="apellido" value="<%=c.getApellido() %>"  class="form-control" required="true"/>
                    <label class="label">Dirección</label>
                    <input name="direccion" value="<%=c.getDireccion() %>"  class="form-control"required="true"/>
                    <input type="hidden" name="idCliente" value="<%=c.getIdCliente() %>"/>
                    <%
                        }
                    %>
                </div>
                <div class="col-md-4">
                    <center><h5>Información de Pago</h5></center>
                    <label>Nombre del titual</label>
                    <input type="text" class="form-control" name="titular" value=""required="true"/>
                    <label>N° Tarjeta </label>
                    <input type="text" class="form-control" name="tarjeta" value=""required="true"/>
                    <img src="assets/img/formapagos.png" width="110px" height="50px"required="true"/>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Fecha de expiración</label>
                            <div class="row">
                                <div class="col-md-6">
                                    <input type="text" name="mes" placeholder="mes" class="form-control"required="true"/>
                                </div>
                                <div class="col-md-6">
                                    <input type="text" name="anio" placeholder="año" class="form-control"required="true"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <label>Codigo de Seguridad</label>
                            <div class="row">
                                <div class="col-md-6">
                                    <input type="text" name="codigo" placeholder="cod" class="form-control"required="true"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <label>Total a pagar </label>
                    <%
                        List<Carrito> lis = (ArrayList)ses.getAttribute("carrito");
                        double total=0;
                        DecimalFormat df = new DecimalFormat("######.##");
                        for(Carrito l:lis){
                            total+=l.getSubtotal();
                        }
                    %>
                    <input type="text" name="total" value="$ <%= total%>" class="form-control" readonly="true"/>
                    <div align="right"><br>
                        <input type="submit" class="btn btn-success" value="Proceder con el pago" style="color:white;" />
                   </div>
                </div>
            </div>
        </form>
    </div>
    <jsp:include page="layout/footeer.jsp"></jsp:include>
    </body>
</html>
<%
   }else{
    response.sendRedirect("inicioSesion.jsp");
}
%>
