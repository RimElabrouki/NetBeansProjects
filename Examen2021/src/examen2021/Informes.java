/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2021;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @NamedQuery(name = "Informes.findAll", query = "SELECT i FROM Informes i")
    , @NamedQuery(name = "Informes.findByIdinforme", query = "SELECT i FROM Informes i WHERE i.idinforme = :idinforme")
    , @NamedQuery(name = "Informes.findByResumen", query = "SELECT i FROM Informes i WHERE i.resumen = :resumen")})
public class Informes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idinforme;
    private String resumen;
    @JoinColumn(name = "idincidencia", referencedColumnName = "idincidencia")
    @ManyToOne(optional = false)
    private Incidencias idincidencia;

    public Informes() {
    }

    public Informes(Integer idinforme) {
        this.idinforme = idinforme;
    }

    public Integer getIdinforme() {
        return idinforme;
    }

    public void setIdinforme(Integer idinforme) {
        this.idinforme = idinforme;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public Incidencias getIdincidencia() {
        return idincidencia;
    }

    public void setIdincidencia(Incidencias idincidencia) {
        this.idincidencia = idincidencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinforme != null ? idinforme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Informes)) {
            return false;
        }
        Informes other = (Informes) object;
        if ((this.idinforme == null && other.idinforme != null) || (this.idinforme != null && !this.idinforme.equals(other.idinforme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "examen2021.Informes[ idinforme=" + idinforme + " ]";
    }
    
}
