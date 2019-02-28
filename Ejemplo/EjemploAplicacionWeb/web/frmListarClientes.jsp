<%-- 
    Document   : frmListarClientes
    Created on : 28/02/2019, 08:30:21 AM
    Author     : tomas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="logica.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="estilos/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Lista de Clientes</title>
    </head>
    <body>
        <div>
            <header>
                <h1>Lista de clientes</h1>
            </header>
            <section>
                <form action="frmListaClientes.jsp" method="post">
                    Nombre: <br>
                    <input type="text" id="txtnombre" name="txtnombre" value=""/>&nbsp;&nbsp;
                    <input type="submit" id="btnbuscar" name="btnbuscar" value="Buscar"/>
                </form>
                <br>
                <table class="tablaBasica">
                    <tr id="titulos">
                        <td style="text-align: center">Código</td>
                        <td style="text-align: center">Nombre</td>
                        <td style="text-align: center">Dirección</td>
                        <td style="text-align: center">Teléfono</td>
                        <td style="text-align: center">&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td style="text-align: center">&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    </tr>
                    <%
                        String nombre = "";
                        String condicion = "";
                        if (request.getParameter("txtnombre") != null) {
                            nombre = request.getParameter("txtnombre");
                            condicion = "NOMBRE like '%" + nombre + "%'";
                        }

                        clsLogicaCliente vloLogicaCliente = new clsLogicaCliente();
                        ResultSet vlo_datos;
                        vlo_datos = vloLogicaCliente.listar(condicion, "");
                        while (vlo_datos.next()) {
                    %>
                    <tr>
                        <%
                            int codigo = vlo_datos.getInt(1);
                        %>
                        <td style="text-align: left"><%=codigo%></td>
                        <td style="text-align: left"><%= vlo_datos.getString(2)%></td>
                        <td style="text-align: left"><%=vlo_datos.getString(3)%></td>
                        <td style="text-align: left"><%=vlo_datos.getString(4)%></td>
                        <td style="text-align: left"><a href="Frm_Clientes-jsp?id=<%=codigo%>">Editar</a></td>
                        <td style="text-align: left"><a href="EliminarCliente?id=<%=codigo%>">Eliminar</a></td>
                    </tr>
                    <%};%>
                </table>
            </section>
        </div>
    </body>
</html>
