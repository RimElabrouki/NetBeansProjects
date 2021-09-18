/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rim
 */
class RecetaException extends Exception {

public RecetaException(String msg) {
        super(msg);
    }

  public static boolean validarNombreReceta(String nombrePizza) {
        boolean ret = true;
        if (nombrePizza.isEmpty()) {
            ret = false;
        }
        if (nombrePizza.length() < 1 || nombrePizza.length() > 150) {
            ret = false;
        }
        for (char c : nombrePizza.toCharArray()) {
                if (!Character.isDigit(c) || (!Character.isLetter(c) && c!=' ')) {
                ret = false;
                break;
            }
        }
        return ret;
    }
    public static boolean validarvalorEnergitico(int valorEnergitico) {
        boolean ret = true;
        if(valorEnergitico<100)
          ret = false;
        return ret;
     
    }
        public static boolean validaraltura(int altura) {
        boolean ret = true;
        if(altura<5 && altura>25 )
          ret = false;
        return ret;
     
    }
    
}
