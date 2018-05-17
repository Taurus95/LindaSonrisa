package TEST;

import DTO.ClienteDto;
import DAO_IMP.ClienteDaoImp;
import java.security.Principal;
import java.sql.Date;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author andres
 */
public class testClienteDaoImp {

    /**
     * @param args the command line arguments
     */
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Principal.class);

    public static void main(String[] args) {
        log.info("Iniciando pruebas de clienteDaoImp");
        //objeto de prueba
        ClienteDto nuevo = new ClienteDto();
        nuevo.setRut("19.017.683-5");
        nuevo.setNombre("Andres Chacon");
        nuevo.setCorreo("andresch95@gmail.com");
        nuevo.setFechaNacimiento(Date.valueOf("1995-05-06"));
        nuevo.setHabilitado(true);
        nuevo.setSexo('M');
        nuevo.setTelefono("81865628");
        nuevo.setContrasenia(DigestUtils.md5Hex("andres"));

        log.info("ClienteDto creado"+nuevo.toString());
        
        //Dao implementado
        ClienteDaoImp implement = new ClienteDaoImp();
        //agregando nuevo
        implement.agregar(nuevo);
        nuevo.setCorreo("andres@gmail.com");
        implement.modificar(nuevo);
        ClienteDto aux = new ClienteDto();
        aux.setRut("19.017.683-5");
        log.info("buscando elemento: "+implement.buscar(aux).toString());
        implement.deshabilitar(aux);
        //proando

    }

}
