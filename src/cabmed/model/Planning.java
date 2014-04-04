package cabmed.model;

import java.util.List;
import java.util.Map;
import javax.persistence.*;

@Entity
public class Planning {
    
    @Id @GeneratedValue
    private int id;
    
    private Map<Jour,Disponibilite> disponibilite;
    private Map<java.util.Date,Horaire> horaire;
}
