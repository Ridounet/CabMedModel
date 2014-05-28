package cabmed.manage.ihm.medecin;

import cabmed.manage.ctrl.CtrlMedecin;
import cabmed.model.Rdv;
import javax.swing.JOptionPane;
import cabmed.model.Patient;
import cabmed.model.Medecin;
import cabmed.model.StatutRdv;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VueDossierPatient extends javax.swing.JFrame implements cabmed.ressources.Observer {
    
    private CtrlMedecin ctrl;
    private Patient patient;
    private Medecin medecin;
    private Rdv rdv;
    private List<Rdv> listRdvAnciens;
    
    private static final int ID = 0;
    private static final int MEDECIN = 1;
    private static final int SPECIALISATION = 2;
    private static final int DATE = 3;
    private static final int HEURE = 4;
    
    public VueDossierPatient() {
        initComponents();
        ztGeneralite.setText("Ce patient ne souffre d'aucun mal");
        ztMutualite.setText("Partenamut");
        ztNom.setText("Amar Ouaali");
        ztNumSecuriteSocial.setText("12450352101");
        ztPrenom.setText("Riduan");
        ztRegistreNat.setText("900329-435-25");
        ztSexe.setText("HOMME");
    }

    public VueDossierPatient(CtrlMedecin ctrlMedecin) {
        this.ctrl = ctrlMedecin;
        listRdvAnciens = new ArrayList<>();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ztGeneralite = new javax.swing.JTextArea();
        scrollTableEnCours1 = new javax.swing.JScrollPane();
        tableRdvAncien = new javax.swing.JTable();
        btCloseRdv = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbTitre = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ztNom = new javax.swing.JTextField();
        ztPrenom = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ztSexe = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ztMutualite = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ztNumSecuriteSocial = new javax.swing.JTextField();
        ztRegistreNat = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cabmed - Dossier patient");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Généralités");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Anciens rendez-vous");

        ztGeneralite.setColumns(20);
        ztGeneralite.setRows(5);
        jScrollPane2.setViewportView(ztGeneralite);

        tableRdvAncien.setModel(new ModeleJTable());
        tableRdvAncien.getTableHeader().setReorderingAllowed(false);
        tableRdvAncien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRdvAncienMouseClicked(evt);
            }
        });
        scrollTableEnCours1.setViewportView(tableRdvAncien);

        btCloseRdv.setText("Clôturer le rendez-vous");
        btCloseRdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseRdvActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Double-cliquez sur un rendez-vous pour voir les détails");

        lbTitre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbTitre.setText("Info patient");

        jLabel4.setText("Nom");

        jLabel5.setText("Prénom");

        ztNom.setEnabled(false);

        ztPrenom.setEnabled(false);

        jLabel6.setText("Sexe");

        ztSexe.setEnabled(false);

        jLabel7.setText("Mutualité");

        ztMutualite.setEnabled(false);

        jLabel8.setText("Num. sécurité sociale");

        jLabel9.setText("Num. registre nationale");

        ztNumSecuriteSocial.setEnabled(false);

        ztRegistreNat.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTableEnCours1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btCloseRdv, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                                        .addGap(82, 82, 82))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ztNom, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ztSexe, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ztPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ztMutualite, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ztRegistreNat, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ztNumSecuriteSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ztNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(ztMutualite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ztPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(ztNumSecuriteSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ztSexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(ztRegistreNat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTableEnCours1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btCloseRdv, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }//GEN-END:initComponents

    private void btCloseRdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseRdvActionPerformed
        rdv.getPatient().setRemarques(ztGeneralite.getText());
        ctrl.fermerDossier(rdv);
    }//GEN-LAST:event_btCloseRdvActionPerformed

    private void tableRdvAncienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRdvAncienMouseClicked
        if (evt.getClickCount() == 2) {
            Rdv rdv = listRdvAnciens.get(tableRdvAncien.getSelectedRow());
            ctrl.showVueRdv(rdv);
        }
    }//GEN-LAST:event_tableRdvAncienMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCloseRdv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbTitre;
    private javax.swing.JScrollPane scrollTableEnCours1;
    private javax.swing.JTable tableRdvAncien;
    private javax.swing.JTextArea ztGeneralite;
    private javax.swing.JTextField ztMutualite;
    private javax.swing.JTextField ztNom;
    private javax.swing.JTextField ztNumSecuriteSocial;
    private javax.swing.JTextField ztPrenom;
    private javax.swing.JTextField ztRegistreNat;
    private javax.swing.JTextField ztSexe;
    // End of variables declaration//GEN-END:variables

    
    public void showView(Rdv rendezVous) {
        this.rdv = rendezVous;
        this.patient = rdv.getPatient();
        this.medecin = rdv.getMedecin();
        ctrl.getRdvPatient(patient);
        
        // Remplissage des TextField
        ztMutualite.setText(patient.getMutualite().getNom());
        ztNom.setText(patient.getNom());
        ztPrenom.setText(patient.getPrenom());
        ztNumSecuriteSocial.setText(patient.getNumSecuSocial());
        ztRegistreNat.setText(patient.getRegistreNat());
        ztSexe.setText(patient.getSexe().toString());
        ztGeneralite.setText(patient.getRemarques());
        
        // Préparation pour la JTable
        listRdvAnciens = new ArrayList<>(); // Nouvelle liste
        for (Rdv r : patient.getRdv()) { // Remplissage de la liste d'abord
            if (r.getStatut() == StatutRdv.CLOTURE) {
                listRdvAnciens.add(r);
            }
        }
        
        update();
        setVisible(true);
    }
    
    @Override
    public void update() {
        ((DefaultTableModel)tableRdvAncien.getModel()).fireTableDataChanged();
    }
    
    public class ModeleJTable extends DefaultTableModel {

        @Override
        public boolean isCellEditable(int row, int column) { return false; }
        @Override
        public int getColumnCount() { return 5; }
        @Override
        public int getRowCount() { return listRdvAnciens.size(); }

        @Override
        public String getColumnName(int column) {
            switch(column) {
                case ID : return "ID";
                case MEDECIN : return "Médecin";
                case SPECIALISATION : return "Spécialisation";
                case DATE : return "Date";
                case HEURE : return "Heure";
                default: return "NO DATA";
            }
        }

        @Override
        public Object getValueAt(int row, int column) {
            switch(column) {
                case ID : return listRdvAnciens.get(row).getId();
                case MEDECIN : return listRdvAnciens.get(row).getMedecin();
                case SPECIALISATION : return listRdvAnciens.get(row).getTypeRdv().getLabel();
                case DATE : return ctrl.getSdf().format(listRdvAnciens.get(row).getDateRdv());
                case HEURE : return listRdvAnciens.get(row).getHeure().getLabel();
                default: return "NO DATA";
            }
        }
    }
    
}