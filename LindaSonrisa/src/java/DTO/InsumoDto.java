
package DTO;


public class InsumoDto {
    
    private int idInsumo;//PK
    private String descripcion;
    private int cantidadActual;
    private int cantidadCritica;
    private int cantidadMaxima;

    public InsumoDto() {
    }

    public InsumoDto(int idInsumo, String descripcion, int cantidadActual, int cantidadCritica, int cantidadMaxima) {
        this.idInsumo = idInsumo;
        this.descripcion = descripcion;
        this.cantidadActual = cantidadActual;
        this.cantidadCritica = cantidadCritica;
        this.cantidadMaxima = cantidadMaxima;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public int getCantidadCritica() {
        return cantidadCritica;
    }

    public void setCantidadCritica(int cantidadCritica) {
        this.cantidadCritica = cantidadCritica;
    }

    public int getCantidadMaxima() {
        return cantidadMaxima;
    }

    public void setCantidadMaxima(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.idInsumo;
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
        final InsumoDto other = (InsumoDto) obj;
        if (this.idInsumo != other.idInsumo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InsumoDto{" + "idInsumo=" + idInsumo + ", descripcion=" + descripcion + ", cantidadActual=" + cantidadActual + ", cantidadCritica=" + cantidadCritica + ", cantidadMaxima=" + cantidadMaxima + '}';
    }
    
    
    
}
