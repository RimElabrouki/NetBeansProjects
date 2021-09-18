/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rim
 */
@Entity
@Table(catalog = "concurso", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidato.findAll", query = "SELECT c FROM Candidato c")
    , @NamedQuery(name = "Candidato.findByIdcandidato", query = "SELECT c FROM Candidato c WHERE c.idcandidato = :idcandidato")
    , @NamedQuery(name = "Candidato.findByNombre", query = "SELECT c FROM Candidato c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Candidato.findByCiudad", query = "SELECT c FROM Candidato c WHERE c.ciudad = :ciudad")
    , @NamedQuery(name = "Candidato.findByFechainscripcion", query = "SELECT c FROM Candidato c WHERE c.fechainscripcion = :fechainscripcion")
    , @NamedQuery(name = "Candidato.findByFinalista", query = "SELECT c FROM Candidato c WHERE c.finalista = :finalista")
    , @NamedQuery(name = "Candidato.findByIdaudicion", query = "SELECT c FROM Candidato c WHERE c.idaudicion = :idaudicion")})
public class Candidato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer idcandidato;
    @Basic(optional = false)
    private String nombre;
    @Basic(optional = false)
    private String ciudad;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date fechainscripcion;
    @Basic(optional = false)
    private boolean finalista;
    private Integer idaudicion;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "candidato")
    private Individual individual;
    @JoinColumn(name = "idcategoria", referencedColumnName = "idcategoria")
    @ManyToOne(optional = false)
    private Categoria idcategoria;

    public Candidato() {
    }

    public Candidato(Integer idcandidato) {
        this.idcandidato = idcandidato;
    }

    public Candidato(Integer idcandidato, String nombre, String ciudad, Date fechainscripcion, boolean finalista) {
        this.idcandidato = idcandidato;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.fechainscripcion = fechainscripcion;
        this.finalista = finalista;
    }

    Candidato(int i, int i0, int i1, String windows_8) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    public Integer getIdcandidato() {
        return idcandidato;
    }

    public void setIdcandidato(Integer idcandidato) {
        this.idcandidato = idcandidato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Date getFechainscripcion() {
        return fechainscripcion;
    }

    public void setFechainscripcion(Date fechainscripcion) {
        this.fechainscripcion = fechainscripcion;
    }

    public boolean getFinalista() {
        return finalista;
    }

    public void setFinalista(boolean finalista) {
        this.finalista = finalista;
    }

    public Integer getIdaudicion() {
        return idaudicion;
    }

    public void setIdaudicion(Integer idaudicion) {
        this.idaudicion = idaudicion;
    }

    public Individual getIndividual() {
        return individual;
    }

    public void setIndividual(Individual individual) {
        this.individual = individual;
    }

    public Categoria getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Categoria idcategoria) {
        this.idcategoria = idcategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcandidato != null ? idcandidato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidato)) {
            return false;
        }
        Candidato other = (Candidato) object;
        if ((this.idcandidato == null && other.idcandidato != null) || (this.idcandidato != null && !this.idcandidato.equals(other.idcandidato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Candidato[ idcandidato=" + idcandidato + " ]";
    }
    
}
