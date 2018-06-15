package SERVLET;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DAO_IMP.ClienteDaoImp;
import DAO_IMP.ConsultaDaoImp;
import DTO.ClienteDto;
import DTO.ConsultaDto;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author andres
 */
@WebServlet(name = "loginConRut", urlPatterns = {"/loginConRut"})
public class loginConRut extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            //abrimos una sesion
            HttpSession session = request.getSession();
            session.setAttribute("mj", null);
            session.setAttribute("rut", request.getParameter("txtRut"));
            //cliente aux
            if (session.getAttribute("cliente") != null) {
                ClienteDto aux = (ClienteDto) session.getAttribute("cliente");
                //osea que ya estamos recibiendo contraseña
                //crearemos un atributo para informar que el logeo se hiso de forma correcta
                String pass = request.getParameter("txtPass");
                //ciframos contraseña del formulario y la comprobamos con la acutal
                if (aux.getContrasenia().equals(DigestUtils.md5Hex(pass))) {
                    //ahora se debera comprobar si este atributo existe en la sesion
                    if (aux.isHabilitado()) {
                        //comprobamos si tengo una consulta agendadda hasta el momento
                        ConsultaDto consulta = new ConsultaDaoImp().consultaPendienteCliente(aux.getRut());
                        
                        if (null == consulta) {
                            session.setAttribute("acceso", 1);
                            response.sendRedirect("PAGES/EspecialidadDoctor.jsp");
                        } else {
                            session.setAttribute("acceso", 1);
                            session.setAttribute("consulta", consulta);
                            response.sendRedirect("PAGES/InformacionConsulta.jsp");
                        }

                    } else {

                        session.setAttribute("acceso", 0);
                        response.sendRedirect("PAGES/IngresarRut.jsp");
                    }
                } else {
                    session.setAttribute("acceso", 0);
                    response.sendRedirect("PAGES/IngresarRut.jsp");
                }
            } else {
                ClienteDto clienteAux = new ClienteDto();
                clienteAux.setRut((String) session.getAttribute("rut"));
                clienteAux.setHabilitado(false);
                clienteAux = new ClienteDaoImp().buscar(clienteAux);
                if (clienteAux.isHabilitado()) {
                    session.setAttribute("cliente", clienteAux);
                    response.sendRedirect("PAGES/IngresarRut.jsp");
                } else if (!clienteAux.isHabilitado() && clienteAux.getNombre() != null) {
                    session.setAttribute("mj", "Su usuario esta deshabilitado");
                    response.sendRedirect("PAGES/IngresarRut.jsp");
                } else {
                    response.sendRedirect("PAGES/RegistroCliente.jsp");
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
