package cabmed.model;

import javax.persistence.*;

public enum Mutualite {
    PARTENAMUT(1,"Partenamut"),
    MUTUALITE_CHRETIENNE(2,"Mutualite Chretienne"),
    SANS_MUT(3,"Sans Mutuelle"),
    AUTRE(4,"Autre");

    Mutualite() {
    }

    Mutualite(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    
    @Id @GeneratedValue
    private int id;
    
    private String nom;
    
}
