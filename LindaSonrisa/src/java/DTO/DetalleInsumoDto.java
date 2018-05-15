
package DTO;

import java.sql.Date;
import java.util.Objects;


public class DetalleInsumoDto {
    
    private String codigo;//PK
    private int idInsumo;//FK
    private int cantidadActual;
    private java.util.Date fechaVencimiento;
    private int precioCompraUnidad;
    private java.util.Date fechaLlegada;

    public DetalleInsumoDto() {
        
    }

    public DetalleInsumoDto(String codigo, int idInsumo, int cantidadActual, Date fechaVencimiento, int precioCompraUnidad, Date fechaLlegada) {
        this.codigo = codigo;
        this.idInsumo = idInsumo;
        this.cantidadActual = cantidadActual;
        this.fechaVencimiento = fechaVencimiento;
        this.precioCompraUnidad = precioCompraUnidad;
        this.fechaLlegada = fechaLlegada;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public Date getFechaVencimiento() {
        return (Date) fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getPrecioCompraUnidad() {
        return precioCompraUnidad;
    }

    public void setPrecioCompraUnidad(int precioCompraUnidad) {
        this.precioCompraUnidad = precioCompraUnidad;
    }

    public Date getFechaLlegada() {
        return (Date) fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.codigo);
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
        final DetalleInsumoDto other = (DetalleInsumoDto) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleInsumoDto{" + "codigo=" + codigo + ", idInsumo=" + idInsumo + ", cantidadActual=" + cantidadActual + ", fechaVencimiento=" + fechaVencimiento + ", precioCompraUnidad=" + precioCompraUnidad + ", fechaLlegada=" + fechaLlegada + '}';
    }
    
    
    
}
