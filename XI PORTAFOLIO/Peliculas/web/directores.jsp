<%-- 
    Document   : directores
    Created on : 03/03/2019, 10:20:19 AM
    Author     : Thomas Chevez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                        <a class="nav-link" href="Peliculas.jsp">Películas</a>
                    </li>
                </ul>
            </div>
        </nav>
        <section>
            <h3 style="margin-top: 50px" class="container text-center">
                Directores
            </h3>
            <form class="container table-bordered" style="padding: 20px">
                <div class="form-group">
                    <label for="exampleInputEmail1">Nombre</label>
                    <input type="text" class="form-control" id="txt_Nombre" name="txt_Nombre" value="" maxlength="50" required>
                </div>
                <button type="submit" id="btn_Guardar" class="btn btn-primary">Guardar</button>
            </form>
            <h3 class="container center-block text-center" style="margin-top: 60px;">Lista de directores</h3>
            <table class="container table-bordered">
                <tr>
                    <th>
                        Nombre:
                    </th>
                </tr>
            </table>
        </section>
    </body>
</html>
