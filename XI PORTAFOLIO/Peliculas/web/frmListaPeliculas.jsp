<%-- 
    Document   : frmListaPeliculas
    Created on : 04/03/2019, 09:44:39 PM
    Author     : Thomas Chevez
--%>

<%@page import="Logica.LogicaPeliculas"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.3.1.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <link rel="icon" type="image/png" href="image/rollo-de-pelicula.png" />
        <title>Pel�culas</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="index.html">Inicio</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="directores.jsp">Directores</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="frmListaPeliculas.jsp">Pel�culas</a>
                    </li>
                </ul>
            </div>
        </nav>

        <header>
            <h3 style="margin-top: 50px" class="container text-center">
                Pel�culas
            </h3>
        </header>

        <section>
            <form action="frmListaPeliculas.jsp" method="post" class="container table-bordered form-inline" style="padding: 20px">
                <div class="form-group">
                    <label for="exampleInputEmail1">Buscar:</label>&nbsp;
                    <input type="text" class="form-control" id="txtBuscar" name="txtBuscar" value="" maxlength="50">&nbsp;&nbsp;&nbsp;
                    <button type="submit" id="btn_Buscar" class="btn btn-primary">Buscar</button>&nbsp;&nbsp;&nbsp;
                    <button type="button" id="btn_Nuevo" class="btn btn-primary" onclick="location.href = 'Peliculas.jsp'">Nuevo</button>
                </div>
            </form>
            <form action="frmListaPeliculas.jsp" method="post">
                <table class="container table-bordered">
                    <tr>
                        <th>
                            Titulo
                        </th>
                        <th>
                            Fecha Estreno
                        </th>
                        <th>
                            Duraci�n
                        </th>
                        <th>
                            Editar
                        </th>
                        <th>
                            Eliminar
                        </th>
                    </tr>
                    <%
                        //Variables
                        ResultSet vlo_RS;
                        LogicaPeliculas vlo_LogicaPeliculas = new LogicaPeliculas();
                        String vlc_Condicion = "";

                        //Inicio
                        try {
                            if (request.getParameter("txtBuscar") != null) {
                                vlc_Condicion = request.getParameter("txtBuscar");
                            }
                            vlo_RS = vlo_LogicaPeliculas.ListaPeliculas(vlc_Condicion);
                            while (vlo_RS.next()) {%>                                
                    <tr>
                        <td>
                            <%=vlo_RS.getString(2)%>
                        </td>
                        <td>
                            <%=vlo_RS.getDate(3)%>
                        </td>
                        <td>
                            <%=vlo_RS.getInt(4)%>
                        </td>
                        <td>
                            <a href="Peliculas.jsp?idPelicula=<%=vlo_RS.getInt(1)%>">
                                <img src="image/editar.png" alt=""/>
                            </a>
                        </td>
                        <td>
                            <a href="EliminarPelicula?idPelicula=<%=vlo_RS.getInt(1)%>">
                                <img src="image/basura.png" alt=""/>
                            </a>
                        </td>
                    </tr>
                    <%}
                        } catch (Exception e) {
                            response.sendRedirect("frmListasPeliculas?msj=" + e.getMessage() + " Error al cargar lista de Pel�culas.");
                        }
                    %>
                </table>
            </form>
        </section>
        <%            if (request.getParameter("msj") != null) {
        %>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#miModal').modal('toggle')
            });
        </script>
        <div class="modal fade" id="miModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">Informaci�n</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>

                    </div>
                    <div class="modal-body">
                        <%= new String(request.getParameter("msj").getBytes("ISO-8859-1"), "UTF-8")%>
                    </div>
                </div>
            </div>
        </div>
        <%
            }
        %>
    </body>
</html>
