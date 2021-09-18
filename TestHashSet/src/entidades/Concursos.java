/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rim
 */
@Entity
@Table(catalog = "biblioteca", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Concursos.findAll", query = "SELECT c FROM Concursos c")
    , @NamedQuery(name = "Concursos.findByTipo", query = "SELECT c FROM Concursos c WHERE c.tipo = :tipo")
    , @NamedQuery(name = "Concursos.findByPremio", query = "SELECT c FROM Concursos c WHERE c.premio = :premio")
    , @NamedQuery(name = "Concursos.findById", query = "SELECT c FROM Concursos c WHERE c.id = :id")})
public class Concursos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    private String tipo;
    @Basic(optional = false)
    private String premio;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Eventos eventos;

    public Concursos() {
    }

    public Concursos(Integer id) {
        this.id = id;
    }

    public Concursos(Integer id, String tipo, String premio) {
        this.id = id;
        this.tipo = tipo;
        this.premio = premio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPremio() {
        return premio;
    }

    public void setPremio(String premio) {
        this.premio = premio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Eventos getEventos() {
        return eventos;
    }

    public void setEventos(Eventos eventos) {
        this.eventos = eventos;
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
        if (!(object instanceof Concursos)) {
            return false;
        }
        Concursos other = (Concursos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Concursos[ id=" + id + " ]";
    }
    
}
