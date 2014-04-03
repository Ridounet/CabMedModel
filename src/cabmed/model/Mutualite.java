package cabmed.model;

import javax.persistence.*;


@Entity
public enum Mutualite {
    PARTENAMUT(1,"Partenamut"),
    MUTUALITE_CHRETIENNE(2,"Mutualite Chretienne"),
    AUTRE(3,"Autre");

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
