package DAO_IMP;

import DAO.IBaseDao;
import DTO.DetalleInsumoDto;
import java.security.Principal;
import java.util.List;
import BBDD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.InsumoDto;

/**
 *
 * @author andres
 */
public class DetalleInsumoDaoImp implements IBaseDao<DetalleInsumoDto> {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Principal.class);

    //metodo para buscar el mas antiguo segun fecha vencimiento y que tenga cantidad actual
    //con el id de un insumo devolvera el objeto de detalle insumo con la fecha mas proxima a vencer y que tenga
    //cantidad
    //devolvera el detalle insumo del cual consume un servicio
    public DetalleInsumoDto buscarMasAntiguoConCantidad(int id_insumo) {
        String query = "SELECT * FROM detalle_insumo WHERE fecha_vencimiento=(SELECT MIN(fecha_vencimiento)"
                + " FROM detalle_insumo  WHERE id_insumo=? and Cantidad_Actual not in (0)) AND id_insumo=? AND Cantidad_Actual not in (0)";

        try (Connection coneccion = Conexion.getConexion()) {
            PreparedStatement sql = coneccion.prepareStatement(query);
            sql.setInt(1, id_insumo);
            ResultSet result = sql.executeQuery();
            while (result.next()) {
                DetalleInsumoDto aux = new DetalleInsumoDto();
                aux.setCodigo(result.getString("codigo"));
                aux.setCantidadActual(result.getInt("cantidad_actual"));
                aux.setFechaLlegada(result.getDate("fecha_llegada"));
                aux.setFechaVencimiento(result.getDate("fecha_vencimiento"));
                aux.setPrecioCompraUnidad(result.getInt("precio_compra_unidad"));
                aux.setIdInsumo(id_insumo);
                return aux;
            }
        } catch (SQLException s) {
            log.error("Error SQL buscando detalle insumo " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al buscando detalle insumo " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<DetalleInsumoDto> listar() {
        String query = "SELECT * FROM detalle_insumo ";
        List<DetalleInsumoDto> list = new ArrayList<>();
        try (Connection coneccion = Conexion.getConexion()) {
            PreparedStatement sql = coneccion.prepareStatement(query);
            ResultSet result = sql.executeQuery();
            while (result.next()) {
                DetalleInsumoDto aux = new DetalleInsumoDto();
                aux.setCodigo(result.getString("codigo"));
                aux.setCantidadActual(result.getInt("cantidad_actual"));
                aux.setFechaLlegada(result.getDate("fecha_llegada"));
                aux.setFechaVencimiento(result.getDate("fecha_vencimiento"));
                aux.setPrecioCompraUnidad(result.getInt("precio_compra_unidad"));
                aux.setIdInsumo(result.getInt("id_insumo"));
                list.add(aux);
            }
        } catch (SQLException s) {
            log.error("Error SQL listando detalle insumo " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al listando detalle insumo " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean agregar(DetalleInsumoDto obj) {
        String query = "INSERT INTO detalle_insumo VALUES(?,?,?,?,?,?)";
        try (Connection coneccion = Conexion.getConexion()) {
            PreparedStatement sql = coneccion.prepareStatement(query);
            sql.setString(1, obj.getCodigo());
            sql.setInt(2, obj.getIdInsumo());
            sql.setInt(3, obj.getCantidadActual());
            sql.setDate(4, obj.getFechaVencimiento());
            sql.setInt(5, obj.getPrecioCompraUnidad());
            sql.setDate(6, obj.getFechaLlegada());

            //aca debemos actualizar el stock general al cual se suma este detalle
            if (sql.execute()) { //siempre que este correcto el agregar detalle insumo
                InsumoDto aux = new InsumoDto(); //creo un objeto para buscar
                aux.setIdInsumo(obj.getIdInsumo()); //setteo el id
                aux = new InsumoDaoImp().buscar(aux); // busco por ese id
                aux.setCantidadActual(aux.getCantidadActual() + obj.getCantidadActual()); //sumo a la cantidad actual
                if (new InsumoDaoImp().modificar(aux)) { //modifico
                    //actualizamos stock general y terminamos
                    coneccion.close();
                    return true;
                }
            }

        } catch (SQLException s) {
            log.error("Error SQL insertando detalle insumo " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al insertando detalle insumo " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean modificar(DetalleInsumoDto obj) {
        String query = "UPDATE detalle_insumo SET cantidad_actual=? WHERE codigo=?";
        try (Connection coneccion = Conexion.getConexion()) {
            PreparedStatement sql = coneccion.prepareStatement(query);
            sql.setString(2, obj.getCodigo());
            sql.setInt(1, obj.getCantidadActual());

            if (sql.executeUpdate() == 1) {
                coneccion.close();
                return true;
            }

        } catch (SQLException s) {
            log.error("Error SQL modificando detalle insumo " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al modificando detalle insumo " + e.getMessage());
        }
        return false;
    }

    @Override
    public DetalleInsumoDto buscar(DetalleInsumoDto obj) {
        String query = "SELECT * FROM detalle_insumo WHERE codigo=?";
        try (Connection coneccion = Conexion.getConexion()) {
            PreparedStatement sql = coneccion.prepareStatement(query);
            sql.setString(1, obj.getCodigo());
            ResultSet result = sql.executeQuery();
            while (result.next()) {
                DetalleInsumoDto aux = new DetalleInsumoDto();
                aux.setCodigo(result.getString("codigo"));
                aux.setCantidadActual(result.getInt("cantidad_actual"));
                aux.setFechaLlegada(result.getDate("fecha_llegada"));
                aux.setFechaVencimiento(result.getDate("fecha_vencimiento"));
                aux.setPrecioCompraUnidad(result.getInt("precio_compra_unidad"));
                aux.setIdInsumo(result.getInt("id_insumo"));
                return aux;
            }
        } catch (SQLException s) {
            log.error("Error SQL buscando detalle insumo " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al buscando detalle insumo " + e.getMessage());
        }
        return null;
    }

}
