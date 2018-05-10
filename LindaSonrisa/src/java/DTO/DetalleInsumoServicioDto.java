
package DTO;


public class DetalleInsumoServicioDto {
    
    private int idServicio;//FK
    private int idInsumo;
    private int cantidadInsumo;

    public DetalleInsumoServicioDto() {
    }

    public DetalleInsumoServicioDto(int idServicio, int idInsumo, int cantidadInsumo) {
        this.idServicio = idServicio;
        this.idInsumo = idInsumo;
        this.cantidadInsumo = cantidadInsumo;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public int getCantidadInsumo() {
        return cantidadInsumo;
    }

    public void setCantidadInsumo(int cantidadInsumo) {
        this.cantidadInsumo = cantidadInsumo;
    }

    @Override
    public String toString() {
        return "DetalleInsumoServicioDto{" + "idServicio=" + idServicio + ", idInsumo=" + idInsumo + ", cantidadInsumo=" + cantidadInsumo + '}';
    }
    
    
}
