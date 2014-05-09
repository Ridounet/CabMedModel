package cabmed.admin.ihm;

import cabmed.admin.ctrl.CtrlLogin;
import cabmed.ressources.Observer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VueLogin extends javax.swing.JFrame implements Observer {

    private final CtrlLogin ctrlLogin;
    
    public VueLogin(CtrlLogin ctrlLogin) {
        super("Cabmed - Login");
        this.ctrlLogin = ctrlLogin;
        initComponents();
    }
    
    
    
    private void actionLogin(ActionEvent evt) {
//        String login = ztLogin.getText();
//        String password = ztPassword.getText();
//        if (login.equals("") || password.equals("")) {
//            JOptionPane.showMessageDialog(null, "Please fill all fields");
//        } else {
//            Administrateur admin = ctrlLogin.login(login, password);
//            if (admin != null) {
//                ctrlLogin.putLogged(admin);
//                ctrlLogin.showAdmin();
//            } else {
//                JOptionPane.showMessageDialog(null, "Login or password not correct");
//            }
//        }
        ctrlLogin.showAdmin();
        
    }

    private JButton btLogin;
    private JLabel lblLogin;
    private JLabel lblPassword;
    private JLabel lblErreur;
    private JTextField ztLogin;
    private JPasswordField ztPassword;
    
    
    private void initComponents() {

        lblLogin = new JLabel();
        lblPassword = new JLabel();
        ztLogin = new JTextField();
        ztPassword = new JPasswordField();
        btLogin = new JButton();
        lblErreur = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblLogin.setText("Login");
        lblPassword.setText("Password");
        btLogin.setText("Log in");
        
        btLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                actionLogin(evt);
            }
        });

        lblErreur.setName("lbErreur"); // NOI18N

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lblLogin)
                            .addComponent(lblPassword))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(ztLogin)
                            .addComponent(ztPassword, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(btLogin))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(lblErreur)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogin)
                    .addComponent(ztLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(ztPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btLogin)
                .addGap(18, 18, 18)
                .addComponent(lblErreur)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }

    @Override
    public void update() {
        
    }
}