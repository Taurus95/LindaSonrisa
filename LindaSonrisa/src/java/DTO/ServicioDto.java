
package DTO;


public class ServicioDto {
    
    private int idServicio;//PK
    private String nombre;
    private String descripcion;
    private int precio;
    private boolean habilitado;

    public ServicioDto() {
    }

    public ServicioDto(int idServicio, String nombre, String descripcion, int precio, boolean habilitado) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.habilitado = habilitado;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idServicio;
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
        final ServicioDto other = (ServicioDto) obj;
        if (this.idServicio != other.idServicio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ServicioDto{" + "idServicio=" + idServicio + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", habilitado=" + habilitado + '}';
    }
    
    
}
