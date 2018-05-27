package TEST;

import DTO.ConsultaDto;
import DAO_IMP.ConsultaDaoImp;
import java.security.Principal;
import java.sql.Date;

/**
 *
 * @author andres
 */
public class testConsulta {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Principal.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConsultaDaoImp implementacionConsulta = new ConsultaDaoImp();
        ConsultaDto nueva = new ConsultaDto();
        nueva.setIdServicio(1);
        nueva.setFecha(new Date(0));
        nueva.setEstado("agendada");
        nueva.setRutCliente("18.876.827-3");
        nueva.setRutTrabajador("11.756.660-9");
        log.info("Nueva consulta: "+nueva.toString());
        implementacionConsulta.agregar(nueva);
        log.info("Agregada! revisar en bd si se descontaron insumos");
        
//        log.info("Actualizando estado");
//        nueva.setIdConsulta(implementacionConsulta.ultimoId());
//        nueva.setEstado("cancelada");
//        implementacionConsulta.modificar(nueva);
//        log.info("Modificado! revisar bd si volvieron insumos");
    }

}
