package cabmed.admin.ctrl;

import cabmed.admin.ihm.VueAdmin;
import cabmed.admin.ihm.VueAdminAddSpecAMedecin;
import cabmed.admin.ihm.VueAdminModifPersonnel;
import cabmed.admin.ihm.VueAdminModifPlanning;
import cabmed.admin.main.Facade;
import cabmed.model.Cp;
import cabmed.model.Infirmiere;
import cabmed.model.Jour;
import cabmed.model.Medecin;
import cabmed.model.Personnel;
import cabmed.model.Secretaire;
import cabmed.model.Specialisation;
import cabmed.model.Tranche;
import java.awt.Dialog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class CtrlAdmin {
    
    private final Facade facade;
    private final CtrlPrincipal ctrlPrincipal;
    private final CtrlAdmin me;
    private VueAdmin vueAdmin;
    private VueAdminModifPlanning vueModifPlanning;
    private VueAdminModifPersonnel vueModifPersonnel;
    private VueAdminAddSpecAMedecin vueAddSpecAMedecin;
    public static final String TYPE_MEDECIN = "Physician";
    public static final String TYPE_SECRETAIRE = "Secretary";
    public static final String TYPE_INFIRMIERE = "Nurse";
    
    @SuppressWarnings("LeakingThisInConstructor")
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
        vueModifPersonnel.setVisible(false);
    }
    
    public void showViewModifPlanning(final Medecin med) {
        if (vueModifPlanning == null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    vueModifPlanning = new VueAdminModifPlanning();
                    Facade.addObserver(vueModifPersonnel);
                    vueModifPlanning.showView(med);
                }
            });
        } else {
            vueModifPlanning.showView(med);
        }
    }
    
    public void hideVueModifPlanning() {
        vueModifPlanning.setVisible(false);
    }
    
    public void showViewAddSpec(final Medecin med) {
        List<Specialisation> listSpecMed = new ArrayList<>(); // Préparation de la liste des spécialités que ce médecin n'a pas
        for (Specialisation spec : getListSpecialisation()) {
            boolean result = true;
            for (Specialisation specMed : med.getSpecialisation()) {
                if (spec.getId() == specMed.getId()) {
                    result = false;
                    break;
                }
            }
            if (result) {
                listSpecMed.add(spec);
            }
        }
        
        if (vueAddSpecAMedecin == null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    vueAddSpecAMedecin = new VueAdminAddSpecAMedecin(me);
                    vueAddSpecAMedecin.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
                    vueAddSpecAMedecin.showView(med, listSpecMed);
                }
            });
        } else {
            vueAddSpecAMedecin.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
            vueAddSpecAMedecin.showView(med, listSpecMed);
        }
    }
    
    public void hideVueAddSpec() {
        vueAddSpecAMedecin.setVisible(false);
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
        if(facade.deleteMedecin(medecin)) {
            vueAdmin.update();
            return true;
        }
        return false;
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
    
    public boolean deleteNurse(Infirmiere infirmiere) {
        if (facade.deleteInfirmiere(infirmiere)) {
            return true;
        } else {
            errorOccured();
            return false;
        }
    }

    public boolean addPersonnel(Personnel personne) {
        return facade.savePersonnel(personne);
    }
    
    public boolean addMedecin(Medecin medecin) {
        return facade.addMedecin(medecin);
    }
    
    public boolean removeSpecialisationPourMedecin(Medecin med, int index) {
        if (facade.removeSpecialisationPourMedecin(med, index)) {
            return true;
        } else {
            errorOccured();
            return false;
        }
    }
    
    public void addSpecialisationAMedecin(Medecin medecin, Specialisation spec) {
        medecin.addSpecialisation(spec);
        if (facade.addSpecialisationAMedecin(medecin)) {
            vueAdmin.updateListSpecPourMedecin();
            vueAddSpecAMedecin.setVisible(false);
        } else {
            vueAddSpecAMedecin.setVisible(false);
            errorOccured();
        }
    }
    

    // Generalites
    public List<Cp> getListCp() { return ctrlPrincipal.getListCp(); }
    public List<Medecin> getListMedecin() { return ctrlPrincipal.getListMedecin(); }
    public List<Secretaire> getListSecretaire() { return ctrlPrincipal.getListSecretaire(); }
    public List<Infirmiere> getListInfirmiere() { return ctrlPrincipal.getListInfirmiere(); }
    public List<Specialisation> getListSpecialisation() { return ctrlPrincipal.getListSpecialisation(); }
    public Tranche[] getTranches() { return Tranche.values(); }
    public Jour[] getJours() { return Jour.values(); }
    
    
    private void errorOccured() {
        JOptionPane.showMessageDialog(vueAdmin, "An error has occured, please try again.", "Error", JOptionPane.OK_OPTION);
    }

}