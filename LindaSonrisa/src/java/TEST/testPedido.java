package TEST;

import DTO.PedidoDto;
import DAO_IMP.PedidoDaoImp;
import DTO.DetalleInsumoDto;
import DTO.DetallePedidoDto;
import DAO_IMP.DetalleInsumoDaoImp;
import DAO_IMP.DetallePedidoDaoImp;
import java.security.Principal;
import java.sql.Date;

/**
 *
 * @author andres
 */
public class testPedido {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Principal.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PedidoDto pedidoNuevo = new PedidoDto();
        pedidoNuevo.setFechaPedido(new Date(2018, 06, 27));
        pedidoNuevo.setFechaEntrega(new Date(2018, 07, 12));
        pedidoNuevo.setEstado("Pediente");
        pedidoNuevo.setRutProveedor("10.726.928-5");
        pedidoNuevo.setRutTrabajador("11.756.660-9");
        pedidoNuevo.setComentario("se acaban de pedir 2 pinzas");
        pedidoNuevo.setValorTotal(10000);
        log.info("nuevo pedido: " + pedidoNuevo.toString());

        if (new PedidoDaoImp().agregar(pedidoNuevo)) {
            log.info("Agregado pedido");
            DetallePedidoDto detalleNuevo = new DetallePedidoDto();
            detalleNuevo.setIdPedido(new PedidoDaoImp().ultimoId());
            detalleNuevo.setCantidad(2);
            detalleNuevo.setFecha_vencimiento(null);
            detalleNuevo.setIdInsumo(6);
            detalleNuevo.setPrecioUnidad(5000);
            log.info("Detalle pedido a agregar: " + detalleNuevo.toString());
            if (new DetallePedidoDaoImp().agregar(detalleNuevo)) {
                log.info("detalle de pedido agregado.");
                log.info("cambiando estado del pedido, deberia agregar a detalle insumo y agregarse la cantiddad al insumo 6");
                PedidoDaoImp imp = new PedidoDaoImp();
                pedidoNuevo.setEstado("Realizada");
                imp.modificar(pedidoNuevo);
                log.info("SI todo salio correcto deberia estar agregado el detalleInsumo");
            }
        }
    }

}
