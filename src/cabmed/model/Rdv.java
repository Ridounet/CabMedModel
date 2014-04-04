package cabmed.model;

import javax.persistence.*;

@Entity
public class Rdv {
    @Id @GeneratedValue
    private int id;
    
    @ManyToOne
    private Patient patient;
    
    @ManyToOne
    private Medecin medecin;
    
    private StatutRdv statut;
    
}
