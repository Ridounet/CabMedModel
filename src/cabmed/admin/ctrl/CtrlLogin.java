package cabmed.admin.ctrl;

import cabmed.admin.ihm.VueLogin;
import cabmed.admin.main.Facade;
import cabmed.ressources.Observer;
import java.awt.EventQueue;
import javax.swing.UnsupportedLookAndFeelException;

public class CtrlLogin {
    
    private VueLogin vueLogin;
    private CtrlLogin me;
    private CtrlPrincipal ctrlPrincipal;
    
    public CtrlLogin (CtrlPrincipal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
        me = this;
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VueLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                vueLogin = new VueLogin(me);
                Facade.addObserver(vueLogin);
                vueLogin.setVisible(true);
            }
        });
        
        
    }
    
}
