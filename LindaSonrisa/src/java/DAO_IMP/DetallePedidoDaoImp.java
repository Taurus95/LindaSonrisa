package DAO_IMP;

import DAO.IBaseDao;
import DTO.DetallePedidoDto;
import java.security.Principal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import BBDD.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author andres
 */
public class DetallePedidoDaoImp implements IBaseDao<DetallePedidoDto> {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Principal.class);

    //no aplica
    @Override
    public List<DetallePedidoDto> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregar(DetallePedidoDto obj) {
        String query = "INSERT INTO detalle_pedido (?,?,?,?)";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setInt(1, obj.getIdPedido());
            sql.setInt(2, obj.getIdInsumo());
            sql.setInt(3, obj.getCantidad());
            sql.setInt(4, obj.getPrecioUnidad());
            if (sql.execute()) {
                conexion.close();
                return true;
            }
        } catch (SQLException s) {
            log.error("Error SQL agregando detalle_pedido " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al agregar detalle_pedido " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean modificar(DetallePedidoDto obj) {
        String query = "UPDATE detalle_pedido SET cantidad=?,precio_unidad=? WHERE id_pedido=? AND id_insumo=?";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setInt(1, obj.getCantidad());
            sql.setInt(2, obj.getPrecioUnidad());
            sql.setInt(3, obj.getIdPedido());
            sql.setInt(4, obj.getIdInsumo());
            if (sql.executeUpdate() == 1) {
                conexion.close();
                return true;
            }
        } catch (SQLException s) {
            log.error("Error SQL modificando detalle_pedido " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al modificar detalle_pedido " + e.getMessage());
        }
        return false;
    }

    @Override
    public DetallePedidoDto buscar(DetallePedidoDto obj) {
        String query = "SELECT * FROM detalle_pedido WHERE id_pedido=?";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setInt(1, obj.getIdPedido());
            sql.setInt(2, obj.getIdInsumo());
            ResultSet result = sql.executeQuery();
            while (result.next()) {
                obj.setCantidad(result.getInt("cantidad"));
                obj.setPrecioUnidad(result.getInt("precio_unidad"));
                conexion.close();
                return obj;
            }
        } catch (SQLException s) {
            log.error("Error SQL busacndo detalle_pedido " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al buscar detalle_pedido " + e.getMessage());
        }
        return null;
    }

}
