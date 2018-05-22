
package DTO;

import java.sql.Date;
import java.util.Objects;


public class TrabajadorDto {
    
    private String rut;//PK
    private String nombre;
    private java.util.Date fechaNacimiento;
    private String sexo;
    private String correo;
    private String direccion;
    private String telefono;
    private String contrasenia;
    private String tipo;
    private String especialidad;
    private boolean habilitado;

    public TrabajadorDto() {
    }

    public TrabajadorDto(String rut, String nombre, Date fechaNacimiento, String sexo, String correo, String direccion, String telefono, String contrasenia, String tipo, String especialidad, boolean habilitado) {
        this.rut = rut;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        this.tipo = tipo;
        this.especialidad = especialidad;
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

    public Date getFechaNacimiento() {
        return (Date) fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public String getSexo(){
        return sexo;
    }
    
    public void setSexo (String sexo){
        this.sexo = sexo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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
        hash = 71 * hash + Objects.hashCode(this.rut);
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
        final TrabajadorDto other = (TrabajadorDto) obj;
        if (!Objects.equals(this.rut, other.rut)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TrabajadorDto{" + "rut=" + rut + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo +", correo=" + correo + ", direccion=" + direccion + ", telefono=" + telefono + ", contrasenia=" + contrasenia + ", tipo=" + tipo + ", especialidad=" + especialidad + ", habilitado=" + habilitado + '}';
    }
    
    
    
}
