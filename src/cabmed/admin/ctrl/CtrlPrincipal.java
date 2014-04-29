package cabmed.admin.ctrl;

import javax.swing.SwingUtilities;

public class CtrlPrincipal {
    
    private CtrlLogin ctrlLogin;
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new CtrlPrincipal();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    private CtrlPrincipal() {
        ctrlLogin = new CtrlLogin(this);
        
    }
    
    
    
}
