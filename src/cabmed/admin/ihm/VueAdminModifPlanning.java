package cabmed.admin.ihm;

import cabmed.admin.ctrl.CtrlAdmin;
import cabmed.model.Disponibilite;
import cabmed.model.Jour;
import cabmed.model.Medecin;
import cabmed.model.Tranche;
import cabmed.ressources.Observer;
import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
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
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btSave = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePlanning = new javax.swing.JTable();
        lbTitre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cabmed - Manage planning");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

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

        tablePlanning.setModel(new ModeleTablePlanning());
        tablePlanning.getTableHeader().setReorderingAllowed(false);
        tablePlanning.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePlanningMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePlanning);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
                        .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitre, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        
    }//GEN-LAST:event_btSaveActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        ctrl.hideVueModifPlanning();
    }//GEN-LAST:event_btCancelActionPerformed

    private void tablePlanningMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePlanningMouseClicked
        if (tablePlanning.getSelectedColumn() != 0) {
            if (evt.getClickCount() == 1) {
                Jour j = (Jour)enteteTable.get(tablePlanning.getSelectedColumn());
                Tranche t = listTranche.get(tablePlanning.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Tranche selectionnée: " + t.getLabel() + " pour " + j);
            }
        }
    }//GEN-LAST:event_tablePlanningMouseClicked

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTitre;
    private javax.swing.JTable tablePlanning;
    // End of variables declaration//GEN-END:variables
    
    private Vector enteteTable;
    
    @Override
    public void update() {
        medecin = new Medecin();
        lbTitre.setText("Update Planning");
        //lbTitre.setText(medecin.getPrenom()+ " " + medecin.getNom());
        ((ModeleTablePlanning)tablePlanning.getModel()).update();
    }

}
