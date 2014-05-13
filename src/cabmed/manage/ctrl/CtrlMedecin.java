package cabmed.manage.ctrl;

import cabmed.manage.ihm.VueRechercheDossier;
import cabmed.manage.main.Facade;
import cabmed.model.Medecin;
import javax.swing.SwingUtilities;

public class CtrlMedecin implements ICtrlSecondaire {
    
    private final CtrlMedecin me;
    private final CtrlPrincipal ctrlPrincipal;
    private final Facade facade;
    private final Medecin medecin;
    private VueRechercheDossier vueRechercheDossier;
    
    public CtrlMedecin(CtrlPrincipal ctrlPrincipal, Facade facade, Medecin medecin) {
        this.ctrlPrincipal = ctrlPrincipal;
        this.facade = facade;
        this.medecin = medecin;
        me = this;
    }
    
    @Override
    public void showView() {
        if (vueRechercheDossier == null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    vueRechercheDossier = new VueRechercheDossier(me);
                    cabmed.manage.main.Facade.addObserver(vueRechercheDossier);
                    vueRechercheDossier.setVisible(true);
                }
            });
        } else {
            vueRechercheDossier.setVisible(true);
        }
    }
    
}