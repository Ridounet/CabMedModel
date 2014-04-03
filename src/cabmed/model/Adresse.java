package cabmed.model;

import javax.persistence.*;

@Embeddable
public class Adresse {
    private String rue;
    private Cp cp;
}
