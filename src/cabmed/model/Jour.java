package cabmed.model;

import javax.persistence.*;

public enum Jour {
    LUNDI(0),
    MARDI(1),
    MERCREDI(2),
    JEUDI(3),
    VENDREDI(4),
    SAMEDI(5);
    
    @Id @GeneratedValue
    private int id;

    Jour() {
    }
    
    Jour(int id){
        this.id = id;
    }
}
