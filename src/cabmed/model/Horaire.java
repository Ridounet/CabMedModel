package cabmed.model;

import java.util.Map;
import javax.persistence.*;

@Entity
public class Horaire {
    
    @Id @GeneratedValue
    private int id;
    
    @ElementCollection
    private Map<Tranche,Rdv> occupation;
}
