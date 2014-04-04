package cabmed.model;

import javax.persistence.*;

@Entity
public class Disponibilite {
    
    @Id @GeneratedValue
    private int id;
    
    private Tranche heureDebut;
    private Tranche heureFin;
    
}
