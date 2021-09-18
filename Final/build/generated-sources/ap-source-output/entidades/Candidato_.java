package entidades;

import entidades.Individual;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-11T15:13:09")
@StaticMetamodel(Candidato.class)
public class Candidato_ { 

    public static volatile SingularAttribute<Candidato, Date> fechainscripcion;
    public static volatile SingularAttribute<Candidato, Individual> individual;
    public static volatile SingularAttribute<Candidato, String> ciudad;
    public static volatile SingularAttribute<Candidato, Integer> idaudicion;
    public static volatile SingularAttribute<Candidato, ? extends Object> idcategoria;
    public static volatile SingularAttribute<Candidato, Boolean> finalista;
    public static volatile SingularAttribute<Candidato, Integer> idcandidato;
    public static volatile SingularAttribute<Candidato, String> nombre;

}