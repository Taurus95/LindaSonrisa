/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;

import DAO_IMP.ClienteDaoImp;
import DAO_IMP.ConsultaDaoImp;
import DAO_IMP.ServicioDaoImp;
import DAO_IMP.TrabajadorDaoImp;
import DTO.ConsultaDto;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "boletaConsulta", urlPatterns = {"/boletaConsulta"})
public class boletaConsulta extends HttpServlet {

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
            if (session.getAttribute("consulta") == null) {
                session.invalidate();
                response.sendRedirect("index.html");
                return;
            }
            if ((int) session.getAttribute("acceso") == 1) {
                ConsultaDto consulta = (ConsultaDto) session.getAttribute("consulta");
                int descuento = Integer.parseInt(request.getParameter("descuento"));
                if (consulta.getEstado().equalsIgnoreCase("Pendiente")) {
                    consulta.setTotal(consulta.getTotal() - descuento);
                    consulta.setEstado("Realizada");
                } else {
                    response.sendRedirect("PAGES/DetalleConsultaSecretaria.jsp");
                    return;
                }
                if (new ConsultaDaoImp().modificar(consulta)) {
                    //crear exel ("BOLETA")
                    response.setContentType("application/vnd.ms-excel");
                    response.setHeader("Content-disposition", "filename=boleta.xls");
                    //             PrintWriter out = response.getWriter();
                    String minuto = " ";
                    try {
                        out.println("Boleta Consulta\t" + consulta.getFecha());
                        out.println("Cliente:\t" + new ClienteDaoImp().buscarNombre(consulta.getRutCliente()));
                        out.println("Dentista:\t" + new TrabajadorDaoImp().buscarNombre(consulta.getRutTrabajador()));
                        if (consulta.getMinuto() == 0) {
                            minuto = "00";
                        } else {
                            minuto = "30";
                        }
                        out.println("Hora:\t" + consulta.getHora() + " : " + minuto);
                        out.println("Servicio:\t" + new ServicioDaoImp().buscarNombre(consulta.getIdServicio()));
                        out.println("Precio:\t $" + new ServicioDaoImp().buscarPrecio(consulta.getIdServicio()));
                        out.println("Descuento:\t $" + descuento);
                        out.println("Total:\t $" + consulta.getTotal());
                    } finally {
                        out.close();
                        response.sendRedirect("PAGES/DetalleConsultaSecretaria.jsp");
                    }
                } else {
                    response.sendRedirect("index.html");
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
