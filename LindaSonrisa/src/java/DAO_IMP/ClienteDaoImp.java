package DAO_IMP;

import DAO.IClienteDao;
import DTO.ClienteDto;
import java.security.Principal;
import java.sql.SQLException;
import java.util.List;
import BBDD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author andres
 */
public class ClienteDaoImp implements IClienteDao {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Principal.class);

    @Override
    public boolean deshabilitar(ClienteDto cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClienteDto> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregar(ClienteDto obj) {
        String query = "INSERT INTO cliente VALUES(?,?,?,?,?,?,?,?,?);";
        try (Connection connection = Conexion.getConexion()) {
            PreparedStatement sql = connection.prepareStatement(query);
            sql.setString(1, obj.getRut());
            sql.setString(2, obj.getNombre());
            sql.setString(3, obj.getCorreo());
            //sql.setCharacterStream(4, obj.getSexo());
            sql.setString(5, obj.getDireccion());
            sql.setString(6, obj.getTelefono());
            sql.setDate(7, obj.getFechaNacimiento());
            sql.setString(8, obj.getContrasenia());
            sql.setBoolean(9, obj.isHabilitado());
            
            if(sql.execute()){
                connection.close();
                return true;
            }
            
        } catch (SQLException s) {
            log.error("Error SQL listando detalle " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al listar detalles " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean modificar(ClienteDto obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClienteDto buscar(ClienteDto obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
