/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Rim
 */
@Entity
@Table(name = "puntuacion", catalog = "concurso", schema = "")
@NamedQueries({
    @NamedQuery(name = "Puntuacion_1.findAll", query = "SELECT p FROM Puntuacion_1 p")
    , @NamedQuery(name = "Puntuacion_1.findByIdpuntuacion", query = "SELECT p FROM Puntuacion_1 p WHERE p.idpuntuacion = :idpuntuacion")
    , @NamedQuery(name = "Puntuacion_1.findByIdaudicion", query = "SELECT p FROM Puntuacion_1 p WHERE p.idaudicion = :idaudicion")
    , @NamedQuery(name = "Puntuacion_1.findByIdtribunal", query = "SELECT p FROM Puntuacion_1 p WHERE p.idtribunal = :idtribunal")
    , @NamedQuery(name = "Puntuacion_1.findByPuntuacion", query = "SELECT p FROM Puntuacion_1 p WHERE p.puntuacion = :puntuacion")
    , @NamedQuery(name = "Puntuacion_1.findByEspecial", query = "SELECT p FROM Puntuacion_1 p WHERE p.especial = :especial")})
public class Puntuacion_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idpuntuacion")
    private Integer idpuntuacion;
    @Basic(optional = false)
    @Column(name = "idaudicion")
    private int idaudicion;
    @Basic(optional = false)
    @Column(name = "idtribunal")
    private int idtribunal;
    @Basic(optional = false)
    @Column(name = "puntuacion")
    private int puntuacion;
    @Basic(optional = false)
    @Column(name = "especial")
    private boolean especial;

    public Puntuacion_1() {
    }

    public Puntuacion_1(Integer idpuntuacion) {
        this.idpuntuacion = idpuntuacion;
    }

    public Puntuacion_1(Integer idpuntuacion, int idaudicion, int idtribunal, int puntuacion, boolean especial) {
        this.idpuntuacion = idpuntuacion;
        this.idaudicion = idaudicion;
        this.idtribunal = idtribunal;
        this.puntuacion = puntuacion;
        this.especial = especial;
    }

    public Integer getIdpuntuacion() {
        return idpuntuacion;
    }

    public void setIdpuntuacion(Integer idpuntuacion) {
        Integer oldIdpuntuacion = this.idpuntuacion;
        this.idpuntuacion = idpuntuacion;
        changeSupport.firePropertyChange("idpuntuacion", oldIdpuntuacion, idpuntuacion);
    }

    public int getIdaudicion() {
        return idaudicion;
    }

    public void setIdaudicion(int idaudicion) {
        int oldIdaudicion = this.idaudicion;
        this.idaudicion = idaudicion;
        changeSupport.firePropertyChange("idaudicion", oldIdaudicion, idaudicion);
    }

    public int getIdtribunal() {
        return idtribunal;
    }

    public void setIdtribunal(int idtribunal) {
        int oldIdtribunal = this.idtribunal;
        this.idtribunal = idtribunal;
        changeSupport.firePropertyChange("idtribunal", oldIdtribunal, idtribunal);
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        int oldPuntuacion = this.puntuacion;
        this.puntuacion = puntuacion;
        changeSupport.firePropertyChange("puntuacion", oldPuntuacion, puntuacion);
    }

    public boolean getEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        boolean oldEspecial = this.especial;
        this.especial = especial;
        changeSupport.firePropertyChange("especial", oldEspecial, especial);
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
        if (!(object instanceof Puntuacion_1)) {
            return false;
        }
        Puntuacion_1 other = (Puntuacion_1) object;
        if ((this.idpuntuacion == null && other.idpuntuacion != null) || (this.idpuntuacion != null && !this.idpuntuacion.equals(other.idpuntuacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GUI.Puntuacion_1[ idpuntuacion=" + idpuntuacion + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
