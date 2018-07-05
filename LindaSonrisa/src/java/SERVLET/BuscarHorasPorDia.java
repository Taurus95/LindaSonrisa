package SERVLET;

import DAO_IMP.ConsultaDaoImp;
import DTO.ConsultaDto;
import DTO.HorasAldia;
import DTO.TrabajadorDto;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
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
            if (session.getAttribute("acceso") == null || (int) session.getAttribute("acceso") != 1) {
                session.invalidate();
                response.sendRedirect("index.html");
                return;
            }
            //variables
            //horas de trabajo
            List<Integer> horas = new ArrayList<>();
            horas.add(9);
            horas.add(10);
            horas.add(11);
            horas.add(12);
            horas.add(13);
            horas.add(14);
            horas.add(15);
            horas.add(16);
            horas.add(17);
            //int horas[] = {9, 10, 11, 12, 14, 15, 16, 17};
            //minutos
            int minutos[] = {0, 30};
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
                //tenemos que comprobar si el dia es el actual, por lo tanto las horas solo seran desde la hora actual en adelan
                Calendar calendario = new GregorianCalendar();
                Calendar calendarioToday = new GregorianCalendar();
                calendario.setTimeInMillis(fechaUtil.getTime());
                int diaSeleccionado = calendario.get(Calendar.DAY_OF_MONTH);
                int mesSeleccionado = calendario.get(Calendar.MONTH);
                int annoSeleccionado = calendario.get(Calendar.YEAR);
                //si el dia corresponde al dia actual se comparan horas
                if (diaSeleccionado == calendarioToday.get(Calendar.DAY_OF_MONTH) && mesSeleccionado == calendarioToday.get(Calendar.MONTH)
                        && annoSeleccionado == calendarioToday.get(Calendar.YEAR)) {
                    int hora = calendarioToday.get(Calendar.HOUR_OF_DAY);
                    int minuto = calendarioToday.get(Calendar.MINUTE);
                    List<Integer> horasAux = new ArrayList<>();
                    for (int aux : horas) {
                        if (aux > hora) {
                            horasAux.add(aux);
                        }
                    }
                    horas = horasAux;
                }

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

                if (session.getAttribute("trabajador") != null) {
                    if (horasDisponibles.isEmpty()) {
                        session.setAttribute("msj", "No hay horas disponibles para tal dia, porfavor selecciona otro.");
                        response.sendRedirect("PAGES/BuscarHoraSecretaria.jsp");
                    }else{
                        response.sendRedirect("PAGES/BuscarHoraSecretaria.jsp#about");
                    }
                } else if (session.getAttribute("cliente") != null) {
                    if (horasDisponibles.isEmpty()) {
                        session.setAttribute("msj", "No hay horas disponibles para tal dia, porfavor selecciona otro.");
                        response.sendRedirect("PAGES/AgendarHora.jsp");
                    }else{
                        response.sendRedirect("PAGES/AgendarHora.jsp#about");
                    }
                    
                }

            } catch (ParseException ex) {
                System.out.println("Error en servlet parsenado fecha");
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
