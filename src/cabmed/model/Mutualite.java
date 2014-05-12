package cabmed.model;

public enum Mutualite {
    PARTENAMUT(1,"Partenamut"),
    MUTUALITE_CHRETIENNE(2,"Mutualite Chretienne"),
    SANS_MUT(3,"Sans Mutuelle"),
    AUTRE(4,"Autre");

    Mutualite() {
    }

    Mutualite(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    
    private int id;
    
    private String nom;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
}
