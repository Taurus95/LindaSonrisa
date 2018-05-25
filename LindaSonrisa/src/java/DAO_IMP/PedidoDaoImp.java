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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.DetalleInsumoDto;
import DTO.DetallePedidoDto;

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
        String query = "SELECT * FROM pedido WHERE estado=?";
        List<PedidoDto> list = new ArrayList<>();
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setString(1, aux);
            ResultSet result = sql.executeQuery();
            while (result.next()) {
                PedidoDto obj = new PedidoDto();
                obj.setRutTrabajador(result.getString("rut_trabajador"));
                obj.setRutProveedor(result.getString("rut_trabajador"));
                obj.setComentario(result.getString("comentario"));
                obj.setEstado(result.getString("estado"));
                obj.setValorTotal(result.getInt("valor_total"));
                obj.setFechaEntrega(result.getDate("fecha_entrega"));
                obj.setFechaPedido(result.getDate("fecha_pedido"));
                list.add(obj);
            }
        } catch (SQLException s) {
            log.error("Error SQL al listar pedido " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al listar pedido " + e.getMessage());
        }
        return list;
    }

    @Override
    public List<PedidoDto> listar() {
        String query = "SELECT * FROM pedido";
        List<PedidoDto> list = new ArrayList<>();
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            ResultSet result = sql.executeQuery();
            while (result.next()) {
                PedidoDto obj = new PedidoDto();
                obj.setRutTrabajador(result.getString("rut_trabajador"));
                obj.setRutProveedor(result.getString("rut_trabajador"));
                obj.setComentario(result.getString("comentario"));
                obj.setEstado(result.getString("estado"));
                obj.setValorTotal(result.getInt("valor_total"));
                obj.setFechaEntrega(result.getDate("fecha_entrega"));
                obj.setFechaPedido(result.getDate("fecha_pedido"));
                list.add(obj);
            }
        } catch (SQLException s) {
            log.error("Error SQL al listar pedido " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al listar pedido " + e.getMessage());
        }
        return list;
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
                //si el estado se actualiza a recibido, entonces agregaremos el detalle de este pedido como un
                //detalle de insumo para qie pase a ser parte del inventario
                if ("Realizada".equals(obj.getEstado())) {
                    DetallePedidoDto aux = new DetallePedidoDto(obj.getIdPedido(), 0, 0, 0, null);
                    aux = new DetallePedidoDaoImp().buscar(aux);
                    String codigo = obj.getRutProveedor() + aux.getIdInsumo() + ((aux.getFecha_vencimiento() != null) ? aux.getFecha_vencimiento() : " ");
                    DetalleInsumoDto detalleInsumo = new DetalleInsumoDto(codigo, aux.getIdInsumo(), aux.getCantidad(), aux.getFecha_vencimiento(),
                            aux.getPrecioUnidad(), aux.getFecha_vencimiento());
                    if (new DetalleInsumoDaoImp().agregar(detalleInsumo)) {
                        log.info("Pedido actualizado a realizado y detalle insumo agregado correctamente.");

                    }
                }
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
            sql.setInt(1, obj.getIdPedido());
            ResultSet result = sql.executeQuery();
            while (result.next()) {
                obj.setRutTrabajador(result.getString("rut_trabajador"));
                obj.setRutProveedor(result.getString("rut_trabajador"));
                obj.setComentario(result.getString("comentario"));
                obj.setEstado(result.getString("estado"));
                obj.setValorTotal(result.getInt("valor_total"));
                obj.setFechaEntrega(result.getDate("fecha_entrega"));
                obj.setFechaPedido(result.getDate("fecha_pedido"));
                return obj;
            }
        } catch (SQLException s) {
            log.error("Error SQL al buscar pedido " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al buscar pedido " + e.getMessage());
        }
        return null;
    }

}
