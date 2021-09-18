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
    @NamedQuery(name = "Nivelsw.findAll", query = "SELECT n FROM Nivelsw n")
    , @NamedQuery(name = "Nivelsw.findByIdnivelsw", query = "SELECT n FROM Nivelsw n WHERE n.idnivelsw = :idnivelsw")
    , @NamedQuery(name = "Nivelsw.findByNombre", query = "SELECT n FROM Nivelsw n WHERE n.nombre = :nombre")
    , @NamedQuery(name = "Nivelsw.findByDni", query = "SELECT n FROM Nivelsw n WHERE n.dni = :dni")
    , @NamedQuery(name = "Nivelsw.findByExpertoen", query = "SELECT n FROM Nivelsw n WHERE n.expertoen = :expertoen")
    , @NamedQuery(name = "Nivelsw.findByEmail", query = "SELECT n FROM Nivelsw n WHERE n.email = :email")})
public class Nivelsw implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idnivelsw;
    @Basic(optional = false)
    private String nombre;
    @Basic(optional = false)
    private String dni;
    @Basic(optional = false)
    private String expertoen;
    @Basic(optional = false)
    private String email;
    @OneToMany(mappedBy = "idnivelsw")
    private List<Incidenciassw> incidenciasswList;

    public Nivelsw() {
    }

    public Nivelsw(Integer idnivelsw) {
        this.idnivelsw = idnivelsw;
    }

    public Nivelsw(Integer idnivelsw, String nombre, String dni, String expertoen, String email) {
        this.idnivelsw = idnivelsw;
        this.nombre = nombre;
        this.dni = dni;
        this.expertoen = expertoen;
        this.email = email;
    }

    public Integer getIdnivelsw() {
        return idnivelsw;
    }

    public void setIdnivelsw(Integer idnivelsw) {
        this.idnivelsw = idnivelsw;
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
    public List<Incidenciassw> getIncidenciasswList() {
        return incidenciasswList;
    }

    public void setIncidenciasswList(List<Incidenciassw> incidenciasswList) {
        this.incidenciasswList = incidenciasswList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnivelsw != null ? idnivelsw.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nivelsw)) {
            return false;
        }
        Nivelsw other = (Nivelsw) object;
        if ((this.idnivelsw == null && other.idnivelsw != null) || (this.idnivelsw != null && !this.idnivelsw.equals(other.idnivelsw))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "examen2021.Nivelsw[ idnivelsw=" + idnivelsw + " ]";
    }
    
}
