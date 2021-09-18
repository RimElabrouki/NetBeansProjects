/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import java.util.Date;

/**
 *
 * @author Rim
 */
public class Programa {
    private int id;
    private String nombre;
    private double version;
    private long tamanio;
    private Date fecha;

    public Programa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public long getTamanio() {
        return tamanio;
    }

    public void setTamanio(long tamanio) {
        this.tamanio = tamanio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Programa(int id, String nombre, double version, long tamanio, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.version = version;
        this.tamanio = tamanio;
        this.fecha = fecha;
    }
    
    
            
    
}
