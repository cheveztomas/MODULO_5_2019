<%-- 
    Document   : frmListaPeliculas
    Created on : 04/03/2019, 09:44:39 PM
    Author     : Thomas Chevez
--%>

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
            <h3 style="margin-top: 50px" class="text-center">
                Películas
            </h3>
            <form action="frmListaPeliculas.jsp" method="post">

            </form>
            <form action="frmListaPeliculas.jsp" method="post">
                <table class="container table-bordered">

                </table>
            </form>
        </header>

        <form action="" method="post" class="container table-bordered" style="padding: 20px">
            <div class="form-group">
                <label for="exampleInputEmail1">...</label>
                <input type="text" class="form-control" id="" name="" value="<%=%>" maxlength="50" required>
                <input type="hidden" id="txt_idDirector" name="txt_idDirector" value="<%=%>">
            </div>
            <button type="submit" id="btn_Guardar" class="btn btn-primary">Guardar</button>
            <button type="button" id="btn_Nuevo" class="btn btn-primary" onclick="location.href = ''">Limpiar</button>
        </form>
    </body>
</html>
