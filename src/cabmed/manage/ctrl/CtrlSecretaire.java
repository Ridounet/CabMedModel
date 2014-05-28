package cabmed.manage.ctrl;

import be.belgium.eid.exceptions.EIDException;
import cabmed.manage.ihm.secretaire.VueDossierPatient;
import cabmed.manage.ihm.secretaire.VueModifRdv;
import cabmed.manage.ihm.secretaire.VueRecherchePatient;
import cabmed.manage.main.Facade;
import cabmed.model.Cp;
import cabmed.model.Medecin;
import cabmed.model.Patient;
import cabmed.model.Rdv;
import cabmed.model.Secretaire;
import cabmed.model.Specialisation;
import cabmed.ressources.EID;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class CtrlSecretaire implements ICtrlSecondaire {

    private final CtrlSecretaire me;
    private final CtrlPrincipal ctrlPrincipal;
    private final Facade facade;
    private final Secretaire secretaire;
    
    private List<Medecin> listMedecin;
    private List<Cp> listCp;
    private List<Specialisation> listSpecialisation;
    
    private VueRecherchePatient vueRecherchePatient;
    private VueDossierPatient vueDossierPatient;
    private VueModifRdv vueModifRdv;
    
    CtrlSecretaire(CtrlPrincipal ctrlPrincipal, Facade facade, Secretaire secretaire) {
        this.ctrlPrincipal = ctrlPrincipal;
        this.facade = facade;
        this.secretaire = secretaire;
        me = this;
    }
    
    private void initList() {
        listSpecialisation = facade.getListSpecialisation();
        listCp = facade.getListCp();
        listMedecin = facade.getListMedecin();
        facade.getRdvMedecin(listMedecin);
    }

    @Override
    public void showVuePrincipale() {
        initList();
        if (vueRecherchePatient == null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    vueRecherchePatient = new VueRecherchePatient(me);
                    Facade.addObserver(vueRecherchePatient);
                    vueRecherchePatient.setVisible(true);
                }
            });
        } else {
            vueRecherchePatient.viderChamps();
            vueRecherchePatient.setVisible(true);
        }
    }
    
    public void showVueDossierPatient(final Patient patient) {
        if (vueDossierPatient == null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    vueDossierPatient = new VueDossierPatient(me);
                    Facade.addObserver(vueDossierPatient);
                    vueDossierPatient.showView(patient);
                }
                
            });
        } else {
            vueDossierPatient.showView(patient);
        }
    }
    
    public void showVueModifRdv(Rdv rdv) {
        if (vueModifRdv == null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    vueModifRdv = new VueModifRdv(me);
                    vueModifRdv.showView(rdv);
                }
            });
        } else {
            vueModifRdv.showView(rdv);
        }
    }
    
    public List<Medecin> getListMedecin() { return listMedecin; }
    public List<Cp> getListCp() { return listCp; }
    public List<Specialisation> getListSpecialisation() { return listSpecialisation; }
    public SimpleDateFormat getSdf() { return ctrlPrincipal.getSdf(); }
    
    public Patient lireCarte() {
        try {
            return EID.getData();
        } catch (EIDException e) {
            JOptionPane.showMessageDialog(vueRecherchePatient, 
                    "Erreur lors de la lecture de la carte!\nVérifiez que le lecteur et la carte soient bien mis.",
                    "Erreur!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void savePatient(Patient patient) {
        if (facade.savePatient(patient)) {
            vueRecherchePatient.setVisible(false);
            showVueDossierPatient(patient);
        } else {
            JOptionPane.showMessageDialog(vueRecherchePatient, 
                    "Une erreur est survenue pendant l'enregistrement!", 
                    "Erreur!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Patient getPatientByRegistreNat(String reg) {
        return facade.getPatientByRegistreNat(reg);
    }

    public void getRdvPatient(Patient patient) {
        patient.setRdv(facade.getRdvPatient(patient));
    }
    
    public boolean updateRdv(Rdv rdv) {
        if (!facade.updateRdv(rdv)) {
            JOptionPane.showMessageDialog(vueDossierPatient,
                    "Une erreur est survenue lors de l'enregistrement du rendez-vous\nVeuillez ré-essayer",
                    "Erreur!", JOptionPane.ERROR_MESSAGE);
            return false;
        } else return true;
    }

    
    
    
    
    
    public boolean saveRdv(Rdv rdv) {
        Medecin med = rdv.getMedecin();
        int jour = rdv.getDateRdv().getDay() - 1;
        
        if (facade.updateRdv(rdv)) {
            
            return true;
        } else {
            
            return false;
        }
    }

}