package TEST;

import DAO_IMP.DetalleInsumoDaoImp;
import DAO_IMP.InsumoDaoImp;
import DTO.DetalleInsumoDto;
import DTO.InsumoDto;
import java.security.Principal;
import java.sql.Date;

/**
 *
 * @author andres
 */
public class testDetalleInsumo {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Principal.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DetalleInsumoDaoImp implementacion = new DetalleInsumoDaoImp();

        DetalleInsumoDto aux = new DetalleInsumoDto();
        aux.setCodigo("Prueba");
        aux.setIdInsumo(9);
        aux.setFechaLlegada(new Date(2018, 02, 12));
        aux.setFechaVencimiento(new Date(2018, 10, 20));
        aux.setCantidadActual(10);
        aux.setPrecioCompraUnidad(2500);

        InsumoDto insumo = new InsumoDto();
        insumo.setIdInsumo(9);
        log.info("Insum al cual se sumaran el detalle id: 9 " + new InsumoDaoImp().buscar(insumo).toString());
        log.info(" objeto a agregar: " + aux.toString());
        implementacion.agregar(aux);
        log.info("Despues de agregado el detalle id: 9 " + new InsumoDaoImp().buscar(insumo).toString());

    }

}
