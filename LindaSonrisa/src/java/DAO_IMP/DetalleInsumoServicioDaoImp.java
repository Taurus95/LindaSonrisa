package DAO_IMP;

import DAO.IDetalleInsumoServicio;
import DTO.DetalleInsumoServicioDto;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import BBDD.Conexion;
import java.security.Principal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author andres
 */
public class DetalleInsumoServicioDaoImp implements IDetalleInsumoServicio {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Principal.class);

    @Override
    public boolean eliminar(DetalleInsumoServicioDto obj) {
        String query = "DELETE FROM detalle_insumo_servicio WHERE id_servicio=? AND id_insumo=?";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setInt(1, obj.getIdServicio());
            sql.setInt(2, obj.getIdInsumo());
            if (sql.executeUpdate() == 1) {
                conexion.close();
                return true;
            }
        } catch (SQLException s) {
            log.error("Error SQL eliminando detalleInsumoServicio " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al eliminando detalleInsumoServicio " + e.getMessage());
        }
        return false;
    }

    @Override
    public List<DetalleInsumoServicioDto> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregar(DetalleInsumoServicioDto obj) {
        String query = "INSERT INTO Detalle_Insumo_Servicio VALUES(?,?,?)";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setInt(1, obj.getIdServicio());
            sql.setInt(2, obj.getIdInsumo());
            sql.setInt(3, obj.getCantidadInsumo());
            if (sql.execute()) {
                conexion.close();
                return true;
            }
        } catch (SQLException s) {
            log.error("Error SQL agregando detalleInsumoServicio " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al agregar detalleInsumoServicio " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean modificar(DetalleInsumoServicioDto obj) {
        String query = "UPDATE detalle_insumo_servicio SET cantidad_insumo=? WHERE id_servicio=? AND id_insumo=?";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setInt(1, obj.getCantidadInsumo());
            if (sql.executeUpdate() == 1) {
                conexion.close();
                return true;
            }
        } catch (SQLException s) {
            log.error("Error SQL modificando detalleInsumoServicio " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al modificar detalleInsumoServicio " + e.getMessage());
        }
        return false;
    }

    @Override
    public DetalleInsumoServicioDto buscar(DetalleInsumoServicioDto obj) {
        //no aplica
        return null;
    }

    @Override
    public List<DetalleInsumoServicioDto> listarPorServicio(int id_servicio) {
        String query = "SELECT * FROM detalle_insumo_servicio WHERE id_servicio=?";
        List<DetalleInsumoServicioDto> list = new ArrayList<>();
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setInt(1, id_servicio);
            ResultSet result = sql.executeQuery();
            while (result.next()) {
                DetalleInsumoServicioDto obj = new DetalleInsumoServicioDto();
                obj.setIdServicio(id_servicio);
                obj.setIdInsumo(result.getInt("id_insumo"));
                obj.setCantidadInsumo(result.getInt("cantidad_insumo"));
                list.add(obj);
            }
        } catch (SQLException s) {
            log.error("Error SQL buscando detalleInsumoServicio por idservicio " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al agregar detalleInsumoServicio por idservicio " + e.getMessage());
        }
        return list;
    }

}
