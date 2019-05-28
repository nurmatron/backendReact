
package entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class TravelEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String origin;
    private String destination;
    private String userId;
    private Timestamp timestamp;

    public TravelEntity() {
    }

    public TravelEntity(String origin, String destination, String userId) {
        this.origin = origin;
        this.destination = destination;
        this.userId = userId;
        this.timestamp = Timestamp.valueOf(LocalDateTime.now());
        
                
    }

    public String toJson(){
        return "{"+
                "\n  \"destination\":\""+destination+"\""+
                "\n  \"origin\":\""+origin+"\""+
                 "\n}";
    }

      public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    
}
