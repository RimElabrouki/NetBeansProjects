package entidades;

import entidades.Audicion;
import entidades.Tribunal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-11T15:13:09")
@StaticMetamodel(Puntuacion.class)
public class Puntuacion_ { 

    public static volatile SingularAttribute<Puntuacion, Integer> puntuacion;
    public static volatile SingularAttribute<Puntuacion, Tribunal> idtribunal;
    public static volatile SingularAttribute<Puntuacion, Audicion> idaudicion;
    public static volatile SingularAttribute<Puntuacion, Boolean> especial;
    public static volatile SingularAttribute<Puntuacion, Integer> idpuntuacion;

}