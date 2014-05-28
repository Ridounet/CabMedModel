package cabmed.manage.ctrl;

import cabmed.manage.ihm.medecin.VueAddConclusion;
import cabmed.manage.ihm.medecin.VueDetailsRdv;
import cabmed.manage.ihm.medecin.VueDossierPatient;
import cabmed.manage.ihm.medecin.VueRechercheDossier;
import cabmed.manage.main.Facade;
import cabmed.model.Medecin;
import cabmed.model.Patient;
import cabmed.model.Rdv;
import cabmed.model.StatutRdv;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class CtrlMedecin implements ICtrlSecondaire {
    
    private final CtrlMedecin me;
    private final CtrlPrincipal ctrlPrincipal;
    private final Facade facade;
    private final Medecin medecin;
    private VueRechercheDossier vueRechercheDossier;
    private VueDossierPatient vueDossierPatient;
    private VueDetailsRdv vueDetailsRdv;
    private VueAddConclusion vueAddConclusion;
    
    public CtrlMedecin(CtrlPrincipal ctrlPrincipal, Facade facade, Medecin medecin) {
        this.ctrlPrincipal = ctrlPrincipal;
        this.facade = facade;
        this.medecin = medecin;
        me = this;
    }
    
    @Override
    public void showVuePrincipale() {
        if (vueRechercheDossier == null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    vueRechercheDossier = new VueRechercheDossier(me);
                    Facade.addObserver(vueRechercheDossier);
                    vueRechercheDossier.showView();
                }
            });
        } else {
            vueRechercheDossier.showView();
        }
    }

    private void showVueDossierPatient(Rdv rdv) {
        if (vueDossierPatient == null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    vueDossierPatient = new VueDossierPatient(me);
                    Facade.addObserver(vueDossierPatient);
                    vueDossierPatient.showView(rdv);
                }
            });
        } else {
            vueDossierPatient.showView(rdv);
        }
    }
    
    private void showVueDetailsRdv(Rdv rdv) {
        if (vueDetailsRdv == null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    vueDetailsRdv = new VueDetailsRdv(me);
                    Facade.addObserver(vueDetailsRdv);
                    vueDetailsRdv.showView(rdv);
                }
            });
        } else {
            vueDetailsRdv.showView(rdv);
        }
    }
    
    private void showVueAddConclusion(Rdv rdv) {
        if (vueAddConclusion == null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    vueAddConclusion = new VueAddConclusion(me);
                    vueAddConclusion.showView(rdv);
                }
            });
        } else {
            vueAddConclusion.showView(rdv);
        }
        vueDossierPatient.setVisible(false);
    }
    
    public SimpleDateFormat getSdf() { return ctrlPrincipal.getSdf(); }
    
    public void getRdvParId(int idRdv) {
        Rdv rdv = facade.getRdvParId(idRdv);
        if (rdv == null) {
            JOptionPane.showMessageDialog(vueRechercheDossier, "Ce numéro ne correspond à aucun rendez-vous", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            vueRechercheDossier.setVisible(false);
            showVueDossierPatient(rdv);
        }
    }
    
    public void getRdvPatient(Patient patient) {
        patient.setRdv(facade.getRdvPatient(patient));
    }
    
    public void showVueRdv(Rdv rdv) {
        showVueDetailsRdv(rdv);
    }
    
    public void fermerDossier(Rdv rdv) {
        showVueAddConclusion(rdv);
    }

    public void saveRdv(Rdv rdv) {
        rdv.setStatut(StatutRdv.CLOTURE);
        if (facade.updateRdv(rdv)) {
            vueAddConclusion.setVisible(false);
            showVuePrincipale();
        } else {
            JOptionPane.showMessageDialog(vueAddConclusion, 
                    "Une erreur est survenue pendant l'enregistrement du rendez-vous!", "Erreur!", JOptionPane.ERROR_MESSAGE);
        }
    }
}