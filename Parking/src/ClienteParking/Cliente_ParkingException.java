package ClienteParking;

public class Cliente_ParkingException extends Exception {

    public Cliente_ParkingException(String msg) {
        super(msg);
    }

    /**
     * Función que se le pasa un ClienteParking y comprueba si tiene valores
     * válidos en sus campos nombre, telefono y edad.
     *
     * @param c Cliente cuyos campos se van a comprobar
     * @return true si el ClienteParking tiene valores válidos en sus campos
     * nombre, telefono y edad; false en caso contrario.
     */
    public static boolean validarClienteParking(ClienteParking c) {
        return validarNombreClienteParking(c.getNombre())
                && validarTelefonoClienteParking(c.getTelefono())
                && validarEdadClienteParking(c.getEdad());
    }

    /**
     * *
     * Función que se le pasa una cadena de caracteres y comprueba si es válida
     * como valor para el nombre de un cliente Cadena de caracteres:[a-zA-Z, con
     * tildes, con diéresis] tamaño:[1-150] Obligatorio:Sí
     *
     * @param nombre cadena de caracteres a comprobar
     * @return true si la cadena es un valor válido para el nombre de un cliente
     * y false en caso contrario
     */
    public static boolean validarNombreClienteParking(String nombre) {
        boolean ret = true;
        if (nombre.isEmpty()) {
            ret = false;
        }
        if (nombre.length() < 1 || nombre.length() > 150) {
            ret = false;
        }
        for (char c : nombre.toCharArray()) {
            if (Character.isDigit(c) || (!Character.isLetter(c) && c!=' ')) {
                ret = false;
                break;
            }
        }
        return ret;
    }

    /**
     * *
     * Función que se le pasa una cadena de caracteres y comprueba si es válida
     * como valor para el telefono de un cliente Cadena de caracteres:[0-9]
     * tamaño:[9] Obligatorio:Sí
     *
     * @param telefono cadena de caracteres a comprobar
     * @return true si la cadena es un valor válido para el telefono de un
     * cliente y false en caso contrario
     */
    public static boolean validarTelefonoClienteParking(String telefono) {
        boolean ret = true;
        if (telefono.isEmpty()) {
            ret = false;
        }
        if (telefono.length() != 9) {
            ret = false;
        }
        if (!telefono.matches("[0-9]+")) {
            ret = false;
        }
        return ret;
    }

    /**
     * *
     * Función que se le pasa un entero y comprueba si es válida como valor para
     * la edad de un cliente entero: >=0 Obligatorio:Sí
     *
     * @param edad entero a comprobar
     * @return true si el entero es un valor válido para la edad de un cliente y
     * false en caso contrario
     */
    public static boolean validarEdadClienteParking(int edad) {
        boolean ret = true;
        if(edad<0)
            ret = false;
        return ret;
    }

}
