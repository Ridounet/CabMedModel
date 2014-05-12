package cabmed.manage.ctrl;

import cabmed.admin.ihm.VueAdmin;
import cabmed.manage.ihm.VueRecherchePatient;
import cabmed.manage.main.Facade;
import javax.swing.SwingUtilities;

public class CtrlRecherchePatient {
    
    private final CtrlRecherchePatient me;
    private final CtrlPrincipal ctrlPrincipal;
    private final Facade facade;
    private VueRecherchePatient vueRecherchePatient;
    
    public CtrlRecherchePatient(CtrlPrincipal ctrlPrincipal, Facade facade) {
        this.ctrlPrincipal = ctrlPrincipal;
        this.facade = facade;
        me = this;
    }
    
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
    
}
