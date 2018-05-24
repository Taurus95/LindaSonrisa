package DAO_IMP;

import DAO.IPedidoDao;
import DTO.PedidoDto;
import DTO.ProveedorDto;
import DTO.TrabajadorDto;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import BBDD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author andres
 */
public class PedidoDaoImp implements IPedidoDao {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Principal.class);

    @Override
    public List<PedidoDto> listarPorFechaPedido(Date fecha1, Date fecha2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PedidoDto> listarPorFechaEntrega(Date fecha1, Date fecha2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PedidoDto> listarPorProveedor(ProveedorDto obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PedidoDto> listarPorTrabajador(TrabajadorDto obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PedidoDto> listarPorEstado(String aux) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PedidoDto> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregar(PedidoDto obj) {
        String query = "INSERT INTO pedido(fecha_pedido,fecha_entrega,valor_total,estado,rut_trabajador,rut_proveedor)"
                + " VALUES(?,?,?,?,?,?)";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setDate(1, obj.getFechaPedido());
            sql.setDate(2, obj.getFechaEntrega());
            sql.setInt(3, obj.getValorTotal());
            sql.setString(4, obj.getEstado());
            sql.setString(5, obj.getRutTrabajador());
            sql.setString(6, obj.getRutProveedor());
            if (sql.execute()) {
                conexion.close();
                return true;
            }
        } catch (SQLException s) {
            log.error("Error SQL agregar servicio " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al agregar servicio " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean modificar(PedidoDto obj) {
        String query = "UPDATE pedido SET fecha_pedido=?,fecha_entrega=?,valor_total=?,estado=?,rut_trabajador=?,rut_proveedor=?"
                + "WHERE id_pedido=?";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setDate(1, obj.getFechaPedido());
            sql.setDate(2, obj.getFechaEntrega());
            sql.setInt(3, obj.getValorTotal());
            sql.setString(4, obj.getEstado());
            sql.setString(5, obj.getRutTrabajador());
            sql.setString(6, obj.getRutProveedor());
            sql.setInt(7, obj.getIdPedido());
            if (sql.executeUpdate() == 1) {
                conexion.close();
                return true;
            }
        } catch (SQLException s) {
            log.error("Error SQL al modificar servicio " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al modificar servicio " + e.getMessage());
        }
        return false;
    }

    @Override
    public PedidoDto buscar(PedidoDto obj) {
        String query = "SELECT * FROM pedido WHERE id_pedido=?";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);

        } catch (SQLException s) {
            log.error("Error SQL al buscar servicio " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al buscar servicio " + e.getMessage());
        }
        return null;
    }

}
