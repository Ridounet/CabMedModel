package cabmed.model;

import java.util.Date;
import javax.persistence.*;

@DiscriminatorValue(value="a")
public class Administrateur extends Personnel {
    
}
