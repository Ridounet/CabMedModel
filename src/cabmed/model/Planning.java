package cabmed.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.*;

@Entity
public class Planning implements Serializable {
    
    @Id @GeneratedValue
    private int id;
    
    @ElementCollection
    private Map<Jour,Disponibilite> disponibilite;
    
    @ElementCollection
    private Map<java.util.Date,Horaire> horaire;
}
