
package com.modelo;

/**
 *
 * @author Admin
 */
public class Venta {
    private int idVenta;
    private Cliente cliente;
    private Libro libro;
    private String fecha;
    private int cantidad;
    private double totalPagar;
    private DetalleEnvio detalleEnvio;

    public Venta() {
    }

    public Venta(int idVenta, Cliente cliente, Libro libro, String fecha, int cantidad, double totalPagar, DetalleEnvio detalleEnvio) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.libro = libro;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.totalPagar = totalPagar;
        this.detalleEnvio = detalleEnvio;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public DetalleEnvio getDetalleEnvio() {
        return detalleEnvio;
    }

    public void setDetalleEnvio(DetalleEnvio detalleEnvio) {
        this.detalleEnvio = detalleEnvio;
    }
    
    
}
