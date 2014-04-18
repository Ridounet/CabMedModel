package cabmed.model;

import javax.persistence.*;

@Entity
public class Cp {
    // Attributs
    @Id @GeneratedValue
    private int id;
    
    private int codePostal;
    private String nom;

    
    
    // Constructeurs
    public Cp() { }

    public Cp(int codePostal, String nom) {
        this.codePostal = codePostal;
        this.nom = nom;
    }
    
    // ToString
    @Override
    public String toString() {
        return codePostal + " " + nom;
    }
    
    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getCodePostal() { return codePostal; }
    public void setCodePostal(int codePostal) { this.codePostal = codePostal; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
}