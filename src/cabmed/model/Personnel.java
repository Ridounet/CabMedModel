package cabmed.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public abstract class Personnel extends Personne implements Serializable {
    // Attributs
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date debutTravail;
    
    // Constructeurs
    public Personnel() { }
    
    public Personnel(java.util.Date debutTravail) {
        this.debutTravail = debutTravail;
    }

    public Personnel(Date debutTravail, String registreNat, String nom, String prenom, Date dateNaissance, Adresse adresse, String tel, Sexe sexe) {
        super(registreNat, nom, prenom, dateNaissance, adresse, tel, sexe);
        this.debutTravail = debutTravail;
    }
    
    // Getters & Setters
    public Date getDebutTravail() { return debutTravail; }
    public void setDebutTravail(Date debutTravail) { this.debutTravail = debutTravail; }
    
}
