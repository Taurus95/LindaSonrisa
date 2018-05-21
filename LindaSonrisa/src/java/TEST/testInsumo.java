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
        
        InsumoDto nuevo = new InsumoDto(0,"Pinzas",10,15,100);
        log.info("Insumo nuevo y listo a agregar : "+nuevo.toString());
        implementacion.agregar(nuevo);
        log.info("Buscando recien insertado...");
        InsumoDto aux = new InsumoDto(implementacion.ultimoId()," ",0,0,0);
        implementacion.buscar(aux).toString();
        
       log.info("Modificando descripcion");
       aux.setDescripcion("Pinzas 35mm");
       implementacion.modificar(aux);
       implementacion.buscar(aux).toString();
       log.info("listando todos");
       for(InsumoDto listado:implementacion.listar()){
           listado.toString();
       }
       
        
        
    }
    
}
