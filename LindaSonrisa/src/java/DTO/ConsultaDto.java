package DTO;

import java.sql.Date;

public class ConsultaDto {

    private int idConsulta;//PK
    private int idServicio;//FK
    private java.sql.Date fecha;
    private String rutCliente;//FK
    private String rutTrabajador;//FK
    private String estado;
    private int total;
    private int hora;
    private int minuto;

    public ConsultaDto() {
    }

    public ConsultaDto(int idConsulta, int idServicio, java.sql.Date fecha, String rutCliente, String rutTrabajador, String estado, int total, int hora, int minuto) {
        this.idConsulta = idConsulta;
        this.idServicio = idServicio;
        this.fecha = fecha;
        this.rutCliente = rutCliente;
        this.rutTrabajador = rutTrabajador;
        this.estado = estado;
        this.total = total;
        this.minuto = minuto;
        this.hora = hora;
    }

    public Date getFecha() {
        return fecha;
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

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    @Override
    public String toString() {
        return "ConsultaDto{" + "idConsulta=" + idConsulta + ", idServicio=" + idServicio + ", fecha=" + fecha + ", rutCliente=" + rutCliente + ", rutTrabajador=" + rutTrabajador + ", estado=" + estado + ", total=" + total + ", hora=" + hora + ", minuto=" + minuto + '}';
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


}
