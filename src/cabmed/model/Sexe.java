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

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    @Override
    public String toString() {
        return genre;
    }
    
    
    
}