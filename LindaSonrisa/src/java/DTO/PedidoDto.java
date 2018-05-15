package DTO;

import java.sql.Date;


public class PedidoDto {
    
    private int idPedido;//PK
    private java.util.Date fechaPedido;
    private java.util.Date fechaEntrega;
    private int valorTotal;
    private String estado;
    private String rutTrabajador;//FK
    private String rutProveedor;//FK
    private String comentario;

    public PedidoDto() {
    }

    public PedidoDto(int idPedido, Date fechaPedido, Date fechaEntrega, int valorTotal, String estado, String rutTrabajador, String rutProveedor, String comentario) {
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.valorTotal = valorTotal;
        this.estado = estado;
        this.rutTrabajador = rutTrabajador;
        this.rutProveedor = rutProveedor;
        this.comentario = comentario;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFechaPedido() {
        return (Date) fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaEntrega() {
        return (Date) fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRutTrabajador() {
        return rutTrabajador;
    }

    public void setRutTrabajador(String rutTrabajador) {
        this.rutTrabajador = rutTrabajador;
    }

    public String getRutProveedor() {
        return rutProveedor;
    }

    public void setRutProveedor(String rutProveedor) {
        this.rutProveedor = rutProveedor;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.idPedido;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PedidoDto other = (PedidoDto) obj;
        if (this.idPedido != other.idPedido) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PedidoDto{" + "idPedido=" + idPedido + ", fechaPedido=" + fechaPedido + ", fechaEntrega=" + fechaEntrega + ", valorTotal=" + valorTotal + ", estado=" + estado + ", rutTrabajador=" + rutTrabajador + ", rutProveedor=" + rutProveedor + ", comentario=" + comentario + '}';
    }
    
    
    
    
}
