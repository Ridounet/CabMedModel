package cabmed.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "type_personne")
public abstract class Personne implements Serializable {
    // Attributs
    @Id @GeneratedValue
    @Column(nullable = false, unique = true)
    private int id;
    
    @Column(nullable = false, unique = false)
    private String registreNat;
    
    @Column(nullable = false)
    private String nom;
    
    @Column(nullable = false)
    private String prenom;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dateNaissance;
    
    @Embedded
    private Adresse adresse;
    
    @Column(nullable = true)
    private String tel;
    
    @Column(unique = true)
    private String email;
    
    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sexe sexe;
    
    @Column(name = "visible", nullable = false)
    private boolean visible = true;

    // Constructeurs
    public Personne() { }
    
    public Personne(String registreNat, String nom, String prenom, Date dateNaissance, 
            Adresse adresse, String tel, Sexe sexe, String email, String password) {
        this.registreNat = registreNat;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.tel = tel;
        this.sexe = sexe;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }
    
    // Surcharge "Object"
    @Override
    public String toString() {
        return "Personne{ " 
                + "nom = " + nom 
                + ", prenom = " + prenom 
                + ", date de naissance = " + dateNaissance 
                + ", registre national = " + registreNat 
                + ", sexe = " + sexe + " }";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final Personne other = (Personne) obj;
        if (!this.registreNat.equals(other.registreNat)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.registreNat);
        return hash;
    }
    
    // Getters & Setters
    public Date getDateNaissance() { return dateNaissance; }
    public void setDateNaissance(Date dateNaissance) { this.dateNaissance = dateNaissance; }
    public Adresse getAdresse() { return adresse; }
    public void setAdresse(Adresse adresse) { this.adresse = adresse; }
    public String getRegistreNat() { return registreNat; }
    public void setRegistreNat(String registreNat) { this.registreNat = registreNat; }
    public String getTel() { return tel; }
    public void setTel(String tel) { this.tel = tel; }
    public Sexe getSexe() { return sexe; }
    public void setSexe(Sexe sexe) { this.sexe = sexe; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public boolean isVisible() { return visible; }
    public void setVisible(boolean visible) { this.visible = visible; }
    
}
