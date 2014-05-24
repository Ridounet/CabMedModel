package cabmed.manage.ihm.secretaire;

import cabmed.manage.ctrl.CtrlSecretaire;
import cabmed.model.Adresse;
import cabmed.model.Cp;
import cabmed.model.Mutualite;
import cabmed.model.Patient;
import cabmed.model.Sexe;
import cabmed.ressources.Observer;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

public class VueRecherchePatient extends JFrame implements Observer {

    CtrlSecretaire ctrl;
    Patient patient;
    
    public VueRecherchePatient() {
        initComponents();
        initAttributes();
    }

    public VueRecherchePatient(CtrlSecretaire ctrl) {
        this.ctrl = ctrl;
        initComponents();
        initAttributes();
    }
    
    private void initAttributes() {
        cbSexe.addItem("");
        for (Sexe s : Sexe.values()) {
            cbSexe.addItem(s);
        }
        
        cbMutualite.addItem("");
        for (Mutualite m : Mutualite.values()) {
            cbMutualite.addItem(m.getNom());
        }
        
        cbCp.addItem("");
        cbCp.addItem("1020 Laeken");
        cbCp.addItem("1030 Schaerbeek");
        cbCp.addItem("1040 Etterbeek");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        btLireCarte = new javax.swing.JButton();
        lbRegistreNat = new javax.swing.JLabel();
        ztNumNational = new javax.swing.JFormattedTextField();
        lbNom = new javax.swing.JLabel();
        lbPrenom = new javax.swing.JLabel();
        lbSexe = new javax.swing.JLabel();
        cbSexe = new javax.swing.JComboBox();
        lbDateNaissance = new javax.swing.JLabel();
        dpDateNaissance = new com.toedter.calendar.JDateChooser();
        lbMutuality = new javax.swing.JLabel();
        cbMutualite = new javax.swing.JComboBox();
        lbNumSecuSocial = new javax.swing.JLabel();
        ztNumSecuSocial = new javax.swing.JFormattedTextField();
        ztPrenom = new javax.swing.JTextField();
        ztNom = new javax.swing.JTextField();
        lbAdresse = new javax.swing.JLabel();
        ztAdresse = new javax.swing.JTextField();
        lbCp = new javax.swing.JLabel();
        cbCp = new javax.swing.JComboBox();
        lbTel = new javax.swing.JLabel();
        ztTel = new javax.swing.JFormattedTextField();
        btCancel = new javax.swing.JButton();
        btSauver = new javax.swing.JButton();
        btRechercher = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ztEmail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cabmed - Recherche d'un patient");
        setResizable(false);

        btLireCarte.setText("Lire la carte");
        btLireCarte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLireCarteActionPerformed(evt);
            }
        });

        lbRegistreNat.setText("Numéro national:");

        ztNumNational.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        lbNom.setText("Nom:");

        lbPrenom.setText("Prénom:");

        lbSexe.setText("Sexe:");

        lbDateNaissance.setText("Date de naissance:");

        dpDateNaissance.setDateFormatString("dd/MM/yyyy");

        lbMutuality.setText("Mutualité:");

        lbNumSecuSocial.setText("Numéro sécurité sociale:");

        ztNumSecuSocial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        ztNumSecuSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ztNumSecuSocialActionPerformed(evt);
            }
        });

        lbAdresse.setText("Adresse:");

        lbCp.setText("Code Postal:");

        lbTel.setText("Téléphone:");

        ztTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        btCancel.setText("Effacer");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        btSauver.setText("Sauver");
        btSauver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSauverActionPerformed(evt);
            }
        });

        btRechercher.setText("Chercher");
        btRechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRechercherActionPerformed(evt);
            }
        });

        jLabel1.setText("Email:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btLireCarte, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ztNumNational)
                    .addComponent(lbNom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbRegistreNat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPrenom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSexe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbSexe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbDateNaissance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dpDateNaissance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbMutualite, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ztNumSecuSocial)
                    .addComponent(ztPrenom)
                    .addComponent(ztNom)
                    .addComponent(lbAdresse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ztAdresse)
                    .addComponent(lbCp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbCp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ztTel)
                    .addComponent(lbMutuality, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbNumSecuSocial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btCancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btRechercher)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btSauver))
                            .addComponent(jLabel1)
                            .addComponent(ztEmail))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbRegistreNat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ztNumNational, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbNom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ztNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(lbPrenom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ztPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(lbSexe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbDateNaissance)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dpDateNaissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbMutuality)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbMutualite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbNumSecuSocial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ztNumSecuSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbAdresse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ztAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbCp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbTel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ztTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ztEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btCancel)
                            .addComponent(btRechercher)
                            .addComponent(btSauver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btLireCarte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }//GEN-END:initComponents

    private void btLireCarteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLireCarteActionPerformed
                
        if (ztNom.isEnabled()) {
            
        } else {
            
        }
    }//GEN-LAST:event_btLireCarteActionPerformed

    private void btSauverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSauverActionPerformed
        if (validationChamps()) {
            Patient patient = new Patient();
            patient.setNom(ztNom.getText());
            patient.setPrenom(ztPrenom.getText());
            patient.setNumSecuSocial(ztNumSecuSocial.getText());
            patient.setRegistreNat(ztNumNational.getText());
            patient.setDateNaissance(dpDateNaissance.getDate());
            patient.setAdresse(new Adresse(ztAdresse.getText(), (Cp)cbCp.getSelectedItem()));
            patient.setEmail(ztEmail.getText());
            patient.setMutualite((Mutualite)cbMutualite.getSelectedItem());
            patient.setSexe((Sexe)cbSexe.getSelectedItem());
            patient.setTel(ztTel.getText());
            ctrl.savePatient(patient);
        } else {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs!");
        }
    }//GEN-LAST:event_btSauverActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        viderChamps();
    }//GEN-LAST:event_btCancelActionPerformed

    private void btRechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRechercherActionPerformed
        String reg = ztNumNational.getText();
        patient = ctrl.getPatientByRegistreNat(reg);
        if (patient == null) {
            JOptionPane.showMessageDialog(this, "Aucun patient n'existe avec ce numéro de registre national.");
        } else {
            
        }
        btSauver.enable(true);
    }//GEN-LAST:event_btRechercherActionPerformed
    
    private void ztNumSecuSocialActionPerformed(ActionEvent evt) {
        
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                UnsupportedLookAndFeelException ex) {
            Logger.getLogger(VueRecherchePatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VueRecherchePatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btLireCarte;
    private javax.swing.JButton btRechercher;
    private javax.swing.JButton btSauver;
    private javax.swing.JComboBox cbCp;
    private javax.swing.JComboBox cbMutualite;
    private javax.swing.JComboBox cbSexe;
    private com.toedter.calendar.JDateChooser dpDateNaissance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbAdresse;
    private javax.swing.JLabel lbCp;
    private javax.swing.JLabel lbDateNaissance;
    private javax.swing.JLabel lbMutuality;
    private javax.swing.JLabel lbNom;
    private javax.swing.JLabel lbNumSecuSocial;
    private javax.swing.JLabel lbPrenom;
    private javax.swing.JLabel lbRegistreNat;
    private javax.swing.JLabel lbSexe;
    private javax.swing.JLabel lbTel;
    private javax.swing.JTextField ztAdresse;
    private javax.swing.JTextField ztEmail;
    private javax.swing.JTextField ztNom;
    private javax.swing.JFormattedTextField ztNumNational;
    private javax.swing.JFormattedTextField ztNumSecuSocial;
    private javax.swing.JTextField ztPrenom;
    private javax.swing.JFormattedTextField ztTel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update() {
        
    }
    
    public void enableChamps() {
        ztNom.setEnabled(true);
        ztPrenom.setEnabled(true);
        cbSexe.setEnabled(true);
        cbMutualite.setEnabled(true);
        cbCp.setEnabled(true);
        ztAdresse.setEnabled(true);
        ztNumSecuSocial.setEnabled(true);
        ztTel.setEnabled(true);
        dpDateNaissance.setEnabled(true);
        ztEmail.setEnabled(true);
    }
    
    public void disableChamps() {
        ztNom.setEnabled(false);
        ztPrenom.setEnabled(false);
        cbSexe.setEnabled(false);
        cbMutualite.setEnabled(false);
        cbCp.setEnabled(false);
        ztAdresse.setEnabled(false);
        ztNumSecuSocial.setEnabled(false);
        ztTel.setEnabled(false);
        dpDateNaissance.setEnabled(false);
        ztEmail.setEnabled(false);
    }

    public void viderChamps() {
        ztNumNational.setText("");
        ztNom.setText("");
        ztPrenom.setText("");
        ztAdresse.setText("");
        ztNumSecuSocial.setText("");
        ztTel.setText("");
        cbSexe.setSelectedIndex(0);
        cbMutualite.setSelectedIndex(0);
        cbCp.setSelectedIndex(0);
        dpDateNaissance.setDate(new Date("01/01/1980"));
        ztEmail.setText("");
    }
    
    private boolean validationChamps() {
        return (ztNumNational.getText().equals("") ||
                ztNom.getText().equals("") ||
                ztPrenom.getText().equals("") ||
                ztAdresse.getText().equals("") ||
                ztNumSecuSocial.getText().equals("") ||
                ztTel.getText().equals("") ||
                cbCp.getSelectedIndex() == 0 ||
                cbMutualite.getSelectedIndex() == 0 ||
                cbSexe.getSelectedIndex() == 0 ||
                dpDateNaissance.getDate() == null ||
                ztEmail.getText().equals("")) ? false : true;
    }

}
