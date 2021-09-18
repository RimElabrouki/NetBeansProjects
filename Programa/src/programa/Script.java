/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

/**
 *
 * @author Rim
 */
public class Script extends Programa {
    private int idScript;
    private int numArchivos;
    private String lenguaje;

    public Script() {
    }

    public Script(int idScript, int numArchivos, String lenguaje) {
        this.idScript = idScript;
        this.numArchivos = numArchivos;
        this.lenguaje = lenguaje;
    }

    public int getIdScript() {
        return idScript;
    }

    public void setIdScript(int idScript) {
        this.idScript = idScript;
    }

    public int getNumArchivos() {
        return numArchivos;
    }

    public void setNumArchivos(int numArchivos) {
        this.numArchivos = numArchivos;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }
      public static Script nuevoScript ()  {
        return null;
      
      }
     
    
    
}
