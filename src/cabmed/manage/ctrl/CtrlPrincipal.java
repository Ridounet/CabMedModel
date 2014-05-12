package cabmed.manage.ctrl;

import cabmed.manage.ihm.VueLogin;
import cabmed.manage.main.Facade;
import cabmed.model.Administrateur;
import cabmed.model.Cp;
import cabmed.model.Infirmiere;
import cabmed.model.Medecin;
import cabmed.model.Secretaire;
import cabmed.model.Specialisation;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public final class CtrlPrincipal {
    
    private final CtrlLogin ctrlLogin;
    private final CtrlManage ctrlManage;
    private final Facade facade;
    private final SimpleDateFormat sdf;
    private Administrateur logged;
    private List<Medecin> listMedecin;
    private List<Infirmiere> listInfirmiere;
    private List<Secretaire> listSecretaire;
    private List<Specialisation> listSpecialisation;
    private List<Cp> listCp;
    
    public static void main(String[] args) {
        new CtrlPrincipal();
    }
    
    public CtrlPrincipal() {
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        facade = new Facade(this);
        ctrlManage = new CtrlManage(this, facade);
        ctrlLogin = new CtrlLogin(this, facade);
        
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException 
                | InstantiationException 
                | IllegalAccessException 
                | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(VueLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        facade.initDB();
        
        listCp = facade.getListCp();
        listMedecin = facade.getListMedecin();
        listInfirmiere = facade.getListInfirmiere();
        listSecretaire = facade.getListSecretaire();
        listSpecialisation = facade.getListSpecialisation();
        
        showLogin();
    }
    
    public void showLogin() { ctrlLogin.showView(); }
    public void showPrincipal() { ctrlManage.showView(); }
    public SimpleDateFormat getSdf() { return sdf; }

    public void putLogged(Administrateur admin) { logged = admin; }
    public Administrateur getLogged() { return logged; }

    public List<Medecin> getListMedecin() { return listMedecin; }
    public void setListMedecin(List<Medecin> listMedecin) { this.listMedecin = listMedecin; }
    public List<Infirmiere> getListInfirmiere() { return listInfirmiere; }
    public void setListInfirmiere(List<Infirmiere> listInfirmiere) { this.listInfirmiere = listInfirmiere; }
    public List<Secretaire> getListSecretaire() { return listSecretaire; }
    public void setListSecretaire(List<Secretaire> listSecretaire) { this.listSecretaire = listSecretaire; }
    public List<Specialisation> getListSpecialisation() { return listSpecialisation; }
    public void setListSpecialisation(List<Specialisation> listSpecialisation) { this.listSpecialisation = listSpecialisation; }
    public List<Cp> getListCp() { return listCp; }
    public void setListCp(List<Cp> listCp) { this.listCp = listCp; }
    
    public void addMedecin(Medecin medecin) { listMedecin.add(medecin); }
    public void addSecretaire(Secretaire secretaire) { listSecretaire.add(secretaire); }
    public void addInfirmiere(Infirmiere infirmiere) { listInfirmiere.add(infirmiere); }
    public void addSpecialisation(Specialisation specialisation) { listSpecialisation.add(specialisation); }
    
}
