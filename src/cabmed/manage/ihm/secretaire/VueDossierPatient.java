package cabmed.manage.ihm.secretaire;

import cabmed.manage.ctrl.CtrlSecretaire;
import cabmed.model.Medecin;
import cabmed.model.Patient;
import cabmed.model.Rdv;
import cabmed.model.Specialisation;
import cabmed.model.StatutRdv;
import cabmed.model.Tranche;
import cabmed.ressources.Observer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class VueDossierPatient extends JFrame implements Observer {

    private CtrlSecretaire ctrl;
    private Patient patient;
    private List<Rdv> listRdvActuels;
    private List<Rdv> listRdvAnciens;
    private List<Medecin> listMedecin;
    private List<Specialisation> listSpecialisation;
    
    
    private static final int ID = 0;
    private static final int MEDECIN = 1;
    private static final int SPECIALISATION = 2;
    private static final int DATE = 3;
    private static final int HEURE = 4;
    private static final int STATUT = 5;

    public VueDossierPatient(CtrlSecretaire ctrlSecretaire) {
        this.ctrl = ctrlSecretaire;
        listRdvActuels = new ArrayList<>();
        listRdvAnciens = new ArrayList<>();
        listMedecin = ctrl.getListMedecin();
        listSpecialisation = ctrl.getListSpecialisation();
        initComponents();
        initAttributes();
        
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        paneGeneral = new javax.swing.JTabbedPane();
        paneRdvEnCours = new javax.swing.JPanel();
        scrollTableEnCours = new javax.swing.JScrollPane();
        tableRdvEnCours = new javax.swing.JTable();
        btModifEnCours = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        btClotureActuel = new javax.swing.JButton();
        paneRdvPasses = new javax.swing.JPanel();
        scrollTableEnCours1 = new javax.swing.JScrollPane();
        tableRdvAncien = new javax.swing.JTable();
        btClotureAncien = new javax.swing.JButton();
        paneRdvNouveau = new javax.swing.JPanel();
        lbTitre = new javax.swing.JLabel();
        btAddRdv = new javax.swing.JButton();
        btEffaceChamps = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbMedecin = new javax.swing.JLabel();
        cbMedecin = new javax.swing.JComboBox();
        lbSpecialisation = new javax.swing.JLabel();
        cbSpecialisation = new javax.swing.JComboBox();
        lbDate = new javax.swing.JLabel();
        dpDate = new com.toedter.calendar.JDateChooser();
        lbHeure = new javax.swing.JLabel();
        cbTranche = new javax.swing.JComboBox();
        btClotureNouveau = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cabmed - Historique patient");
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        setResizable(false);

        tableRdvEnCours.setModel(new ModeleRdvEnCours());
        tableRdvEnCours.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableRdvEnCours.getTableHeader().setReorderingAllowed(false);
        scrollTableEnCours.setViewportView(tableRdvEnCours);

        btModifEnCours.setText("Modification");
        btModifEnCours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModifEnCoursActionPerformed(evt);
            }
        });

        btCancel.setBackground(new java.awt.Color(255, 0, 0));
        btCancel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btCancel.setForeground(new java.awt.Color(255, 255, 255));
        btCancel.setText("ANNULER");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        btClotureActuel.setText("Clôturer");
        btClotureActuel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClotureActuelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneRdvEnCoursLayout = new javax.swing.GroupLayout(paneRdvEnCours);
        paneRdvEnCours.setLayout(paneRdvEnCoursLayout);
        paneRdvEnCoursLayout.setHorizontalGroup(
            paneRdvEnCoursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneRdvEnCoursLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneRdvEnCoursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTableEnCours, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                    .addGroup(paneRdvEnCoursLayout.createSequentialGroup()
                        .addComponent(btModifEnCours, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(paneRdvEnCoursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneRdvEnCoursLayout.createSequentialGroup()
                    .addContainerGap(520, Short.MAX_VALUE)
                    .addComponent(btClotureActuel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        paneRdvEnCoursLayout.setVerticalGroup(
            paneRdvEnCoursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneRdvEnCoursLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTableEnCours, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(paneRdvEnCoursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btModifEnCours, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(btCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(67, Short.MAX_VALUE))
            .addGroup(paneRdvEnCoursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneRdvEnCoursLayout.createSequentialGroup()
                    .addContainerGap(282, Short.MAX_VALUE)
                    .addComponent(btClotureActuel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        paneGeneral.addTab("Rendez-vous actuels", paneRdvEnCours);

        tableRdvAncien.setModel(new ModeleRdvAncien());
        tableRdvAncien.getTableHeader().setReorderingAllowed(false);
        scrollTableEnCours1.setViewportView(tableRdvAncien);

        btClotureAncien.setText("Clôturer");
        btClotureAncien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClotureAncienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneRdvPassesLayout = new javax.swing.GroupLayout(paneRdvPasses);
        paneRdvPasses.setLayout(paneRdvPassesLayout);
        paneRdvPassesLayout.setHorizontalGroup(
            paneRdvPassesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneRdvPassesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneRdvPassesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTableEnCours1, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneRdvPassesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btClotureAncien, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        paneRdvPassesLayout.setVerticalGroup(
            paneRdvPassesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneRdvPassesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTableEnCours1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btClotureAncien, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        paneGeneral.addTab("Rendez-vous anciens", paneRdvPasses);

        lbTitre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTitre.setText("Ajout d'un rendez-vous:");

        btAddRdv.setText("Ajouter");
        btAddRdv.setPreferredSize(new java.awt.Dimension(58, 23));
        btAddRdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddRdvActionPerformed(evt);
            }
        });

        btEffaceChamps.setText("Annuler");
        btEffaceChamps.setPreferredSize(new java.awt.Dimension(58, 23));
        btEffaceChamps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEffaceChampsActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbMedecin.setText("Médecin");

        cbMedecin.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMedecinItemStateChanged(evt);
            }
        });

        lbSpecialisation.setText("Spécialisation");

        cbSpecialisation.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSpecialisationItemStateChanged(evt);
            }
        });

        lbDate.setText("Date");

        dpDate.setEnabled(false);
        dpDate.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                dpDateInputMethodTextChanged(evt);
            }
        });

        lbHeure.setText("Heure");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMedecin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbMedecin, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbSpecialisation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbSpecialisation, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dpDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                    .addComponent(lbHeure, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbTranche, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbMedecin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbMedecin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbSpecialisation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbSpecialisation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dpDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbHeure)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTranche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        btClotureNouveau.setText("Clôturer");
        btClotureNouveau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClotureNouveauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneRdvNouveauLayout = new javax.swing.GroupLayout(paneRdvNouveau);
        paneRdvNouveau.setLayout(paneRdvNouveauLayout);
        paneRdvNouveauLayout.setHorizontalGroup(
            paneRdvNouveauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneRdvNouveauLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneRdvNouveauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(paneRdvNouveauLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(paneRdvNouveauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAddRdv, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btEffaceChamps, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btClotureNouveau, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        paneRdvNouveauLayout.setVerticalGroup(
            paneRdvNouveauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneRdvNouveauLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneRdvNouveauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneRdvNouveauLayout.createSequentialGroup()
                        .addComponent(btAddRdv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEffaceChamps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(paneRdvNouveauLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneRdvNouveauLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btClotureNouveau, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        paneGeneral.addTab("Nouveau rendez-vous", paneRdvNouveau);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneGeneral)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneGeneral)
                .addContainerGap())
        );

        pack();
    }//GEN-END:initComponents

    private void btClotureNouveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClotureNouveauActionPerformed
        cloturer();
    }//GEN-LAST:event_btClotureNouveauActionPerformed

    private void btEffaceChampsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEffaceChampsActionPerformed
        viderChamps();
    }//GEN-LAST:event_btEffaceChampsActionPerformed

    
    
    
    
    
    
    private void btAddRdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddRdvActionPerformed
        if (cbMedecin.getSelectedIndex() == 0 ||
                cbSpecialisation.getSelectedIndex() == 0 ||
                cbTranche.getSelectedIndex() == 0 ||
                dpDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs!", "Champs manquants!", JOptionPane.WARNING_MESSAGE);
        } else {
            Rdv rdv = new Rdv();
            rdv.setMedecin((Medecin)cbMedecin.getSelectedItem());
            rdv.setTypeRdv((Specialisation)cbSpecialisation.getSelectedItem());
            rdv.setDateRdv(dpDate.getDate());
            rdv.setHeure((Tranche)cbTranche.getSelectedItem());
            rdv.setPatient(patient);
            rdv.setStatut(StatutRdv.EN_COURS);
            if (ctrl.updateRdv(rdv)) {
                JOptionPane.showMessageDialog(this, "Rendez-vous sauvegardé!", 
                        "Sauvegardé", JOptionPane.INFORMATION_MESSAGE);
                viderChamps();
            }
        }
    }//GEN-LAST:event_btAddRdvActionPerformed

    
    
    
    
    
    
    
    
    private void btModifEnCoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModifEnCoursActionPerformed
        if (tableRdvEnCours.getSelectedRowCount() != 1) {
            JOptionPane.showMessageDialog(this, "Veuillez choisir un et un seul rendez-vous!", "Erreur!", JOptionPane.WARNING_MESSAGE);
        } else {
            Rdv rdv = (Rdv) listRdvActuels.get(tableRdvEnCours.getSelectedRow());
            ctrl.showVueModifRdv(rdv);
        }
    }//GEN-LAST:event_btModifEnCoursActionPerformed

    private void btClotureAncienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClotureAncienActionPerformed
        cloturer();
    }//GEN-LAST:event_btClotureAncienActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        if (tableRdvEnCours.getSelectedRowCount() != 1) {
            JOptionPane.showMessageDialog(this, "Veuillez choisir un et un seul rendez-vous!", "Erreur!", JOptionPane.WARNING_MESSAGE);
        } else {
            int i = JOptionPane.showConfirmDialog(this, "Êtes-vous sûr de vouloir annuler ce rendez-vous",
                    "Confirmation?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (i == 0) {
                Rdv rdv = (Rdv) listRdvActuels.get(tableRdvEnCours.getSelectedRow());
                rdv.setStatut(StatutRdv.ANNULE);
                ctrl.updateRdv(rdv);
            }
        }
    }//GEN-LAST:event_btCancelActionPerformed

    private void btClotureActuelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClotureActuelActionPerformed
        cloturer();
    }//GEN-LAST:event_btClotureActuelActionPerformed

    
    
    
    
    
    private void cbMedecinItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMedecinItemStateChanged
        if (cbMedecin.getSelectedIndex() == 0) {
            cbSpecialisation.removeAllItems();
            cbSpecialisation.enable(false);
            dpDate.enable(false);
            cbTranche.removeAllItems();
            cbTranche.enable(false);
        } else {
            cbSpecialisation.removeAllItems();
            cbSpecialisation.addItem("");
            for (Specialisation s : ((Medecin)cbMedecin.getSelectedItem()).getSpecialisation()) {
                cbSpecialisation.addItem(s);
            }
            cbSpecialisation.enable(true);
        }
    }//GEN-LAST:event_cbMedecinItemStateChanged

    private void cbSpecialisationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSpecialisationItemStateChanged
        if (cbSpecialisation.getSelectedIndex() == 0) {
            dpDate.enable(false);
            cbTranche.removeAllItems();
            cbTranche.enable(false);
        } else {
            dpDate.enable(true);
        }
    }//GEN-LAST:event_cbSpecialisationItemStateChanged

    private void dpDateInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_dpDateInputMethodTextChanged
        if (dpDate.getDate() == null) {
            cbTranche.removeAllItems();
            cbTranche.enable(false);
        } else {
            List<Tranche> listTranche = new ArrayList<>();
            Date date = dpDate.getDate();
            Map<Tranche,Rdv> horaire = ((Medecin)cbMedecin.getSelectedItem()).getPlanning().getHoraire().get(date).getOccupation();
            //Horaire horaire = ((Medecin)cbMedecin.getSelectedItem()).getPlanning().getHoraire().get(date);
            for (Tranche t : horaire.keySet()) {
                if (horaire.get(t) == null) {
                    listTranche.add(t);
                }
            }
            
            cbTranche.removeAllItems();
            cbTranche.addItem("");
            for (Tranche t : listTranche) {
                cbTranche.addItem(t);
            }
            cbTranche.enable(true);
        }
    }//GEN-LAST:event_dpDateInputMethodTextChanged

    private void cloturer() {
        setVisible(false);
        ctrl.showVuePrincipale();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddRdv;
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btClotureActuel;
    private javax.swing.JButton btClotureAncien;
    private javax.swing.JButton btClotureNouveau;
    private javax.swing.JButton btEffaceChamps;
    private javax.swing.JButton btModifEnCours;
    private javax.swing.JComboBox cbMedecin;
    private javax.swing.JComboBox cbSpecialisation;
    private javax.swing.JComboBox cbTranche;
    private com.toedter.calendar.JDateChooser dpDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbHeure;
    private javax.swing.JLabel lbMedecin;
    private javax.swing.JLabel lbSpecialisation;
    private javax.swing.JLabel lbTitre;
    private javax.swing.JTabbedPane paneGeneral;
    private javax.swing.JPanel paneRdvEnCours;
    private javax.swing.JPanel paneRdvNouveau;
    private javax.swing.JPanel paneRdvPasses;
    private javax.swing.JScrollPane scrollTableEnCours;
    private javax.swing.JScrollPane scrollTableEnCours1;
    private javax.swing.JTable tableRdvAncien;
    private javax.swing.JTable tableRdvEnCours;
    // End of variables declaration//GEN-END:variables

    private void viderChamps() {
        cbMedecin.setSelectedIndex(0);
        cbSpecialisation.setSelectedIndex(0);
        cbTranche.setSelectedIndex(0);
    }

    private void initAttributes() {
        cbMedecin.addItem("");
        for (Medecin m : listMedecin) {
            cbMedecin.addItem(m);
        }
        
        cbSpecialisation.addItem("");
        for (Specialisation s : listSpecialisation) {
            cbSpecialisation.addItem(s);
        }
        
        cbTranche.addItem("");
        for (Tranche t : Tranche.values()) {
            cbTranche.addItem(t);
        }
        
        dpDate.setDate(new Date());
    }

    @Override
    public void update() {
        ctrl.getRdvPatient(patient);
        initListRdv();
        ((DefaultTableModel)tableRdvAncien.getModel()).fireTableDataChanged();
        ((DefaultTableModel)tableRdvEnCours.getModel()).fireTableDataChanged();
    }

    public void showView(Patient pat) {
        patient = pat;
        ctrl.getRdvPatient(patient);
        initListRdv();
        ((DefaultTableModel)tableRdvAncien.getModel()).fireTableDataChanged();
        ((DefaultTableModel)tableRdvEnCours.getModel()).fireTableDataChanged();
        cbMedecin.setSelectedIndex(0);
        cbSpecialisation.setSelectedIndex(0);
        cbTranche.setSelectedIndex(0);
        dpDate.setDate(new Date());
        setVisible(true);
    }
    
    private void initListRdv() {
        listRdvActuels = new ArrayList<>();
        listRdvAnciens = new ArrayList<>();
        for (Rdv rdv : patient.getRdv()) {
            if (rdv.getStatut() == StatutRdv.EN_COURS) listRdvActuels.add(rdv);
            else listRdvAnciens.add(rdv);
        }
    }
    
    private class ModeleRdvEnCours extends DefaultTableModel {

        public ModeleRdvEnCours() {
            super(new String[] {"ID", "Médecin", "Spécialisation", "Date", "Heure", "Statut"}, listRdvActuels.size());
        }
        
        @Override
        public boolean isCellEditable(int row, int column) { return false; }
        @Override
        public int getColumnCount() { return 5; }
        @Override
        public int getRowCount() { return listRdvActuels.size(); }
        
        @Override
        public Object getValueAt(int row, int column) {
            switch(column) {
                case ID: return listRdvActuels.get(row).getId();
                case MEDECIN: return listRdvActuels.get(row).getMedecin().getNom() + " " + listRdvActuels.get(row).getMedecin().getPrenom();
                case SPECIALISATION: return listRdvActuels.get(row).getTypeRdv().getLabel();
                case DATE: return ctrl.getSdf().format(listRdvActuels.get(row).getDateRdv());
                case HEURE: return listRdvActuels.get(row).getHeure().getLabel();
                default: return "NO DATA";
            }
        }

        @Override
        public String getColumnName(int column) {
            switch(column) {
                case ID: return "ID";
                case MEDECIN: return "Médecin";
                case SPECIALISATION: return "Spécialisation";
                case DATE: return "Date";
                case HEURE: return "Heure";
                default: return "NO DATA";
            }
        }
    }
    
    private class ModeleRdvAncien extends DefaultTableModel {
        
        public ModeleRdvAncien() {
            super(new String[] {"ID", "Médecin", "Spécialisation", "Date", "Heure", "Statut"}, listRdvAnciens.size());
            
        }
        
        @Override
        public boolean isCellEditable(int row, int column) { return false; }
        @Override
        public int getColumnCount() { return 6; }
        @Override
        public int getRowCount() { return listRdvAnciens.size(); }
        
        @Override
        public Object getValueAt(int row, int column) {
            
            switch(column) {
                case ID: return listRdvAnciens.get(row).getId();
                case MEDECIN: return listRdvAnciens.get(row).getMedecin().getNom() + " " + listRdvAnciens.get(row).getMedecin().getPrenom();
                case SPECIALISATION: return listRdvAnciens.get(row).getTypeRdv().getLabel();
                case DATE: return ctrl.getSdf().format(listRdvAnciens.get(row).getDateRdv());
                case HEURE: return listRdvAnciens.get(row).getHeure().getLabel();
                case STATUT: return listRdvAnciens.get(row).getStatut().getLabel();
                default: return "NO DATA";
            }
        }

        @Override
        public String getColumnName(int column) {
            switch(column) {
                case ID: return "ID";
                case MEDECIN: return "Médecin";
                case SPECIALISATION: return "Spécialisation";
                case DATE: return "Date";
                case HEURE: return "Heure";
                case STATUT: return "Statut";
                default: return "NO DATA";
            }
        }
    }
    
}