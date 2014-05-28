package cabmed.manage.ihm.medecin;

import cabmed.manage.ctrl.CtrlMedecin;
import cabmed.model.Rdv;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class VueDetailsRdv extends javax.swing.JFrame implements cabmed.ressources.Observer {

    private final CtrlMedecin ctrl;
    private Rdv rdv;
    
    private static final int MEDICAMENT = 0;
    private static final int DUREE = 1;
    private static final int POSOLOGIE = 2;
    
    public VueDetailsRdv(CtrlMedecin ctrlMedecin) {
        this.ctrl = ctrlMedecin;
        rdv = new Rdv();
        rdv.setPrescriptions(new ArrayList<>());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        btClose = new javax.swing.JButton();
        paneAddPrescription = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ztMedecin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ztSpecialisation = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        ztDate = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePrescription = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ztRecommandation = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Cabmed - Détails d'un rendez-vous");
        setResizable(false);

        btClose.setText("Fermer");
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseActionPerformed(evt);
            }
        });

        paneAddPrescription.setBorder(javax.swing.BorderFactory.createTitledBorder("Détails du rendez-vous"));

        jLabel3.setText("Médecin:");

        ztMedecin.setText("Didier VO");
        ztMedecin.setEnabled(false);

        jLabel4.setText("Spécialisation:");

        ztSpecialisation.setText("Généraliste");
        ztSpecialisation.setEnabled(false);

        jLabel5.setText("Date:");

        ztDate.setText("07/05/2014");
        ztDate.setEnabled(false);

        javax.swing.GroupLayout paneAddPrescriptionLayout = new javax.swing.GroupLayout(paneAddPrescription);
        paneAddPrescription.setLayout(paneAddPrescriptionLayout);
        paneAddPrescriptionLayout.setHorizontalGroup(
            paneAddPrescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneAddPrescriptionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneAddPrescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ztMedecin)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ztSpecialisation)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ztDate))
                .addContainerGap())
        );
        paneAddPrescriptionLayout.setVerticalGroup(
            paneAddPrescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneAddPrescriptionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ztMedecin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ztSpecialisation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ztDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablePrescription.setModel(new ModeleJTable());
        tablePrescription.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablePrescription);

        jLabel2.setText("Prescription & Posologie:");

        ztRecommandation.setColumns(20);
        ztRecommandation.setRows(5);
        ztRecommandation.setText("M. s'est présenté pour des douleurs au ventre.\nIl n'a qu'une indigestion.");
        ztRecommandation.setEnabled(false);
        jScrollPane1.setViewportView(ztRecommandation);

        jLabel1.setText("Remarques du médecin:");

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
        setVisible(false);
    }//GEN-LAST:event_btCloseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JFormattedTextField ztDate;
    private javax.swing.JTextField ztMedecin;
    private javax.swing.JTextArea ztRecommandation;
    private javax.swing.JFormattedTextField ztSpecialisation;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update() {
        ((DefaultTableModel)tablePrescription.getModel()).fireTableDataChanged();
    }

    public void showView(Rdv rendezVous) {
        this.rdv = rendezVous;
        if (rdv.getPrescriptions() == null) rdv.setPrescriptions(new ArrayList<>());
        ztRecommandation.setText(rendezVous.getRemarque());
        ztMedecin.setText(rendezVous.getMedecin().toString());
        ztDate.setText(ctrl.getSdf().format(rendezVous.getDateRdv()));
        ztSpecialisation.setText(rendezVous.getTypeRdv().getLabel());
        
        update();
        setVisible(true);
    }
    
    public class ModeleJTable extends DefaultTableModel {
        
        @Override
        public boolean isCellEditable(int row, int column) { return false; }
        @Override
        public int getColumnCount() { return 3; }
        @Override
        public int getRowCount() { return rdv.getPrescriptions().size(); }

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
