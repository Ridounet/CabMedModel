package cabmed.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Rdv implements Serializable {
    @Id @GeneratedValue
    private int id;
    
    @ManyToOne
    private Patient patient;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Medecin medecin;
    
    @Enumerated(EnumType.STRING)
    private StatutRdv statut;
    
    
    
}
