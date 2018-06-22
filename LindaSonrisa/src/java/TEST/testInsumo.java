package TEST;

import DTO.InsumoDto;
import DTO.DetalleInsumoDto;
import DAO_IMP.InsumoDaoImp;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andres
 */
public class testInsumo {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Principal.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InsumoDaoImp implementacion = new InsumoDaoImp();
        try {
            //
//        InsumoDto nuevo = new InsumoDto(0, "Tornillo", 10, 15, 100);
//        log.info("Insumo nuevo y listo a agregar : " + nuevo.toString());
//        implementacion.agregar(nuevo);
//        log.info("Buscando recien insertado...");
//        InsumoDto aux = new InsumoDto(implementacion.ultimoId(), " ", 0, 0, 0);
//        implementacion.buscar(aux).toString();
//
//        log.info("Modificando descripcion");
//        aux.setDescripcion("Tornillo 35mm");
//        implementacion.modificar(aux);
//        log.info("Modificado: " + implementacion.buscar(aux).toString());
//        log.info("listando todos");
//        for (InsumoDto listado : implementacion.listar()) {
//            log.info("Listado: " + listado.toString());
//
//        }
//        log.info("listando criticos");
//        for (InsumoDto listado : implementacion.buscarCriticos()) {
//            log.info("Listado: " + listado.toString());
//
//        }
            java.util.Date fechaUtil = new SimpleDateFormat("yyyy-MM-dd").parse("2018-06-22");
            Calendar calendario = new GregorianCalendar();
            Calendar calendarioToday = new GregorianCalendar();
            calendario.setTimeInMillis(fechaUtil.getTime());
            int diaSeleccionado = calendario.get(Calendar.DAY_OF_MONTH);
            int mesSeleccionado = calendario.get(Calendar.MONTH);
            int annoSeleccionado = calendario.get(Calendar.YEAR);
            System.out.println("dia : "+diaSeleccionado);
            System.out.println("Mes : "+mesSeleccionado);
            System.out.println("Año: "+annoSeleccionado);
            
            if(diaSeleccionado==calendarioToday.get(Calendar.DAY_OF_MONTH)&&mesSeleccionado==calendarioToday.get(Calendar.MONTH)){
                System.out.println("Son iguales y se pueden comparar");
            }else{
                System.out.println("no se comparan");
                System.out.println("fecha "+fechaUtil);
                System.out.println("fecha sistema "+new Date());
            }
        } catch (ParseException ex) {
            Logger.getLogger(testInsumo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
