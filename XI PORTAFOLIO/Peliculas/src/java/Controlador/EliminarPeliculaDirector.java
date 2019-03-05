/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidades.ClsPeliculasDirectores;
import Entidades.ClsRetorno;
import Logica.LogicaPeliculasDirectores;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thomas Chevez
 */
public class EliminarPeliculaDirector extends HttpServlet {

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
            //Varaibles
            ClsRetorno vlo_Retorno;
            LogicaPeliculasDirectores vlo_LogicaPeliculasDirectores = new LogicaPeliculasDirectores();
            ClsPeliculasDirectores vlo_PeliculasDirectores = new ClsPeliculasDirectores();

            //Inicio
            try {
                vlo_PeliculasDirectores.setVgn_idDirector(Integer.parseInt(request.getParameter("idDirector")));
                vlo_PeliculasDirectores.setVgn_idPelicula(Integer.parseInt(request.getParameter("idPelicula")));
                vlo_Retorno = vlo_LogicaPeliculasDirectores.EliminarDirectorPelicula(vlo_PeliculasDirectores);
                response.sendRedirect("Peliculas.jsp?idPelicula="+vlo_PeliculasDirectores.getVgn_idPelicula()+"&msj="+vlo_Retorno.getVgc_Mensaje());
            } catch (Exception e) {
                response.sendRedirect("Peliculas.jsp?idPelicula="+vlo_PeliculasDirectores.getVgn_idPelicula()+"&msj="+e.getMessage()+" Error al realizar acción.");
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
