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
            int rango = 0;
            if (request.getParameter("rangoEdad") != null) {
                rango = Integer.parseInt(request.getParameter("rangoEdad"));
            }
        %>
        <h2>+
            Hola <%        
                out.print(nombre + " " + ape1 + " " + ape2);
            %>
        </h2>

        <p>
            Su edad es:
        </p>
        <%
            if (rango == 1) {
                out.print("20 y 35 años");
            } else if (rango == 2) {
                out.print("36 y 55 años");
            } else if (rango == 3) {
                out.print("56 y 70 años");
            }
        %>
    </body>
</html>
