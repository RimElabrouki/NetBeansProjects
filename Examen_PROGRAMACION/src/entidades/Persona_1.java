/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

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
@Table(name = "persona", catalog = "concurso", schema = "")
@NamedQueries({
    @NamedQuery(name = "Persona_1.findAll", query = "SELECT p FROM Persona_1 p")
    , @NamedQuery(name = "Persona_1.findByIdpersona", query = "SELECT p FROM Persona_1 p WHERE p.idpersona = :idpersona")
    , @NamedQuery(name = "Persona_1.findByNombre", query = "SELECT p FROM Persona_1 p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Persona_1.findByEmail", query = "SELECT p FROM Persona_1 p WHERE p.email = :email")
    , @NamedQuery(name = "Persona_1.findByDni", query = "SELECT p FROM Persona_1 p WHERE p.dni = :dni")
    , @NamedQuery(name = "Persona_1.findByTelefono", query = "SELECT p FROM Persona_1 p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Persona_1.findByIdcandidato", query = "SELECT p FROM Persona_1 p WHERE p.idcandidato = :idcandidato")})
public class Persona_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idpersona")
    private Integer idpersona;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "dni")
    private String dni;
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "idcandidato")
    private int idcandidato;

    public Persona_1() {
    }

    public Persona_1(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public Persona_1(Integer idpersona, String nombre, String dni, int idcandidato) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.dni = dni;
        this.idcandidato = idcandidato;
    }

    public Integer getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Integer idpersona) {
        Integer oldIdpersona = this.idpersona;
        this.idpersona = idpersona;
        changeSupport.firePropertyChange("idpersona", oldIdpersona, idpersona);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        String oldDni = this.dni;
        this.dni = dni;
        changeSupport.firePropertyChange("dni", oldDni, dni);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        String oldTelefono = this.telefono;
        this.telefono = telefono;
        changeSupport.firePropertyChange("telefono", oldTelefono, telefono);
    }

    public int getIdcandidato() {
        return idcandidato;
    }

    public void setIdcandidato(int idcandidato) {
        int oldIdcandidato = this.idcandidato;
        this.idcandidato = idcandidato;
        changeSupport.firePropertyChange("idcandidato", oldIdcandidato, idcandidato);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpersona != null ? idpersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona_1)) {
            return false;
        }
        Persona_1 other = (Persona_1) object;
        if ((this.idpersona == null && other.idpersona != null) || (this.idpersona != null && !this.idpersona.equals(other.idpersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Persona_1[ idpersona=" + idpersona + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
