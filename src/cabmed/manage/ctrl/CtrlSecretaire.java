package cabmed.manage.ctrl;

import be.belgium.eid.exceptions.EIDException;
import cabmed.manage.ihm.secretaire.VueHistoriquePatient;
import cabmed.manage.ihm.secretaire.VueRecherchePatient;
import cabmed.manage.main.Facade;
import cabmed.model.Patient;
import cabmed.model.Secretaire;
import cabmed.ressources.EID;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class CtrlSecretaire implements ICtrlSecondaire {

    private final CtrlSecretaire me;
    private final CtrlPrincipal ctrlPrincipal;
    private final Facade facade;
    private final Secretaire secretaire;
    private VueRecherchePatient vueRecherchePatient;
    private VueHistoriquePatient vueHistoriquePatient;
    
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
    
    private void showHistoriquePatient(final Patient patient) {
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
    
    public Patient lireCarte() {
        try {
            return EID.getData();
        } catch (EIDException e) {
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

    
}
