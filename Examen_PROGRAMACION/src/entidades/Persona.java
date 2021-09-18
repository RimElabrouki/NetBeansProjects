/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(catalog = "concurso", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByIdpersona", query = "SELECT p FROM Persona p WHERE p.idpersona = :idpersona")
    , @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Persona.findByEmail", query = "SELECT p FROM Persona p WHERE p.email = :email")
    , @NamedQuery(name = "Persona.findByDni", query = "SELECT p FROM Persona p WHERE p.dni = :dni")
    , @NamedQuery(name = "Persona.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Persona.findByIdcandidato", query = "SELECT p FROM Persona p WHERE p.idcandidato = :idcandidato")})
public class Persona implements Serializable {

    private static final long serialVersionUID = -4408701407989087223L;
    @Id
    @Basic(optional = false)
    private Integer idpersona;
    @Basic(optional = false)
    private String nombre;
    private String email;
    @Basic(optional = false)
    private String dni;
    private String telefono;
    @Basic(optional = false)
    private int idcandidato;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idportavoz")
    private List<Grupo> grupoList;

    public Persona() {
    }

    public Persona(Integer idpersona) {
        this.idpersona = idpersona;
    }
    // Persona (int id, String nombre, String email, String telefono, String dni)

    public Persona(Integer idpersona, String nombre, String email, String dni, String telefono) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
    }

    public Persona(int idpersona, String nombre, String dni, int idcandidato) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.dni = dni;
        this.idcandidato = idcandidato;
    }

    public Persona(int idpersona, String nombre, String email, String dni, String telefono, int idcandidato) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
        this.idcandidato = idcandidato;

    }

    public Persona(Integer idpersona, String nombre, String email, String dni, String telefono, int idcandidato, List<Grupo> grupoList) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
        this.idcandidato = idcandidato;
        this.grupoList = grupoList;
    }

    public Integer getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdcandidato() {
        return idcandidato;
    }

    public void setIdcandidato(int idcandidato) {
        this.idcandidato = idcandidato;
    }

    @XmlTransient
    public List<Grupo> getGrupoList() {
        return grupoList;
    }

    public void setGrupoList(List<Grupo> grupoList) {
        this.grupoList = grupoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpersona != null ? idpersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idpersona == null && other.idpersona != null) || (this.idpersona != null && !this.idpersona.equals(other.idpersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Persona[ idpersona=" + idpersona + " ]";
    }

    private String data() {
        return this.idpersona + "|" + this.nombre + "|" + this.email + "|" + this.dni + "|" + this.telefono + "|" + this.idcandidato;
    }

    /*
    Importar un objeto de la entidad Persona desde un fichero de bytes.
     */
    public static Persona importarPersonaDesdeFicheroDeBytes(String path) {
        Persona ret = new Persona();
        FileInputStream lector = null;
        ObjectInputStream lectorObjeto = null;
        try {
            try {
                lector = new FileInputStream(path);
                lectorObjeto = new ObjectInputStream(lector);
                ret = (Persona) lectorObjeto.readObject();
                System.out.println("" + ret);
            } finally {
                if (lectorObjeto != null) {
                    lectorObjeto.close();
                }
                if (lector != null) {
                    lector.close();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
        } catch (EOFException e) {
            System.out.println("Final de fichero");
        } catch (IOException e) {
            System.out.println("Se ha producido una IOException: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Se ha producido una ClassNotFoundException" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Se ha producido una Exception" + e.getMessage());
        }
        return ret;
    }

    /*
Exportar los datos de un objeto de la clase Persona hacia un fichero binario.
     */
    public static void exportarPersonaFicheroBinario(Persona p, String path) {
        try {
            FileOutputStream fichero = new FileOutputStream(path, false);
            ObjectOutputStream escritor = new ObjectOutputStream(fichero);
            escritor.writeObject((Persona) p);
            escritor.flush();
            escritor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Se ha producido una IOException" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Se ha producido una Exception" + e.getMessage());
        }
    }
 
}
