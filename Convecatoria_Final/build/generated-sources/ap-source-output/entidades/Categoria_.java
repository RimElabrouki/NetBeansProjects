package entidades;

import entidades.Candidato;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-11T16:36:28")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile CollectionAttribute<Categoria, Candidato> candidatoCollection;
    public static volatile SingularAttribute<Categoria, String> categoria;
    public static volatile SingularAttribute<Categoria, Integer> idcategoria;

}