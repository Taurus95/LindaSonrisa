/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import org.apache.commons.codec.digest.DigestUtils;
import static org.apache.taglibs.standard.functions.Functions.trim;

/**
 *
 * @author andres
 */
@WebServlet(name = "registrarClienteSecretaria", urlPatterns = {"/registrarClienteSecretaria"})
public class registrarClienteSecretaria extends HttpServlet {

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
            nuevo.setRut((String) request.getParameter("txtRut"));            
            nuevo.setNombre(trim((String)request.getParameter("txtNombre")));
            nuevo.setCorreo(trim((String) request.getParameter("txtCorreo")));
            System.out.println("INFO-> "+nuevo.toString());
            nuevo.setHabilitado(true);
            nuevo.setTelefono(trim((String) request.getParameter("txtTelefono")));
            nuevo.setContrasenia(DigestUtils.md5Hex(trim((String) request.getParameter("txtContrasenia"))));
            nuevo.setSexo(trim((String) request.getParameter("cmbSexo")));
            nuevo.setDireccion((String) request.getParameter("txtDireccion"));
            //try para agregar fecha 
            try {
                java.util.Date fechaUtil = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("calNacimiento"));
                java.sql.Date fecha = new java.sql.Date(fechaUtil.getTime());
                nuevo.setFechaNacimiento(fecha);
            } catch (ParseException ex) {
                Logger.getLogger(nuevoCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(nuevo);
            if (!new ClienteDaoImp().comprobar(nuevo.getRut())) {
                if (new ClienteDaoImp().agregar(nuevo)) {
                    //agregar ficha social si existe
                    session.setAttribute("ms", "Cliente registrado!");
                    response.sendRedirect("PAGES/HomeSecretaria.jsp");
                } else {
                    session.setAttribute("ms", "No se pudo registrar, contactar admin");
                    response.sendRedirect("PAGES/HomeSecretaria.jsp");
                }
            } else {
                if (new ClienteDaoImp().modificar(nuevo)) {
                    session.setAttribute("ms", "Ya existe registro para el rut ingresado, los datos fueron actualizados!");
                   response.sendRedirect("PAGES/HomeSecretaria.jsp");
                } else {
                    session.setAttribute("ms", "Ya existe registro para el rut ingresado!");
                    response.sendRedirect("PAGES/RegistroClientesecretaria.jsp");
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
