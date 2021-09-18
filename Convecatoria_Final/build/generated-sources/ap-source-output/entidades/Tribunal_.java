package entidades;

import entidades.Puntuacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-11T16:36:28")
@StaticMetamodel(Tribunal.class)
public class Tribunal_ { 

    public static volatile SingularAttribute<Tribunal, Integer> idtribunal;
    public static volatile SingularAttribute<Tribunal, String> telefono;
    public static volatile SingularAttribute<Tribunal, String> nombre;
    public static volatile CollectionAttribute<Tribunal, Puntuacion> puntuacionCollection;
    public static volatile SingularAttribute<Tribunal, String> email;
    public static volatile SingularAttribute<Tribunal, String> dni;

}