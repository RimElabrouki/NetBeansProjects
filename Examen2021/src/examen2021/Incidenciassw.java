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
    @NamedQuery(name = "Incidenciassw.findAll", query = "SELECT i FROM Incidenciassw i")
    , @NamedQuery(name = "Incidenciassw.findByIdincidencia", query = "SELECT i FROM Incidenciassw i WHERE i.idincidencia = :idincidencia")})
public class Incidenciassw implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer idincidencia;
    @JoinColumn(name = "idincidencia", referencedColumnName = "idincidencia", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Incidencias incidencias;
    @JoinColumn(name = "idnivelsw", referencedColumnName = "idnivelsw")
    @ManyToOne
    private Nivelsw idnivelsw;
    @JoinColumn(name = "idprograma", referencedColumnName = "idprograma")
    @ManyToOne(optional = false)
    private Programas idprograma;

    public Incidenciassw() {
    }

    public Incidenciassw(Integer idincidencia) {
        this.idincidencia = idincidencia;
    }

    public Integer getIdincidencia() {
        return idincidencia;
    }

    public void setIdincidencia(Integer idincidencia) {
        this.idincidencia = idincidencia;
    }

    public Incidencias getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(Incidencias incidencias) {
        this.incidencias = incidencias;
    }

    public Nivelsw getIdnivelsw() {
        return idnivelsw;
    }

    public void setIdnivelsw(Nivelsw idnivelsw) {
        this.idnivelsw = idnivelsw;
    }

    public Programas getIdprograma() {
        return idprograma;
    }

    public void setIdprograma(Programas idprograma) {
        this.idprograma = idprograma;
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
        if (!(object instanceof Incidenciassw)) {
            return false;
        }
        Incidenciassw other = (Incidenciassw) object;
        if ((this.idincidencia == null && other.idincidencia != null) || (this.idincidencia != null && !this.idincidencia.equals(other.idincidencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "examen2021.Incidenciassw[ idincidencia=" + idincidencia + " ]";
    }
    
}
