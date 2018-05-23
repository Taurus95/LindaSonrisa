package DAO_IMP;

import DAO.IProveedorDao;
import DTO.ProveedorDto;
import java.util.List;
import BBDD.Conexion;
import java.security.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author andres
 */
public class ProveedorDaoImp implements IProveedorDao {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Principal.class);

    @Override
    public boolean deshabilitar(ProveedorDto obj) {
        String query = "UPDATE proveedor SET habilitado=0 WHERE rut=? ";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setString(1, obj.getRut());

            if (sql.executeUpdate() == 1) {
                conexion.close();
                return true;
            }

        } catch (SQLException s) {
            log.error("Error SQL deshabilitando proveedor " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al deshabilitando proveedor " + e.getMessage());
        }
        return false;
    }

    @Override
    public List<ProveedorDto> listar() {
        String query = "SELECT * FROM proveedor WHERE rut=?";
        List<ProveedorDto> list = new ArrayList<>();
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            ResultSet result = sql.executeQuery();
            while (result.next()) {
                ProveedorDto obj = new ProveedorDto();
                obj.setNombre(result.getString("nombre"));
                obj.setNombreContacto(result.getString("nombre_contacto"));
                obj.setTelefonoContacto(result.getString("telefono_contacto"));
                obj.setCorreoContacto(result.getString("correo_contacto"));
                obj.setIdInsumo(result.getInt("id_insumo"));
                obj.setHabilitado(result.getBoolean("habilitado"));
                list.add(obj);
            }

        } catch (SQLException s) {
            log.error("Error SQL listando proveedor " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al listando proveedor " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean agregar(ProveedorDto obj) {
        String query = "INSERT INTO proveedor VALUES(?,?,?,?,?,?,?)";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setString(1, obj.getRut());
            sql.setString(2, obj.getNombre());
            sql.setString(3, obj.getNombreContacto());
            sql.setString(4, obj.getTelefonoContacto());
            sql.setString(5, obj.getCorreoContacto());
            sql.setInt(6, obj.getIdInsumo());
            sql.setBoolean(7, obj.isHabilitado());

            if (sql.execute()) {
                conexion.close();
                return true;
            }

        } catch (SQLException s) {
            log.error("Error SQL agregando proveedor " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al agregando proveedor " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean modificar(ProveedorDto obj) {
        String query = "UPDATE proveedor SET nombre=?,nombre_contacto=?,telefono_contacto=?, correo_contacto=?,"
                + "id_insumo=?, habilitado=? WHERE rut=?";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setString(7, obj.getRut());
            sql.setString(1, obj.getNombre());
            sql.setString(2, obj.getNombreContacto());
            sql.setString(3, obj.getTelefonoContacto());
            sql.setString(4, obj.getCorreoContacto());
            sql.setInt(5, obj.getIdInsumo());
            sql.setBoolean(6, obj.isHabilitado());

            if (sql.executeUpdate() == 1) {
                conexion.close();
                return true;
            }

        } catch (SQLException s) {
            log.error("Error SQL modificando proveedor " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al modificando proveedor " + e.getMessage());
        }
        return false;
    }

    @Override
    public ProveedorDto buscar(ProveedorDto obj) {
        String query = "SELECT * FROM proveedor WHERE rut=?";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setString(1, obj.getRut());
            ResultSet result = sql.executeQuery();
            while (result.next()) {
                obj.setNombre(result.getString("nombre"));
                obj.setNombreContacto(result.getString("nombre_contacto"));
                obj.setTelefonoContacto(result.getString("telefono_contacto"));
                obj.setCorreoContacto(result.getString("correo_contacto"));
                obj.setIdInsumo(result.getInt("id_insumo"));
                obj.setHabilitado(result.getBoolean("habilitado"));
                conexion.close();
                return obj;
            }

        } catch (SQLException s) {
            log.error("Error SQL buscando proveedor " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al buscando proveedor " + e.getMessage());
        }
        return obj;
    }

    @Override
    public boolean habilitar(ProveedorDto obj) {
        String query = "UPDATE proveedor SET habilitado=1 WHERE rut=? ";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setString(1, obj.getRut());

            if (sql.executeUpdate() == 1) {
                conexion.close();
                return true;
            }

        } catch (SQLException s) {
            log.error("Error SQL habilitando proveedor " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al habilitando proveedor " + e.getMessage());
        }
        return false;
    }

}
