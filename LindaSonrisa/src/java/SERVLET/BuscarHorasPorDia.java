package SERVLET;

import DAO_IMP.ConsultaDaoImp;
import DTO.ClienteDto;
import DTO.ConsultaDto;
import DTO.HorasAldia;
import DTO.TrabajadorDto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
@WebServlet(name = "BuscarHorasPorDia", urlPatterns = {"/BuscarHorasPorDia"})
public class BuscarHorasPorDia extends HttpServlet {

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
                //obtenemos dentista para buscar sus horas disponibles
                TrabajadorDto dentista = (TrabajadorDto) session.getAttribute("dentista");
                try {
                    //obtenemos fecha para la cual buscaremos horas disponibles
                    java.util.Date fechaUtil = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateDia"));
                    java.sql.Date fecha = new java.sql.Date(fechaUtil.getTime());
                    session.setAttribute("fecha", fecha);
                    //horas ocupadas para tal dentista en tal hora
                    ArrayList<ConsultaDto> horasOcupadas = (ArrayList<ConsultaDto>) new ConsultaDaoImp().listarPorDiaDoctor(dentista.getRut(), fecha);
                    //lista donde agregar horas disponibles
                    ArrayList<HorasAldia> horasDisponibles = new ArrayList<>();
                    //horas de trabajo
                    int horas[] = {9, 10, 11, 12, 13, 14, 15, 16, 17};
                    //minutos
                    int minutos[] = {0, 31};
                    //para todas las horas del dia
                    for (int hora : horas) {
                        for (int minuto : minutos) {
                            HorasAldia horaConsulta = new HorasAldia(hora, minuto, "Disponible", dentista.getNombre());
                            if (!horasOcupadas.isEmpty()) {
                                for (ConsultaDto consulta : horasOcupadas) {
                                    //si la hora se encuentra dentro de una consulta ya creada se cambia estado
                                    if (consulta.getHora() == hora && consulta.getMinuto() == minuto) {
                                        horaConsulta.setEstado("Ocupada");
                                        break;
                                    }
                                }
                            }
                            horasDisponibles.add(horaConsulta);
                        }
                    }
                    //se agrega la lista con horas disponibles a la session
                    session.setAttribute("horasDisponibles", horasDisponibles);
                    response.sendRedirect("PAGES/AgendarHora.jsp");
                } catch (ParseException ex) {
                    System.out.println("Error en servlet parsenado fecha");
                }
            } else {
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
