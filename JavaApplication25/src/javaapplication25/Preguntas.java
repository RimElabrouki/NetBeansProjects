/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication25;

/**
 *
 * @author Rim
 */
public class Preguntas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        boolean ret;
        String Resp = "Siglo de Oro";
        // if statement
        
        System.out.println("¿A qué período pertenece Quevedo?");
        if (Resp.equals(Resp)){
         System.out.println("Siglo de Oro");
            System.out.println("Bien");
            ret = true;
    }else {
            System.out.println("Generación del 98.");
            ret = false;
        }
    }
}
