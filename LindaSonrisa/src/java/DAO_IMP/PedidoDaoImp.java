package DAO_IMP;
import DAO.IPedidoDao;
import DTO.PedidoDto;
import DTO.ProveedorDto;
import DTO.TrabajadorDto;
import java.util.Date;
import java.util.List;
/**
 *
 * @author andres
 */
public class PedidoDaoImp implements IPedidoDao {

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(PedidoDto obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PedidoDto buscar(PedidoDto obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
