package cabmed.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Planning implements Serializable {
    // Attributs
    @Id @GeneratedValue
    private int id;
    
    @ElementCollection
    @OneToMany(cascade = CascadeType.ALL)
    private Map<Jour,Disponibilite> disponibilite;
    
    @ElementCollection
    @OneToMany(cascade = CascadeType.ALL)
    private Map<Date,Horaire> horaire;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Medecin medecin;
    
    // Constructeurs
    public Planning(Medecin medecin) { setMedecin(medecin); }

    public Planning() { }
    
    // Override "Object"
    @Override
    public String toString() {
        return "Planning du docteur " + medecin.getPrenom() + " " + medecin.getNom();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.medecin);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (getClass() != obj.getClass()) { return false; }
        final Planning other = (Planning) obj;
        if (!Objects.equals(this.medecin, other.medecin)) { return false; }
        return true;
    }
    
    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Map<Jour, Disponibilite> getDisponibilite() { return disponibilite; }
    public void setDisponibilite(Map<Jour, Disponibilite> disponibilite) { this.disponibilite = disponibilite; }
    public Map<Date, Horaire> getHoraire() { return horaire; }
    public void setHoraire(Map<Date, Horaire> horaire) { this.horaire = horaire; }
    public Medecin getMedecin() { return medecin; }
    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
        medecin.setPlanning(this);
    }
    
}
