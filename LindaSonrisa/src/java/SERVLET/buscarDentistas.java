package SERVLET;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DTO.TrabajadorDto;
import DAO_IMP.TrabajadorDaoImp;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author andres
 */
@WebServlet(name = "buscarDentistas", urlPatterns = {"/buscarDentistas"})
public class buscarDentistas extends HttpServlet {

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
            if (session.getAttribute("acceso") == null) {
                session.invalidate();
                response.sendRedirect("index.html");
                return;
            }
            if ((int) session.getAttribute("acceso") == 1) {
                String especialidad = request.getParameter("especialidad");
                ArrayList<TrabajadorDto> lista = (ArrayList<TrabajadorDto>) new TrabajadorDaoImp().listarDentistaEspecialidad(especialidad);
                session.setAttribute("especialidad", especialidad);
                session.setAttribute("dentistas", lista);
                if (session.getAttribute("trabajador") != null) {
                    response.sendRedirect("PAGES/ServicioYdentistaSecretaria.jsp");
                } else if (session.getAttribute("cliente") != null) {
                    response.sendRedirect("PAGES/EspecialidadDoctor.jsp");
                }
            } else {
                session.invalidate();
                response.sendRedirect("index.html");
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
