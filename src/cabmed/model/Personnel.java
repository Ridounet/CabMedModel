package cabmed.model;

import java.util.Date;
import javax.persistence.*;

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.CHAR, name = "type_personnel")
public class Personnel extends Personne {
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private java.util.Date debutTravail;
}
