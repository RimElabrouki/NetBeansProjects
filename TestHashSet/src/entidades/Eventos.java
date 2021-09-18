/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Eventos.findAll", query = "SELECT e FROM Eventos e")
    , @NamedQuery(name = "Eventos.findById", query = "SELECT e FROM Eventos e WHERE e.id = :id")
    , @NamedQuery(name = "Eventos.findByNombre", query = "SELECT e FROM Eventos e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Eventos.findByFechaHora", query = "SELECT e FROM Eventos e WHERE e.fechaHora = :fechaHora")})
public class Eventos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    private String nombre;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date fechaHora;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "eventos")
    private Cursos cursos;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "eventos")
    private Lecturas lecturas;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "eventos")
    private Concursos concursos;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "eventos")
    private Visionados visionados;
    @JoinColumn(name = "idSocios", referencedColumnName = "id")
    @ManyToOne
    private Socios idSocios;
    @OneToMany(mappedBy = "idEvento")
    private List<Socios> sociosList;

    public Eventos() {
    }

    public Eventos(Integer id) {
        this.id = id;
    }

    public Eventos(Integer id, String nombre, Date fechaHora) {
        this.id = id;
        this.nombre = nombre;
        this.fechaHora = fechaHora;
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

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Cursos getCursos() {
        return cursos;
    }

    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
    }

    public Lecturas getLecturas() {
        return lecturas;
    }

    public void setLecturas(Lecturas lecturas) {
        this.lecturas = lecturas;
    }

    public Concursos getConcursos() {
        return concursos;
    }

    public void setConcursos(Concursos concursos) {
        this.concursos = concursos;
    }

    public Visionados getVisionados() {
        return visionados;
    }

    public void setVisionados(Visionados visionados) {
        this.visionados = visionados;
    }

    public Socios getIdSocios() {
        return idSocios;
    }

    public void setIdSocios(Socios idSocios) {
        this.idSocios = idSocios;
    }

    @XmlTransient
    public List<Socios> getSociosList() {
        return sociosList;
    }

    public void setSociosList(List<Socios> sociosList) {
        this.sociosList = sociosList;
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
        if (!(object instanceof Eventos)) {
            return false;
        }
        Eventos other = (Eventos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Eventos[ id=" + id + " ]";
    }
    
}
