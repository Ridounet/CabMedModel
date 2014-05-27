package cabmed.manage.ihm.secretaire;

import cabmed.manage.ctrl.CtrlSecretaire;
import cabmed.model.Medecin;
import cabmed.model.Rdv;
import cabmed.model.Specialisation;
import cabmed.model.Tranche;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class VueModifRdv extends javax.swing.JFrame {
    
    private CtrlSecretaire ctrl;
    private Rdv rdv;
    private List<Medecin> listMedecin;
    private List<Specialisation> listSpecialisation;
    
    public VueModifRdv() {
        initComponents();
        initChamps();
        
    }

    public VueModifRdv(CtrlSecretaire ctrl) {
        this.ctrl = ctrl;
        initComponents();
        initChamps();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbMedecin = new javax.swing.JComboBox();
        dpDate = new com.toedter.calendar.JDateChooser();
        cbTranche = new javax.swing.JComboBox();
        btSave = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbSpecialisation = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cabmed - Modif. Rdv");
        setResizable(false);

        jLabel2.setText("Médecin:");

        jLabel3.setText("Date:");

        jLabel5.setText("Heure:");

        dpDate.setDateFormatString("dd-MM-yyyy");
        dpDate.setMinSelectableDate(new Date());

        btSave.setText("Sauver");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        btCancel.setText("Annuler");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        jLabel4.setText("Specialisation:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dpDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbTranche, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbMedecin, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbSpecialisation, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbMedecin, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbSpecialisation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dpDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTranche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }//GEN-END:initComponents

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        if (validationChamps()) {
            int option = JOptionPane.showConfirmDialog(this,
                    "Enregistrer ce rendez-vous?\n"
                            + "Médecin: " + ((Medecin)cbMedecin.getSelectedItem()).getNom() + "\n"
                            + "Spécialisation: " + ((Specialisation)cbSpecialisation.getSelectedItem()).getLabel() + "\n"
                            + "Date: " + ctrl.getSdf().format(dpDate.getDate()) + "\n"
                            + "Heure: " + cbTranche.getSelectedItem(),
                    "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (option == 0) {
                rdv.setDateRdv(dpDate.getDate());
                rdv.setHeure((Tranche)cbTranche.getSelectedItem());
                rdv.setMedecin((Medecin)cbMedecin.getSelectedItem());
                rdv.setTypeRdv((Specialisation)cbSpecialisation.getSelectedItem());
                if (ctrl.updateRdv(rdv)) {
                    setVisible(false);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs");
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        
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
            java.util.logging.Logger.getLogger(VueModifRdv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VueModifRdv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VueModifRdv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VueModifRdv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VueModifRdv().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btSave;
    private javax.swing.JComboBox cbMedecin;
    private javax.swing.JComboBox cbSpecialisation;
    private javax.swing.JComboBox cbTranche;
    private com.toedter.calendar.JDateChooser dpDate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
    
    private boolean validationChamps() {
        if (cbMedecin.getSelectedIndex() == 0 ||
                cbTranche.getSelectedIndex() == 0 ||
                cbSpecialisation.getSelectedIndex() == 0 ||
                dpDate.getDate() == null)
            return false;
        else return true;
    }

    private void initChamps() {
        listMedecin = ctrl.getListMedecin();
        cbMedecin.addItem("");
        for (Medecin m : listMedecin) {
            cbMedecin.addItem(m);
        }
        
        listSpecialisation = ctrl.getListSpecialisation();
        cbSpecialisation.addItem("");
        for (Specialisation s : listSpecialisation) {
            cbSpecialisation.addItem(s);
        }
        
        cbTranche.addItem("");
        for (Tranche t : Tranche.values()) {
            cbTranche.addItem(t);
        }
    }

    public void showView(Rdv rdvRecu) {
        this.rdv = rdvRecu;
        cbMedecin.setSelectedItem(rdv.getMedecin());
        cbSpecialisation.setSelectedItem(rdv.getTypeRdv());
        cbTranche.setSelectedItem(rdv.getHeure());
        dpDate.setDate(rdv.getDateRdv());
        setVisible(true);
    }
    
}
