package cabmed.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Embeddable
public class Adresse implements Serializable {
    // Attributs
    @Column(nullable = false)
    private String adresse;
    
    @ManyToOne
    @JoinColumn(name = "code_postal", nullable = false)
    private Cp cp;

    // Override "Object"
    @Override
    public String toString() {
        return "Adresse{" + "rue=" + adresse + ", cp=" + cp.toString() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.adresse);
        hash = 37 * hash + Objects.hashCode(this.cp);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (getClass() != obj.getClass()) { return false; }
        final Adresse other = (Adresse) obj;
        if (!Objects.equals(this.adresse, other.adresse)) { return false; }
        if (!Objects.equals(this.cp, other.cp)) { return false; }
        return true;
    }
    
    // Constructeurs
    public Adresse() { }

    public Adresse(String rue, Cp cp) {
        this.adresse = rue;
        this.cp = cp;
    }

    // Getters & Setters
    public Cp getCp() { return cp; }
    public void setCp(Cp cp) { this.cp = cp; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    
}