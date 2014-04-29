package cabmed.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Disponibilite implements Serializable {
    // Attributs
    @Id @GeneratedValue
    private int id;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Tranche heureDebut;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Tranche heureFin;

    // Constructeurs
    public Disponibilite(Tranche heureDebut, Tranche heureFin) {
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }
    
    public Disponibilite() { }
    
    // Surcharge "Object"
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.heureDebut);
        hash = 71 * hash + Objects.hashCode(this.heureFin);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (getClass() != obj.getClass()) { return false; }
        final Disponibilite other = (Disponibilite) obj;
        if (this.heureDebut != other.heureDebut) { return false; }
        if (this.heureFin != other.heureFin) { return false; }
        return true;
    }

    @Override
    public String toString() {
        return "Disponible de " + heureDebut.getLabel() + " à " + heureFin.getLabel();
    }
    
    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Tranche getHeureDebut() { return heureDebut; }
    public void setHeureDebut(Tranche heureDebut) { this.heureDebut = heureDebut; }
    public Tranche getHeureFin() { return heureFin; }
    public void setHeureFin(Tranche heureFin) { this.heureFin = heureFin; }
    
}
