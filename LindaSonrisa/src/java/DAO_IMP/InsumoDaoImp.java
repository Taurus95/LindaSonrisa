package DAO_IMP;

import DAO.IInsumoDao;
import DTO.DetalleInsumoDto;
import DTO.InsumoDto;
import java.sql.Connection;
import java.util.List;
import BBDD.Conexion;
import java.security.Principal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author andres
 */
public class InsumoDaoImp implements IInsumoDao {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Principal.class);

    @Override
    public List<InsumoDto> buscarCriticos() {
        //Query Correcta
        String query = "SELECT * FROM insumo WHERE cantidad_actual < cantidad_critica";
        List<InsumoDto> list = new ArrayList<>();
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            ResultSet results = sql.executeQuery();

            while (results.next()) {
                InsumoDto obj = new InsumoDto();
                obj.setIdInsumo(results.getInt("id_insumo"));
                obj.setDescripcion(results.getString("descripcion"));
                obj.setCantidadActual(results.getInt("cantidad_actual"));
                obj.setCantidadCritica(results.getInt("cantidad_critica"));
                obj.setCantidadMaxima(results.getInt("cantidad_maxima"));
                list.add(obj);
            }
            conexion.close();

        } catch (SQLException ex) {
            log.error("Error listando criticos insumo " + ex.getMessage());
        } catch (Exception e) {
            log.error("Error listando criticos insumo " + e.getMessage());
        }
        return list;
    }

    @Override
    public List<DetalleInsumoDto> buscarDetalles(InsumoDto obj) {
        String query = "SELECT * FROM detalle_insumo WHERE id_insumo =?";
        List<DetalleInsumoDto> list = new ArrayList<>();
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setInt(1, obj.getIdInsumo());
            ResultSet results = sql.executeQuery();

            while (results.next()) {
                DetalleInsumoDto aux = new DetalleInsumoDto();
                aux.setIdInsumo(obj.getIdInsumo());
                aux.setCodigo(results.getString("codigo"));
                aux.setCantidadActual(results.getInt("cantidad_actual"));
                aux.setFechaLlegada(results.getDate("fecha_llegada"));
                aux.setFechaVencimiento(results.getDate("fecha_vencimiento"));
                aux.setPrecioCompraUnidad(results.getInt("precio_compra_unidad"));
                list.add(aux);
            }

        } catch (SQLException ex) {
            log.error("Error listando criticos insumo " + ex.getMessage());
        } catch (Exception e) {
            log.error("Error listando criticos insumo " + e.getMessage());
        }
        return list;
    }

    @Override
    public List<InsumoDto> listar() {
        String query = "SELECT * FROM insumo ";
        List<InsumoDto> list = new ArrayList<>();
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            ResultSet results = sql.executeQuery();

            while (results.next()) {
                InsumoDto obj = new InsumoDto();
                obj.setIdInsumo(results.getInt("id_insumo"));
                obj.setDescripcion(results.getString("descripcion"));
                obj.setCantidadActual(results.getInt("cantidad_actual"));
                obj.setCantidadCritica(results.getInt("cantidad_critica"));
                obj.setCantidadMaxima(results.getInt("cantidad_maxima"));
                list.add(obj);
            }
            conexion.close();

        } catch (SQLException ex) {
            log.error("Error listando insumo " + ex.getMessage());
        } catch (Exception e) {
            log.error("Error listando insumo " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean agregar(InsumoDto obj) {
        String query = "INSERT INTO insumo(descripcion,cantidad_actual,cantidad_critica,cantidad_maxima) VALUES(?,?,?,?)";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setString(1, obj.getDescripcion());
            sql.setInt(2, obj.getCantidadActual());
            sql.setInt(3, obj.getCantidadCritica());
            sql.setInt(4, obj.getCantidadMaxima());

            if (sql.execute()) {
                conexion.close();
                return true;
            }
        } catch (SQLException ex) {
            log.error("Error agregando insumo " + ex.getMessage());
        } catch (Exception e) {
            log.error("Error agregando insumo " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean modificar(InsumoDto obj) {
        String query = "UPDATE insumo SET descripcion=?,cantidad_actual=?,cantidad_critica=?,cantidad_maxima=? WHERE id_insumo=?";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setString(1, obj.getDescripcion());
            sql.setInt(2, obj.getCantidadActual());
            sql.setInt(3, obj.getCantidadCritica());
            sql.setInt(4, obj.getCantidadMaxima());
            sql.setInt(5, obj.getIdInsumo());

            if (sql.executeUpdate() == 1) {
                conexion.close();
                return true;
            }
        } catch (SQLException ex) {
            log.error("Error modificando insumo " + ex.getMessage());
        } catch (Exception e) {
            log.error("Error modificando insumo " + e.getMessage());
        }
        return false;
    }

    @Override
    public InsumoDto buscar(InsumoDto obj) {
        String query = "SELECT * FROM insumo WHERE id_insumo = ?";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setInt(1, obj.getIdInsumo());
            ResultSet results = sql.executeQuery();
            while (results.next()) {
                obj.setDescripcion(results.getString("descripcion"));
                obj.setCantidadActual(results.getInt("cantidad_actual"));
                obj.setCantidadCritica(results.getInt("cantidad_critica"));
                obj.setCantidadMaxima(results.getInt("cantidad_maxima"));
            }
            conexion.close();

        } catch (SQLException ex) {
            log.error("Error buscando insumo " + ex.getMessage());
        } catch (Exception e) {
            log.error("Error buscando insumo " + e.getMessage());
        }
        return obj;
    }

    //funcion para conocer el id del ultimo agregado
    public int ultimoId() {
        String query = "SELECT MAX(id_insumo) as id FROM insumo";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            ResultSet results = sql.executeQuery();
            while (results.next()) {
                return results.getInt("id");
            }
            conexion.close();

        } catch (SQLException ex) {
            log.error("Error listando insumo " + ex.getMessage());
        } catch (Exception e) {
            log.error("Error listando insumo " + e.getMessage());
        }
        return 0;
    }

}
