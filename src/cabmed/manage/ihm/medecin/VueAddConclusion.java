package cabmed.manage.ihm.medecin;

import cabmed.manage.ctrl.CtrlMedecin;
import cabmed.model.Prescription;
import cabmed.model.Rdv;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VueAddConclusion extends javax.swing.JFrame {

    private CtrlMedecin ctrl;
    private Rdv rdv;
    private List<Prescription> listPrescription;
    
    private static final int MEDICAMENT = 0;
    private static final int DUREE = 1;
    private static final int POSOLOGIE = 2;
    
    public VueAddConclusion() {
        initComponents();
    }

    public VueAddConclusion(CtrlMedecin ctrlMedecin) {
        this.ctrl = ctrlMedecin;
        rdv = new Rdv();
        listPrescription = new ArrayList<>();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ztRecommandation = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePrescription = new javax.swing.JTable();
        paneAddPrescription = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ztMedicament = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ztDuree = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        ztPosologie = new javax.swing.JFormattedTextField();
        btAddPrescription = new javax.swing.JButton();
        btClear = new javax.swing.JButton();
        btClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cabmed - Clôture du rendez-vous");
        setResizable(false);

        jLabel1.setText("Recommandation du médecin:");

        ztRecommandation.setColumns(20);
        ztRecommandation.setRows(5);
        jScrollPane1.setViewportView(ztRecommandation);

        jLabel2.setText("Prescription & posologie:");

        tablePrescription.setModel(new ModeleJTable());
        tablePrescription.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablePrescription);

        paneAddPrescription.setBorder(javax.swing.BorderFactory.createTitledBorder("Ajouter une prescription"));

        jLabel3.setText("Médicament:");

        jLabel4.setText("Durée (en jour):");

        jLabel5.setText("Posologie (par jour):");

        btAddPrescription.setText("Ajouter");
        btAddPrescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddPrescriptionActionPerformed(evt);
            }
        });

        btClear.setText("Effacer");
        btClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneAddPrescriptionLayout = new javax.swing.GroupLayout(paneAddPrescription);
        paneAddPrescription.setLayout(paneAddPrescriptionLayout);
        paneAddPrescriptionLayout.setHorizontalGroup(
            paneAddPrescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneAddPrescriptionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneAddPrescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ztMedicament)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ztDuree)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ztPosologie)
                    .addGroup(paneAddPrescriptionLayout.createSequentialGroup()
                        .addComponent(btAddPrescription, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btClear, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        paneAddPrescriptionLayout.setVerticalGroup(
            paneAddPrescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneAddPrescriptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ztMedicament, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ztDuree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ztPosologie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(paneAddPrescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAddPrescription, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btClear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btClose.setText("Clôturer");
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(paneAddPrescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btClose, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(paneAddPrescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btClose, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }//GEN-END:initComponents

    private void btCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseActionPerformed
        rdv.setRemarque(ztRecommandation.getText());
        rdv.setPrescriptions(listPrescription);
        ctrl.saveRdv(rdv);
    }//GEN-LAST:event_btCloseActionPerformed

    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        viderChamps();
    }//GEN-LAST:event_btClearActionPerformed

    private void btAddPrescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddPrescriptionActionPerformed
        if (ztMedicament.getText().equals("") ||
                ztDuree.getText().equals("") ||
                ztPosologie.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs pour une préscriptions!");
        } else {
            Prescription pres = new Prescription(ztMedicament.getText(), ztPosologie.getText(), Integer.parseInt(ztDuree.getText()));
            listPrescription.add(pres);
            ((DefaultTableModel)tablePrescription.getModel()).fireTableDataChanged();
            viderChamps();
        }
    }//GEN-LAST:event_btAddPrescriptionActionPerformed

    private void viderChamps() {
        ztMedicament.setText("");
        ztDuree.setText("");
        ztPosologie.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddPrescription;
    private javax.swing.JButton btClear;
    private javax.swing.JButton btClose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel paneAddPrescription;
    private javax.swing.JTable tablePrescription;
    private javax.swing.JFormattedTextField ztDuree;
    private javax.swing.JTextField ztMedicament;
    private javax.swing.JFormattedTextField ztPosologie;
    private javax.swing.JTextArea ztRecommandation;
    // End of variables declaration//GEN-END:variables

    public void showView(Rdv rendezVous) {
        this.rdv = rendezVous;
        listPrescription = new ArrayList<>();
        rdv.setPrescriptions(listPrescription);
        setVisible(true);
    }
    
    public class ModeleJTable extends DefaultTableModel {
        @Override
        public boolean isCellEditable(int row, int column) { return false; }
        @Override
        public int getColumnCount() { return 3; }
        @Override
        public int getRowCount() { return listPrescription.size(); }

        @Override
        public String getColumnName(int column) {
            switch(column) {
                case MEDICAMENT : return "Médicament";
                case DUREE : return "Durée (en jour)";
                case POSOLOGIE : return "Posologie (par jour)";
                default : return "NO DATA";
            }
        }

        @Override
        public Object getValueAt(int row, int column) {
            switch(column) {
                case MEDICAMENT : return rdv.getPrescriptions().get(row).getMedicament();
                case DUREE : return rdv.getPrescriptions().get(row).getDuree();
                case POSOLOGIE : return rdv.getPrescriptions().get(row).getPosologie();
                default: return "NO DATA";
            }
        }
    }
}