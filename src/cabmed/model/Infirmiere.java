package cabmed.model;

import java.util.Date;
import javax.persistence.*;

@DiscriminatorValue(value="i")
public class Infirmiere extends Personnel {
    
}
