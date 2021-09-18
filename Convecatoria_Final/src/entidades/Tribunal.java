/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
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
@Table(catalog = "concurso", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tribunal.findAll", query = "SELECT t FROM Tribunal t")
    , @NamedQuery(name = "Tribunal.findByIdtribunal", query = "SELECT t FROM Tribunal t WHERE t.idtribunal = :idtribunal")
    , @NamedQuery(name = "Tribunal.findByNombre", query = "SELECT t FROM Tribunal t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Tribunal.findByEmail", query = "SELECT t FROM Tribunal t WHERE t.email = :email")
    , @NamedQuery(name = "Tribunal.findByDni", query = "SELECT t FROM Tribunal t WHERE t.dni = :dni")
    , @NamedQuery(name = "Tribunal.findByTelefono", query = "SELECT t FROM Tribunal t WHERE t.telefono = :telefono")})
public class Tribunal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idtribunal;
    @Basic(optional = false)
    private String nombre;
    @Basic(optional = false)
    private String email;
    @Basic(optional = false)
    private String dni;
    @Basic(optional = false)
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtribunal")
    private Collection<Puntuacion> puntuacionCollection;

    public Tribunal() {
    }

    public Tribunal(Integer idtribunal) {
        this.idtribunal = idtribunal;
    }

    public Tribunal(Integer idtribunal, String nombre, String email, String dni, String telefono) {
        this.idtribunal = idtribunal;
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
    }

    public Integer getIdtribunal() {
        return idtribunal;
    }

    public void setIdtribunal(Integer idtribunal) {
        this.idtribunal = idtribunal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        hash += (idtribunal != null ? idtribunal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tribunal)) {
            return false;
        }
        Tribunal other = (Tribunal) object;
        if ((this.idtribunal == null && other.idtribunal != null) || (this.idtribunal != null && !this.idtribunal.equals(other.idtribunal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tribunal[ idtribunal=" + idtribunal + " ]";
    }
    
}
