/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(catalog = "biblioteca", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Penalizaciones.findAll", query = "SELECT p FROM Penalizaciones p")
    , @NamedQuery(name = "Penalizaciones.findById", query = "SELECT p FROM Penalizaciones p WHERE p.id = :id")
    , @NamedQuery(name = "Penalizaciones.findByMotivo", query = "SELECT p FROM Penalizaciones p WHERE p.motivo = :motivo")
    , @NamedQuery(name = "Penalizaciones.findByFecha", query = "SELECT p FROM Penalizaciones p WHERE p.fecha = :fecha")})
public class Penalizaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private String motivo;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idSocio", referencedColumnName = "id")
    @ManyToOne
    private Socios idSocio;
    @OneToMany(mappedBy = "idPenalizacion")
    private List<Socios> sociosList;

    public Penalizaciones() {
    }

    public Penalizaciones(Integer id) {
        this.id = id;
    }

    public Penalizaciones(Integer id, String motivo, Date fecha) {
        this.id = id;
        this.motivo = motivo;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Socios getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Socios idSocio) {
        this.idSocio = idSocio;
    }

    @XmlTransient
    public List<Socios> getSociosList() {
        return sociosList;
    }

    public void setSociosList(List<Socios> sociosList) {
        this.sociosList = sociosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Penalizaciones)) {
            return false;
        }
        Penalizaciones other = (Penalizaciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Penalizaciones[ id=" + id + " ]";
    }
    
}
