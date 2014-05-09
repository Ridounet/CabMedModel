package cabmed.admin.ctrl;

import cabmed.admin.ihm.VueAdmin;
import cabmed.admin.ihm.VueAdminModifPersonnel;
import cabmed.admin.main.Facade;
import cabmed.model.Cp;
import cabmed.model.Infirmiere;
import cabmed.model.Medecin;
import cabmed.model.Personnel;
import cabmed.model.Secretaire;
import cabmed.model.Specialisation;
import java.awt.Dialog;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.SwingUtilities;

public class CtrlAdmin {
    
    private final Facade facade;
    private final CtrlPrincipal ctrlPrincipal;
    private final CtrlAdmin me;
    private VueAdmin vueAdmin;
    private VueAdminModifPersonnel vueModifPersonnel;
    public static final String TYPE_MEDECIN = "Physician";
    public static final String TYPE_SECRETAIRE = "Secretary";
    public static final String TYPE_INFIRMIERE = "Nurse";
    
    public CtrlAdmin(CtrlPrincipal ctrlPrincipal, Facade facade) {
        this.ctrlPrincipal = ctrlPrincipal;
        this.facade = facade;
        me = this;
    }
    
    public void showView() {
        if (vueAdmin == null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    vueAdmin = new VueAdmin(me);
                    Facade.addObserver(vueAdmin);
                    vueAdmin.setVisible(true);
                }
            });
        } else {
            vueAdmin.setVisible(true);
        }
    }
    
    public void showViewModifPersonnel(final String type, final Personnel personne) {
        if (vueModifPersonnel == null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    vueModifPersonnel = new VueAdminModifPersonnel(me);
                    Facade.addObserver(vueModifPersonnel);
                    vueModifPersonnel.setPersonne(type, personne);
                    vueModifPersonnel.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
                    vueModifPersonnel.setVisible(true);
                }
            });
        } else {
            vueModifPersonnel.setPersonne(type, personne);
            vueModifPersonnel.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
            vueModifPersonnel.setVisible(true);
        }
        
        
    }
    
    public void hideVueModifPersonnel() {
        vueAdmin.setVisible(true);
        vueModifPersonnel.setVisible(false);
    }
    
    
    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------
    // ------------------------------ Ressources -------------------------------
    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------
    

    public SimpleDateFormat getSdf() {
        return ctrlPrincipal.getSdf();
    }

    // Actions
    public boolean deleteMedecin(Medecin medecin) {
        return facade.deleteMedecin(medecin);
    }

    public boolean addInfirmiere(Infirmiere infirmiere) {
        if (facade.addInfirmiere(infirmiere)) {
            vueAdmin.update();
            return true;
        }
        return false;
    }

    public boolean addSecretaire(Secretaire secretaire) {
        if (facade.addSecretaire(secretaire)) {
            vueAdmin.update();
            return true;
        }
        return false;
    }
    
    public boolean deleteSecretaire(Secretaire secretaire) {
        return facade.deleteSecretaire(secretaire);
    }

    public boolean addPersonnel(Personnel personne) {
        return facade.savePersonnel(personne);
    }
    
    public boolean addMedecin(Medecin medecin) {
        if (facade.addMedecin(medecin)) {
            return true;
        }
        return false;
    }

    // Generalites
    public List<Cp> getListCp() { return ctrlPrincipal.getListCp(); }
    public List<Medecin> getListMedecin() { return ctrlPrincipal.getListMedecin(); }
    public List<Secretaire> getListSecretaire() { return ctrlPrincipal.getListSecretaire(); }
    public List<Infirmiere> getListInfirmiere() { return ctrlPrincipal.getListInfirmiere(); }
    public List<Specialisation> getListSpecialisation() { return ctrlPrincipal.getListSpecialisation(); }

}
