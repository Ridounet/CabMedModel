package cabmed.model;

import java.util.Date;
import javax.persistence.*;

public class Personne {

    @Id @GeneratedValue
    private int id;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    
    @Embedded
    private Adresse adresse;
    
    private long registreNat;
    private String tel;
    private char sexe;
    private String nom;

    @Override
    public String toString() {
        return "Personne{ " 
                + "nom = " + nom 
                + ", prenom = " + prenom 
                + ", date de naissance = " + dateNaissance 
                + ", registre national = " + registreNat 
                + ", sexe = " + sexe + " }";
    }
    private String prenom;
    private Mutualite mutualite;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Date getDateNaissance() { return dateNaissance; }
    public void setDateNaissance(Date dateNaissance) { this.dateNaissance = dateNaissance; }
    public Adresse getAdresse() { return adresse; }
    public void setAdresse(Adresse adresse) { this.adresse = adresse; }
    public long getRegistreNat() { return registreNat; }
    public void setRegistreNat(long registreNat) { this.registreNat = registreNat; }
    public String getTel() { return tel; }
    public void setTel(String tel) { this.tel = tel; }
    public char getSexe() { return sexe; }
    public void setSexe(char sexe) { this.sexe = sexe; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public Mutualite getMutualite() { return mutualite; }
    public void setMutualite(Mutualite mutualite) { this.mutualite = mutualite; }
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personne other = (Personne) obj;
        if (this.registreNat != other.registreNat) {
            return false;
        }
        return true;
    }
    
}
