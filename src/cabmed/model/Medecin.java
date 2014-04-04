package cabmed.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@DiscriminatorValue(value="m")
public class Medecin extends Personnel {
    
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Specialisation> specialisation;
    
    private Planning planning;
}
