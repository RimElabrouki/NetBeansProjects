/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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
    @NamedQuery(name = "Socios.findAll", query = "SELECT s FROM Socios s")
    , @NamedQuery(name = "Socios.findById", query = "SELECT s FROM Socios s WHERE s.id = :id")
    , @NamedQuery(name = "Socios.findByNombre", query = "SELECT s FROM Socios s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Socios.findByApellido", query = "SELECT s FROM Socios s WHERE s.apellido = :apellido")
    , @NamedQuery(name = "Socios.findByDni", query = "SELECT s FROM Socios s WHERE s.dni = :dni")
    , @NamedQuery(name = "Socios.findByTelefono", query = "SELECT s FROM Socios s WHERE s.telefono = :telefono")
    , @NamedQuery(name = "Socios.findByDireccion", query = "SELECT s FROM Socios s WHERE s.direccion = :direccion")})
public class Socios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private String nombre;
    @Basic(optional = false)
    private String apellido;
    @Basic(optional = false)
    private String dni;
    @Basic(optional = false)
    private String telefono;
    @Basic(optional = false)
    private String direccion;
    @OneToMany(mappedBy = "idSocio")
    private List<Penalizaciones> penalizacionesList;
    @OneToMany(mappedBy = "idSocios")
    private List<Eventos> eventosList;
    @OneToMany(mappedBy = "idSocio")
    private List<Prestamos> prestamosList;
    @JoinColumn(name = "idPenalizacion", referencedColumnName = "id")
    @ManyToOne
    private Penalizaciones idPenalizacion;
    @JoinColumn(name = "idEvento", referencedColumnName = "id")
    @ManyToOne
    private Eventos idEvento;
    @JoinColumn(name = "idPrestamo", referencedColumnName = "id")
    @ManyToOne
    private Prestamos idPrestamo;

    public Socios() {
    }

    public Socios(Integer id) {
        this.id = id;
    }

    public Socios(Integer id, String nombre, String apellido, String dni, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlTransient
    public List<Penalizaciones> getPenalizacionesList() {
        return penalizacionesList;
    }

    public void setPenalizacionesList(List<Penalizaciones> penalizacionesList) {
        this.penalizacionesList = penalizacionesList;
    }

    @XmlTransient
    public List<Eventos> getEventosList() {
        return eventosList;
    }

    public void setEventosList(List<Eventos> eventosList) {
        this.eventosList = eventosList;
    }

    @XmlTransient
    public List<Prestamos> getPrestamosList() {
        return prestamosList;
    }

    public void setPrestamosList(List<Prestamos> prestamosList) {
        this.prestamosList = prestamosList;
    }

    public Penalizaciones getIdPenalizacion() {
        return idPenalizacion;
    }

    public void setIdPenalizacion(Penalizaciones idPenalizacion) {
        this.idPenalizacion = idPenalizacion;
    }

    public Eventos getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Eventos idEvento) {
        this.idEvento = idEvento;
    }

    public Prestamos getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Prestamos idPrestamo) {
        this.idPrestamo = idPrestamo;
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
        if (!(object instanceof Socios)) {
            return false;
        }
        Socios other = (Socios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Socios[ id=" + id + " ]";
    }
    
}
