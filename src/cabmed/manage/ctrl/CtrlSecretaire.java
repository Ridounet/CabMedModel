package cabmed.manage.ctrl;

import cabmed.manage.ihm.secretaire.VueRecherchePatient;
import cabmed.manage.main.Facade;
import cabmed.model.Patient;
import cabmed.model.Secretaire;
import cabmed.ressources.EID;
import javax.swing.SwingUtilities;

public class CtrlSecretaire implements ICtrlSecondaire {
    
    private final CtrlSecretaire me;
    private final CtrlPrincipal ctrlPrincipal;
    private final Facade facade;
    private final Secretaire secretaire;
    private VueRecherchePatient vueRecherchePatient;
    
    CtrlSecretaire(CtrlPrincipal ctrlPrincipal, Facade facade, Secretaire secretaire) {
        this.ctrlPrincipal = ctrlPrincipal;
        this.facade = facade;
        this.secretaire = secretaire;
        me = this;
    }
    
    @Override
    public void showView() {
        if (vueRecherchePatient == null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    vueRecherchePatient = new VueRecherchePatient(me);
                    cabmed.manage.main.Facade.addObserver(vueRecherchePatient);
                    vueRecherchePatient.setVisible(true);
                }
            });
        } else {
            vueRecherchePatient.setVisible(true);
        }
    }
    
    public Patient lireCarte() {
        try {
            return EID.getData();
        } catch (Exception e) {
            return null;
        }
    }
    
}
