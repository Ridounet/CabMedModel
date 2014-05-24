package cabmed.model;

import java.util.Objects;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.codePostal;
        hash = 29 * hash + Objects.hashCode(this.nom);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (getClass() != obj.getClass()) { return false; }
        final Cp other = (Cp) obj;
        if (this.codePostal != other.codePostal) { return false; }
        return true;
    }
    
    
    
    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getCodePostal() { return codePostal; }
    public void setCodePostal(int codePostal) { this.codePostal = codePostal; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
}