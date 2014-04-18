package cabmed.model;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class Adresse implements Serializable {
    // Attributs
    @Column(nullable = false)
    private String adresse;
    
    @ManyToOne
    @JoinColumn(name = "code_postal", nullable = false)
    private Cp cp;

    // ToString
    @Override
    public String toString() {
        return "Adresse{" + "rue=" + adresse + ", cp=" + cp.toString() + '}';
    }

    // Constructeurs
    public Adresse() { }

    public Adresse(String rue, Cp cp) {
        this.adresse = rue;
        this.cp = cp;
    }

    // Getters & Setters
    public String getRue() { return adresse; }
    public void setRue(String rue) { this.adresse = rue; }
    public Cp getCp() { return cp; }
    public void setCp(Cp cp) { this.cp = cp; }
    
}