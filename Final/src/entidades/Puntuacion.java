/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rim
 */
@Entity
@Table(catalog = "concurso", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puntuacion.findAll", query = "SELECT p FROM Puntuacion p")
    , @NamedQuery(name = "Puntuacion.findByIdpuntuacion", query = "SELECT p FROM Puntuacion p WHERE p.idpuntuacion = :idpuntuacion")
    , @NamedQuery(name = "Puntuacion.findByPuntuacion", query = "SELECT p FROM Puntuacion p WHERE p.puntuacion = :puntuacion")
    , @NamedQuery(name = "Puntuacion.findByEspecial", query = "SELECT p FROM Puntuacion p WHERE p.especial = :especial")})
public class Puntuacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer idpuntuacion;
    @Basic(optional = false)
    private int puntuacion;
    @Basic(optional = false)
    private boolean especial;
    @JoinColumn(name = "idaudicion", referencedColumnName = "idaudicion")
    @ManyToOne(optional = false)
    private Audicion idaudicion;
    @JoinColumn(name = "idtribunal", referencedColumnName = "idtribunal")
    @ManyToOne(optional = false)
    private Tribunal idtribunal;

    public Puntuacion() {
    }

    public Puntuacion(Integer idpuntuacion) {
        this.idpuntuacion = idpuntuacion;
    }

    public Puntuacion(Integer idpuntuacion, int puntuacion, boolean especial) {
        this.idpuntuacion = idpuntuacion;
        this.puntuacion = puntuacion;
        this.especial = especial;
    }

    public Integer getIdpuntuacion() {
        return idpuntuacion;
    }

    public void setIdpuntuacion(Integer idpuntuacion) {
        this.idpuntuacion = idpuntuacion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public boolean getEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    public Audicion getIdaudicion() {
        return idaudicion;
    }

    public void setIdaudicion(Audicion idaudicion) {
        this.idaudicion = idaudicion;
    }

    public Tribunal getIdtribunal() {
        return idtribunal;
    }

    public void setIdtribunal(Tribunal idtribunal) {
        this.idtribunal = idtribunal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpuntuacion != null ? idpuntuacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puntuacion)) {
            return false;
        }
        Puntuacion other = (Puntuacion) object;
        if ((this.idpuntuacion == null && other.idpuntuacion != null) || (this.idpuntuacion != null && !this.idpuntuacion.equals(other.idpuntuacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Puntuacion[ idpuntuacion=" + idpuntuacion + " ]";
    }
    
}
