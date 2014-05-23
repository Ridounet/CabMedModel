package cabmed.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Prescription implements Serializable {
    // Attributs
    @Id @GeneratedValue
    private int id;
    
    private String medicament;
    private String posologie;
    private int duree;
    
    // Constructeurs
    public Prescription () { }
    
    public Prescription(String medicament, String posologie, int duree) {
        this.medicament = medicament;
        this.posologie = posologie;
        this.duree = duree;
    }
    
    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getMedicament() { return medicament; }
    public void setMedicament(String medicament) { this.medicament = medicament; }
    public String getPosologie() { return posologie; }
    public void setPosologie(String posologie) { this.posologie = posologie; }
    public int getDuree() { return duree; }
    public void setDuree(int duree) { this.duree = duree; }
    
    
}
