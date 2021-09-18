/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    @NamedQuery(name = "Elementos.findAll", query = "SELECT e FROM Elementos e")
    , @NamedQuery(name = "Elementos.findById", query = "SELECT e FROM Elementos e WHERE e.id = :id")})
public class Elementos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @OneToMany(mappedBy = "idElemento")
    private List<Prestamos> prestamosList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "elementos")
    private Dvds dvds;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "elementos")
    private Libros libros;
    @JoinColumn(name = "genero", referencedColumnName = "id")
    @ManyToOne
    private Generos genero;
    @JoinColumn(name = "estanteria", referencedColumnName = "id")
    @ManyToOne
    private Estanterias estanteria;
    @JoinColumn(name = "lote", referencedColumnName = "id")
    @ManyToOne
    private Lotes lote;

    public Elementos() {
    }

    public Elementos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public List<Prestamos> getPrestamosList() {
        return prestamosList;
    }

    public void setPrestamosList(List<Prestamos> prestamosList) {
        this.prestamosList = prestamosList;
    }

    public Dvds getDvds() {
        return dvds;
    }

    public void setDvds(Dvds dvds) {
        this.dvds = dvds;
    }

    public Libros getLibros() {
        return libros;
    }

    public void setLibros(Libros libros) {
        this.libros = libros;
    }

    public Generos getGenero() {
        return genero;
    }

    public void setGenero(Generos genero) {
        this.genero = genero;
    }

    public Estanterias getEstanteria() {
        return estanteria;
    }

    public void setEstanteria(Estanterias estanteria) {
        this.estanteria = estanteria;
    }

    public Lotes getLote() {
        return lote;
    }

    public void setLote(Lotes lote) {
        this.lote = lote;
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
        if (!(object instanceof Elementos)) {
            return false;
        }
        Elementos other = (Elementos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Elementos[ id=" + id + " ]";
    }
    
}
