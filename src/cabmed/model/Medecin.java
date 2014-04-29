package cabmed.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@DiscriminatorValue(value="med")
public class Medecin extends Personnel {
    // Attributs
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.PERSIST})
    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "medecin_specialisations")
    private List<Specialisation> specialisation;
    
    @OneToMany
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
    public List<Specialisation> getSpecialisation() { return specialisation; }
    public void setSpecialisation(List<Specialisation> specialisation) { this.specialisation = specialisation; }
    public Planning getPlanning() { return planning; }
    public void setPlanning(Planning planning) { this.planning = planning; }
    
}
