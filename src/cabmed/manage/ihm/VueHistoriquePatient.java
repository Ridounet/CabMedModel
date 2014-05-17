package cabmed.manage.ihm;

import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class VueHistoriquePatient extends javax.swing.JFrame {

    public VueHistoriquePatient() {
        initComponents();
        initAttributes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneGeneral = new javax.swing.JTabbedPane();
        paneRdvEnCours = new javax.swing.JPanel();
        scrollTableEnCours = new javax.swing.JScrollPane();
        tableRdvEnCours = new javax.swing.JTable();
        btModifEnCours = new javax.swing.JButton();
        btCancelEnCours = new javax.swing.JButton();
        btDetailEnCours = new javax.swing.JButton();
        paneRdvPasses = new javax.swing.JPanel();
        scrollTableEnCours1 = new javax.swing.JScrollPane();
        tableRdvAncien = new javax.swing.JTable();
        paneRdvNouveau = new javax.swing.JPanel();
        lbTitre = new javax.swing.JLabel();
        btAddRdv = new javax.swing.JButton();
        btCancelRdv = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbMedecin = new javax.swing.JLabel();
        cbMedecin = new javax.swing.JComboBox();
        lbSpecialisation = new javax.swing.JLabel();
        cbSpecialisation = new javax.swing.JComboBox();
        lbDate = new javax.swing.JLabel();
        dpDate = new com.toedter.calendar.JDateChooser();
        lbHeure = new javax.swing.JLabel();
        cbTranche = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cabmed - History ");
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        setResizable(false);

        tableRdvEnCours.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Médecin", "Spécialisation", "Date", "Heure"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRdvEnCours.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableRdvEnCours.getTableHeader().setReorderingAllowed(false);
        scrollTableEnCours.setViewportView(tableRdvEnCours);
        if (tableRdvEnCours.getColumnModel().getColumnCount() > 0) {
            tableRdvEnCours.getColumnModel().getColumn(0).setResizable(false);
            tableRdvEnCours.getColumnModel().getColumn(1).setResizable(false);
            tableRdvEnCours.getColumnModel().getColumn(2).setResizable(false);
            tableRdvEnCours.getColumnModel().getColumn(3).setResizable(false);
            tableRdvEnCours.getColumnModel().getColumn(4).setResizable(false);
        }

        btModifEnCours.setText("Modification");
        btModifEnCours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModifEnCoursActionPerformed(evt);
            }
        });

        btCancelEnCours.setBackground(new java.awt.Color(255, 0, 0));
        btCancelEnCours.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btCancelEnCours.setForeground(new java.awt.Color(255, 255, 255));
        btCancelEnCours.setText("ANNULER");

        btDetailEnCours.setText("Détails");

        javax.swing.GroupLayout paneRdvEnCoursLayout = new javax.swing.GroupLayout(paneRdvEnCours);
        paneRdvEnCours.setLayout(paneRdvEnCoursLayout);
        paneRdvEnCoursLayout.setHorizontalGroup(
            paneRdvEnCoursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneRdvEnCoursLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneRdvEnCoursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTableEnCours, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                    .addGroup(paneRdvEnCoursLayout.createSequentialGroup()
                        .addComponent(btModifEnCours, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btDetailEnCours, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btCancelEnCours, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        paneRdvEnCoursLayout.setVerticalGroup(
            paneRdvEnCoursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneRdvEnCoursLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTableEnCours, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(paneRdvEnCoursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btModifEnCours, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCancelEnCours, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDetailEnCours, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        paneGeneral.addTab("Rendez-vous actuels", paneRdvEnCours);

        tableRdvAncien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Médecin", "Spécialisation", "Date", "Heure"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRdvAncien.getTableHeader().setReorderingAllowed(false);
        scrollTableEnCours1.setViewportView(tableRdvAncien);
        if (tableRdvAncien.getColumnModel().getColumnCount() > 0) {
            tableRdvAncien.getColumnModel().getColumn(0).setResizable(false);
            tableRdvAncien.getColumnModel().getColumn(1).setResizable(false);
            tableRdvAncien.getColumnModel().getColumn(2).setResizable(false);
            tableRdvAncien.getColumnModel().getColumn(3).setResizable(false);
            tableRdvAncien.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout paneRdvPassesLayout = new javax.swing.GroupLayout(paneRdvPasses);
        paneRdvPasses.setLayout(paneRdvPassesLayout);
        paneRdvPassesLayout.setHorizontalGroup(
            paneRdvPassesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneRdvPassesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTableEnCours1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                .addContainerGap())
        );
        paneRdvPassesLayout.setVerticalGroup(
            paneRdvPassesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneRdvPassesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTableEnCours1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addContainerGap())
        );

        paneGeneral.addTab("Rendez-vous Anciens", paneRdvPasses);

        lbTitre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTitre.setText("Ajout d'un rendez-vous:");

        btAddRdv.setText("Ajouter");
        btAddRdv.setPreferredSize(new java.awt.Dimension(58, 23));
        btAddRdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddRdvActionPerformed(evt);
            }
        });

        btCancelRdv.setText("Annuler");
        btCancelRdv.setPreferredSize(new java.awt.Dimension(58, 23));
        btCancelRdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelRdvActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbMedecin.setText("Médecin");

        lbSpecialisation.setText("Spécialisation");

        lbDate.setText("Date");

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
                            .addComponent(btCancelRdv, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(84, Short.MAX_VALUE))
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
                        .addComponent(btCancelRdv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(paneRdvNouveauLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
        );

        paneGeneral.addTab("Nouveau rendez-vous", paneRdvNouveau);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneGeneral)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btModifEnCoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModifEnCoursActionPerformed
        
    }//GEN-LAST:event_btModifEnCoursActionPerformed

    private void btAddRdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddRdvActionPerformed
        
    }//GEN-LAST:event_btAddRdvActionPerformed

    private void btCancelRdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelRdvActionPerformed
        viderChamps();
    }//GEN-LAST:event_btCancelRdvActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(VueHistoriquePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VueHistoriquePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VueHistoriquePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VueHistoriquePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VueHistoriquePatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddRdv;
    private javax.swing.JButton btCancelEnCours;
    private javax.swing.JButton btCancelRdv;
    private javax.swing.JButton btDetailEnCours;
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
        
    }

    private void initAttributes() {
        cbMedecin.addItem("");
        cbMedecin.addItem("Truc Machin Chose");
        cbMedecin.addItem("Machin de la machine");
        cbMedecin.addItem("Chose de la truc");
        
        cbSpecialisation.addItem("");
        cbSpecialisation.addItem("Généraliste");
        cbSpecialisation.addItem("Specialiste des pieds");
        cbSpecialisation.addItem("Specialiste des doigts");
    }
    
    private class ModeleRdvEnCours extends DefaultTableModel {

        @Override
        public boolean isCellEditable(int row, int column) { return false; }
        @Override
        public int getColumnCount() { return 5; }
        @Override
        public int getRowCount() {
            return super.getRowCount(); //To change body of generated methods, choose Tools | Templates.
        }
        
        @Override
        public Object getValueAt(int row, int column) {
            return super.getValueAt(row, column); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String getColumnName(int column) {
            switch(column) {
                case 0:
                    
                    return null;
                case 1:
                    
                    return null;
                case 2:
                    
                    return null;
                case 3:
                    
                    return null;
                default:
                    
                    return null;
            }
        }
    }
    
    private class ModeleRdvAncien extends DefaultTableModel {

        @Override
        public boolean isCellEditable(int row, int column) { return false; }
        @Override
        public int getColumnCount() { return 5; }
        @Override
        public int getRowCount() {
            return super.getRowCount(); //To change body of generated methods, choose Tools | Templates.
        }
        
        @Override
        public Object getValueAt(int row, int column) {
            return super.getValueAt(row, column); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String getColumnName(int column) {
            switch(column) {
                case 0:
                    
                    return null;
                case 1:
                    
                    return null;
                case 2:
                    
                    return null;
                case 3:
                    
                    return null;
                default:
                    
                    return null;
            }
        }
    }
    
}
