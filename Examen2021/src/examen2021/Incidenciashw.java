/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2021;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(catalog = "incidencias", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incidenciashw.findAll", query = "SELECT i FROM Incidenciashw i")
    , @NamedQuery(name = "Incidenciashw.findByIdincidencia", query = "SELECT i FROM Incidenciashw i WHERE i.idincidencia = :idincidencia")})
public class Incidenciashw implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer idincidencia;
    @JoinColumn(name = "idequipo", referencedColumnName = "idequipo")
    @ManyToOne(optional = false)
    private Equipo idequipo;
    @JoinColumn(name = "idincidencia", referencedColumnName = "idincidencia", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Incidencias incidencias;
    @JoinColumn(name = "idnivelhw", referencedColumnName = "idnivelhw")
    @ManyToOne
    private Nivelhw idnivelhw;

    public Incidenciashw() {
    }

    public Incidenciashw(Integer idincidencia) {
        this.idincidencia = idincidencia;
    }

    public Integer getIdincidencia() {
        return idincidencia;
    }

    public void setIdincidencia(Integer idincidencia) {
        this.idincidencia = idincidencia;
    }

    public Equipo getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(Equipo idequipo) {
        this.idequipo = idequipo;
    }

    public Incidencias getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(Incidencias incidencias) {
        this.incidencias = incidencias;
    }

    public Nivelhw getIdnivelhw() {
        return idnivelhw;
    }

    public void setIdnivelhw(Nivelhw idnivelhw) {
        this.idnivelhw = idnivelhw;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idincidencia != null ? idincidencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incidenciashw)) {
            return false;
        }
        Incidenciashw other = (Incidenciashw) object;
        if ((this.idincidencia == null && other.idincidencia != null) || (this.idincidencia != null && !this.idincidencia.equals(other.idincidencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "examen2021.Incidenciashw[ idincidencia=" + idincidencia + " ]";
    }
    
}
