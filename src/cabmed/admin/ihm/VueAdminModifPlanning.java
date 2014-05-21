package cabmed.admin.ihm;

import cabmed.admin.ctrl.CtrlAdmin;
import cabmed.model.Disponibilite;
import cabmed.model.Jour;
import cabmed.model.Medecin;
import cabmed.model.Tranche;
import cabmed.ressources.Observer;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VueAdminModifPlanning extends javax.swing.JFrame implements Observer {

    private Medecin medecin;
    private List<Tranche> listTranche;
    private CtrlAdmin ctrl;
    private Disponibilite lundi, mardi, mercredi, jeudi, vendredi, samedi;
    
    public VueAdminModifPlanning() {
        enteteTable = new Vector();
        enteteTable.add("");
        enteteTable.addAll(Arrays.asList(Jour.values()));
        lundi = new Disponibilite(Tranche.H0900, Tranche.H1500);
        mardi = new Disponibilite(Tranche.H0900, Tranche.H1800);
        mercredi = new Disponibilite(Tranche.H0900, Tranche.H1200);
        jeudi = new Disponibilite(Tranche.H0900, Tranche.H1200);
        vendredi = new Disponibilite(Tranche.H0900, Tranche.H1200);
        samedi = new Disponibilite();
        //enteteTable.addAll(Arrays.asList(ctrl.getJours()));
        listTranche = Arrays.asList(Tranche.values());
        //listTranche = Arrays.asList(ctrl.getTranches());
        medecin = new Medecin();
        initComponents();
        initAttributes();
        
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        btSave = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        lbTitre = new javax.swing.JLabel();
        panelLundi = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbDebutLundi = new javax.swing.JComboBox();
        cbFinLundi = new javax.swing.JComboBox();
        panelMardi = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbDebutMardi = new javax.swing.JComboBox();
        cbFinMardi = new javax.swing.JComboBox();
        panelMercredi = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbDebutMercredi = new javax.swing.JComboBox();
        cbFinMercredi = new javax.swing.JComboBox();
        panelJeudi = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbDebutJeudi = new javax.swing.JComboBox();
        cbFinJeudi = new javax.swing.JComboBox();
        panelVendredi = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cbDebutVendredi = new javax.swing.JComboBox();
        cbFinVendredi = new javax.swing.JComboBox();
        panelSamedi = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbDebutSamedi = new javax.swing.JComboBox();
        cbFinSamedi = new javax.swing.JComboBox();
        checkLundi = new javax.swing.JCheckBox();
        checkMardi = new javax.swing.JCheckBox();
        checkMercredi = new javax.swing.JCheckBox();
        checkJeudi = new javax.swing.JCheckBox();
        checkVendredi = new javax.swing.JCheckBox();
        checkSamedi = new javax.swing.JCheckBox();

        setTitle("Cabmed - Gestion planning");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

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

        lbTitre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTitre.setText("Didier VO");

        panelLundi.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LUNDI");

        jLabel7.setText("Heure de début");

        jLabel13.setText("Heure de fin:");

        javax.swing.GroupLayout panelLundiLayout = new javax.swing.GroupLayout(panelLundi);
        panelLundi.setLayout(panelLundiLayout);
        panelLundiLayout.setHorizontalGroup(
            panelLundiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLundiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLundiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbDebutLundi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbFinLundi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelLundiLayout.setVerticalGroup(
            panelLundiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLundiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(cbDebutLundi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(cbFinLundi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        panelMardi.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MARDI");

        jLabel8.setText("Heure de début");

        jLabel14.setText("Heure de fin:");

        javax.swing.GroupLayout panelMardiLayout = new javax.swing.GroupLayout(panelMardi);
        panelMardi.setLayout(panelMardiLayout);
        panelMardiLayout.setHorizontalGroup(
            panelMardiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMardiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMardiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbDebutMardi, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbFinMardi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMardiLayout.setVerticalGroup(
            panelMardiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMardiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(cbDebutMardi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(cbFinMardi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        panelMercredi.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MERCREDI");

        jLabel9.setText("Heure de début");

        jLabel15.setText("Heure de fin:");

        javax.swing.GroupLayout panelMercrediLayout = new javax.swing.GroupLayout(panelMercredi);
        panelMercredi.setLayout(panelMercrediLayout);
        panelMercrediLayout.setHorizontalGroup(
            panelMercrediLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMercrediLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMercrediLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(cbDebutMercredi, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbFinMercredi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMercrediLayout.setVerticalGroup(
            panelMercrediLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMercrediLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(cbDebutMercredi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(cbFinMercredi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        panelJeudi.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("JEUDI");

        jLabel10.setText("Heure de début");

        jLabel16.setText("Heure de fin:");

        javax.swing.GroupLayout panelJeudiLayout = new javax.swing.GroupLayout(panelJeudi);
        panelJeudi.setLayout(panelJeudiLayout);
        panelJeudiLayout.setHorizontalGroup(
            panelJeudiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJeudiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelJeudiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(cbDebutJeudi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbFinJeudi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelJeudiLayout.setVerticalGroup(
            panelJeudiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJeudiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(cbDebutJeudi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(cbFinJeudi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        panelVendredi.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("VENDREDI");

        jLabel11.setText("Heure de début");

        jLabel17.setText("Heure de fin:");

        javax.swing.GroupLayout panelVendrediLayout = new javax.swing.GroupLayout(panelVendredi);
        panelVendredi.setLayout(panelVendrediLayout);
        panelVendrediLayout.setHorizontalGroup(
            panelVendrediLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVendrediLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelVendrediLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(cbDebutVendredi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbFinVendredi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelVendrediLayout.setVerticalGroup(
            panelVendrediLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVendrediLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(cbDebutVendredi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(cbFinVendredi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        panelSamedi.setBackground(new java.awt.Color(204, 204, 204));
        panelSamedi.setPreferredSize(new java.awt.Dimension(147, 370));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("SAMEDI");

        jLabel12.setText("Heure de début");

        jLabel18.setText("Heure de fin:");

        javax.swing.GroupLayout panelSamediLayout = new javax.swing.GroupLayout(panelSamedi);
        panelSamedi.setLayout(panelSamediLayout);
        panelSamediLayout.setHorizontalGroup(
            panelSamediLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSamediLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSamediLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(cbDebutSamedi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbFinSamedi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelSamediLayout.setVerticalGroup(
            panelSamediLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSamediLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(cbDebutSamedi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(cbFinSamedi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        checkLundi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkLundiMouseClicked(evt);
            }
        });

        checkMardi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkMardiMouseClicked(evt);
            }
        });

        checkMercredi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkMercrediMouseClicked(evt);
            }
        });

        checkJeudi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkJeudiMouseClicked(evt);
            }
        });

        checkVendredi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkVendrediMouseClicked(evt);
            }
        });

        checkSamedi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkSamediMouseClicked(evt);
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
                        .addGap(63, 63, 63)
                        .addComponent(checkLundi)
                        .addGap(143, 143, 143)
                        .addComponent(checkMardi)
                        .addGap(142, 142, 142)
                        .addComponent(checkMercredi)
                        .addGap(146, 146, 146)
                        .addComponent(checkJeudi)
                        .addGap(142, 142, 142)
                        .addComponent(checkVendredi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkSamedi)
                        .addGap(64, 64, 64))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelLundi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panelMardi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panelMercredi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panelJeudi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panelVendredi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panelSamedi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(checkLundi)
                    .addComponent(checkMardi)
                    .addComponent(checkMercredi)
                    .addComponent(checkJeudi)
                    .addComponent(checkVendredi)
                    .addComponent(checkSamedi))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelJeudi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelMercredi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelMardi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelLundi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelSamedi, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addComponent(panelVendredi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }//GEN-END:initComponents

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        
    }//GEN-LAST:event_btSaveActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        ctrl.hideVueModifPlanning();
    }//GEN-LAST:event_btCancelActionPerformed

    private void checkLundiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkLundiMouseClicked
        if (checkLundi.isSelected()) {
            cbDebutLundi.setEnabled(true);
            cbFinLundi.setEnabled(true);
        } else {
            cbDebutLundi.setEnabled(false);
            cbFinLundi.setEnabled(false);
        }
    }//GEN-LAST:event_checkLundiMouseClicked

    private void checkMardiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkMardiMouseClicked
        if (checkMardi.isSelected()) {
            cbDebutMardi.setEnabled(true);
            cbFinMardi.setEnabled(true);
        } else {
            cbDebutMardi.setEnabled(false);
            cbFinMardi.setEnabled(false);
        }
    }//GEN-LAST:event_checkMardiMouseClicked

    private void checkMercrediMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkMercrediMouseClicked
        if (checkMercredi.isSelected()) {
            cbDebutMercredi.setEnabled(true);
            cbFinMercredi.setEnabled(true);
        } else {
            cbDebutMercredi.setEnabled(false);
            cbFinMercredi.setEnabled(false);
        }
    }//GEN-LAST:event_checkMercrediMouseClicked

    private void checkJeudiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkJeudiMouseClicked
        if (checkJeudi.isSelected()) {
            cbDebutJeudi.setEnabled(true);
            cbFinJeudi.setEnabled(true);
        } else {
            cbDebutJeudi.setEnabled(false);
            cbFinJeudi.setEnabled(false);
        }
    }//GEN-LAST:event_checkJeudiMouseClicked

    private void checkVendrediMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkVendrediMouseClicked
        if (checkVendredi.isSelected()) {
            cbDebutVendredi.setEnabled(true);
            cbFinVendredi.setEnabled(true);
        } else {
            cbDebutVendredi.setEnabled(false);
            cbFinVendredi.setEnabled(false);
        }
    }//GEN-LAST:event_checkVendrediMouseClicked

    private void checkSamediMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkSamediMouseClicked
        if (checkSamedi.isSelected()) {
            cbDebutSamedi.setEnabled(true);
            cbFinSamedi.setEnabled(true);
        } else {
            cbDebutSamedi.setEnabled(false);
            cbFinSamedi.setEnabled(false);
        }
    }//GEN-LAST:event_checkSamediMouseClicked

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
            java.util.logging.Logger.getLogger(VueAdminModifPlanning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VueAdminModifPlanning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VueAdminModifPlanning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VueAdminModifPlanning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VueAdminModifPlanning().setVisible(true);
            }
        });
    }

    public void showView(Medecin medecin) {
        this.medecin = medecin;
        update();
        setVisible(true);
    }

    private void initAttributes() {
        cbDebutLundi.addItem(lundi.getHeureDebut());
        cbFinLundi.addItem(lundi.getHeureFin());
        cbDebutMardi.addItem(mardi.getHeureDebut());
        cbFinMardi.addItem(mardi.getHeureFin());
        cbDebutMercredi.addItem(mercredi.getHeureDebut());
        cbFinMercredi.addItem(mercredi.getHeureFin());
        cbDebutJeudi.addItem(jeudi.getHeureDebut());
        cbFinJeudi.addItem(jeudi.getHeureFin());
        cbDebutVendredi.addItem(vendredi.getHeureDebut());
        cbFinVendredi.addItem(vendredi.getHeureFin());
        cbDebutSamedi.addItem(samedi.getHeureDebut());
        cbFinSamedi.addItem(samedi.getHeureFin());
    }

    // ***************************** ModeleJTable *****************************
    public class ModeleTablePlanning extends DefaultTableModel implements Observer {
        
        public static final int ROW_COUNT = 40;
        
        public ModeleTablePlanning() {
            super(enteteTable, listTranche.size());
        }

        @Override public int getRowCount() { return listTranche.size(); }
        @Override public int getColumnCount() { return 7; }
        
        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 0) return false;
            else return true;
        }
        
        @Override
        public Class getColumnClass(int col) {
            if (col == 0) {
                return String.class;
            } else {
                return Boolean.class;
            }
        }
        
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) { // Si la première colonne
                if (rowIndex == (getRowCount()-1)) { // Si la dernière ligne
                    return listTranche.get(rowIndex).getLabel() + " - 19h00";
                } else { // Si autres lignes
                    return listTranche.get(rowIndex).getLabel() + 
                            " - " + listTranche.get(rowIndex+1).getLabel();
                }
            } else {
                return true;
            }
        }
        
        @Override
        public void update() {
            fireTableDataChanged();
        }
    }
    // *************************** Fin ModeleJTable ***************************
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btSave;
    private javax.swing.JComboBox cbDebutJeudi;
    private javax.swing.JComboBox cbDebutLundi;
    private javax.swing.JComboBox cbDebutMardi;
    private javax.swing.JComboBox cbDebutMercredi;
    private javax.swing.JComboBox cbDebutSamedi;
    private javax.swing.JComboBox cbDebutVendredi;
    private javax.swing.JComboBox cbFinJeudi;
    private javax.swing.JComboBox cbFinLundi;
    private javax.swing.JComboBox cbFinMardi;
    private javax.swing.JComboBox cbFinMercredi;
    private javax.swing.JComboBox cbFinSamedi;
    private javax.swing.JComboBox cbFinVendredi;
    private javax.swing.JCheckBox checkJeudi;
    private javax.swing.JCheckBox checkLundi;
    private javax.swing.JCheckBox checkMardi;
    private javax.swing.JCheckBox checkMercredi;
    private javax.swing.JCheckBox checkSamedi;
    private javax.swing.JCheckBox checkVendredi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbTitre;
    private javax.swing.JPanel panelJeudi;
    private javax.swing.JPanel panelLundi;
    private javax.swing.JPanel panelMardi;
    private javax.swing.JPanel panelMercredi;
    private javax.swing.JPanel panelSamedi;
    private javax.swing.JPanel panelVendredi;
    // End of variables declaration//GEN-END:variables
    
    private Vector enteteTable;
    
    @Override
    public void update() {
        medecin = new Medecin();
        lbTitre.setText("Mise à jour planning");
        //lbTitre.setText(medecin.getPrenom()+ " " + medecin.getNom());
        
    }

}
