
package DTO;
import java.sql.Blob;


public class FichaSocialDto {
    
    private String rutCliente;//FK
    private Blob liquidacion1;
    private Blob liquidacion2;
    private Blob liquidacion3;
    private Blob certificadoAFP;
    private Blob finiquito;

    public FichaSocialDto(String rutCliente, Blob liquidacion1, Blob liquidacion2, Blob liquidacion3, Blob certificadoAFP, Blob finiquito) {
        this.rutCliente = rutCliente;
        this.liquidacion1 = liquidacion1;
        this.liquidacion2 = liquidacion2;
        this.liquidacion3 = liquidacion3;
        this.certificadoAFP = certificadoAFP;
        this.finiquito = finiquito;
    }

    public FichaSocialDto() {
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public Blob getLiquidacion1() {
        return liquidacion1;
    }

    public void setLiquidacion1(Blob liquidacion1) {
        this.liquidacion1 = liquidacion1;
    }

    public Blob getLiquidacion2() {
        return liquidacion2;
    }

    public void setLiquidacion2(Blob liquidacion2) {
        this.liquidacion2 = liquidacion2;
    }

    public Blob getLiquidacion3() {
        return liquidacion3;
    }

    public void setLiquidacion3(Blob liquidacion3) {
        this.liquidacion3 = liquidacion3;
    }

    public Blob getCertificadoAFP() {
        return certificadoAFP;
    }

    public void setCertificadoAFP(Blob certificadoAFP) {
        this.certificadoAFP = certificadoAFP;
    }

    public Blob getFiniquito() {
        return finiquito;
    }

    public void setFiniquito(Blob finiquito) {
        this.finiquito = finiquito;
    }
    
    
}
