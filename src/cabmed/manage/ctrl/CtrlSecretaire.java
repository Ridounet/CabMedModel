package cabmed.manage.ctrl;

import be.belgium.eid.exceptions.EIDException;
import cabmed.manage.ihm.secretaire.VueHistoriquePatient;
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
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class CtrlSecretaire implements ICtrlSecondaire {

    private final CtrlSecretaire me;
    private final CtrlPrincipal ctrlPrincipal;
    private final Facade facade;
    private final Secretaire secretaire;
    private VueRecherchePatient vueRecherchePatient;
    private VueHistoriquePatient vueHistoriquePatient;
    private VueModifRdv vueModifRdv;
    
    CtrlSecretaire(CtrlPrincipal ctrlPrincipal, Facade facade, Secretaire secretaire) {
        this.ctrlPrincipal = ctrlPrincipal;
        this.facade = facade;
        this.secretaire = secretaire;
        me = this;
    }
    
    @Override
    public void showVuePrincipale() {
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
    
    public void showHistoriquePatient(final Patient patient) {
        if (vueHistoriquePatient == null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    vueHistoriquePatient = new VueHistoriquePatient(me);
                    Facade.addObserver(vueHistoriquePatient);
                    vueHistoriquePatient.showView(patient);
                }
                
            });
        } else {
            vueHistoriquePatient.showView(patient);
        }
    }
    
    public void showModifRdv(Rdv rdv) {
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
    
    public List<Cp> getListCp() { return ctrlPrincipal.getListCp(); }
    public List<Medecin> getListMedecin() { return facade.getListMedecin(); }
    public List<Specialisation> getListSpecialisation() { return facade.getListSpecialisation(); }
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
            showHistoriquePatient(patient);
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
            JOptionPane.showMessageDialog(vueHistoriquePatient,
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