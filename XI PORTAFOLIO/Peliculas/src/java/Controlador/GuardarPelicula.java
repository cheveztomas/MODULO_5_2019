/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.ClsPeliculas;
import Entidades.ClsRetorno;
import Logica.LogicaPeliculas;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thomas Chevez
 */
public class GuardarPelicula extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //Variables
            ClsRetorno vlo_Retorno;
            ClsPeliculas vlo_Pelicula = new ClsPeliculas();
            LogicaPeliculas vlo_LogicaPeliculas = new LogicaPeliculas();

            //Inicio
            try {
                vlo_Pelicula.setVgc_titulo(request.getParameter("txt_Titulo"));
                vlo_Pelicula.setVgd_fecha(new java.sql.Date(Date.valueOf(request.getParameter("txt_Fecha")).getTime()));
                vlo_Pelicula.setVgn_duracion(Integer.parseInt(request.getParameter("txt_Duracion")));
                vlo_Pelicula.setVgn_idPelicula(Integer.parseInt(request.getParameter("txt_idPelicula")));
                vlo_Retorno = vlo_LogicaPeliculas.GuardarPelicula(vlo_Pelicula);
                response.sendRedirect("Peliculas.jsp?msj=" + vlo_Retorno.getVgc_Mensaje() + "&idPelicula=" + vlo_Retorno.getVgn_id());
            } catch (Exception e) {
                response.sendRedirect("Peliculas.jsp?msj=" + e.getMessage() + "Error al tratar de realizar acción.");
            }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
