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
    
    @Column(nullable = true, unique = true)
    private String numSecuSocial;

    @Transient
    private List<Rdv> rdv;
    
    private String remarques;

    // Constructeurs
    public Patient(Mutualite mutualite, String registreNat, String nom, String prenom, 
            Date dateNaissance, Adresse adresse, String tel, Sexe sexe, String numSecuSocial, String email, String password) {
        super(registreNat, nom, prenom, dateNaissance, adresse, tel, sexe, email, password);
        this.mutualite = mutualite;
        this.numSecuSocial = numSecuSocial;
    }
    
    public Patient() {}
    
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
    public String getNumSecuSocial() { return numSecuSocial; }
    public void setNumSecuSocial(String numSecuSocial) { this.numSecuSocial = numSecuSocial; }
    public String getRemarques() { return remarques; }
    public void setRemarques(String remarques) { this.remarques = remarques; }
    
}
