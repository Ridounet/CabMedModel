package cabmed.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@DiscriminatorValue(value="med")
public class Medecin extends Personnel {
    // Attributs
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.PERSIST})
    @JoinTable(name = "medecin_specialisation", joinColumns = @JoinColumn(name = "medecin_id", unique = false), inverseJoinColumns = @JoinColumn(unique = false, name = "specialisation_id"))
    private List<Specialisation> specialisation = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.REMOVE)
    @ElementCollection(fetch = FetchType.LAZY)
    private List<Rdv> rdv = new ArrayList<>();
    
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
    public List<Rdv> getRdv() { return rdv; }
    public void setRdv(List<Rdv> rdv) { this.rdv = rdv; }
    
    public void addSpecialisation(Specialisation specialisation) {
        this.specialisation.add(specialisation);
        specialisation.addMedecin(this);
    }
    
}
