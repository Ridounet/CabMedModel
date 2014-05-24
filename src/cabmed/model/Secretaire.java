package cabmed.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@DiscriminatorValue(value="sec")
public class Secretaire extends Personnel {
    
    // Constructeurs
    public Secretaire() { }
    
    public Secretaire(Date debutTravail, String registreNat, String nom, 
            String prenom, Date dateNaissance, Adresse adresse, String tel, Sexe sexe, String email, String password) {
        super(debutTravail, registreNat, nom, prenom, dateNaissance, adresse, tel, sexe, email, password);
    }
}