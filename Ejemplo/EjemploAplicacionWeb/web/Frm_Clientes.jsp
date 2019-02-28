<%-- 
    Document   : Frm_Clientes
    Created on : 28/02/2019, 10:03:58 AM
    Author     : tomas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="logica.*"%>
<%@page import="entidades.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="estilos/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Nuevo Cliente</title>
    </head>
    <body>
        <div>
            <heder><h1>Mantenimiento de Clientes</h1></heder>
                <%
                    String id = request.getParameter("id");
                    int codigo = Integer.parseInt(id);
                    clsEntidadCliente vlo_Cliente;
                    clsLogicaCliente vlo_LogicaCliente = new clsLogicaCliente();
                    if (codigo > 0) {
                        vlo_Cliente = vlo_LogicaCliente.ObtenerRegistro("ID_CLIENTE=" + id);
                    } else {
                        vlo_Cliente = new clsEntidadCliente();
                    }

                %>
            <section>
                <form action="Clientes" method="post">
                    <%                        if (codigo > 0) {%>
                    Código: <br>
                    <input type="number" id="txtcodigo" name="txtcodigo" value="<%=vlo_Cliente.getVgn_IdCliente()%>" required/><br>
                    <%} else {%>
                    <input type="hidden" id="txtcodigo" name="txtcodigo" value="-1"/><br>
                    <%}%>
                    Nombre: <br>
                    <input type="text" id="txtnombre" name="txtnombre" value="<%=vlo_Cliente.getVgn_IdCliente()%>" required/><br>
                    Dirección: <br>
                    <input type="text" id="txtdireccion" name="txtdireccion" value="<%=vlo_Cliente.getVgc_direccion()%>" required/><br>
                    <br>
                    <input type="submit" id="BtnGuardar" valur="Guardar"/> &nbsp;&nbsp;
                    <input type="reset" id="BtnCancelar" value="Cancelar"/>&nbsp;&nbsp;
                    <input type="button" id="BtnRegresar" valure="Regresar" onclick="location.href='frmListarClientes.jsp'">
                </form>
                    <br><br>
                    <a href="index.html">Regresar al inicio.</a>
            </section>
        </div>
    </body>
</html>
