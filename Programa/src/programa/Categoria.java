/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import java.util.ArrayList;

/**
 *
 * @author Rim
 */
public class Categoria {
    private int idScript;
    private String nombre;
    private ArrayList<Programa> programas = new ArrayList<Programa>();

    public Categoria() {
    }

    public Categoria(int idScript, String nombre) {
        this.idScript = idScript;
        this.nombre = nombre;
    }

    public int getIdScript() {
        return idScript;
    }

    public void setIdScript(int idScript) {
        this.idScript = idScript;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
      
    
}
