/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import static entidades.Candidato_.nombre;


/**
 *
 * @author Rim x)
 * una nueva clase Rechazo que trabaje con genéricos
 */
public class Rechazo <I extends Candidato>{

    private int idrechazo;
    private I incidencia;// incidencia, del tipo genérico <I> donde I puede ser una incidencia HW o SW
    private String motivo;

    public Rechazo() {
    }

    public Rechazo(int idrechazo, I incidencia, String motivo) {
        this.idrechazo = idrechazo;
        this.incidencia = incidencia;
        this.motivo = motivo;
    }

    public int getIdrechazo() {
        return idrechazo;
    }

    public void setIdrechazo(int idrechazo) {
        this.idrechazo = idrechazo;
    }

    public I getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(I incidencia) {
        this.incidencia = incidencia;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    

/*sobrescribir el método toString() de esa clase para que muestre
el idrechazo, el motivo, el id de la incidencia y su descripcion y, 
    además, si se trata de una
incidencia SW indicar el idprograma al que se refiera o si es de tipo incidencia HW indicar el idequipo
del equipo al que se refiera la incidencia.

   
    @Override
    public String toString() {
        String tipoIncidencia;
        if (!this.incidencia.getClass().equals(Incidenciashw.class)) {
            tipoIncidencia = "HW";
        } else {
            tipoIncidencia = "SW";
        }
        return "Rechazo{" + "idrechazo=" + idrechazo + ", idincidencia="
                + incidencia.getIdincidencia() + ", descrip=" + this.incidencia.getDescripcion() + ", tipo "
                + tipoIncidencia + ", motivo de rechazo=" + motivo + '}';
    }
}*/

}
