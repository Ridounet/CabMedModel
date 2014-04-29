package cabmed.model;

import java.io.Serializable;
import java.util.Map;
import javax.persistence.*;

@Entity
public class Horaire implements Serializable {
    // Attributs
    @Id @GeneratedValue
    private int id;
    
    @ElementCollection
    private Map<Tranche,Rdv> occupation;
    
    // Constructeurs
    public Horaire() {  }
    
    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Map<Tranche, Rdv> getOccupation() { return occupation; }
    public void setOccupation(Map<Tranche, Rdv> occupation) { this.occupation = occupation; }
    
}
