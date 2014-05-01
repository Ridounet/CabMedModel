package cabmed.admin.ctrl;

import cabmed.admin.ihm.VueAdmin;
import cabmed.admin.main.Facade;
import javax.swing.SwingUtilities;

public class CtrlAdmin {
    
    private final Facade facade;
    private final CtrlPrincipal ctrlPrincipal;
    private final CtrlAdmin me;
    private VueAdmin vueAdmin;
    
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
    
}
