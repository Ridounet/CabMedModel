package cabmed.admin.ihm;

import cabmed.admin.ctrl.CtrlAdmin;
import cabmed.model.Adresse;
import cabmed.model.Cp;
import cabmed.model.Infirmiere;
import cabmed.model.Medecin;
import cabmed.model.Personnel;
import cabmed.model.Secretaire;
import cabmed.model.Sexe;
import java.util.Date;
import javax.swing.JOptionPane;

public class VueAdminModifPersonnel extends javax.swing.JFrame implements cabmed.ressources.Observer{

    private CtrlAdmin ctrlAdmin;
    private Personnel personne;

    public VueAdminModifPersonnel(CtrlAdmin ctrlAdmin) {
        this.ctrlAdmin = ctrlAdmin;
        initComponents();
        initAttributes();
    }
    
    public VueAdminModifPersonnel() {
        initComponents();
        initAttributes();
    }
    
    private void initAttributes() {
        cbSexe.addItem(Sexe.HOMME);
        cbSexe.addItem(Sexe.FEMME);
        for (Cp cp : ctrlAdmin.getListCp()) {
            cbCp.addItem(cp);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbDetailPersonne = new javax.swing.JLabel();
        lbTitre = new javax.swing.JLabel();
        lbNom = new javax.swing.JLabel();
        lbPrenom = new javax.swing.JLabel();
        lbDateNaissance = new javax.swing.JLabel();
        lbSexe = new javax.swing.JLabel();
        lbNumeroNational = new javax.swing.JLabel();
        lbTel = new javax.swing.JLabel();
        lbBeginWork = new javax.swing.JLabel();
        lbAdresse = new javax.swing.JLabel();
        lbCp = new javax.swing.JLabel();
        ztNom = new javax.swing.JFormattedTextField();
        ztPrenom = new javax.swing.JFormattedTextField();
        cbSexe = new javax.swing.JComboBox();
        ztNumeroNational = new javax.swing.JFormattedTextField();
        ztTel = new javax.swing.JFormattedTextField();
        ztAdresse = new javax.swing.JTextField();
        btSave = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        dpDateNaissance = new com.toedter.calendar.JDateChooser();
        dpDebutTravail = new com.toedter.calendar.JDateChooser();
        cbCp = new javax.swing.JComboBox();

        setTitle("Cabmed - modification Personal");
        setResizable(false);

        lbDetailPersonne.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbDetailPersonne.setText("Person's details");
        lbDetailPersonne.setToolTipText("");

        lbTitre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTitre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitre.setText("TODO");

        lbNom.setText("Firstname");

        lbPrenom.setText("Lastname");

        lbDateNaissance.setText("Birthdate");

        lbSexe.setText("Sex");

        lbNumeroNational.setText("National number");

        lbTel.setText("Tel.");

        lbBeginWork.setText("Beginning work at");

        lbAdresse.setText("Address");

        lbCp.setText("Postal code");

        ztNom.setMaximumSize(new java.awt.Dimension(115, 22));
        ztNom.setPreferredSize(new java.awt.Dimension(115, 22));

        ztPrenom.setMaximumSize(new java.awt.Dimension(115, 22));
        ztPrenom.setPreferredSize(new java.awt.Dimension(115, 22));

        cbSexe.setPreferredSize(new java.awt.Dimension(115, 22));

        ztNumeroNational.setPreferredSize(new java.awt.Dimension(115, 22));

        ztTel.setPreferredSize(new java.awt.Dimension(115, 22));

        ztAdresse.setPreferredSize(new java.awt.Dimension(115, 22));

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

        dpDateNaissance.setDate(new java.util.Date("01/01/1980"));
        dpDateNaissance.setDateFormatString("dd/MM/yyyy");
        dpDateNaissance.setMaxSelectableDate(new java.util.Date());
        dpDateNaissance.setMinSelectableDate(new java.util.Date("01/01/1900"));

        dpDebutTravail.setDate(new java.util.Date());
        dpDebutTravail.setDateFormatString("dd/MM/yyyy");
        dpDebutTravail.setMinSelectableDate(new java.util.Date());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbDetailPersonne, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbTel)
                                .addComponent(lbSexe)
                                .addComponent(lbNom)
                                .addComponent(lbAdresse)
                                .addComponent(lbCp)
                                .addComponent(lbNumeroNational)
                                .addComponent(lbBeginWork)
                                .addComponent(lbPrenom)
                                .addComponent(lbDateNaissance)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(147, 147, 147)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ztAdresse, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                .addComponent(ztTel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ztNumeroNational, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbSexe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ztPrenom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ztNom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dpDebutTravail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dpDateNaissance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbCp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btSave)
                .addGap(18, 18, 18)
                .addComponent(btCancel)
                .addGap(95, 95, 95))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lbTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbDetailPersonne, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbNom)
                                    .addComponent(ztNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbPrenom)
                                    .addComponent(ztPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(lbDateNaissance))
                            .addComponent(dpDateNaissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbSexe)
                            .addComponent(cbSexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNumeroNational)
                            .addComponent(ztNumeroNational, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTel)
                            .addComponent(ztTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lbBeginWork))
                    .addComponent(dpDebutTravail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAdresse)
                    .addComponent(ztAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbCp)
                    .addComponent(cbCp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSave)
                    .addComponent(btCancel))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        if (newEnregistrement) { // Si nouvel enregistrement, faire un nouvel objet.
            Personnel personne;
            if (type.equals(CtrlAdmin.TYPE_MEDECIN)) {
                personne = new Medecin();
                getDatas(personne);
                if (ctrlAdmin.addMedecin((Medecin)personne)) {
                    JOptionPane.showMessageDialog(null, "Physician saved");
                    ctrlAdmin.hideVueModifPersonnel();
                } else {
                    JOptionPane.showMessageDialog(null, "Physician not saved");
                }
            } else if (type.equals(CtrlAdmin.TYPE_INFIRMIERE)) {
                personne = new Infirmiere();
                getDatas(personne);
                ctrlAdmin.saveInfirmiere((Infirmiere)personne);
            } else {
                personne = new Secretaire();
                getDatas(personne);
                ctrlAdmin.saveSecretaire((Secretaire)personne);
            }
        } else { // Si pas nouvel enregistrement, renvoyer l'objet déjà créé avec les nouvelles valeurs
            getDatas(this.personne);
            ctrlAdmin.addPersonnel(this.personne);
        }
        
    }//GEN-LAST:event_btSaveActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        ctrlAdmin.hideVueModifPersonnel();
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
            java.util.logging.Logger.getLogger(VueAdminModifPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VueAdminModifPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VueAdminModifPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VueAdminModifPersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VueAdminModifPersonnel().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btSave;
    private javax.swing.JComboBox cbCp;
    private javax.swing.JComboBox cbSexe;
    private com.toedter.calendar.JDateChooser dpDateNaissance;
    private com.toedter.calendar.JDateChooser dpDebutTravail;
    private javax.swing.JLabel lbAdresse;
    private javax.swing.JLabel lbBeginWork;
    private javax.swing.JLabel lbCp;
    private javax.swing.JLabel lbDateNaissance;
    private javax.swing.JLabel lbDetailPersonne;
    private javax.swing.JLabel lbNom;
    private javax.swing.JLabel lbNumeroNational;
    private javax.swing.JLabel lbPrenom;
    private javax.swing.JLabel lbSexe;
    private javax.swing.JLabel lbTel;
    private javax.swing.JLabel lbTitre;
    private javax.swing.JTextField ztAdresse;
    private javax.swing.JFormattedTextField ztNom;
    private javax.swing.JFormattedTextField ztNumeroNational;
    private javax.swing.JFormattedTextField ztPrenom;
    private javax.swing.JFormattedTextField ztTel;
    // End of variables declaration//GEN-END:variables
    // Autres attributs
    private final Date dateDefaut = new Date("01/01/1980");
    private String type;
    private boolean newEnregistrement = false;

    @Override
    public void update() {
        
    }
    
    public Personnel getPersonne() { return personne; }
    
    public void setPersonne(String type, Personnel personne) {
        this.personne = personne;
        this.type = type;
        
        if (personne == null) {
            newEnregistrement = true;
            emptyFields();
        } else {
            newEnregistrement = false;
            fillFields();
        }
    }

    private void fillFields() {
        cbSexe.setSelectedItem(Sexe.HOMME);
        dpDateNaissance.setDate(personne.getDateNaissance());
        dpDebutTravail.setDate(personne.getDebutTravail());
        lbTitre.setText(personne.getPrenom() + " " + personne.getNom());
        ztAdresse.setText(personne.getAdresse().getAdresse());
        cbCp.setSelectedItem(personne.getAdresse().getCp());
        ztNom.setText(personne.getNom());
        ztNumeroNational.setText(personne.getRegistreNat());
        ztPrenom.setText(personne.getPrenom());
        ztTel.setText(personne.getTel());
    }

    private void emptyFields() {
        cbSexe.setSelectedIndex(0);
        dpDateNaissance.setDate(dateDefaut);
        dpDebutTravail.setDate(new Date());
        lbTitre.setText("New " + type);
        ztAdresse.setText("");
        cbCp.setSelectedIndex(0);
        ztNom.setText("");
        ztNumeroNational.setText("");
        ztPrenom.setText("");
        ztTel.setText("");
    }

    private void getDatas(Personnel personne) {
        personne.setAdresse(new Adresse(ztAdresse.getText(),(Cp)cbCp.getSelectedItem()));
        
    }
    
    private boolean ctrlFields() {
        if (ztAdresse.getText().isEmpty() ||
                ztNom.getText().isEmpty() ||
                ztPrenom.getText().isEmpty() ||
                ztNumeroNational.getText().isEmpty() ||
                ztTel.getText().isEmpty() ||
                true ||
                true ) {
            return true;
        } else {
            return false;
        }
    }
}
