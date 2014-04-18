package cabmed.model;

import javax.persistence.*;

public enum StatutRdv {
    EN_COURS(1, "En Cours"),
    CLOTURE(2, "Cloturé"),
    ANNULE(3, "Annulé");
    
    @Id @GeneratedValue
    private int id;
    private String label;
    
    StatutRdv() { }
    
    StatutRdv(int id, String label) {
        this.id = id;
        this.label = label;
    }
}
