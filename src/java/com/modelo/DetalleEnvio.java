
package com.modelo;

/**
 *
 * @author Admin
 */
public class DetalleEnvio {
    private int idDetalleEnvio;
    private Envio envio;
    private int idEstadoEnvio;
    private String tiempoEnvio;

    public DetalleEnvio() {
    }

    public DetalleEnvio(int idDetalleEnvio, Envio envio, int idEstadoEnvio, String tiempoEnvio) {
        this.idDetalleEnvio = idDetalleEnvio;
        this.envio = envio;
        this.idEstadoEnvio = idEstadoEnvio;
        this.tiempoEnvio = tiempoEnvio;
    }

    public int getIdDetalleEnvio() {
        return idDetalleEnvio;
    }

    public void setIdDetalleEnvio(int idDetalleEnvio) {
        this.idDetalleEnvio = idDetalleEnvio;
    }

    public Envio getEnvio() {
        return envio;
    }

    public void setEnvio(Envio envio) {
        this.envio = envio;
    }

    public int getIdEstadoEnvio() {
        return idEstadoEnvio;
    }

    public void setIdEstadoEnvio(int idEstadoEnvio) {
        this.idEstadoEnvio = idEstadoEnvio;
    }

    public String getTiempoEnvio() {
        return tiempoEnvio;
    }

    public void setTiempoEnvio(String tiempoEnvio) {
        this.tiempoEnvio = tiempoEnvio;
    }

    
}
