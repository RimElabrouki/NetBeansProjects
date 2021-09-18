/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Rim
 */
@Entity
@Table(name = "candidato", catalog = "concurso", schema = "")
@NamedQueries({
    @NamedQuery(name = "Candidato.findAll", query = "SELECT c FROM Candidato c")
    , @NamedQuery(name = "Candidato.findByIdcandidato", query = "SELECT c FROM Candidato c WHERE c.idcandidato = :idcandidato")
    , @NamedQuery(name = "Candidato.findByNombre", query = "SELECT c FROM Candidato c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Candidato.findByCiudad", query = "SELECT c FROM Candidato c WHERE c.ciudad = :ciudad")
    , @NamedQuery(name = "Candidato.findByFechainscripcion", query = "SELECT c FROM Candidato c WHERE c.fechainscripcion = :fechainscripcion")
    , @NamedQuery(name = "Candidato.findByFinalista", query = "SELECT c FROM Candidato c WHERE c.finalista = :finalista")
    , @NamedQuery(name = "Candidato.findByIdcategoria", query = "SELECT c FROM Candidato c WHERE c.idcategoria = :idcategoria")
    , @NamedQuery(name = "Candidato.findByIdaudicion", query = "SELECT c FROM Candidato c WHERE c.idaudicion = :idaudicion")})
public class Candidato implements Serializable, Comparable<Candidato> {

    //private static final long serialVersionUID = -4408701407989087223L;
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = -4408701407989087223L;
    @Id
    @Basic(optional = false)
    @Column(name = "idcandidato")
    private Integer idcandidato;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "fechainscripcion")
    @Temporal(TemporalType.DATE)
    private Date fechainscripcion;
    @Basic(optional = false)
    @Column(name = "finalista")
    private boolean finalista;
    @Basic(optional = false)
    @Column(name = "idcategoria")
    private int idcategoria;
    @Column(name = "idaudicion")
    private Integer idaudicion;

    public Candidato() {
    }

    public Candidato(Integer idcandidato, String nombre, String ciudad, Date fechainscripcion, boolean finalista, int idcategoria, Integer idaudicion) {
        this.idcandidato = idcandidato;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.fechainscripcion = fechainscripcion;
        this.finalista = finalista;
        this.idcategoria = idcategoria;
        this.idaudicion = idaudicion;
    }

    public Candidato(Integer idcandidato) {
        this.idcandidato = idcandidato;
    }

    public Candidato(Integer idcandidato, String nombre, String ciudad, boolean finalista, int idcategoria, Integer idaudicion) {
        this.idcandidato = idcandidato;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.finalista = finalista;
        this.idcategoria = idcategoria;
        this.idaudicion = idaudicion;
    }

    public Candidato(int idcandidato, String nombre, String ciudad, Date fechainscripcion, boolean finalista, int idcategoria, int idaudicion) {
        this.idcandidato = idcandidato;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.fechainscripcion = fechainscripcion;
        this.finalista = finalista;
        this.idcategoria = idcategoria;
    }

    public Candidato(int idcandidato, String nombre, String ciudad) {
        this.idcandidato = idcandidato;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public Candidato(int i, int i0, int i1, String windows_8) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getIdcandidato() {
        return idcandidato;
    }

    public void setIdcandidato(Integer idcandidato) {
        Integer oldIdcandidato = this.idcandidato;
        this.idcandidato = idcandidato;
        changeSupport.firePropertyChange("idcandidato", oldIdcandidato, idcandidato);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        String oldCiudad = this.ciudad;
        this.ciudad = ciudad;
        changeSupport.firePropertyChange("ciudad", oldCiudad, ciudad);
    }

    public Date getFechainscripcion() {
        return fechainscripcion;
    }

    public void setFechainscripcion(Date fechainscripcion) {
        Date oldFechainscripcion = this.fechainscripcion;
        this.fechainscripcion = fechainscripcion;
        changeSupport.firePropertyChange("fechainscripcion", oldFechainscripcion, fechainscripcion);
    }

    public boolean getFinalista() {
        return finalista;
    }

    public void setFinalista(boolean finalista) {
        boolean oldFinalista = this.finalista;
        this.finalista = finalista;
        changeSupport.firePropertyChange("finalista", oldFinalista, finalista);
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        int oldIdcategoria = this.idcategoria;
        this.idcategoria = idcategoria;
        changeSupport.firePropertyChange("idcategoria", oldIdcategoria, idcategoria);
    }

    public Integer getIdaudicion() {
        return idaudicion;
    }

    public void setIdaudicion(Integer idaudicion) {
        Integer oldIdaudicion = this.idaudicion;
        this.idaudicion = idaudicion;
        changeSupport.firePropertyChange("idaudicion", oldIdaudicion, idaudicion);
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

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
//idcandidato | nombre | ciudad | fecha de inscripción (en formato dd/mm/aaaa)

    private String data() {
        return this.idcandidato + "|" + this.nombre + "|" + this.ciudad + "|" + this.fechainscripcion + "|" + this.finalista + "|" + this.idcategoria + "|" + this.idaudicion;
    }

    /*
  El campo idcandidato para el caso de la candidato .
     */
    @Override
    public int compareTo(Candidato t) {
        return Integer.valueOf(this.getIdcandidato()).compareTo(t.getIdcandidato());
    }

    //importar un fichero binario
    public static Candidato importarCandidatoDesdeFicheroDeBytes(String path) {
        Candidato ret = new Candidato();
        FileInputStream lector = null;
        ObjectInputStream lectorObjeto = null;
        try {
            try {
                lector = new FileInputStream(path);
                lectorObjeto = new ObjectInputStream(lector);
                ret = (Candidato) lectorObjeto.readObject();
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
// exportar coleccion deste fichero de caracteres

    private static void exportarCandidatoFicheroCaracteres(ArrayList<Candidato> candidatos, String path) {
        File fichero = new File(path);
        FileWriter escritor = null;
        PrintWriter buffer = null;
        try {
            try {
                escritor = new FileWriter(fichero, false);
                buffer = new PrintWriter(escritor);
                SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
                for (Candidato c : candidatos) {
                    String date1 = format1.format(c.getFechainscripcion());
                    buffer.print(c.getIdcandidato() + "|" + c.getNombre() + "|" + c.getCiudad() + "|" + date1 + ".\n");
                }
            } finally {
                if (buffer != null) {
                    buffer.close();
                }
                if (escritor != null) {
                    escritor.close();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Se ha producido una IOException" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Se ha producido una Exception" + e.getMessage());
        }
    }

    // importar coleccion de objetos desde un fichero de caracteres
    public static ArrayList<Candidato> importarCandidatosDesdeFicheroDeCaracteres(String path) {
        ArrayList<Candidato> ret = new ArrayList<>();
        File fichero = new File(path);
        FileReader lector = null;
        BufferedReader buffer = null;
        try {
            try {
                lector = new FileReader(fichero);
                buffer = new BufferedReader(lector);
                String linea;
                while ((linea = buffer.readLine()) != null) {
//Se separa cada linea del fichero de acuerdo al orden marcado en el método Programa.data()
                    String[] campos = linea.split("\\|");
                    //Date fechainscripcion, boolean finalista, int idcategoria, int idaudicion
                    int idcandidato = Integer.parseInt(campos[0]);
                    String nombre = campos[1];
                    String ciudad = campos[2];
                    SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
                    Date fechainscripcion = format1.parse(campos[3]); 
                    boolean finalista = Boolean.getBoolean(campos[4]);
                    int idcategoria = Integer.parseInt(campos[5]);
                    int idaudicion = Integer.parseInt(campos[6]);
                    Candidato c = new Candidato(idcandidato, nombre, ciudad,fechainscripcion, finalista, idcategoria, idaudicion);
                    ret.add(c);
                }
            } finally {
                if (buffer != null) {
                    buffer.close();
                }
                if (lector != null) {
                    lector.close();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Se ha producido una IOException" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Se ha producido una Exception" + e.getMessage());
        }
        return ret;
    }

}
