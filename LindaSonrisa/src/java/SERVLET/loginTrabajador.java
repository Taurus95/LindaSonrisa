/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DAO_IMP.TrabajadorDaoImp;
import DTO.TrabajadorDto;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author andres
 */
@WebServlet(name = "loginTrabajador", urlPatterns = {"/loginTrabajador"})
public class loginTrabajador extends HttpServlet {

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
            HttpSession session = request.getSession();
            String rut = request.getParameter("txtRut");
            String pass = DigestUtils.md5Hex(request.getParameter("pass"));
            TrabajadorDaoImp implement = new TrabajadorDaoImp();
            TrabajadorDto trabajador = new TrabajadorDto();
            trabajador.setRut(rut);
            trabajador.setHabilitado(false);
            //trabajador = implement.buscar(trabajador);
            if (trabajador.isHabilitado()) {
                if (trabajador.getContrasenia().equals(pass)) {
                    session.setAttribute("trabajador", trabajador);
                    if (trabajador.getTipo().equalsIgnoreCase("Secretaria")) {
                        response.sendRedirect("PAGES/HomeSecretaria.jsp");
                    }
                    if (trabajador.getTipo().equalsIgnoreCase("dentista")) {
                        response.sendRedirect("PAGES/HomeDentista.jsp");
                    }
                } else {
                    session.setAttribute("msg", "error");
                    response.sendRedirect("PAGES/ingresarTrabajador.jsp");
                }
            } else {
                session.setAttribute("msg", "error");
                response.sendRedirect("PAGES/ingresarTrabajador.jsp");
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