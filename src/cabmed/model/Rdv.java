package cabmed.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Rdv implements Serializable {
    // Attributs
    @Id @GeneratedValue
    private int id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRdv;
    
    @Enumerated(EnumType.STRING)
    private Tranche heure;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Patient patient;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Medecin medecin;
    
    @ManyToOne
    private Specialisation typeRdv;
    
    @Enumerated(EnumType.STRING)
    private StatutRdv statut;
    
    @OneToMany
    @ElementCollection
    private List<Prescription> prescriptions;
    
    private String remarque;

    // Constructeurs
    public Rdv(Date dateRdv, Patient patient, Medecin medecin, Specialisation typeRdv, StatutRdv statut, Tranche heure) {
        this.dateRdv = dateRdv; this.patient = patient; this.medecin = medecin;
        this.typeRdv = typeRdv; this.statut = statut; this.heure = heure;
    }

    public Rdv() { }
    
    // Override "Object"
    @Override
    public String toString() {
        return "RDV pour " + patient.getPrenom()+ " " + patient.getNom()
                + " avec le docteur " + medecin.getNom() 
                + " le "+ dateRdv +" à " + heure.getLabel() 
                + ", type du rdv = " + typeRdv + ", statut = " + statut.getLabel();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.dateRdv);
        hash = 41 * hash + Objects.hashCode(this.patient);
        hash = 41 * hash + Objects.hashCode(this.medecin);
        hash = 41 * hash + Objects.hashCode(this.typeRdv);
        hash = 41 * hash + Objects.hashCode(this.statut);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (getClass() != obj.getClass()) { return false; }
        final Rdv other = (Rdv) obj;
        if (!Objects.equals(this.dateRdv, other.dateRdv)) { return false; }
        if (!Objects.equals(this.patient, other.patient)) { return false; }
        if (!Objects.equals(this.medecin, other.medecin)) { return false; }
        if (!Objects.equals(this.typeRdv, other.typeRdv)) { return false; }
        if (this.heure != other.heure) { return false; }
        return true;
    }
    
    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }
    public Medecin getMedecin() { return medecin; }
    public void setMedecin(Medecin medecin) { this.medecin = medecin; }
    public Specialisation getTypeRdv() { return typeRdv; }
    public void setTypeRdv(Specialisation typeRdv) { this.typeRdv = typeRdv; }
    public StatutRdv getStatut() { return statut; }
    public void setStatut(StatutRdv statut) { this.statut = statut; }
    public Date getDateRdv() { return dateRdv; }
    public void setDateRdv(Date dateRdv) { this.dateRdv = dateRdv; }
    public Tranche getHeure() { return heure; }
    public void setHeure(Tranche heure) { this.heure = heure; }
    public List<Prescription> getPrescriptions() { return prescriptions; }
    public void setPrescriptions(List<Prescription> prescriptions) { this.prescriptions = prescriptions; }
    public String getRemarque() { return remarque; }
    public void setRemarque(String remarque) { this.remarque = remarque; }
    
}
