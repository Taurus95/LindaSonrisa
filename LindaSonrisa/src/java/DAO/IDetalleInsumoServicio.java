package DAO;
import DTO.DetalleInsumoServicioDto;
import java.util.List;
/**
 *
 * @author andres
 */
public interface IDetalleInsumoServicio extends IBaseDao<DetalleInsumoServicioDto> {
    
    public boolean eliminar(DetalleInsumoServicioDto obj);
    
    public List<DetalleInsumoServicioDto> listarPorServicio(int id_servicio);
    
}
