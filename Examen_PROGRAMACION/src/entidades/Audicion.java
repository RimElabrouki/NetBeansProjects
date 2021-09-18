/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Rim
 */
@Entity
@Table(name = "audicion", catalog = "concurso", schema = "")
@NamedQueries({
    @NamedQuery(name = "Audicion.findAll", query = "SELECT a FROM Audicion a")
    , @NamedQuery(name = "Audicion.findByIdaudicion", query = "SELECT a FROM Audicion a WHERE a.idaudicion = :idaudicion")
    , @NamedQuery(name = "Audicion.findByLugar", query = "SELECT a FROM Audicion a WHERE a.lugar = :lugar")
    , @NamedQuery(name = "Audicion.findByFechahora", query = "SELECT a FROM Audicion a WHERE a.fechahora = :fechahora")
    , @NamedQuery(name = "Audicion.findByPuntuacionmedia", query = "SELECT a FROM Audicion a WHERE a.puntuacionmedia = :puntuacionmedia")})
public class Audicion implements Serializable, Comparable<Audicion> {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idaudicion")
    private Integer idaudicion;
    @Basic(optional = false)
    @Column(name = "lugar")
    private String lugar;
    @Basic(optional = false)
    @Column(name = "fechahora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahora;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "puntuacionmedia")
    private BigDecimal puntuacionmedia;

    public Audicion() {
    }

    public Audicion(Integer idaudicion) {
        this.idaudicion = idaudicion;
    }

    public Audicion(Integer idaudicion, String lugar, Date fechahora) {
        this.idaudicion = idaudicion;
        this.lugar = lugar;
        this.fechahora = fechahora;
    }

    public Integer getIdaudicion() {
        return idaudicion;
    }

    public void setIdaudicion(Integer idaudicion) {
        Integer oldIdaudicion = this.idaudicion;
        this.idaudicion = idaudicion;
        changeSupport.firePropertyChange("idaudicion", oldIdaudicion, idaudicion);
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        String oldLugar = this.lugar;
        this.lugar = lugar;
        changeSupport.firePropertyChange("lugar", oldLugar, lugar);
    }

    public Date getFechahora() {
        return fechahora;
    }

    public void setFechahora(Date fechahora) {
        Date oldFechahora = this.fechahora;
        this.fechahora = fechahora;
        changeSupport.firePropertyChange("fechahora", oldFechahora, fechahora);
    }

    public BigDecimal getPuntuacionmedia() {
        return puntuacionmedia;
    }

    public void setPuntuacionmedia(BigDecimal puntuacionmedia) {
        BigDecimal oldPuntuacionmedia = this.puntuacionmedia;
        this.puntuacionmedia = puntuacionmedia;
        changeSupport.firePropertyChange("puntuacionmedia", oldPuntuacionmedia, puntuacionmedia);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaudicion != null ? idaudicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Audicion)) {
            return false;
        }
        Audicion other = (Audicion) object;
        if ((this.idaudicion == null && other.idaudicion != null) || (this.idaudicion != null && !this.idaudicion.equals(other.idaudicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Audicion[ idaudicion=" + idaudicion + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    @Override
    public int compareTo(Audicion a) {
       return this.getPuntuacionmedia().compareTo(a.getPuntuacionmedia());

    }

}
