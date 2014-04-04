package cabmed.model;

import javax.persistence.*;

@Entity
public enum StatutRdv {
    EN_COURS(1),
    CLOTURE(2),
    ANNULE(3);
    
    @Id @GeneratedValue
    private int id;
    
    StatutRdv() { }
    
    StatutRdv(int id) {
        this.id = id;
    }
}
