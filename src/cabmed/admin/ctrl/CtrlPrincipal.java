package cabmed.admin.ctrl;

import cabmed.admin.ihm.VueLogin;
import cabmed.admin.main.Facade;
import cabmed.model.Cp;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public final class CtrlPrincipal {
    
    private final CtrlLogin ctrlLogin;
    private final CtrlAdmin ctrlAdmin;
    private final Facade facade;
    private final SimpleDateFormat sdf;
    private List<Cp> listCp;
    
    public static void main(String[] args) {
        new CtrlPrincipal();
    }
    
    private CtrlPrincipal() {
        listCp = new LinkedList<>();
        
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        facade = new Facade();
        ctrlAdmin = new CtrlAdmin(this, facade);
        ctrlLogin = new CtrlLogin(this, facade);
        
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException 
                | InstantiationException 
                | IllegalAccessException 
                | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(VueLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        facade.initDB();
        showLogin();
    }
    
    public void showLogin() { ctrlLogin.showView(); }
    public void showAdmin() { ctrlAdmin.showView(); }
    public SimpleDateFormat getSdf() { return sdf; }

    public List<Cp> getListCp() {
        return listCp;
    }
    
    
}
