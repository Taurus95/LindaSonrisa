package TEST;

import DTO.InsumoDto;
import DTO.DetalleInsumoDto;
import DAO_IMP.InsumoDaoImp;
import java.security.Principal;

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

        InsumoDto nuevo = new InsumoDto(0, "Tornillo", 10, 15, 100);
        log.info("Insumo nuevo y listo a agregar : " + nuevo.toString());
        implementacion.agregar(nuevo);
        log.info("Buscando recien insertado...");
        InsumoDto aux = new InsumoDto(implementacion.ultimoId(), " ", 0, 0, 0);
        implementacion.buscar(aux).toString();

        log.info("Modificando descripcion");
        aux.setDescripcion("Tornillo 35mm");
        implementacion.modificar(aux);
        log.info("Modificado: " + implementacion.buscar(aux).toString());
        log.info("listando todos");
        for (InsumoDto listado : implementacion.listar()) {
            log.info("Listado: " + listado.toString());

        }
        log.info("listando criticos");
        for (InsumoDto listado : implementacion.buscarCriticos()) {
            log.info("Listado: " + listado.toString());

        }

    }

}
