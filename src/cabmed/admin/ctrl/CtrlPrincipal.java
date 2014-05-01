package cabmed.admin.ctrl;

import cabmed.admin.ihm.VueLogin;
import cabmed.admin.main.Facade;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

public final class CtrlPrincipal {
    
    private final CtrlLogin ctrlLogin;
    private final CtrlAdmin ctrlAdmin;
    private final Facade facade;
    
    public static void main(String[] args) {
        new CtrlPrincipal();
    }
    
    private CtrlPrincipal() {
        
        facade = new Facade();
        ctrlAdmin = new CtrlAdmin(this, facade);
        ctrlLogin = new CtrlLogin(this, facade);
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException 
                | InstantiationException 
                | IllegalAccessException 
                | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(VueLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        showLogin();
    }
    
    public void showLogin() {
        ctrlLogin.showView();
    }

    public void showAdmin() {
        ctrlAdmin.showView();
    }
    
    
    
}
