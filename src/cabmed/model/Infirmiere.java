package cabmed.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@DiscriminatorValue(value="inf")
public class Infirmiere extends Personnel {
    // Constructeurs
    public Infirmiere() { }

    public Infirmiere(Date debutTravail, String registreNat, String nom, 
            String prenom, Date dateNaissance, Adresse adresse, String tel, Sexe sexe, String email, String password) {
        super(debutTravail, registreNat, nom, prenom, dateNaissance, adresse, tel, sexe, email, password);
    }
    
}
