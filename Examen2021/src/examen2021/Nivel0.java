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
    @NamedQuery(name = "Nivel0.findAll", query = "SELECT n FROM Nivel0 n")
    , @NamedQuery(name = "Nivel0.findByIdnivel0", query = "SELECT n FROM Nivel0 n WHERE n.idnivel0 = :idnivel0")
    , @NamedQuery(name = "Nivel0.findByNombre", query = "SELECT n FROM Nivel0 n WHERE n.nombre = :nombre")
    , @NamedQuery(name = "Nivel0.findByDni", query = "SELECT n FROM Nivel0 n WHERE n.dni = :dni")
    , @NamedQuery(name = "Nivel0.findByTelefono", query = "SELECT n FROM Nivel0 n WHERE n.telefono = :telefono")
    , @NamedQuery(name = "Nivel0.findByEmail", query = "SELECT n FROM Nivel0 n WHERE n.email = :email")})
public class Nivel0 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idnivel0;
    @Basic(optional = false)
    private String nombre;
    @Basic(optional = false)
    private String dni;
    private String telefono;
    @Basic(optional = false)
    private String email;
    @OneToMany(mappedBy = "idnivel0")
    private List<Incidencias> incidenciasList;

    public Nivel0() {
    }

    public Nivel0(Integer idnivel0) {
        this.idnivel0 = idnivel0;
    }

    public Nivel0(Integer idnivel0, String nombre, String dni, String email) {
        this.idnivel0 = idnivel0;
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
    }

    public Integer getIdnivel0() {
        return idnivel0;
    }

    public void setIdnivel0(Integer idnivel0) {
        this.idnivel0 = idnivel0;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<Incidencias> getIncidenciasList() {
        return incidenciasList;
    }

    public void setIncidenciasList(List<Incidencias> incidenciasList) {
        this.incidenciasList = incidenciasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnivel0 != null ? idnivel0.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nivel0)) {
            return false;
        }
        Nivel0 other = (Nivel0) object;
        if ((this.idnivel0 == null && other.idnivel0 != null) || (this.idnivel0 != null && !this.idnivel0.equals(other.idnivel0))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "examen2021.Nivel0[ idnivel0=" + idnivel0 + " ]";
    }
    
}
