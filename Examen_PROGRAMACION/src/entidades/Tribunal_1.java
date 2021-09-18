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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "tribunal", catalog = "concurso", schema = "")
@NamedQueries({
    @NamedQuery(name = "Tribunal_1.findAll", query = "SELECT t FROM Tribunal_1 t")
    , @NamedQuery(name = "Tribunal_1.findByIdtribunal", query = "SELECT t FROM Tribunal_1 t WHERE t.idtribunal = :idtribunal")
    , @NamedQuery(name = "Tribunal_1.findByNombre", query = "SELECT t FROM Tribunal_1 t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Tribunal_1.findByEmail", query = "SELECT t FROM Tribunal_1 t WHERE t.email = :email")
    , @NamedQuery(name = "Tribunal_1.findByDni", query = "SELECT t FROM Tribunal_1 t WHERE t.dni = :dni")
    , @NamedQuery(name = "Tribunal_1.findByTelefono", query = "SELECT t FROM Tribunal_1 t WHERE t.telefono = :telefono")})
public class Tribunal_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtribunal")
    private Integer idtribunal;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;

    public Tribunal_1() {
    }

    public Tribunal_1(Integer idtribunal) {
        this.idtribunal = idtribunal;
    }

    public Tribunal_1(Integer idtribunal, String nombre, String email, String dni, String telefono) {
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
        Integer oldIdtribunal = this.idtribunal;
        this.idtribunal = idtribunal;
        changeSupport.firePropertyChange("idtribunal", oldIdtribunal, idtribunal);
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtribunal != null ? idtribunal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tribunal_1)) {
            return false;
        }
        Tribunal_1 other = (Tribunal_1) object;
        if ((this.idtribunal == null && other.idtribunal != null) || (this.idtribunal != null && !this.idtribunal.equals(other.idtribunal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tribunal_1[ idtribunal=" + idtribunal + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
