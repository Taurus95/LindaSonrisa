package DAO_IMP;

//imports
import DAO.IClienteDao;
import DTO.ClienteDto;
import java.security.Principal;
import java.sql.SQLException;
import java.util.List;
import BBDD.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author andres
 */
public class ClienteDaoImp implements IClienteDao {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Principal.class);

    @Override
    public boolean deshabilitar(ClienteDto cliente) {
        String query = "UPDATE cliente SET habilitado=0 WHERE rut=?";
        try (Connection connection = Conexion.getConexion()) {
            PreparedStatement sql = connection.prepareStatement(query);
            sql.setString(1, cliente.getRut());

            //Si actualiza una row retorna
            if (sql.executeUpdate() == 1) {
                connection.close();
                return true;
            }

        } catch (SQLException s) {
            log.error("Error SQL deshabilitando cliente " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al deshabilitar cliente " + e.getMessage());
        }

        return false;
    }

    @Override
    public List<ClienteDto> listar() {
        List<ClienteDto> list = new ArrayList<>();
        String query = "SELECT * FROM cliente";
        try (Connection connection = Conexion.getConexion()) {
            PreparedStatement sql = connection.prepareStatement(query);
            try (ResultSet results = sql.executeQuery()) {
                while (results.next()) {
                    ClienteDto aux = new ClienteDto();
                    aux.setRut(results.getString("rut"));
                    aux.setNombre(results.getString("nombre"));
                    aux.setSexo(results.getString("sexo"));
                    aux.setCorreo(results.getString("correo"));
                    aux.setDireccion(results.getString("direccion"));
                    aux.setTelefono(results.getString("telefono"));
                    aux.setFechaNacimiento(results.getDate("fecha_nacimiento"));
                    aux.setHabilitado(results.getBoolean("habilitado"));
                    list.add(aux);
                }
            } catch (Exception e) {
                log.error("Error al obtener resultset de listado: " + e.getMessage());
            }
            connection.close();

        } catch (SQLException s) {
            log.error("Error SQL listando cliente " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al listando cliente " + e.getMessage());
        } finally {
            return list;
        }
    }

    //agregar nuevo cliente
    @Override
    public boolean agregar(ClienteDto obj) {
        String query = "INSERT INTO cliente VALUES(?,?,?,?,?,?,?,?,?)";
        try (Connection connection = Conexion.getConexion()) {
            PreparedStatement sql = connection.prepareStatement(query);
            sql.setString(1, obj.getRut());
            sql.setString(2, obj.getNombre());
            sql.setString(3, obj.getCorreo());
            sql.setString(4, obj.getSexo());
            sql.setString(5, obj.getDireccion());
            sql.setString(6, obj.getTelefono());
            sql.setDate(7, (Date) obj.getFechaNacimiento());
            sql.setString(8, obj.getContrasenia());
            sql.setBoolean(9, obj.isHabilitado());
            //Si retorna true agregamos correcto
            if (sql.execute()) {
                connection.close();
                return true;
            }
        } catch (SQLException s) {
            log.error("Error SQL al agregar cliente: " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al agregar cliente" + e.getMessage());
        }
        return false;
    }

    //modificamos todo parametro del cliente, hasta su contraseña.
    @Override
    public boolean modificar(ClienteDto obj) {
        String query = "UPDATE cliente SET nombre=?,correo=?,sexo=?,direccion=?,telefono=?,"
                + "fecha_nacimiento=?,contraseña=?,habilitado=? WHERE rut=? ";
        try (Connection connection = Conexion.getConexion()) {
            PreparedStatement sql = connection.prepareStatement(query);
            sql.setString(9, obj.getRut());
            sql.setString(1, obj.getNombre());
            sql.setString(2, obj.getCorreo());
            sql.setString(3, obj.getSexo());
            sql.setString(4, obj.getDireccion());
            sql.setString(5, obj.getTelefono());
            sql.setDate(6, (Date) obj.getFechaNacimiento());
            sql.setString(7, obj.getContrasenia());
            sql.setBoolean(8, obj.isHabilitado());

            //probando executeUpdate para comprobar que actualizo una fila nada mas y no mas o menos.
            if (sql.executeUpdate() == 1) {
                connection.close();
                return true;
            }
        } catch (SQLException s) {
            log.error("Error SQL al modificar cliente" + s.getMessage());
        } catch (Exception e) {
            log.error("Error al modificar " + e.getMessage());
        }
        return false;
    }

    //buscar regresa un cliente filtrado por su rut//
    @Override
    public ClienteDto buscar(ClienteDto obj) {
        String query = "SELECT * FROM cliente WHERE rut = ?";
        try (Connection connection = Conexion.getConexion()) {

            PreparedStatement sql = connection.prepareStatement(query);
            sql.setString(1, obj.getRut());

            try (ResultSet results = sql.executeQuery()) {
                while (results.next()) {
                    obj.setRut(results.getString("rut"));
                    obj.setNombre(results.getString("nombre"));
                    obj.setSexo(results.getString("sexo"));
                    obj.setCorreo(results.getString("correo"));
                    obj.setDireccion(results.getString("direccion"));
                    obj.setTelefono(results.getString("telefono"));
                    obj.setFechaNacimiento(results.getDate("fecha_nacimiento"));
                    obj.setHabilitado(results.getBoolean("habilitado"));
                    obj.setContrasenia(results.getString("contraseña"));
                }
            } catch (Exception e) {
                log.error("Error al obtener resultset de buscar: " + e.getMessage());
            }
            connection.close();

        } catch (SQLException s) {
            log.error("Error SQL buscando cliente " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al buscar cliente " + e.getMessage());
        } finally {
            return obj;
        }
    }

    //habilitamos cliente con su rut
    @Override
    public boolean habilitar(ClienteDto cliente) {
        String query = "UPDATE cliente SET habilitado=1  WHERE rut=?";
        try (Connection connection = Conexion.getConexion()) {
            PreparedStatement sql = connection.prepareStatement(query);
            sql.setString(1, cliente.getRut());

            //Si actualizamos un registro retornamos 
            if (sql.executeUpdate() == 1) {
                connection.close();
                return true;
            }

        } catch (SQLException s) {
            log.error("Error SQL habilitando cliente " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al habilitar cliente " + e.getMessage());
        }

        return false;
    }

}
