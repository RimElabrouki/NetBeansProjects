/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2021;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(catalog = "incidencias", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programas.findAll", query = "SELECT p FROM Programas p")
    , @NamedQuery(name = "Programas.findByIdprograma", query = "SELECT p FROM Programas p WHERE p.idprograma = :idprograma")
    , @NamedQuery(name = "Programas.findByNombre", query = "SELECT p FROM Programas p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Programas.findByTamanio", query = "SELECT p FROM Programas p WHERE p.tamanio = :tamanio")
    , @NamedQuery(name = "Programas.findByVersion", query = "SELECT p FROM Programas p WHERE p.version = :version")})
public class Programas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idprograma;
    @Basic(optional = false)
    private String nombre;
    private Integer tamanio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprograma")
    private List<Incidenciassw> incidenciasswList;

    public Programas() {
    }

    public Programas(Integer idprograma) {
        this.idprograma = idprograma;
    }

    public Programas(Integer idprograma, String nombre) {
        this.idprograma = idprograma;
        this.nombre = nombre;
    }

    public Integer getIdprograma() {
        return idprograma;
    }

    public void setIdprograma(Integer idprograma) {
        this.idprograma = idprograma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTamanio() {
        return tamanio;
    }

    public void setTamanio(Integer tamanio) {
        this.tamanio = tamanio;
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    @XmlTransient
    public List<Incidenciassw> getIncidenciasswList() {
        return incidenciasswList;
    }

    public void setIncidenciasswList(List<Incidenciassw> incidenciasswList) {
        this.incidenciasswList = incidenciasswList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprograma != null ? idprograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programas)) {
            return false;
        }
        Programas other = (Programas) object;
        if ((this.idprograma == null && other.idprograma != null) || (this.idprograma != null && !this.idprograma.equals(other.idprograma))) {
            return false;
        }
        return true;
    }

    public Programas(Integer idprograma, String nombre, Integer tamanio, double version, List<Incidenciassw> incidenciasswList) {
        this.idprograma = idprograma;
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.version = new BigDecimal(version, MathContext.UNLIMITED);
        this.incidenciasswList = incidenciasswList;
    }

    @Override
    public String toString() {
        return "examen2021.Programas[ idprograma=" + idprograma + " ]";
    }

    public static ArrayList<Programas> ImportarProgramasDesdeFicheroDeCaracteres(String path) {
        // declarar una variable de tipo arraylist de Veterinario ret,inicializada vacia
        ArrayList<Programas> ret = new ArrayList<>();
        // crear un objeto de tipo File para poder acceder a este fichero'Veterinario.txt'
        File fichero = new File(path);
        //asociarse con este file para poder leer del mismo
        FileReader lector = null;
        // asociarse este FileReader y que por lo tanto al final nos va a permiter leer directamente a este file
        BufferedReader buffer = null;
        try {
            try {
                lector = new FileReader(fichero);
                buffer = new BufferedReader(lector);
                String linea;
                //mientras sea distinda de null reccorer linea por linea el fichero de caracteres
                while ((linea = buffer.readLine()) != null) {
// la funcion split se devuelve un array de cadena de caracteres 
// que es el resultado de devidir la variable(linea)en funcion de este separador'|' y mas tenemos escapar añadir //
                    String[] campos = linea.split("\\ |");
                    // parseInt: convertir la cadena de caracteres a un tipo primetivo(int) 
                    int idprograma = Integer.parseInt(campos[0]);
                    String nombre = campos[1];
                    int tamanio = Integer.parseInt(campos[2]);
                    double version = Double.parseDouble(campos[3]);

                    /* BigDecimal version = new BigDecimal(10);
                    int i;
                    i = version.intValue(campo[3]);
                     */
                    // crear un objeto nuevo para acceder a v 
                    Programas p = new Programas(idprograma, nombre, tamanio, version, null);
                    // ret la lista de vetenario que voy a devolver
                    ret.add(p);
                }
            } finally {
                if (buffer != null);
                {
                    buffer.close();
                }
                if (lector != null);
                {
                    lector.close();

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("se ha producido una FileNotFoundException" + e.getMessage());
        } catch (IOException e) {
            System.out.println("se ha producido una FileNotFoundException" + e.getMessage());
        } catch (Exception e) {
            System.out.println("se ha producido una FileNotFoundException" + e.getMessage());
        }
        return ret;
    }

    public static void ImportarProgramaDesdeFicheroDeBytes(String path) {
        // declarar una variable de tipo arraylist de programas ret,inicializada vacia
        //ArrayList<Programas> ret = new ArrayList<>();

        // streams porque fichero de bytes
        FileInputStream lector = null;
        ObjectInputStream lectorObject = null;
        try {
            try {
                lector = new FileInputStream(path);
                lectorObject = new ObjectInputStream(lector);
                Programas p;
                while ((p = (Programas) lectorObject.readObject()) != null) {
                    //ret.add(p);

                }
            } finally {
                if (lectorObject != null);
                {
                    lectorObject.close();
                }
                if (lector != null);
                {
                    lector.close();

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("se ha producido una FileNotFoundException" + e.getMessage());
            // final de fichero Binario==> End Of File  
        } catch (EOFException e) {
            System.out.println("Final de fichero");
        } catch (IOException e) {
            System.out.println("se ha producido una IOException" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("se ha producido una ClassNotFoundException " + e.getMessage());
        } catch (Exception e) {
            System.out.println("se ha producido una =Exception" + e.getMessage());
        }
    }

    // exportar un fichero de caracteres
    private static void exportarFicheroCaracteresProgramas(ArrayList<Programas> programas, String path) {
        //la ruta
        File fichero = new File(path);
        //Streams de caracteres para poder escribir sobre fichero
        FileWriter escritor = null;
        //otro buffer intermedio,sociado a FileWriter y File
        //Escribir sobre este Buffer(stream de salida)como systme.out
        // buffer podemos volcar cualquiera de cadena de caracteres
        PrintWriter buffer = null;
        //vamos a establecer los valores para filewritter y pritwriter (give him the values )
        try {
            try {
                escritor = new FileWriter(fichero, true);
                buffer = new PrintWriter(escritor);
                for (Programas p : programas) {
                    buffer.print("  " + p.getNombre() + "  " + p.getTamanio() + "  " + p.getVersion() + "  " + p.getIncidenciasswList() + "  " + p.idprograma + ".\n");
                }
            } finally {
                if (buffer != null);
                {
                    buffer.close();

                }
                if (escritor != null);
                {
                    escritor.close();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("se ha producido una FileNotFoundException" + e.getMessage());
        } // exception de entrada salida
        catch (IOException e) {
            System.out.println("se ha producido una IOException " + e.getMessage());

        } catch (Exception e) {
            System.out.println("se ha producido una Exception " + e.getMessage());
        }
    }

    public static void exportarProgramasBinario(ArrayList<Programas> programas, String filename) {
        OutputStream os;
        ObjectOutput out;
        try {
            os = new FileOutputStream(filename);
            out = new ObjectOutputStream(os);
            out.writeObject(programas);
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado." + ex.toString());

        } catch (IOException ex) {
            System.out.println("Error" + ex.toString());
        }
    }
}
