package cabmed.model;

import java.util.Date;
import javax.persistence.*;

@DiscriminatorValue(value="s")
public class Secretaire extends Personnel {
    
}
