/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Rim
 */
public enum Lugares {
    Madrid(1, "Madrid"),
    Barcelona(2, "Barcelona"),
    Sevilla(3, "Sevilla"),
    Santander(4, "Santander");
    private int id;
    private String nombre;

    private Lugares(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    

}
