
package DTO;

import java.sql.Date;


public class ConsultaDto {
    
    private int idConsulta;//PK
    private int idServicio;//FK
    private java.util.Date fecha;
    private String rutCliente;//FK
    private String rutTrabajador;//FK
    private String estado;
    private int total;

    public ConsultaDto() {
    }

    public ConsultaDto(int idConsulta, int idServicio, Date fecha, String rutCliente, String rutTrabajador, String estado, int total) {
        this.idConsulta = idConsulta;
        this.idServicio = idServicio;
        this.fecha = fecha;
        this.rutCliente = rutCliente;
        this.rutTrabajador = rutTrabajador;
        this.estado = estado;
        this.total = total;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public Date getFecha() {
        return (Date) fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getRutTrabajador() {
        return rutTrabajador;
    }

    public void setRutTrabajador(String rutTrabajador) {
        this.rutTrabajador = rutTrabajador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idConsulta;
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
        final ConsultaDto other = (ConsultaDto) obj;
        if (this.idConsulta != other.idConsulta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConsultaDto{" + "idConsulta=" + idConsulta + ", idServicio=" + idServicio + ", fecha=" + fecha + ", rutCliente=" + rutCliente + ", rutTrabajador=" + rutTrabajador + ", estado=" + estado + ", total=" + total + '}';
    }
    
    
    
}
