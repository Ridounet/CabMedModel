package cabmed.model;

public enum Tranche {
    H0900(0, "09h00"), H0930(2, "09h30"),
    H1000(4, "10h00"), H1030(6, "10h30"),
    H1100(8, "11h00"), H1130(10, "11h30"),
    H1200(12, "12h00"), H1230(14, "12h30"),
    H1300(16, "13h00"), H1330(18, "13h30"),
    H1400(20, "14h00"), H1430(22, "14h30"),
    H1500(24, "15h00"), H1530(26, "15h30"),
    H1600(28, "16h00"), H1630(30, "16h30"),
    H1700(32, "17h00"), H1730(34, "17h30"),
    H1800(36, "18h00"), H1830(38, "18h30");
    
    // Attributs
    private int id;
    private String label;
    
    // Constructeurs
    Tranche() { }
    
    Tranche(int id, String label) {
        this.id = id;
        this.label = label;
    }
    
    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }
    
}
