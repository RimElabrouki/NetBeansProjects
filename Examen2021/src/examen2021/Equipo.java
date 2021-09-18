/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2021;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rim
 */
@Entity
@Table(catalog = "incidencias", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipos.findAll", query = "SELECT e FROM Equipos e")
    , @NamedQuery(name = "Equipos.findByIdequipo", query = "SELECT e FROM Equipos e WHERE e.idequipo = :idequipo")
    , @NamedQuery(name = "Equipos.findByDiscoduro", query = "SELECT e FROM Equipos e WHERE e.discoduro = :discoduro")
    , @NamedQuery(name = "Equipos.findByRam", query = "SELECT e FROM Equipos e WHERE e.ram = :ram")
    , @NamedQuery(name = "Equipos.findBySo", query = "SELECT e FROM Equipos e WHERE e.so = :so")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idequipo;
    @Basic(optional = false)
    private int discoduro;
    @Basic(optional = false)
    private int ram;
    @Basic(optional = false)
    private String so;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idequipo")
    private List<Incidenciashw> incidenciashwList;

    public Equipo() {
    }

    public Equipo(Integer idequipo) {
        this.idequipo = idequipo;
    }

    public Equipo(Integer idequipo, int discoduro, int ram, String so) {
        this.idequipo = idequipo;
        this.discoduro = discoduro;
        this.ram = ram;
        this.so = so;
    }

    public Equipo(int idequipo, int ram, String so, int discoduro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(Integer idequipo) {
        this.idequipo = idequipo;
    }

    public int getDiscoduro() {
        return discoduro;
    }

    public void setDiscoduro(int discoduro) {
        this.discoduro = discoduro;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    @XmlTransient
    public List<Incidenciashw> getIncidenciashwList() {
        return incidenciashwList;
    }

    public void setIncidenciashwList(List<Incidenciashw> incidenciashwList) {
        this.incidenciashwList = incidenciashwList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idequipo != null ? idequipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.idequipo == null && other.idequipo != null) || (this.idequipo != null && !this.idequipo.equals(other.idequipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "examen2021.Equipos[ idequipo=" + idequipo + " ]";
    }
    
}
