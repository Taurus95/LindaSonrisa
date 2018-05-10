
package DTO;

import java.util.Objects;


public class ProveedorDto {
   
    private String rut;//PK
    private String nombre;
    private String nombreContacto;
    private String telefonoContacto;
    private String correoContacto;
    private int idInsumo;//FK
    private boolean habilitado;

    public ProveedorDto() {
    }

    public ProveedorDto(String rut, String nombre, String nombreContacto, String telefonoContacto, String correoContacto, int idInsumo, boolean habilitado) {
        this.rut = rut;
        this.nombre = nombre;
        this.nombreContacto = nombreContacto;
        this.telefonoContacto = telefonoContacto;
        this.correoContacto = correoContacto;
        this.idInsumo = idInsumo;
        this.habilitado = habilitado;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getCorreoContacto() {
        return correoContacto;
    }

    public void setCorreoContacto(String correoContacto) {
        this.correoContacto = correoContacto;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.rut);
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
        final ProveedorDto other = (ProveedorDto) obj;
        if (!Objects.equals(this.rut, other.rut)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProveedorDto{" + "rut=" + rut + ", nombre=" + nombre + ", nombreContacto=" + nombreContacto + ", telefonoContacto=" + telefonoContacto + ", correoContacto=" + correoContacto + ", idInsumo=" + idInsumo + ", habilitado=" + habilitado + '}';
    }
    
    
}
