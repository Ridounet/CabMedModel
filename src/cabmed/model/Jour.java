package cabmed.model;

import javax.persistence.*;

public enum Jour {
    LUNDI("Lundi", 0),
    MARDI("Mardi", 1),
    MERCREDI("Mercredi", 2),
    JEUDI("Jeudi", 3),
    VENDREDI("Vendredi", 4),
    SAMEDI("Samedi", 5);
    
    private int id;
    private String label;

    Jour() {
    }
    
    Jour(String label, int id){
        this.id = id;
        this.label = label;
    }
}
