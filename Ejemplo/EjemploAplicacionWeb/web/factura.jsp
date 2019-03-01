<%-- 
    Document   : factura
    Created on : 28/02/2019, 10:40:48 PM
    Author     : Thomas Chevez
--%>

<%@page import="java.util.Date"%>
<%@page import="logica.*"%>
<%@page import="entidades.*"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="estilos/jquery-ui.css" rel="stylesheet" type="text/css"/>
        <link href="estilos/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
        <!--<link href="estilos/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="estilos/jquery-ui.css" rel="stylesheet" type="text/css"/>
        <link href="estilos/jquery.dataTables.css" rel="stylesheet" type="text/css"/>-->
        <link href="estilos/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Facturación</title>
    </head>
    <body>
        <div id="agrupar">
            <header id="encabezado">
                <h1>Facturación</h1>
            </header>
            <br/>
            <section>
                <%
                    clsEntidadFactura vlo_Factura = new clsEntidadFactura();
                    Date fecha = new Date();
                    java.sql.Date fechasql = new java.sql.Date(fecha.getTime());
                    vlo_Factura.setFecha(fechasql);
                    String sentencia = "";
                    if (request.getParameter("txtNumFactura") != null) {
                        sentencia = "NUM_FACTURA=" + Integer.parseInt(request.getParameter("txtNumFactura"));
                        clsLogicaFacturas vloLogicaF = new clsLogicaFacturas();
                        vlo_Factura = vloLogicaF.ObtenerRegistro(sentencia);
                    }
                %>
                <form action="Factura" method="post">
                    <table style="width: 100%">
                        <tr>
                            <td><strong>Factura No.</strong> &nbsp; 
                                <input type="text" name="txtNumFactura" value="<%= vlo_Factura.getNumFactura()%>" readonly/>
                            </td>
                            <td><strong>Fecha Facturación &nbsp;</strong>
                                <input type="text" name="txtFechaFactura" id="datepicker"value="<%= vlo_Factura.getFecha()%>" required/> 
                            </td>
                        </tr>
                        <tr>
                            <td><strong>Seleccione el Cliente</strong>&nbsp;
                                <input type="hidden" id="txtIdCliente" name="txtIdCliente" value="<%= vlo_Factura.getIdCliente()%>" required/>
                                <%
                                    String NombreCliente = "";
                                    if (vlo_Factura.getIdCliente() > 0) {
                                        clsLogicaCliente vlo_LogicaCliente = new clsLogicaCliente();
                                        clsEntidadCliente vlo_EC = vlo_LogicaCliente.ObtenerRegistro("ID_CLIENTE=" + vlo_Factura.getIdCliente());
                                        NombreCliente = vlo_EC.getVgc_Nombre();
                                    }
                                %>
                                <input type="text" id="txtNombreCliente" name="txtNombreCliente" style="width: 200px" value="<%= NombreCliente%>"/> 

                                <a id="btnBuscarCliente" href="#"><img src="images/Buscar_Cliente.png" title="Buscar Cliente"/></a>
                            </td>
                        </tr>
                    </table>
                    <br>
                    <hr/>
                    <br>
                    <table style="width: 100%">
                        <tr>
                            <td>Cod.Producto &nbsp; 
                                <input type="text" name="txtIdProducto" id="txtIdProducto" value="" size="5" required/> &nbsp;
                                <a id="btnBuscarProducto" href="#"><img src="images/buscar.png" title="Buscar Producto"/></a>
                            </td>
                            <td>Descripción &nbsp;<input type="text" name="txtdescripcion" id="txtdescripcion" size="25" required/> </td>
                            <td>Cantidad &nbsp; <input type="number" name="txtcantidad" id="txtcantidad" min="1" max="100" value="1" required /></td>
                            <td>Precio &nbsp;<input type="text" name="txtprecio" id="txtprecio" size="8" required/> </td>
                        </tr>
                    </table>
                    <br>
                    <hr/>
                    <br>
                    <input type="submit" value="Agregar" name="btnAgregar">
                </form>
            </section>
            <section>
                <h2>Detalle de factura</h2>
                <table id="DetalleFactura" class="tablaBasica">
                    <thead>
                        <tr id="titulos">
                            <th style="text-align: center">Código</th>
                            <th style="text-align: center">Descripción</th>
                            <th style="text-align: center">Cantidad</th>
                            <th style="text-align: center">Precio</th>
                            <th style="text-align: center">&nbsp;&nbsp</th>
                            <th style="text-align: center">&nbsp;&nbsp</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%

                            clsLogicaDetalleFactura vlo_Detalle = new clsLogicaDetalleFactura();
                            ResultSet vlo_RS_Detalle;
                            String condicion = "";
                            boolean HayDatos = false;
                            if (request.getParameter("txtNumFactura") != null) {
                                condicion = "NUM_FACTURA=" + Integer.parseInt(request.getParameter("txtNumFactura"));
                            } else {
                                condicion = "NUM_FACTURA=-1";
                            }
                            vlo_RS_Detalle = vlo_Detalle.listar(condicion, "");
                            while (vlo_RS_Detalle.next()) {
                        %>
                        <tr>
                            <%
                                HayDatos = true;
                                int numfactura = vlo_RS_Detalle.getInt(1);
                                int codigop = vlo_RS_Detalle.getInt(2);
                                String descripcion = vlo_RS_Detalle.getString(3);
                                int cantidad = vlo_RS_Detalle.getInt(4);
                                double precioV = vlo_RS_Detalle.getDouble(5);%>
                            <td style="text-align: left"><%= codigop%></td>
                            <td style="text-align: left"><%= descripcion%></td>
                            <td style="text-align: left"><%= cantidad%></td>
                            <td style="text-align: left"><%= precioV%></td>
                            <td style="text-align: center">
                                <a href="EliminarDetalle?id=<%=codigop%>&factura=<%=numfactura%>">
                                    Eliminar
                                </a>
                            </td>

                        </tr>
                        <%
                            }
                            if (!HayDatos) {%>
                        <tr>
                            <td>&nbsp;</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <%}
                        %>
                    </tbody>
                </table>
                <br><br>
                <input type="button" id="BtnCancelar" value="Cancelar Factura" onclick="location.href = 'CancelarFactura?txtNumFactura=' +<%= vlo_Factura.getNumFactura()%>"/>
            </section>
            <a href="index.html">Regresar al index</a>
        </div>
        <div id="dialog" title="Buscar Cliente">
            <table id="tablaClientes" class="display">
                <thead>
                    <tr>
                        <th style="text-align: center">Código</th>
                        <th style="text-align: center">Nombre</th>
                        <th style="text-align: center">&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        clsLogicaCliente vlo_Clientes = new clsLogicaCliente();
                        ResultSet vlo_datos;
                        vlo_datos = vlo_Clientes.listar("", "");
                        while (vlo_datos.next()) {
                    %>
                    <tr>
                        <%int codigo = vlo_datos.getInt(1);
                            String nombre = vlo_datos.getString(2);%>
                        <td style="text-align: left"><%= codigo%></td>
                        <td style="text-align: left"><%= nombre%></td>
                        <td style="text-align: center">
                            <a href="#" onclick="SeleccionarCliente('<%=codigo%>', '<%= nombre%>');">
                                Seleccionar
                            </a>
                        </td>

                    </tr>
                    <%}%>
                </tbody>  
            </table>
        </div>
        <div id="dialogProductos" title="Buscar Productos">
            <table id="tablaProductos" class="display">
                <thead>
                    <tr>
                        <th style="text-align: center">Código</th>
                        <th style="text-align: center">Descripción</th>
                        <th style="text-align: center">Precio</th>
                        <th style="text-align: center">&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp</th>
                    </tr>
                </thead>
                <tbody>
                    <%

                        clsLogicaProductos vlo_Productos = new clsLogicaProductos();
                        vlo_datos = vlo_Productos.listar("", "");
                        while (vlo_datos.next()) {
                    %>


                    <tr>
                        <%int codigop = vlo_datos.getInt(1);
                            String descripcion = vlo_datos.getString(2);
                            double precioV = vlo_datos.getDouble(3);%>
                        <td style="text-align: left"><%= codigop%></td>
                        <td style="text-align: left"><%= descripcion%></td>
                        <td style="text-align: left"><%= precioV%></td>
                        <td style="text-align: center">
                            <a href="#" onclick="SeleccionarProducto('<%=codigop%>', '<%= descripcion%>', '<%= precioV%>');">
                                Seleccionar
                            </a>
                        </td>

                    </tr>
                    <%}%>
                </tbody>  
            </table>
        </div>

        <script src="Scripts/jquery.js" type="text/javascript"></script>
        <script src="Scripts/jquery-ui.js" type="text/javascript"></script>
        <script src="Scripts/jquery.dataTables.js" type="text/javascript"></script>

        <script>
                                //hacer que la lista de clientes se comporte como un datatable
                                $(document).ready(function () {
                                    $('#tablaClientes').dataTable({
                                        "lengthMenu": [[5, 15, 15, -1], [5, 10, 15, "All"]],
                                        "language": {
                                            "info": "Mostrando página _PAGE_ de _PAGES_",
                                            "infoEmpty": "No existen Registros disponibles",
                                            "zeroRecords": "No se encuentran registros",
                                            "search": "Buscar",
                                            "infoFiltered": "",
                                            "lengthMenu": "Mostrar _MENU_ Registros",
                                            "paginate": {
                                                "first": "Primero",
                                                "last": "Último",
                                                "next": "Siguiente",
                                                "previous": "Anterior"
                                            }

                                        }
                                    });

                                });
                                //hacer que la lista de productos se comporte como un datatable
                                $(document).ready(function () {
                                    $('#tablaProductos').dataTable({
                                        "lengthMenu": [[5, 15, 15, -1], [5, 10, 15, "All"]],
                                        "language": {
                                            "info": "Mostrando página _PAGE_ de _PAGES_",
                                            "infoEmpty": "No existen Registros disponibles",
                                            "zeroRecords": "No se encuentran registros",
                                            "search": "Buscar",
                                            "infoFiltered": "",
                                            "lengthMenu": "Mostrar _MENU_ Registros",
                                            "paginate": {
                                                "first": "Primero",
                                                "last": "Último",
                                                "next": "Siguiente",
                                                "previous": "Anterior"
                                            }

                                        }
                                    });

                                });
                                //mostrar calendario
                                $(function () {
                                    $("#datepicker").datepicker({
                                        showOn: "button",
                                        buttonImage: "images/Calendar.png",
                                        buttonImageOnly: true,
                                        dateFormat: "yy-mm-dd",
                                        buttonText: "Seleccione una fecha"
                                    });
                                });
                                //mostrar clientes
                                $(function () {
                                    $("#dialog").dialog({
                                        autoOpen: false,
                                        modal: true,
                                        resizable: true,
                                        width: 500
                                    });

                                    $("#btnBuscarCliente").click(function () {
                                        $("#dialog").dialog("open");
                                    });
                                });
                                //Mostrar Productos

                                $(function () {
                                    $("#dialogProductos").dialog({
                                        autoOpen: false,
                                        modal: true,
                                        resizable: true,
                                        width: 500
                                    });

                                    $("#btnBuscarProducto").click(function () {
                                        $("#dialogProductos").dialog("open");
                                    });
                                });
                                //seleccionar cliente
                                function SeleccionarCliente(idCliente, nombreCliente) {
                                    $("#txtIdCliente").val(idCliente);
                                    $("#txtNombreCliente").val(nombreCliente);
                                    $("#dialog").dialog("close");
                                }
                                //seleccionar producto
                                function SeleccionarProducto(idProducto, Descripcion, Precio) {
                                    $("#txtIdProducto").val(idProducto);
                                    $("#txtdescripcion").val(Descripcion);
                                    $("#txtprecio").val(Precio);
                                    $("#dialogProductos").dialog("close");
                                }

        </script>
    </body>
</html>

