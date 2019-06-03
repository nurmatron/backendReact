package entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-29T09:52:46")
@StaticMetamodel(SavedTravelEntity.class)
public class SavedTravelEntity_ { 

    public static volatile SingularAttribute<SavedTravelEntity, String> duration;
    public static volatile SingularAttribute<SavedTravelEntity, String> distance;
    public static volatile SingularAttribute<SavedTravelEntity, String> price;
    public static volatile SingularAttribute<SavedTravelEntity, String> origin;
    public static volatile SingularAttribute<SavedTravelEntity, String> destination;
    public static volatile SingularAttribute<SavedTravelEntity, Long> id;
    public static volatile SingularAttribute<SavedTravelEntity, String> transport;
    public static volatile SingularAttribute<SavedTravelEntity, String> userId;
    public static volatile SingularAttribute<SavedTravelEntity, Timestamp> timestamp;

}