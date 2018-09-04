package Model;

import Model.Modelo;
import Model.Montadora;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-04T13:03:44")
@StaticMetamodel(Veiculo.class)
public class Veiculo_ { 

    public static volatile SingularAttribute<Veiculo, Float> motor;
    public static volatile SingularAttribute<Veiculo, Float> km;
    public static volatile ListAttribute<Veiculo, Modelo> Modelo;
    public static volatile SingularAttribute<Veiculo, String> Cor;
    public static volatile SingularAttribute<Veiculo, Long> id;
    public static volatile ListAttribute<Veiculo, Montadora> Montadora;

}