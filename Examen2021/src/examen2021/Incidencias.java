/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2021;

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
@Table(catalog = "incidencias", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incidencias.findAll", query = "SELECT i FROM Incidencias i")
    , @NamedQuery(name = "Incidencias.findByIdincidencia", query = "SELECT i FROM Incidencias i WHERE i.idincidencia = :idincidencia")
    , @NamedQuery(name = "Incidencias.findByDescripcion", query = "SELECT i FROM Incidencias i WHERE i.descripcion = :descripcion")
    , @NamedQuery(name = "Incidencias.findByPrioridad", query = "SELECT i FROM Incidencias i WHERE i.prioridad = :prioridad")
    , @NamedQuery(name = "Incidencias.findByFechacreacion", query = "SELECT i FROM Incidencias i WHERE i.fechacreacion = :fechacreacion")
    , @NamedQuery(name = "Incidencias.findByRevisada", query = "SELECT i FROM Incidencias i WHERE i.revisada = :revisada")
    , @NamedQuery(name = "Incidencias.findByAceptada", query = "SELECT i FROM Incidencias i WHERE i.aceptada = :aceptada")})
public class Incidencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idincidencia;
    @Basic(optional = false)
    private String descripcion;
    private Integer prioridad;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date fechacreacion;
    @Basic(optional = false)
    private boolean revisada;
    @Basic(optional = false)
    private boolean aceptada;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "incidencias")
    private Incidenciashw incidenciashw;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "incidencias")
    private Incidenciassw incidenciassw;
    @JoinColumn(name = "idestado", referencedColumnName = "idestado")
    @ManyToOne(optional = false)
    private Estados idestado;
    @JoinColumn(name = "idnivel0", referencedColumnName = "idnivel0")
    @ManyToOne
    private Nivel0 idnivel0;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuarios idusuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idincidencia")
    private List<Informes> informesList;

    public Incidencias() {
    }

    public Incidencias(Integer idincidencia) {
        this.idincidencia = idincidencia;
    }

    public Incidencias(Integer idincidencia, String descripcion, Integer prioridad, Date fechacreacion, boolean revisada, boolean aceptada, Incidenciashw incidenciashw, Incidenciassw incidenciassw, Estados idestado, Nivel0 idnivel0, Usuarios idusuario, List<Informes> informesList) {
        this.idincidencia = idincidencia;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.fechacreacion = fechacreacion;
        this.revisada = revisada;
        this.aceptada = aceptada;
        this.incidenciashw = incidenciashw;
        this.incidenciassw = incidenciassw;
        this.idestado = idestado;
        this.idnivel0 = idnivel0;
        this.idusuario = idusuario;
        this.informesList = informesList;
    }

    public Incidencias(Integer idincidencia, String descripcion, Date fechacreacion, boolean revisada, boolean aceptada) {
        this.idincidencia = idincidencia;
        this.descripcion = descripcion;
        this.fechacreacion = fechacreacion;
        this.revisada = revisada;
        this.aceptada = aceptada;
    }

    public Integer getIdincidencia() {
        return idincidencia;
    }

    public void setIdincidencia(Integer idincidencia) {
        this.idincidencia = idincidencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public boolean getRevisada() {
        return revisada;
    }

    public void setRevisada(boolean revisada) {
        this.revisada = revisada;
    }

    public boolean getAceptada() {
        return aceptada;
    }

    public void setAceptada(boolean aceptada) {
        this.aceptada = aceptada;
    }

    public Incidenciashw getIncidenciashw() {
        return incidenciashw;
    }

    public void setIncidenciashw(Incidenciashw incidenciashw) {
        this.incidenciashw = incidenciashw;
    }

    public Incidenciassw getIncidenciassw() {
        return incidenciassw;
    }

    public void setIncidenciassw(Incidenciassw incidenciassw) {
        this.incidenciassw = incidenciassw;
    }

    public Estados getIdestado() {
        return idestado;
    }

    public void setIdestado(Estados idestado) {
        this.idestado = idestado;
    }

    public Nivel0 getIdnivel0() {
        return idnivel0;
    }

    public void setIdnivel0(Nivel0 idnivel0) {
        this.idnivel0 = idnivel0;
    }

    public Usuarios getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuarios idusuario) {
        this.idusuario = idusuario;
    }

    @XmlTransient
    public List<Informes> getInformesList() {
        return informesList;
    }

    public void setInformesList(List<Informes> informesList) {
        this.informesList = informesList;
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
        if (!(object instanceof Incidencias)) {
            return false;
        }
        Incidencias other = (Incidencias) object;
        if ((this.idincidencia == null && other.idincidencia != null) || (this.idincidencia != null && !this.idincidencia.equals(other.idincidencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "examen2021.Incidencias[ idincidencia=" + idincidencia + " ]";
    }
    /*
      @Override
    public int compareTo(Incidencias in) {
        if(a == null)
            return 1;
        if ((this.prioridad.equals.in.prioridad()) 
            return 0;
        if (this.podios < a.getPodios())
            return -1;
        return 1;       
    }
*/
}
