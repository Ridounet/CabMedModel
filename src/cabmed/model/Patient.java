package cabmed.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@DiscriminatorValue(value="pat")
public class Patient extends Personne implements Serializable {
    // Attributs
    @Enumerated(EnumType.STRING)
    private Mutualite mutualite;
    
    @OneToMany
    @ElementCollection(fetch = FetchType.LAZY)
    private List<Rdv> rdv;

    // Constructeurs
    public Patient(Mutualite mutualite, String registreNat, String nom, String prenom, Date dateNaissance, Adresse adresse, String tel, Sexe sexe) {
        super(registreNat, nom, prenom, dateNaissance, adresse, tel, sexe);
        this.mutualite = mutualite;
    }
    
    public Patient() { }
    
    // Override "Object"
    @Override
    public String toString() {
        return getPrenom() + " " + getNom() + " (patient)";
    }
    
    
    // Getters & Setters
    public Mutualite getMutualite() { return mutualite; }
    public void setMutualite(Mutualite mutualite) { this.mutualite = mutualite; }
    public List<Rdv> getRdv() { return rdv; }
    public void setRdv(List<Rdv> rdv) { this.rdv = rdv; }
    
}
