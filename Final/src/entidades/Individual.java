/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
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
@Table(catalog = "concurso", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Individual.findAll", query = "SELECT i FROM Individual i")
    , @NamedQuery(name = "Individual.findByIdcandidato", query = "SELECT i FROM Individual i WHERE i.idcandidato = :idcandidato")
    , @NamedQuery(name = "Individual.findByEdad", query = "SELECT i FROM Individual i WHERE i.edad = :edad")})
public class Individual implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer idcandidato;
    @Basic(optional = false)
    private int edad;
    @JoinColumn(name = "idcandidato", referencedColumnName = "idcandidato", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Candidato candidato;

    public Individual() {
    }

    public Individual(Integer idcandidato) {
        this.idcandidato = idcandidato;
    }

    public Individual(Integer idcandidato, int edad) {
        this.idcandidato = idcandidato;
        this.edad = edad;
    }

    public Integer getIdcandidato() {
        return idcandidato;
    }

    public void setIdcandidato(Integer idcandidato) {
        this.idcandidato = idcandidato;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
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
        if (!(object instanceof Individual)) {
            return false;
        }
        Individual other = (Individual) object;
        if ((this.idcandidato == null && other.idcandidato != null) || (this.idcandidato != null && !this.idcandidato.equals(other.idcandidato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Individual[ idcandidato=" + idcandidato + " ]";
    }
    
}
