/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2021;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
    @NamedQuery(name = "Nivelhw.findAll", query = "SELECT n FROM Nivelhw n")
    , @NamedQuery(name = "Nivelhw.findByIdnivelhw", query = "SELECT n FROM Nivelhw n WHERE n.idnivelhw = :idnivelhw")
    , @NamedQuery(name = "Nivelhw.findByNombre", query = "SELECT n FROM Nivelhw n WHERE n.nombre = :nombre")
    , @NamedQuery(name = "Nivelhw.findByDni", query = "SELECT n FROM Nivelhw n WHERE n.dni = :dni")
    , @NamedQuery(name = "Nivelhw.findByExpertoen", query = "SELECT n FROM Nivelhw n WHERE n.expertoen = :expertoen")
    , @NamedQuery(name = "Nivelhw.findByEmail", query = "SELECT n FROM Nivelhw n WHERE n.email = :email")})
public class Nivelhw implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idnivelhw;
    @Basic(optional = false)
    private String nombre;
    @Basic(optional = false)
    private String dni;
    @Basic(optional = false)
    private String expertoen;
    @Basic(optional = false)
    private String email;
    @OneToMany(mappedBy = "idnivelhw")
    private List<Incidenciashw> incidenciashwList;

    public Nivelhw() {
    }

    public Nivelhw(Integer idnivelhw) {
        this.idnivelhw = idnivelhw;
    }

    public Nivelhw(Integer idnivelhw, String nombre, String dni, String expertoen, String email) {
        this.idnivelhw = idnivelhw;
        this.nombre = nombre;
        this.dni = dni;
        this.expertoen = expertoen;
        this.email = email;
    }

    public Integer getIdnivelhw() {
        return idnivelhw;
    }

    public void setIdnivelhw(Integer idnivelhw) {
        this.idnivelhw = idnivelhw;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getExpertoen() {
        return expertoen;
    }

    public void setExpertoen(String expertoen) {
        this.expertoen = expertoen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        hash += (idnivelhw != null ? idnivelhw.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nivelhw)) {
            return false;
        }
        Nivelhw other = (Nivelhw) object;
        if ((this.idnivelhw == null && other.idnivelhw != null) || (this.idnivelhw != null && !this.idnivelhw.equals(other.idnivelhw))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "examen2021.Nivelhw[ idnivelhw=" + idnivelhw + " ]";
    }
    
}
