package DAO_IMP;

import DTO.ConsultaDto;
import DAO.IBaseDao;
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
public class ConsultaDaoImp implements IBaseDao<ConsultaDto> {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Principal.class);

    @Override
    public List<ConsultaDto> listar() {
        String query = "SELECT * FROM consulta";
        List<ConsultaDto> list = new ArrayList<>();
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            ResultSet result = sql.executeQuery();
            while (result.next()) {
                ConsultaDto obj = new ConsultaDto();
                obj.setIdServicio(result.getInt("id_servicio"));
                obj.setRutCliente(result.getString("rut_cliente"));
                obj.setRutTrabajador(result.getString("rut_trabajador"));
                obj.setFecha(result.getDate("fecha"));
                obj.setEstado(result.getString("estado"));
                obj.setTotal(result.getInt("total"));
                list.add(obj);
            }
        } catch (SQLException s) {
            log.error("Error SQL al listar consulta: " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al listar consulta" + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean agregar(ConsultaDto obj) {
        String query = "INSERT INTO consulta(id_servicio,fecha,rut_cliente,rut_trabajador,estado,total) VALUES(?,?,?,?,?,?)";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setInt(1, obj.getIdServicio());
            sql.setDate(2, obj.getFecha());
            sql.setString(3, obj.getRutCliente());
            sql.setString(4, obj.getRutTrabajador());
            sql.setString(5, obj.getEstado());
            sql.setInt(6, obj.getTotal());

            if (sql.execute()) {
                conexion.close();
                return true;
            }

        } catch (SQLException s) {
            log.error("Error SQL al agregar consulta: " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al agregar consulta" + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean modificar(ConsultaDto obj) {
        String query = "UPDATE consulta SET id_servicio=?,rut_cliente=?,rut_trabajador=?,fecha=?,estado=?,total=?"
                + "WHERE id_consulta=? ";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setInt(1, obj.getIdServicio());
            sql.setDate(4, obj.getFecha());
            sql.setString(2, obj.getRutCliente());
            sql.setString(3, obj.getRutTrabajador());
            sql.setString(5, obj.getEstado());
            sql.setInt(6, obj.getTotal());
            if (sql.executeUpdate() == 1) {
                conexion.close();
                return true;
            }
        } catch (SQLException s) {
            log.error("Error SQL al modificando consulta: " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al modificando consulta" + e.getMessage());
        }
        return false;
    }

    @Override
    public ConsultaDto buscar(ConsultaDto obj) {
        String query = "SELECT * FROM consulta WHERE id_consulta=?";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setInt(1, obj.getIdConsulta());
            ResultSet result = sql.executeQuery();
            while (result.next()) {
                obj.setIdServicio(result.getInt("id_servicio"));
                obj.setRutCliente(result.getString("rut_cliente"));
                obj.setRutTrabajador(result.getString("rut_trabajador"));
                obj.setFecha(result.getDate("fecha"));
                obj.setEstado(result.getString("estado"));
                obj.setTotal(result.getInt("total"));
                return obj;
            }
        } catch (SQLException s) {
            log.error("Error SQL al buscar consulta: " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al buscar consulta" + e.getMessage());
        }
        return null;
    }

}
