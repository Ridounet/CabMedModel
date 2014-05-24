package cabmed.manage.ctrl;

import cabmed.manage.ihm.VueLogin;
import cabmed.manage.main.Facade;
import cabmed.model.Administrateur;
import cabmed.model.Medecin;
import cabmed.model.Personnel;
import cabmed.model.Secretaire;
import javax.swing.JOptionPane;
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
    }
    
    public void showView() {
        if (vueLogin == null) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    vueLogin = new VueLogin(me);
                    vueLogin.setVisible(true);
                }
            });
        } else {
            vueLogin.setVisible(true);
        }
        
    }

    public void login(String login, String password) {
//        Personnel personne;
//        if ((personne = facade.loginMedecin(login, password)) != null) {
//            vueLogin.setVisible(false);
//            ctrlPrincipal.showMedecin((Medecin) personne);
//        } else if ((personne = facade.loginSecretaire(login, password)) != null) {
//            vueLogin.setVisible(false);
//            ctrlPrincipal.showSecretaire((Secretaire) personne);
//        } else {
//            JOptionPane.showMessageDialog(vueLogin, "Login or password incorrect");
//        }
        vueLogin.setVisible(false);
        ctrlPrincipal.showSecretaire(null);
    }

}
