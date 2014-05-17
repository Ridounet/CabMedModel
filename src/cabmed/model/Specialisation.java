package cabmed.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    
    @ManyToMany(mappedBy = "specialisation")
    private List<Medecin> medecin = new ArrayList<>();
    
    private boolean visible = true;

    // Constructeurs
    public Specialisation(int duree, String label) {
        this.duree = duree;
        this.label = label;
    }
    
    public Specialisation() { }

    // Surcharge "Object"
    @Override
    public String toString() {
        return label;
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
    public boolean isVisible() { return visible; }
    public void setVisible(boolean visible) { this.visible = visible; }
    public List<Medecin> getMedecin() { return medecin; }
    public void setMedecin(List<Medecin> medecin) { this.medecin = medecin; }
    
    public void addMedecin(Medecin medecin) {
        this.medecin.add(medecin);
    }
    
}
