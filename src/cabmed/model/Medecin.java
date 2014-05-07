package cabmed.model;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;

@Entity
@DiscriminatorValue(value="med")
public class Medecin extends Personnel {
    // Attributs
    
    @ElementCollection(fetch = FetchType.EAGER)
    private Map<Specialisation, String> specialisation;
    
    @OneToMany(cascade = CascadeType.DETACH)
    @ElementCollection(fetch = FetchType.LAZY)
    private List<Rdv> rdv;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Planning planning;

    // Constructeurs
    public Medecin(Planning planning, Date debutTravail, String registreNat, String nom, String prenom, Date dateNaissance, Adresse adresse, String tel, Sexe sexe) {
        super(debutTravail, registreNat, nom, prenom, dateNaissance, adresse, tel, sexe);
        //this.planning = planning;
    }
    
    public Medecin(Date debutTravail, String registreNat, String nom, 
            String prenom, Date dateNaissance, Adresse adresse, String tel, Sexe sexe) {
        super(debutTravail, registreNat, nom, prenom, dateNaissance, adresse, tel, sexe);
    }
    
    public Medecin() { }
    
    // Getters & Setters
    public Map<Specialisation, String> getSpecialisation() { return specialisation; }
    public void setSpecialisation(Map<Specialisation, String> specialisation) { this.specialisation = specialisation; }
    public Planning getPlanning() { return planning; }
    public void setPlanning(Planning planning) { this.planning = planning; }
    
}
