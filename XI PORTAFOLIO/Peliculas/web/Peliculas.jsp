<%-- 
    Document   : Peliculas
    Created on : 03/03/2019, 11:10:23 AM
    Author     : Thomas Chevez
--%>

<%@page import="Logica.LogicaDirectores"%>
<%@page import="Logica.LogicaPeliculasDirectores"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Date"%>
<%@page import="Entidades.ClsPeliculas"%>
<%@page import="Logica.LogicaPeliculas"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link href="css/jquery-ui.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" type="image/png" href="image/rollo-de-pelicula.png" />
        <title>Películas</title>
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
                Películas
            </h3>
        </header>

        <section>
            <%
                //Variables
                LogicaPeliculas vlo_LogicaPeliculas = new LogicaPeliculas();
                ClsPeliculas vlo_Pelicula = new ClsPeliculas();

                //Inicio
                try {
                    if (request.getParameter("idPelicula") != null) {
                        vlo_Pelicula = vlo_LogicaPeliculas.RetornarPelicula(Integer.parseInt(request.getParameter("idPelicula")));
                    } else {
                        vlo_Pelicula = new ClsPeliculas();
                        vlo_Pelicula.setVgn_idPelicula(-1);
                        Date fecha = new Date();
                        vlo_Pelicula.setVgd_fecha(new java.sql.Date(fecha.getTime()));
                    }
                } catch (Exception e) {
                    response.sendRedirect("Peliculas.jsp?msj=" + e.getMessage() + "Error al cargar película.");
                }

            %>
            <form action="GuardarPelicula" method="post" class="container table-bordered" style="padding: 20px">
                <div class="form-group">
                    <label for="exampleInputEmail1">Titulo</label>
                    <input type="text" class="form-control" id="txt_Titulo" name="txt_Titulo" value="<%=vlo_Pelicula.getVgc_titulo()%>" maxlength="50" required>
                    <label for="exampleInputEmail1">Fecha Estreno</label><br>
                    <input type="text" class="form-control" name="txt_Fecha" id="datepicker"value="<%=vlo_Pelicula.getVgd_fecha()%>" required/> <br>
                    <label for="exampleInputEmail1">Duración</label>
                    <input type="number" class="form-control" id="txt_Duracion" name="txt_Duracion" value="<%=vlo_Pelicula.getVgn_duracion()%>" maxlength="2" required>
                    <input type="hidden" id="txt_idPelicula" name="txt_idPelicula" value="<%=vlo_Pelicula.getVgn_idPelicula()%>">
                </div>
                <button type="submit" id="btn_Guardar" class="btn btn-primary">Guardar</button>
                <button type="button" id="btn_Nuevo" class="btn btn-primary" onclick="location.href = 'Peliculas.jsp'">Limpiar</button>
            </form>
            <%
                if (request.getParameter("idPelicula") != null) {
                    if (Integer.parseInt(request.getParameter("idPelicula")) > 0) {
            %>
            <h3 style="margin-top: 50px" class="container text-center">
                Directores
            </h3>
            <form action="Peliculas.jsp" method="post">
                <table class="container table-bordered">
                    <tr>
                        <th>
                            Directores
                        </th>
                        <th>
                            Eliminar
                        </th>
                    </tr>
                    <%
                        //Variables
                        ResultSet vlo_RS;
                        String vlc_Condicion = "";
                        LogicaPeliculasDirectores vlo_LogicaPeliculasDirectores = new LogicaPeliculasDirectores();

                        //Inicio
                        try {
                            if (request.getParameter("txtBuscar") != null) {
                                vlc_Condicion = request.getParameter("txtBuscar");
                            }
                            vlo_RS = vlo_LogicaPeliculasDirectores.ListaDirectoresPeliculas(vlo_Pelicula.getVgn_idPelicula());
                            while (vlo_RS.next()) {%>  
                    <tr>
                        <td>
                            <%
                                out.print(vlo_RS.getString(2));
                            %>
                        </td>
                        <td>
                            <a href="EliminarPeliculaDirector?idPelicula=<%=vlo_Pelicula.getVgn_idPelicula()%>&idDirector=<%=vlo_RS.getInt(1)%>">
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
            <h3 class="container center-block text-center" style="margin-top: 60px;">Lista de directores</h3>
            <form action="Peliculas.jsp" method="post" class="container table-bordered form-inline" style="padding: 20px">
                <div class="form-group">
                    <label for="exampleInputEmail1">Buscar:</label>&nbsp;
                    <input type="text" class="form-control" id="txtBuscar" name="txtBuscar" value="" maxlength="50">&nbsp;&nbsp;&nbsp;
                    <button type="submit" id="btn_Buscar" class="btn btn-primary">Buscar</button>
                </div>
            </form>
            <form action="Peliculas.jsp" method="post">
                <table class="container table-bordered">
                    <tr>
                        <th>
                            Nombre
                        </th>
                        <th>
                            Agregar a Película
                        </th>
                    </tr>
                    <%
                        //Variables
                        String vlc_CondicionB = "";
                        int idDirector = 0;
                        LogicaDirectores vlo_LogicaDirectores = new LogicaDirectores();

                        //Inicio
                        try {
                            if (request.getParameter("txtBuscar") != null) {
                                vlc_CondicionB = request.getParameter("txtBuscar");
                                vlo_RS = vlo_LogicaDirectores.ListaDirectores(vlc_CondicionB);
                            } else {
                                vlo_RS = vlo_LogicaDirectores.ListaDirectores(vlc_CondicionB);
                            }
                            while (vlo_RS.next()) {  %>                              
                    <tr>
                        <% idDirector = vlo_RS.getInt(1);%>
                        <td>
                            <%=vlo_RS.getString(2)%>
                        </td>
                        <td>
                            <a href="GuardarPeliculasDirectores?idPelicula=<%=vlo_Pelicula.getVgn_idPelicula()%>&idDirector=<%=vlo_RS.getInt(1)%>">
                                <img src="image/mas.png" alt=""/>
                            </a>
                        </td>
                    </tr>
                    <%}
                        } catch (Exception e) {
                        }
                    %>
                </table>
            </form>
            <%
                    }
                }
            %>
        </section>
        <script src="js/jquery-3.3.1.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="js/jquery-ui.min.js" type="text/javascript"></script>

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
        <script>
            $(function () {
                $("#datepicker").datepicker({
                    showOn: "button",
                    buttonImage: "image/calendario.png",
                    buttonImageOnly: true,
                    dateFormat: "yy-mm-dd",
                    buttonText: "Seleccione una fecha"
                });
            });
        </script>
    </body>
</html>
