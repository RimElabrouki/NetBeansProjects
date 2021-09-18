/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author paloma
 */
public class Validaion extends Exception {

    public Validaion(String msg) {
        super(msg);
    }

    public static boolean validarId(int id) {
        boolean ret = true;

        if (id <= 0) {
            ret = false;
        }

        return ret;
    }

    public static boolean validarIdEsdtado(int idEstado) {
        boolean ret = true;

        if (idEstado < 1 || idEstado > 6) {
            ret = false;
        }

        return ret;
    }

    public static boolean validarDescripcion(String des) {
        boolean ret = true;
        if (des.length() <= 20 || des.length() > 500) {
            ret = false;
        }
        for (char c : des.toCharArray()) {
            if (Character.isDigit(c) || (!Character.isLetter(c) && c != ' ')) {
                ret = false;
                break;
            }

        }
        return ret;
    }

    public static boolean validarIdPrioridad(int idPrioridad) {
        boolean ret = true;

        if (idPrioridad < 0 || idPrioridad > 5) {
            ret = false;
        }

        return ret;
    }

    // Equipos
    public static boolean validarIdEquipo(int idEquipo) {
        boolean ret = true;
        if (idEquipo <= 0) {
            ret = false;
        }

        return ret;
    }

    public static boolean validarDisc(int disc) {
        boolean ret = true;
        if (disc < 1 || disc > 4096) {
            ret = false;
        }

        return ret;
    }

    public static boolean validarSo(String so) {
        boolean ret = true;
        if (so.length() <= 30 || so.length() > 50) {
            ret = false;
        }
        for (char c : so.toCharArray()) {
            if (Character.isDigit(c) || (!Character.isLetter(c) && c != ' ')) {
                ret = false;
                break;
            }

        }
        return ret;
    }

    public static boolean validarRam(int ram) {
        boolean ret = true;
        if (ram < 1) {
            ret = false;
        }

        return ret;
    }

//programas
    public static boolean validarIdProgramas(int id) {
        boolean ret = true;

        if (id <= 1) {
            ret = false;
        }

        return ret;
    }

    public static boolean validarTamanio(int tamanio) {
        boolean ret = true;

        if (tamanio < 1) {
            ret = false;
        }

        return ret;
    }

    public static boolean validarNombre(String des) {
        boolean ret = true;
        if (des.length() <= 20 || des.length() > 50) {
            ret = false;
        }
        for (char c : des.toCharArray()) {
            if (Character.isDigit(c) || (!Character.isLetter(c) && c != ' ')) {
                ret = false;
                break;
            }

        }
        return ret;
    }
    
    
       public static boolean validarversion (float version) {
        boolean ret = true;

        if ( version< 1.0 ) {
            ret = false;
        }
        
        return ret;
    }
       
      /* 
       //Devuelve true si la cadena que llega tiene la sintaxis de un decimal
public boolean esDecimal(String cad){
    NDigitos = 0;
    NDigitos = cad.length();
    //boolean hayPunto=false;
    StringBuffer parteEntera = new StringBuffer();
    StringBuffer parteDecimal = new StringBuffer();
    int i=0;
 
    for( i=0;i<cad.length(); i++ )                	      // length.- Devuelve el nº de caracteres del String, expresado en int.
        if ( cad.charAt(i) == '.'){                          //Detectar si hay un punto decimal en la cadena
            hayPunto=true;
        }
        if(hayPunto){                                       //Si hay punto guardar la posición donde se encuentra el carácter punto
            posicionDelPunto=cad.indexOf('.');                 //(si la cadena tiene varios puntos, detecta donde esta el primero).
        }
        else{
            return false;                                      //Si no hay punto; no es decimal
        }
        if( posicionDelPunto == cad.length()-1 || posicionDelPunto== 0){    //Si el punto esta al final o al principio no es un decimal
            return false;
        }
    for( i=0;i<posicionDelPunto; i++ ){
        parteEntera.append(cad.charAt(i)) ;                 //Guardar la parte entera en una variable
 
    }*/
 

}
