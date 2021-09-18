
import java.util.Calendar;
import java.util.Date;

public class ProgramaException extends Exception {

    public ProgramaException(String msg) {
        super(msg);
    }

    public static boolean validarNombre(String nombre) {
        boolean ret = true;

        if (nombre.isEmpty()) {
            ret = false;
        }
        if (nombre.length() < 3 || nombre.length() > 125) {
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

    public static boolean validarLenguaje(String lenguaje) {
        boolean ret = true;

        if (lenguaje.isEmpty()) {
            ret = false;
        }
        if (lenguaje.length() < 3 || lenguaje.length() > 125) {
            ret = false;
        }
        for (char c : lenguaje.toCharArray()) {
            if (Character.isDigit(c) || (!Character.isLetter(c) && c != ' ')) {
                ret = false;
                break;
            }

        }
        return ret;
    }

    public static boolean validarId(long tamanio) {
        boolean ret = true;

        if (tamanio <= 100) {
            ret = false;
        }

        return ret;
    }

    public static boolean isValidFecha(Date fechaHora) {
        // create un Calendario
        Calendar cal = Calendar.getInstance();
        // cambiar el estado indulgente ( change lenient state)
        cal.setLenient(false);
        //asigna el calendario para dar un fechaHora(assigns calendar to given date)
        cal.setTime(fechaHora);
        try {
            cal.getTime();
            return true;
        } catch (Exception e) {
            System.out.println("Formato de fecha inválido");
            return false;
        }
    }
    

}
