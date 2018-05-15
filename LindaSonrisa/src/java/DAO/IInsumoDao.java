
package DAO;
import DTO.InsumoDto;
import DTO.DetalleInsumoDto;
import java.util.List;
/**
 *
 * @author andres
 */
public interface IInsumoDao extends IBaseDao<InsumoDto> {
    
    public List<InsumoDto> buscarCriticos();
    
    public List<DetalleInsumoDto> buscarDetalles(InsumoDto obj);
    

}
