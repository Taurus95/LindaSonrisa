package DAO;
import DTO.DetalleInsumoServicioDto;
/**
 *
 * @author andres
 */
public interface IDetalleInsumoServicio extends IBaseDao<DetalleInsumoServicioDto> {
    
    public boolean eliminar(DetalleInsumoServicioDto obj);
    
}
