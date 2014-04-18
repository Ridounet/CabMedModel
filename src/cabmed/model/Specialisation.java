package cabmed.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Specialisation implements Serializable {
    // Attributs
    @Id @GeneratedValue
    private int id;
    
    @Column(nullable = false)
    private int duree;
    
    @Column(nullable = false, unique = true)
    private String label;

    // Constructeurs
    public Specialisation(int duree, String label) {
        this.duree = duree;
        this.label = label;
    }
    
    public Specialisation() { }

    // Surcharge "Object"
    @Override
    public String toString() {
        return "Specialisation: " + label + " avec durée par défaut de " + duree + "min";
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.duree;
        hash = 37 * hash + Objects.hashCode(this.label);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (getClass() != obj.getClass()) { return false; }
        final Specialisation other = (Specialisation) obj;
        if (this.duree != other.duree) { return false; }
        if (!Objects.equals(this.label, other.label)) { return false; }
        return true;
    }
    
    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getDuree() { return duree; }
    public void setDuree(int duree) { this.duree = duree; }
    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }
}
