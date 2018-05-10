
package DTO;


public class DetallePedidoDto {
    
    private int idPedido;//FK
    private int idInsumo;
    private int cantidad;
    private int precioUnidad;

    public DetallePedidoDto() {
    }

    public DetallePedidoDto(int idPedido, int idInsumo, int cantidad, int precioUnidad) {
        this.idPedido = idPedido;
        this.idInsumo = idInsumo;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(int precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    @Override
    public String toString() {
        return "DetallePedidoDto{" + "idPedido=" + idPedido + ", idInsumo=" + idInsumo + ", cantidad=" + cantidad + ", precioUnidad=" + precioUnidad + '}';
    }
    
    
    
    
}
