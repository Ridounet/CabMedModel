package cabmed.model;

public enum Tranche {
    H0900(0, "09h00"), H0915(1, "09h15"), H0930(2, "09h30"), H0945(3, "09h45"),
    H1000(4, "10h00"), H1015(5, "10h15"), H1030(6, "10h30"), H1045(7, "10h45"),
    H1100(8, "11h00"), H1115(9, "11h15"), H1130(10, "11h30"), H1145(11, "11h45"),
    H1200(12, "12h00"), H1215(13, "12h15"), H1230(14, "12h30"), H1245(15, "12h45"),
    H1300(16, "13h00"), H1315(17, "13h15"), H1330(18, "13h30"), H1345(19, "13h45"),
    H1400(20, "14h00"), H1415(21, "14h15"), H1430(22, "14h30"), H1445(23, "14h45"),
    H1500(24, "15h00"), H1515(25, "15h15"), H1530(26, "15h30"), H1545(27, "15h45"),
    H1600(28, "16h00"), H1615(29, "16h15"), H1630(30, "16h30"), H1645(31, "16h45"),
    H1700(32, "17h00"), H1715(33, "17h15"), H1730(34, "17h30"), H1745(35, "17h45"),
    H1800(36, "18h00"), H1815(37, "18h15"), H1830(38, "18h30"), H1845(39, "18h45");
    
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
