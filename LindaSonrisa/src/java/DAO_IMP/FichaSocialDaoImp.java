package DAO_IMP;

import DAO.IBaseDao;
import DTO.FichaSocialDto;
import java.sql.Connection;
import java.util.List;
import BBDD.Conexion;
import java.security.Principal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author andres
 */
public class FichaSocialDaoImp implements IBaseDao<FichaSocialDto> {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Principal.class);

    //creo que este metodo no sera necesario, de serlo se crea
    @Override
    public List<FichaSocialDto> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregar(FichaSocialDto obj) {
        String query = "INSERT INTO ficha_social VAlUES(?,?,?,?,?,?)";
        try (Connection conection = Conexion.getConexion()) {
            PreparedStatement sql = conection.prepareStatement(query);
            sql.setString(1, obj.getRutCliente());
            sql.setBlob(5, obj.getCertificadoAFP());
            sql.setBlob(6, obj.getFiniquito());
            sql.setBlob(2, obj.getLiquidacion1());
            sql.setBlob(3, obj.getLiquidacion2());
            sql.setBlob(4, obj.getLiquidacion3());

            if (sql.execute()) {
                conection.close();
                return true;
            }
        } catch (SQLException ex) {
            log.error("Error agregando ficha social " + ex.getMessage());
        } catch (Exception e) {
            log.error("Error agregando ficha social " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean modificar(FichaSocialDto obj) {
        String query = "UPDATE ficha_social SET liquidacion1=?,liquidacion2=?,liquidacion3=?,"
                + "certificado_AFP=?,finiquito=? WHERE rut_cliente=?";
        try (Connection conection = Conexion.getConexion()) {
            PreparedStatement sql = conection.prepareStatement(query);
            sql.setString(6, obj.getRutCliente());
            sql.setBlob(4, obj.getCertificadoAFP());
            sql.setBlob(5, obj.getFiniquito());
            sql.setBlob(1, obj.getLiquidacion1());
            sql.setBlob(2, obj.getLiquidacion2());
            sql.setBlob(3, obj.getLiquidacion3());

            if (sql.executeUpdate() == 1) {
                conection.close();
                return true;
            }
        } catch (SQLException ex) {
            log.error("Error modificando ficha social " + ex.getMessage());
        } catch (Exception e) {
            log.error("Error modificando ficha social " + e.getMessage());
        }
        return false;
    }

    @Override
    public FichaSocialDto buscar(FichaSocialDto obj) {
        String query= "SELECT * FROM ficha_social WHERE rut_cliente = ?";
        try(Connection conection = Conexion.getConexion()){
            PreparedStatement sql = conection.prepareStatement(query);
            sql.setString(1, obj.getRutCliente());
            try(ResultSet result = sql.executeQuery()){
                while(result.next()){
                    obj.setRutCliente(result.getString("rut_cliente"));
                    obj.setLiquidacion1(result.getBlob("liquidacion1"));
                    obj.setLiquidacion2(result.getBlob("liquidacion2"));
                    obj.setLiquidacion3(result.getBlob("liquidacion3"));
                    obj.setCertificadoAFP(result.getBlob("certificado_AFP"));
                    obj.setFiniquito(result.getBlob("finiquito"));
                }
            }
            conection.close();
        } catch (SQLException ex) {
            log.error("Error buscando ficha social " + ex.getMessage());
        } catch (Exception e) {
            log.error("Error buscando ficha social " + e.getMessage());
        }
        return obj;
    }

}
