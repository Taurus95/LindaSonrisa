package SERVLET;

import DAO_IMP.ClienteDaoImp;
import DTO.ClienteDto;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.apache.taglibs.standard.functions.Functions.trim;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author andres
 */
@WebServlet(name = "nuevoCliente", urlPatterns = {"/nuevoCliente"})
public class nuevoCliente extends HttpServlet {

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
            ClienteDto nuevo = new ClienteDto();
            nuevo.setRut((String) session.getAttribute("rut"));
            nuevo.setNombre(trim((String) request.getParameter("txtNombre")));
            nuevo.setCorreo(trim((String) request.getParameter("txtCorreo")));
            nuevo.setHabilitado(true);
            nuevo.setTelefono(trim((String) request.getParameter("txtTelefono")));
            nuevo.setContrasenia(DigestUtils.md5Hex(trim((String) request.getParameter("txtContrasenia"))));
            nuevo.setSexo(trim((String) request.getParameter("cmbSexo")));
            nuevo.setDireccion((String) request.getParameter("txtDireccion"));
            System.out.println("nuevo " + nuevo.toString());
            //try para agregar fecha 
            try {
                java.util.Date fechaUtil = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("calNacimiento"));
                java.sql.Date fecha = new java.sql.Date(fechaUtil.getTime());
                nuevo.setFechaNacimiento(fecha);
            } catch (ParseException ex) {
                Logger.getLogger(nuevoCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (new ClienteDaoImp().agregar(nuevo)) {
                session.setAttribute("cliente", nuevo);
                session.setAttribute("acceso", 1);
                response.sendRedirect("PAGES/EspecialidadDoctor.jsp");
            } else {
                session.invalidate();
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
