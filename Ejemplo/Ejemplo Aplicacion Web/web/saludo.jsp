<%-- 
    Document   : saludo
    Created on : 26/02/2019, 11:07:26 AM
    Author     : tomas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saludo JSP</title>
    </head>
    <body>
        <h1>Respuesta desde JSP</h1>
        <%
            String nombre = request.getParameter("txtnombre");
            String ape1 = request.getParameter("txtape1");
            String ape2 = request.getParameter("txtape2");
            if (request.getParameter("rangoEdad") != null) {
                int rango = Integer.parseInt(request.getParameter("rangoEdad"));
            }
        %>
    </body>
</html>
