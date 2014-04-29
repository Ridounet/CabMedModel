package cabmed.model;

import javax.persistence.*;

public enum StatutRdv {
    EN_COURS(1, "En Cours"),
    CLOTURE(2, "Cloturé"),
    ANNULE(3, "Annulé");
    
    // Attributs
    @Id @GeneratedValue
    private int id;
    private String label;
    
    // Constructeurs
    StatutRdv() { }
    
    StatutRdv(int id, String label) {
        this.id = id;
        this.label = label;
    }
    
    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

}
