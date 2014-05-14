package cabmed.admin.ihm;

import cabmed.admin.ctrl.CtrlAdmin;
import cabmed.model.Medecin;
import cabmed.model.Specialisation;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VueAdminAddSpecAMedecin extends javax.swing.JFrame {

    private CtrlAdmin ctrl;
    private List<Specialisation> listSpec;
    private Medecin medecin;
    
    public VueAdminAddSpecAMedecin() {
        initComponents();
    }

    public VueAdminAddSpecAMedecin(CtrlAdmin ctrlAdmin) {
        initComponents();
        this.ctrl = ctrlAdmin;
        listSpec = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitre = new javax.swing.JLabel();
        lbErreur = new javax.swing.JLabel();
        cbSpec = new javax.swing.JComboBox();
        btSave = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setTitle("Cabmed - Add specialisation");

        lbTitre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitre.setText("Select a Specialization");

        lbErreur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btSave.setText("Save");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        btCancel.setText("Cancel");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btSave)
                        .addGap(68, 68, 68)
                        .addComponent(btCancel)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbErreur, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbTitre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbSpec, 0, 190, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbTitre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbErreur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbSpec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSave)
                    .addComponent(btCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        if (cbSpec.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a specialization.");
        } else {
            Specialisation spec = (Specialisation) cbSpec.getSelectedItem();
            ctrl.addSpecialisationAMedecin(medecin, spec);
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        ctrl.hideVueAddSpec();
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
            java.util.logging.Logger.getLogger(VueAdminAddSpecAMedecin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VueAdminAddSpecAMedecin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VueAdminAddSpecAMedecin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VueAdminAddSpecAMedecin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VueAdminAddSpecAMedecin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btSave;
    private javax.swing.JComboBox cbSpec;
    private javax.swing.JLabel lbErreur;
    private javax.swing.JLabel lbTitre;
    // End of variables declaration//GEN-END:variables

    public void showView(Medecin medecin, List<Specialisation> listSpecialisation) {
        this.medecin = medecin;
        cbSpec.removeAllItems();
        cbSpec.addItem("");
        for (Specialisation s : listSpecialisation) {
            cbSpec.addItem(s);
        }
        setVisible(true);
    }
}
