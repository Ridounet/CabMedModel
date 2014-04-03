package cabmed.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Personnel extends Personne {
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date debutTravail;
}
