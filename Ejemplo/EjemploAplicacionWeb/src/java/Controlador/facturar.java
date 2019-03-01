/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import entidades.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.*;

/**
 *
 * @author Thomas Chevez
 */
public class facturar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            clsLogicaFacturas vlo_Logica = new clsLogicaFacturas();
            clsLogicaDetalleFactura vlo_LogicaD = new clsLogicaDetalleFactura();
            clsEntidadFactura vlo_EntidadFactura = new clsEntidadFactura();
            clsEntidadDetalleFactura vlo_EntidadDetalle = new clsEntidadDetalleFactura();
            int vln_resultado;
            vlo_EntidadFactura.setNumFactura(Integer.parseInt(request.getParameter("txtNumFactura")));
            SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
            String fechaString = request.getParameter("txtFechaFactura");
            Date fecha = formato.parse(fechaString);
            java.sql.Date fechasql = new java.sql.Date(fecha.getTime());
            vlo_EntidadFactura.setFecha(fechasql);
            vlo_EntidadFactura.setIdCliente(Integer.parseInt(request.getParameter("txtIdCliente")));
            vlo_EntidadFactura.setEstado("Pendiente");
            vln_resultado = vlo_Logica.guardar(vlo_EntidadFactura).getNumFactura();
            vlo_EntidadDetalle.setNumFactura(vln_resultado);
            vlo_EntidadDetalle.setIdProducto(Integer.parseInt(request.getParameter("txtIdProducto")));
            vlo_EntidadDetalle.setCantidad(Integer.parseInt(request.getParameter("txtcantidad")));
            vlo_EntidadDetalle.setPrecio(Double.parseDouble(request.getParameter("txtprecio")));
            vlo_LogicaD.guardar(vlo_EntidadDetalle);
            response.sendRedirect("frm_Facturacion.jsp?txtNumFactura=" + vln_resultado);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(facturar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(facturar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
