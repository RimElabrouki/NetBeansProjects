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
    @NamedQuery(name = "Generos.findAll", query = "SELECT g FROM Generos g")
    , @NamedQuery(name = "Generos.findById", query = "SELECT g FROM Generos g WHERE g.id = :id")
    , @NamedQuery(name = "Generos.findByNombre", query = "SELECT g FROM Generos g WHERE g.nombre = :nombre")})
public class Generos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private String nombre;
    @OneToMany(mappedBy = "genero")
    private List<Elementos> elementosList;
    @OneToMany(mappedBy = "genero")
    private List<Estanterias> estanteriasList;

    public Generos() {
    }

    public Generos(Integer id) {
        this.id = id;
    }

    public Generos(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    @XmlTransient
    public List<Elementos> getElementosList() {
        return elementosList;
    }

    public void setElementosList(List<Elementos> elementosList) {
        this.elementosList = elementosList;
    }

    @XmlTransient
    public List<Estanterias> getEstanteriasList() {
        return estanteriasList;
    }

    public void setEstanteriasList(List<Estanterias> estanteriasList) {
        this.estanteriasList = estanteriasList;
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
        if (!(object instanceof Generos)) {
            return false;
        }
        Generos other = (Generos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Generos[ id=" + id + " ]";
    }
    
}
