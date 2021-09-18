/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validacion;

import entidades.Persona;

/**
 *
 * @author Rim
 */
public class PersonaException extends Exception {

    public PersonaException(String msg) {
        super(msg);
    }

//valor entero > 0
    public static boolean validarId(int Idpersona) {
        return Idpersona > 0;
    
    }

    public static boolean validarNombre(String nombre) {
        boolean ret = true;

        if (nombre.isEmpty()) {
            ret = false;
        }
        if (nombre.length() >= 2 || nombre.length() <= 150) {
            ret = false;
        }
        for (char c : nombre.toCharArray()) {
            if (Character.isDigit(c) || (!Character.isLetter(c) && c != ' ')) {
                ret = false;
                break;
            }

        }
        return ret;
    }

    public static boolean validarEmail(String email) {
        boolean ret = true;

        if (email.isEmpty()) {
            ret = false;
        }
        if (email.length() >= 2 || email.length() <= 50) {
            ret = false;
        }
        for (char c : email.toCharArray()) {
            if (Character.isDigit(c) || (!Character.isLetter(c))) {
                ret = false;
                break;
            }

        }
        return ret;
    }

    public static boolean validarTlfn(String tlfn) {
        boolean ret = true;
        if (tlfn.length() != 11 && tlfn.length() != 12 && tlfn.length() != 9) {
            ret = false;
        }
        for (char c : tlfn.toCharArray()) {
            if ((Character.isLetter(c) && c != ' ') || !Character.isDigit(c)) {
                ret = false;
                break;
            }
        }
        return ret;
    } 
    
    private static boolean soloNumeros(String dni) {

        int i, j = 0;
        String numero = ""; // Es el número que se comprueba uno a uno por si hay alguna letra entre los 8 primeros dígitos
        String miDNI = ""; // Guardamos en una cadena los números para después calcular la letra
        String[] unoNueve = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (i = 0; i < dni.length() - 1; i++) {
            numero = dni.substring(i, i + 1);

            for (j = 0; j < unoNueve.length; j++) {
                if (numero.equals(unoNueve[j])) {
                    miDNI += unoNueve[j];
                }
            }
        }

        if (miDNI.length() != 8) {
            return false;
        } else {
            return true;
        }
    }
    
    
    private static String letraDNI(String dni) {
        // El método es privado porque lo voy a usar internamente en esta clase, no se necesita fuera de ella

        // pasar miNumero a integer
        int miDNI = Integer.parseInt(dni.substring(0, 8));
        int resto = 0;
        String miLetra = "";
        String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

        resto = miDNI % 23;

        miLetra = asignacionLetra[resto];

        return miLetra;
    }
     
    
    public static boolean validarDNI(String dni) {

        String letraMayuscula = ""; //Guardaremos la letra introducida en formato mayúscula

        // Aquí excluimos cadenas distintas a 9 caracteres que debe tener un dni y también si el último caracter no es una letra
        if (dni.length() != 9 || Character.isLetter(dni.charAt(8)) == false) {
            return false;
        }

        // Al superar la primera restricción, la letra la pasamos a mayúscula
        letraMayuscula = (dni.substring(8)).toUpperCase();

        // Por último validamos que sólo tengo 8 dígitos entre los 8 primeros caracteres y que la letra introducida es igual a la de la ecuación
        // Llamamos a los métodos privados de la clase soloNumeros() y letraDNI()
        if (PersonaException.soloNumeros(dni) == true && PersonaException.letraDNI(dni).equals(letraMayuscula)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validarPersona(Persona p) throws PersonaException {
        if (!validarId(p.getIdpersona())) {
            throw new PersonaException("El id de la Persona  ha de ser >0.");
        }

        if (!validarNombre(p.getNombre())) {
            throw new PersonaException("cadena tamaño < 2,cadena tamaño > 150,cadena con caracteres no permitidos.");
        }
        
          if (!validarEmail(p.getEmail())) {
            throw new PersonaException("El Nombre del prsona ha tener entre 2 y 50 caracteres.");
        }
        
           if (!validarTlfn(p.getTelefono())) {
            throw new PersonaException("cadena tamaño no igual a 9, cadena con caracteres no numéricos.");
        }
           
              if (!validarDNI(p.getTelefono())) {
            throw new PersonaException("cadena tamaño no igual 9,cadena que comienza por letra cadena que termina en un carácter numérico cadena que termina en 2  más letras cadena que termina en letra minúscula.");
        }
          

        return true;
    }
}

