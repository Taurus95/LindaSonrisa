package DAO_IMP;

import DTO.ConsultaDto;
import DAO.IBaseDao;
import java.util.List;
import BBDD.Conexion;
import DTO.DetalleInsumoDto;
import DTO.DetalleInsumoServicioDto;
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
                obj.setHora(result.getInt("hora"));
                obj.setMinuto(result.getInt("minuto"));
                list.add(obj);
            }
        } catch (SQLException s) {
            log.error("Error SQL al listar consulta: " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al listar consulta" + e.getMessage());
        }
        return list;
    }

    public List<ConsultaDto> listarPorDiaDoctor(String rut, java.sql.Date fecha) {
        String query = "SELECT * FROM consulta WHERE fecha=? AND estado='Pendiente' AND rut_trabajador=?";
        List<ConsultaDto> list = new ArrayList<>();
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setDate(1, fecha);
            sql.setString(2, rut);
            ResultSet result = sql.executeQuery();
            while (result.next()) {
                ConsultaDto obj = new ConsultaDto();
                obj.setIdServicio(result.getInt("id_servicio"));
                obj.setRutCliente(result.getString("rut_cliente"));
                obj.setRutTrabajador(result.getString("rut_trabajador"));
                obj.setFecha(result.getDate("fecha"));
                obj.setEstado(result.getString("estado"));
                obj.setTotal(result.getInt("total"));
                obj.setHora(result.getInt("hora"));
                obj.setMinuto(result.getInt("minuto"));
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
        String query = "INSERT INTO consulta(id_servicio,fecha,rut_cliente,rut_trabajador,estado,total,hora,minuto) VALUES(?,?,?,?,?,?,?,?)";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setInt(1, obj.getIdServicio());
            sql.setDate(2, obj.getFecha());
            sql.setString(3, obj.getRutCliente());
            sql.setString(4, obj.getRutTrabajador());
            sql.setString(5, obj.getEstado());
            sql.setInt(6, obj.getTotal());
            sql.setInt(7, obj.getHora());
            sql.setInt(8, obj.getMinuto());

            sql.execute();
            this.restaInsumosServicio(obj.getIdServicio());
            conexion.close();
            return true;

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
                + ",hora=?,minuto=?"
                + "WHERE id_consulta=? ";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setInt(1, obj.getIdServicio());
            sql.setDate(4, obj.getFecha());
            sql.setString(2, obj.getRutCliente());
            sql.setString(3, obj.getRutTrabajador());
            sql.setString(5, obj.getEstado());
            sql.setInt(6, obj.getTotal());
            sql.setInt(7, obj.getHora());
            sql.setInt(8, obj.getMinuto());
            sql.setInt(9, obj.getIdConsulta());

            if (sql.executeUpdate() == 1) {
                if (obj.getEstado().equals("cancelada")) {
                    this.sumaInsumosServicio(obj.getIdServicio());
                }
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
                obj.setHora(result.getInt("hora"));
                obj.setMinuto(result.getInt("minuto"));
                return obj;
            }
        } catch (SQLException s) {
            log.error("Error SQL al buscar consulta: " + s.getMessage());
        } catch (Exception e) {
            log.error("Error al buscar consulta" + e.getMessage());
        }
        return null;
    }

    public boolean restaInsumosServicio(int id_servicio) {
        //para cada detalle del servicio se deben restar los insumos correspondientes
        for (DetalleInsumoServicioDto detalle : new DetalleInsumoServicioDaoImp().listarPorServicio(id_servicio)) {
            //se obtiene detalleDe insumo al que se restara stock
            DetalleInsumoDto detalleInsumo = new DetalleInsumoDaoImp().buscarMasAntiguoConCantidad(detalle.getIdInsumo());
            //se realiza resta
            int resta = detalleInsumo.getCantidadActual() - detalle.getCantidadInsumo();
            //se comprueba que tenga la cantidad necesaria para hacer la resta completa
            if (resta >= 0) {
                detalleInsumo.setCantidadActual(resta);
                //cargamos el detalle insumo con datos actualizados
                new DetalleInsumoDaoImp().modificar(detalleInsumo);
                //actualizamos stock para tal insumo
                new InsumoDaoImp().actualizarStock(detalleInsumo.getIdInsumo());
            } else {
                while (resta < 0) {
                    //setiamos a 0 el detalle insumo actual
                    detalleInsumo.setCantidadActual(0);
                    //cargamos el detalle insumo con datos actualizados
                    new DetalleInsumoDaoImp().modificar(detalleInsumo);
                    //buscamos un detalle insumo nuevo al que restarle
                    detalleInsumo = new DetalleInsumoDaoImp().buscarMasAntiguoConCantidad(detalle.getIdInsumo());

                    //restamos al nuevo
                    resta = detalleInsumo.getCantidadActual() - Math.abs(resta);
                    //si esta vez la cantidad actual sirvio la resta sera positiva
                    if (resta > 0) {
                        //actualizamos con resta
                        detalleInsumo.setCantidadActual(resta);
                        //cargamos el detalle insumo con datos actualizados
                        new DetalleInsumoDaoImp().modificar(detalleInsumo);
                        //actualizamos stock general con lo que quedo
                        new InsumoDaoImp().actualizarStock(detalleInsumo.getIdInsumo());

                    }

                }
            }
        }
        return true;
    }

    public boolean sumaInsumosServicio(int id_servicio) {
        //para cada detalle del servicio se deben restar los insumos correspondientes
        for (DetalleInsumoServicioDto detalle : new DetalleInsumoServicioDaoImp().listarPorServicio(id_servicio)) {
            //se obtiene detalleDe insumo al que se restara stock
            DetalleInsumoDto detalleInsumo = new DetalleInsumoDaoImp().buscarMasAntiguoConCantidad(detalle.getIdInsumo());
            //se realiza suma
            int suma = detalleInsumo.getCantidadActual() + detalle.getCantidadInsumo();
            //setiamos nueva cantidad
            detalleInsumo.setCantidadActual(suma);
            //cargamos el detalle insumo con datos actualizados
            new DetalleInsumoDaoImp().modificar(detalleInsumo);
            //actualizamos stock para tal insumo
            new InsumoDaoImp().actualizarStock(detalleInsumo.getIdInsumo());

        }
        return true;
    }

    public int ultimoId() {
        String query = "SELECT MAX(id_consulta) as id FROM consulta";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            ResultSet results = sql.executeQuery();
            while (results.next()) {
                return results.getInt("id");
            }
            conexion.close();

        } catch (SQLException ex) {
            log.error("Error buscando ultimo id_consulyta " + ex.getMessage());
        } catch (Exception e) {
            log.error("Error buscando ultimo id_consulta " + e.getMessage());
        }
        return 0;
    }
    
    public ConsultaDto consultaPendienteCliente(String rut){
        String query = "SELECT * FROM consulta WHERE rut_cliente=? AND estado='Pendiente'"
                + " AND ROWNUM=1 ORDER BY fecha desc";
        try (Connection conexion = Conexion.getConexion()) {
            PreparedStatement sql = conexion.prepareStatement(query);
            sql.setString(1, rut);
            ResultSet result = sql.executeQuery();
            while (result.next()) {
                ConsultaDto obj = new ConsultaDto();
                obj.setIdConsulta(result.getInt("id_consulta"));
                obj.setIdServicio(result.getInt("id_servicio"));
                obj.setRutCliente(result.getString("rut_cliente"));
                obj.setRutTrabajador(result.getString("rut_trabajador"));
                obj.setFecha(result.getDate("fecha"));
                obj.setEstado(result.getString("estado"));
                obj.setTotal(result.getInt("total"));
                obj.setHora(result.getInt("hora"));
                obj.setMinuto(result.getInt("minuto"));
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
