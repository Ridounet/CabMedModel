package cabmed.admin.ctrl;

import cabmed.admin.ihm.VueLogin;
import cabmed.admin.main.Facade;
import cabmed.model.Administrateur;
import javax.swing.SwingUtilities;

public class CtrlLogin {
    
    private final Facade facade;
    private final CtrlPrincipal ctrlPrincipal;
    private final CtrlLogin me;
    private VueLogin vueLogin;
    
    public CtrlLogin (CtrlPrincipal ctrlPrincipal, Facade facade) {
        this.ctrlPrincipal = ctrlPrincipal;
        this.facade = facade;
        me = this;
        
        //showView();
        
        // Recherche DB
        
    }
    
    public void showView() {
        if (vueLogin == null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    vueLogin = new VueLogin(me);
                    Facade.addObserver(vueLogin);
                    vueLogin.setVisible(true);
                }
            });
        } else {
            vueLogin.setVisible(true);
        }
        
    }
    
    public void showAdmin() {
        vueLogin.setVisible(false);
        ctrlPrincipal.showAdmin();
    }

    public Administrateur login(String login, String password) {
        return facade.login(login, password);
    }

    public void putLogged(Administrateur admin) {
        ctrlPrincipal.putLogged(admin);
    }
    
}
