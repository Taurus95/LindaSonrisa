package DTO;

import java.sql.Date;

public class DetallePedidoDto {

    private int idPedido;//FK
    private int idInsumo;
    private int cantidad;
    private int precioUnidad;
    private Date fecha_vencimiento;

    public DetallePedidoDto() {
    }

    public DetallePedidoDto(int idPedido, int idInsumo, int cantidad, int precioUnidad, Date fecha_vencimiento) {
        this.idPedido = idPedido;
        this.idInsumo = idInsumo;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
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
        return "DetallePedidoDto{" + "idPedido=" + idPedido + ", idInsumo=" + idInsumo + ", cantidad=" + cantidad + ", precioUnidad=" + precioUnidad + ", fecha_vencimiento=" + fecha_vencimiento + '}';
    }

}
