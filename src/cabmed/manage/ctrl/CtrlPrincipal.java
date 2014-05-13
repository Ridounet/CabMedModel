package cabmed.manage.ctrl;

import cabmed.manage.ihm.VueLogin;
import cabmed.manage.main.Facade;
import cabmed.model.Cp;
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
    private final Facade facade;
    private final SimpleDateFormat sdf;
    private ICtrlSecondaire ctrlSecondaire;
    private List<Medecin> listMedecin;
    private List<Specialisation> listSpecialisation;
    private List<Cp> listCp;
    
    public static void main(String[] args) {
        new CtrlPrincipal();
    }
    
    public CtrlPrincipal() {
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        facade = new Facade(this);
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
        listSpecialisation = facade.getListSpecialisation();
        
        showLogin();
    }
    
    public void showSecretaire(Secretaire secretaire) {
        ctrlSecondaire = new CtrlSecretaire(this, facade, secretaire);
        ctrlSecondaire.showView();
    }
    
    public void showMedecin(Medecin medecin) { 
        ctrlSecondaire = new CtrlMedecin(this, facade, medecin);
        ctrlSecondaire.showView();
    }
    
    public void showLogin() { ctrlLogin.showView(); }
    public SimpleDateFormat getSdf() { return sdf; }
    public List<Medecin> getListMedecin() { return listMedecin; }
    public void setListMedecin(List<Medecin> listMedecin) { this.listMedecin = listMedecin; }
    public List<Specialisation> getListSpecialisation() { return listSpecialisation; }
    public void setListSpecialisation(List<Specialisation> listSpecialisation) { this.listSpecialisation = listSpecialisation; }
    public List<Cp> getListCp() { return listCp; }
    public void setListCp(List<Cp> listCp) { this.listCp = listCp; }
    
}
