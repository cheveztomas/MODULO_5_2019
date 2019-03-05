<%-- 
    Document   : directores
    Created on : 03/03/2019, 10:20:19 AM
    Author     : Thomas Chevez
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="Logica.LogicaDirectores"%>
<%@page import="Entidades.ClsDirectores"%>
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
        <title>Directores</title>
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
                        <a class="nav-link" href="frmListaPeliculas.jsp">Películas</a>
                    </li>
                </ul>
            </div>
        </nav>
        <header>
            <h3 style="margin-top: 50px" class="container text-center">
                Directores
            </h3>
            <%
                //Variables
                int vln_idDirector = -1;
                if (request.getParameter("idDirector") != null) {
                    vln_idDirector = Integer.parseInt(request.getParameter("idDirector"));
                }
                ClsDirectores vlo_Director;
                LogicaDirectores vlo_LogicaDirectores = new LogicaDirectores();

                //Inicio
                if (vln_idDirector > 0) {
                    vlo_Director = vlo_LogicaDirectores.RetornarDirector(vln_idDirector);
                } else {
                    vlo_Director = new ClsDirectores();
                    vlo_Director.setVgc_idDirector(-1);
                }
            %>
        </header>

        <section>
            <form action="GuardarDirector" method="post" class="container table-bordered" style="padding: 20px">
                <div class="form-group">
                    <label for="exampleInputEmail1">Nombre</label>
                    <input type="text" class="form-control" id="txt_Nombre" name="txt_Nombre" value="<%=vlo_Director.getVgc_Nombre()%>" maxlength="50" required>
                    <input type="hidden" id="txt_idDirector" name="txt_idDirector" value="<%=vlo_Director.getVgc_idDirector()%>">
                </div>
                <button type="submit" id="btn_Guardar" class="btn btn-primary">Guardar</button>
                <button type="button" id="btn_Nuevo" class="btn btn-primary" onclick="location.href = 'directores.jsp'">Limpiar</button>
            </form>
            <h3 class="container center-block text-center" style="margin-top: 60px;">Lista de directores</h3>
            <form action="directores.jsp" method="post" class="container table-bordered form-inline" style="padding: 20px">
                <div class="form-group">
                    <label for="exampleInputEmail1">Buscar:</label>&nbsp;
                    <input type="text" class="form-control" id="txtBuscar" name="txtBuscar" value="" maxlength="50">&nbsp;&nbsp;&nbsp;
                    <button type="submit" id="btn_Buscar" class="btn btn-primary">Buscar</button>
                </div>
            </form>
            <form action="directores.jsp" method="post">
                <table class="container table-bordered">
                    <tr>
                        <th>
                            Nombre
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
                        String vlc_Condicion = "";
                        ResultSet vlo_RS;
                        int idDirector = 0;

                        //Inicio
                        try {
                            if (request.getParameter("txtBuscar") != null) {
                                vlc_Condicion = request.getParameter("txtBuscar");
                                vlo_RS = vlo_LogicaDirectores.ListaDirectores(vlc_Condicion);
                            } else {
                                vlo_RS = vlo_LogicaDirectores.ListaDirectores(vlc_Condicion);
                            }
                            while (vlo_RS.next()) {  %>                              
                    <tr>
                        <% idDirector = vlo_RS.getInt(1);%>
                        <td>
                            <%=vlo_RS.getString(2)%>
                        </td>
                        <td>
                            <a href="directores.jsp?idDirector=<%=idDirector%>">
                                <img src="image/editar.png" alt=""/>
                            </a>
                        </td>
                        <td>
                            <a href="EliminarDirector?idDirector=<%=idDirector%>">
                                <img src="image/basura.png" alt=""/>
                            </a>
                        </td>
                    </tr>
                    <%}
                        } catch (Exception e) {
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
                        <h4 class="modal-title" id="myModalLabel">Información</h4>
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
