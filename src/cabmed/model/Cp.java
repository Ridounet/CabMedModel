package cabmed.model;

import javax.persistence.*;

@Entity
public class Cp {
    @Id @GeneratedValue
    private int id;
    
    private int codePostal;
    private String nom;
    
}
