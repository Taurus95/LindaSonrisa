
package DAO;
import DTO.PedidoDto;
import java.util.List;
import java.util.Date;
import DTO.ProveedorDto;
import DTO.TrabajadorDto;
/**
 *
 * @author andres
 */
public interface IPedidoDao extends IBaseDao<PedidoDto> {
    
    public List<PedidoDto> listarPorFechaPedido(Date fecha1,Date fecha2);
    
    public List<PedidoDto> listarPorFechaEntrega(Date fecha1,Date fecha2);
    
    public List<PedidoDto> listarPorProveedor(ProveedorDto obj);
    
    public List<PedidoDto> listarPorTrabajador(TrabajadorDto obj);
    
    public List<PedidoDto> listarPorEstado(String aux);
    
}
