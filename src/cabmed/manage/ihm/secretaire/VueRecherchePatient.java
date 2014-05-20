package cabmed.manage.ihm.secretaire;

import cabmed.manage.ctrl.CtrlSecretaire;
import cabmed.model.Mutualite;
import cabmed.model.Sexe;
import cabmed.ressources.Observer;
import java.util.Date;
import javax.swing.JOptionPane;

public class VueRecherchePatient extends javax.swing.JFrame implements Observer {

    public VueRecherchePatient() {
        initComponents();
        initAttributes();
    }

    public VueRecherchePatient(CtrlSecretaire me) {
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        btSaveSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        cbSexe.setEnabled(false);

        lbDateNaissance.setText("Date de naissance:");

        dpDateNaissance.setDateFormatString("dd/MM/yyyy");
        dpDateNaissance.setEnabled(false);

        lbMutuality.setText("Mutualité:");

        cbMutualite.setEnabled(false);

        lbNumSecuSocial.setText("Numéro sécurité sociale:");

        ztNumSecuSocial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        ztNumSecuSocial.setEnabled(false);
        ztNumSecuSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ztNumSecuSocialActionPerformed(evt);
            }
        });

        ztPrenom.setEnabled(false);

        ztNom.setEnabled(false);

        lbAdresse.setText("Adresse:");

        ztAdresse.setEnabled(false);

        lbCp.setText("Code Postal:");

        cbCp.setEnabled(false);

        lbTel.setText("Téléphone:");

        ztTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        ztTel.setEnabled(false);

        btCancel.setText("Annuler");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        btSaveSearch.setText("Chercher / Sauver");
        btSaveSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveSearchActionPerformed(evt);
            }
        });

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
                    .addComponent(lbRegistreNat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
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
                        .addComponent(btCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSaveSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btSaveSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btLireCarte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ztNumSecuSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ztNumSecuSocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ztNumSecuSocialActionPerformed

    private void btLireCarteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLireCarteActionPerformed
        if (ztNom.isEnabled()) {
            disableChamps();
        } else {
            enableChamps();
        }
    }//GEN-LAST:event_btLireCarteActionPerformed

    private void btSaveSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveSearchActionPerformed
        if (validationChamps()) {
            JOptionPane.showMessageDialog(null, "All fields are OK");
        } else {
            JOptionPane.showMessageDialog(null, "Please fill all fields!");
        }
    }//GEN-LAST:event_btSaveSearchActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        viderChamps();
        disableChamps();
    }//GEN-LAST:event_btCancelActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VueRecherchePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VueRecherchePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VueRecherchePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VueRecherchePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VueRecherchePatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btLireCarte;
    private javax.swing.JButton btSaveSearch;
    private javax.swing.JComboBox cbCp;
    private javax.swing.JComboBox cbMutualite;
    private javax.swing.JComboBox cbSexe;
    private com.toedter.calendar.JDateChooser dpDateNaissance;
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
    }

    private void viderChamps() {
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
    }
    
    private boolean validationChamps() {
        if (ztNumNational.getText().equals("") ||
                ztNom.getText().equals("") ||
                ztPrenom.getText().equals("") ||
                ztAdresse.getText().equals("") ||
                ztNumSecuSocial.getText().equals("") ||
                ztTel.getText().equals("") ||
                cbCp.getSelectedIndex() == 0 ||
                cbMutualite.getSelectedIndex() == 0 ||
                cbSexe.getSelectedIndex() == 0 ||
                dpDateNaissance.getDate() == null) {
            return false;
        } else {
            return true;
        }
    }

}
