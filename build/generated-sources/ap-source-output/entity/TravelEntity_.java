package entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-23T09:29:04")
@StaticMetamodel(TravelEntity.class)
public class TravelEntity_ { 

    public static volatile SingularAttribute<TravelEntity, String> origin;
    public static volatile SingularAttribute<TravelEntity, String> destination;
    public static volatile SingularAttribute<TravelEntity, Long> id;
    public static volatile SingularAttribute<TravelEntity, String> userId;
    public static volatile SingularAttribute<TravelEntity, Timestamp> timestamp;

}