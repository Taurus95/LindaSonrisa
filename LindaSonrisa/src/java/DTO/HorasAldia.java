package DTO;

/**
 *
 * @author andres
 */
public class HorasAldia {

    private int hora;
    private int minutos;
    private String estado;
    private String doctor;

    public HorasAldia() {
    }

    public HorasAldia(int hora, int minutos, String estado, String doctor) {
        this.hora = hora;
        this.minutos = minutos;
        this.estado = estado;
        this.doctor = doctor;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "HorasAldia{" + "hora=" + hora + ", minutos=" + minutos + ", estado=" + estado + ", doctor=" + doctor + '}';
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

}
