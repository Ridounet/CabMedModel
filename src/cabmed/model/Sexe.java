package cabmed.model;

public enum Sexe {
    
    HOMME(1, "Homme"),
    FEMME(2, "Femme");
    
    private int id;
    private String genre;
    
    Sexe(int id, String genre) {
        this.id = id;
        this.genre = genre;
    }
    
}