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
    @NamedQuery(name = "Estanterias.findAll", query = "SELECT e FROM Estanterias e")
    , @NamedQuery(name = "Estanterias.findById", query = "SELECT e FROM Estanterias e WHERE e.id = :id")
    , @NamedQuery(name = "Estanterias.findByCodigo", query = "SELECT e FROM Estanterias e WHERE e.codigo = :codigo")
    , @NamedQuery(name = "Estanterias.findByUbicacion", query = "SELECT e FROM Estanterias e WHERE e.ubicacion = :ubicacion")
    , @NamedQuery(name = "Estanterias.findByCompleta", query = "SELECT e FROM Estanterias e WHERE e.completa = :completa")})
public class Estanterias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private Character codigo;
    @Basic(optional = false)
    private String ubicacion;
    @Basic(optional = false)
    private boolean completa;
    @OneToMany(mappedBy = "estanteria")
    private List<Elementos> elementosList;
    @JoinColumn(name = "genero", referencedColumnName = "id")
    @ManyToOne
    private Generos genero;

    public Estanterias() {
    }

    public Estanterias(Integer id) {
        this.id = id;
    }

    public Estanterias(Integer id, Character codigo, String ubicacion, boolean completa) {
        this.id = id;
        this.codigo = codigo;
        this.ubicacion = ubicacion;
        this.completa = completa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getCodigo() {
        return codigo;
    }

    public void setCodigo(Character codigo) {
        this.codigo = codigo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean getCompleta() {
        return completa;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
    }

    @XmlTransient
    public List<Elementos> getElementosList() {
        return elementosList;
    }

    public void setElementosList(List<Elementos> elementosList) {
        this.elementosList = elementosList;
    }

    public Generos getGenero() {
        return genero;
    }

    public void setGenero(Generos genero) {
        this.genero = genero;
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
        if (!(object instanceof Estanterias)) {
            return false;
        }
        Estanterias other = (Estanterias) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Estanterias[ id=" + id + " ]";
    }
    
}
