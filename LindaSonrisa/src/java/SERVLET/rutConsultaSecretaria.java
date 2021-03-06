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
import DAO_IMP.ClienteDaoImp;
import DAO_IMP.ConsultaDaoImp;
import DTO.ClienteDto;
import DTO.ConsultaDto;
import javax.servlet.http.HttpSession;

/**
 *
 * @author andres
 */
@WebServlet(name = "rutConsultaSecretaria", urlPatterns = {"/rutConsultaSecretaria"})
public class rutConsultaSecretaria extends HttpServlet {

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
            if (!new ClienteDaoImp().comprobar(rut)) {
                session.setAttribute("mj", "El cliente necesita registro");
                response.sendRedirect("PAGES/RegistrarClienteSecretaria.jsp");
            } else {
                ConsultaDto consulta = new ConsultaDaoImp().consultaPendienteCliente(rut);
                if (null == consulta) {
                    ClienteDto aux = new ClienteDto();
                    aux.setRut(rut);
                    aux = new ClienteDaoImp().buscar(aux);
                    if (aux != null && aux.isHabilitado()) {
                        session.setAttribute("cliente", aux);
                        response.sendRedirect("PAGES/ServicioYdentistaSecretaria.jsp");
                    } else {
                        session.setAttribute("mj", "El cliente necesita registro");
                        response.sendRedirect("PAGES/AgendarConsultaSecretaria.jsp");
                    }
                } else {
                    session.setAttribute("consulta", consulta);
                    response.sendRedirect("PAGES/DetalleConsultaSecretaria.jsp");
                }
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
