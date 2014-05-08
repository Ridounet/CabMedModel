package cabmed.admin.ctrl;

import cabmed.admin.ihm.VueLogin;
import cabmed.admin.main.Facade;
import cabmed.model.Administrateur;
import cabmed.model.Cp;
import cabmed.model.Infirmiere;
import cabmed.model.Medecin;
import cabmed.model.Secretaire;
import cabmed.model.Specialisation;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public final class CtrlPrincipal {
    
    private final CtrlLogin ctrlLogin;
    private final CtrlAdmin ctrlAdmin;
    private final Facade facade;
    private final SimpleDateFormat sdf;
    private Administrateur logged;
    private List<Medecin> medecins;
    private List<Infirmiere> infirmieres;
    private List<Secretaire> secretaires;
    private List<Specialisation> specialisations;
    private List<Cp> listCp;
    
    public static void main(String[] args) {
        new CtrlPrincipal();
    }
    
    public CtrlPrincipal() {
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        facade = new Facade();
        ctrlAdmin = new CtrlAdmin(this, facade);
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
        medecins = facade.getListMedecin();
        infirmieres = facade.getListInfirmiere();
        secretaires = facade.getListSecretaire();
        specialisations = facade.getListSpecialisation();
        
        showLogin();
    }
    
    public void showLogin() { ctrlLogin.showView(); }
    public void showAdmin() { ctrlAdmin.showView(); }
    public SimpleDateFormat getSdf() { return sdf; }

    public void putLogged(Administrateur admin) { logged = admin; }
    public Administrateur getLogged() { return logged; }
    
    public List<Medecin> getMedecins() { return medecins; }
    public void setMedecins(List<Medecin> medecins) { this.medecins = medecins; }
    public List<Infirmiere> getInfirmieres() { return infirmieres; }
    public void setInfirmieres(List<Infirmiere> infirmieres) { this.infirmieres = infirmieres; }
    public List<Secretaire> getSecretaires() { return secretaires; }
    public void setSecretaires(List<Secretaire> secretaires) { this.secretaires = secretaires; }
    public List<Specialisation> getSpecialisations() { return specialisations; }
    public void setSpecialisations(List<Specialisation> specialisations) { this.specialisations = specialisations; }
    public List<Cp> getListCp() { return listCp; }
    
    
}
