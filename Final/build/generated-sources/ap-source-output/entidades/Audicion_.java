package entidades;

import entidades.Puntuacion;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-11T15:13:09")
@StaticMetamodel(Audicion.class)
public class Audicion_ { 

    public static volatile SingularAttribute<Audicion, Date> fechahora;
    public static volatile SingularAttribute<Audicion, BigDecimal> puntuacionmedia;
    public static volatile SingularAttribute<Audicion, String> lugar;
    public static volatile ListAttribute<Audicion, Puntuacion> puntuacionList;
    public static volatile SingularAttribute<Audicion, Integer> idaudicion;

}