
package com.modelo;

/**
 *
 * @author Admin
 */
public class Envio {
    private int idEnvio;
    private double costoEnvio;
    private String destino;

    public Envio() {
    }

    public Envio(int idEnvio, double costoEnvio, String destino) {
        this.idEnvio = idEnvio;
        this.costoEnvio = costoEnvio;
        this.destino = destino;
    }

    public int getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(int idEnvio) {
        this.idEnvio = idEnvio;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    
}
