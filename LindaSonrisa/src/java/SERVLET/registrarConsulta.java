package SERVLET;

import DAO_IMP.ConsultaDaoImp;
import DAO_IMP.ServicioDaoImp;
import DTO.ClienteDto;
import DTO.ConsultaDto;
import DTO.ServicioDto;
import DTO.TrabajadorDto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author andres
 */
@WebServlet(name = "registrarConsulta", urlPatterns = {"/registrarConsulta"})
public class registrarConsulta extends HttpServlet {

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
            if ((int) session.getAttribute("acceso") == 1) {
                ClienteDto cliente = (ClienteDto) session.getAttribute("cliente");
                TrabajadorDto dentista = (TrabajadorDto) session.getAttribute("dentista");
                ServicioDto servicio = new ServicioDaoImp().buscarIdServicio((String) session.getAttribute("especialidad"));
                Date fecha = (Date) session.getAttribute("fecha");
                int hora = Integer.parseInt(request.getParameter("hora"));
                int minuto = Integer.parseInt(request.getParameter("minutos"));
                ConsultaDto nuevaConsulta = new ConsultaDto();
                nuevaConsulta.setIdServicio(servicio.getIdServicio());
                nuevaConsulta.setFecha(fecha);
                nuevaConsulta.setEstado("Pendiente");
                nuevaConsulta.setHora(hora);
                nuevaConsulta.setMinuto(minuto);
                nuevaConsulta.setRutCliente(cliente.getRut());
                nuevaConsulta.setRutTrabajador(dentista.getRut());
                nuevaConsulta.setTotal(servicio.getPrecio());
                if (new ConsultaDaoImp().agregar(nuevaConsulta)) {
                    session.setAttribute("consulta", nuevaConsulta);
                    response.sendRedirect("PAGES/InformacionConsulta.jsp");
                }
            } else {
                response.sendRedirect("PAGES/Home.jsp");
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
