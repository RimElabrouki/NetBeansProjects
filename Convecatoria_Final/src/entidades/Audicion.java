/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rim
 */
@Entity
@Table(catalog = "concurso", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Audicion.findAll", query = "SELECT a FROM Audicion a")
    , @NamedQuery(name = "Audicion.findByIdaudicion", query = "SELECT a FROM Audicion a WHERE a.idaudicion = :idaudicion")
    , @NamedQuery(name = "Audicion.findByLugar", query = "SELECT a FROM Audicion a WHERE a.lugar = :lugar")
    , @NamedQuery(name = "Audicion.findByFechahora", query = "SELECT a FROM Audicion a WHERE a.fechahora = :fechahora")
    , @NamedQuery(name = "Audicion.findByPuntuacionmedia", query = "SELECT a FROM Audicion a WHERE a.puntuacionmedia = :puntuacionmedia")})
public class Audicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer idaudicion;
    @Basic(optional = false)
    private String lugar;
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahora;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal puntuacionmedia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idaudicion")
    private Collection<Puntuacion> puntuacionCollection;

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
        this.idaudicion = idaudicion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFechahora() {
        return fechahora;
    }

    public void setFechahora(Date fechahora) {
        this.fechahora = fechahora;
    }

    public BigDecimal getPuntuacionmedia() {
        return puntuacionmedia;
    }

    public void setPuntuacionmedia(BigDecimal puntuacionmedia) {
        this.puntuacionmedia = puntuacionmedia;
    }

    @XmlTransient
    public Collection<Puntuacion> getPuntuacionCollection() {
        return puntuacionCollection;
    }

    public void setPuntuacionCollection(Collection<Puntuacion> puntuacionCollection) {
        this.puntuacionCollection = puntuacionCollection;
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
    
}
