package cabmed.model;

import javax.persistence.*;

@Entity
class Specialisation {
    
    @Id @GeneratedValue
    private int id;
    
    private int duree;
    private String label;
}
