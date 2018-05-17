
package DTO;

import java.sql.Date;
import java.util.Objects;


public class ClienteDto {
    
    private String rut; //PK
    private String nombre;
    private String correo;
    private String sexo;
    private String direccion;
    private String telefono;
    private java.sql.Date fechaNacimiento;
    private String contrasenia;
    private boolean habilitado;

    public ClienteDto() {
    }

    public ClienteDto(String rut, String nombre, String correo, String sexo, String direccion, String telefono, Date fechaNacimiento, String contrasenia, boolean habilitado) {
        this.rut = rut;
        this.nombre = nombre;
        this.correo = correo;
        this.sexo = sexo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasenia = contrasenia;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public java.util.Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(java.util.Date fechaNacimiento) {
        this.fechaNacimiento = (Date) fechaNacimiento;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.rut);
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
        final ClienteDto other = (ClienteDto) obj;
        if (!Objects.equals(this.rut, other.rut)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClienteDto{" + "rut=" + rut + ", nombre=" + nombre + ", correo=" + correo + ", sexo=" + sexo + ", direccion=" + direccion + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", contrasenia=" + contrasenia + ", habilitado=" + habilitado + '}';
    }

    
}
