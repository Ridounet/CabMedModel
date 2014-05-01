package cabmed.admin.ihm;

import cabmed.admin.ctrl.CtrlAdmin;
import javax.swing.JFrame;

public class VueAdmin extends JFrame implements cabmed.ressources.Observer{

    private final CtrlAdmin ctrlAdmin;
    
//    public VueAdmin() {
//        ctrlAdmin = new CtrlAdmin(new CtrlPrincipal(), new Facade());
//        initComponents();
//    }

    public VueAdmin(CtrlAdmin ctrlAdmin) {
        super("Cabmed - Administration");
        this.ctrlAdmin = ctrlAdmin;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        panelMedecin = new javax.swing.JPanel();
        scrollPaneMedecin = new javax.swing.JScrollPane();
        tableMedecin = new javax.swing.JTable();
        btMedecinUpdate = new javax.swing.JButton();
        btMedecinUpdatePlanning = new javax.swing.JButton();
        btMedecinDelete = new javax.swing.JButton();
        btMedecinAdd = new javax.swing.JButton();
        panelMedecinListSpec = new javax.swing.JPanel();
        btMedecinDeleteSpec = new javax.swing.JButton();
        btMedecinAddSpec = new javax.swing.JButton();
        scrollPaneMedecinListSpec = new javax.swing.JScrollPane();
        listMedecinSpec = new javax.swing.JList();
        panelSecretaire = new javax.swing.JPanel();
        scrollPaneSecretaire = new javax.swing.JScrollPane();
        tableSecretaire = new javax.swing.JTable();
        btSecretaireDelete = new javax.swing.JButton();
        btSecretaireUpdatePlanning = new javax.swing.JButton();
        btSecretaireUpdate = new javax.swing.JButton();
        btSecretaireAdd = new javax.swing.JButton();
        panelInfirmiere = new javax.swing.JPanel();
        scrollPaneInfirmiere = new javax.swing.JScrollPane();
        tableInfirmiere = new javax.swing.JTable();
        btInfirmiereUpdate = new javax.swing.JButton();
        btInfirmiereUpdatePlanning = new javax.swing.JButton();
        btInfirmiereDelete = new javax.swing.JButton();
        btInfirmiereAdd = new javax.swing.JButton();
        panelSpecialisation = new javax.swing.JPanel();
        scrollPaneSpec = new javax.swing.JScrollPane();
        tableSpec = new javax.swing.JTable();
        btSpecUpdate = new javax.swing.JButton();
        btSpecDelete = new javax.swing.JButton();
        paneSpecAdd = new javax.swing.JPanel();
        btSpecAdd = new javax.swing.JButton();
        ztSpecDuree = new javax.swing.JFormattedTextField();
        lblSpecDuree = new javax.swing.JLabel();
        ztSpecLabel = new javax.swing.JTextField();
        lblSpecLabel = new javax.swing.JLabel();
        lblSpecAjout = new javax.swing.JLabel();
        menubar = new javax.swing.JMenuBar();
        menuActionFile = new javax.swing.JMenu();
        MenuActionEdit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cabmed - Administration");
        setResizable(false);

        tabbedPane.setName("Médecin"); // NOI18N

        tableMedecin.setAutoCreateRowSorter(true);
        tableMedecin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Birthdate", "Sex", "National Number", "Tel.", "Beginning work at", "Address", "Postal code"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPaneMedecin.setViewportView(tableMedecin);
        if (tableMedecin.getColumnModel().getColumnCount() > 0) {
            tableMedecin.getColumnModel().getColumn(0).setResizable(false);
            tableMedecin.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableMedecin.getColumnModel().getColumn(1).setResizable(false);
            tableMedecin.getColumnModel().getColumn(1).setPreferredWidth(60);
            tableMedecin.getColumnModel().getColumn(2).setResizable(false);
            tableMedecin.getColumnModel().getColumn(2).setPreferredWidth(60);
            tableMedecin.getColumnModel().getColumn(3).setResizable(false);
            tableMedecin.getColumnModel().getColumn(3).setPreferredWidth(30);
            tableMedecin.getColumnModel().getColumn(4).setResizable(false);
            tableMedecin.getColumnModel().getColumn(4).setPreferredWidth(70);
            tableMedecin.getColumnModel().getColumn(5).setResizable(false);
            tableMedecin.getColumnModel().getColumn(5).setPreferredWidth(50);
            tableMedecin.getColumnModel().getColumn(6).setResizable(false);
            tableMedecin.getColumnModel().getColumn(6).setPreferredWidth(80);
            tableMedecin.getColumnModel().getColumn(7).setResizable(false);
            tableMedecin.getColumnModel().getColumn(7).setPreferredWidth(70);
            tableMedecin.getColumnModel().getColumn(8).setResizable(false);
            tableMedecin.getColumnModel().getColumn(8).setPreferredWidth(45);
        }

        btMedecinUpdate.setText("Modification");
        btMedecinUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMedecinUpdateActionPerformed(evt);
            }
        });

        btMedecinUpdatePlanning.setText("Modif. Planning");
        btMedecinUpdatePlanning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMedecinUpdatePlanningActionPerformed(evt);
            }
        });

        btMedecinDelete.setBackground(new java.awt.Color(255, 0, 0));
        btMedecinDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btMedecinDelete.setForeground(new java.awt.Color(255, 255, 255));
        btMedecinDelete.setText("DELETE");
        btMedecinDelete.setToolTipText("");
        btMedecinDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMedecinDeleteActionPerformed(evt);
            }
        });

        btMedecinAdd.setText("Add a Physician");

        panelMedecinListSpec.setBorder(javax.swing.BorderFactory.createTitledBorder("List of Specialization"));

        btMedecinDeleteSpec.setText("Delete Specialization");
        btMedecinDeleteSpec.setFocusable(false);
        btMedecinDeleteSpec.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btMedecinDeleteSpec.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btMedecinDeleteSpec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMedecinDeleteSpecActionPerformed(evt);
            }
        });

        btMedecinAddSpec.setText("Add Specialization");

        listMedecinSpec.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        listMedecinSpec.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "item", "item", "item" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listMedecinSpec.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listMedecinSpec.setToolTipText("");
        scrollPaneMedecinListSpec.setViewportView(listMedecinSpec);

        javax.swing.GroupLayout panelMedecinListSpecLayout = new javax.swing.GroupLayout(panelMedecinListSpec);
        panelMedecinListSpec.setLayout(panelMedecinListSpecLayout);
        panelMedecinListSpecLayout.setHorizontalGroup(
            panelMedecinListSpecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMedecinListSpecLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneMedecinListSpec, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelMedecinListSpecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btMedecinDeleteSpec)
                    .addComponent(btMedecinAddSpec))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMedecinListSpecLayout.setVerticalGroup(
            panelMedecinListSpecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMedecinListSpecLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMedecinListSpecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPaneMedecinListSpec, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelMedecinListSpecLayout.createSequentialGroup()
                        .addComponent(btMedecinAddSpec, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btMedecinDeleteSpec, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelMedecinLayout = new javax.swing.GroupLayout(panelMedecin);
        panelMedecin.setLayout(panelMedecinLayout);
        panelMedecinLayout.setHorizontalGroup(
            panelMedecinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMedecinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMedecinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMedecinLayout.createSequentialGroup()
                        .addComponent(scrollPaneMedecin, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                        .addGap(117, 117, 117))
                    .addGroup(panelMedecinLayout.createSequentialGroup()
                        .addComponent(btMedecinUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btMedecinUpdatePlanning)
                        .addGap(18, 18, 18)
                        .addComponent(btMedecinAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btMedecinDelete)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelMedecinLayout.createSequentialGroup()
                        .addComponent(panelMedecinListSpec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelMedecinLayout.setVerticalGroup(
            panelMedecinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMedecinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneMedecin, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelMedecinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btMedecinDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btMedecinAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelMedecinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btMedecinUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btMedecinUpdatePlanning, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(panelMedecinListSpec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Physician", panelMedecin);

        tableSecretaire.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Birthdate", "Sex", "National Number", "Tel.", "Beginning work at", "Address", "Postal code"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPaneSecretaire.setViewportView(tableSecretaire);
        if (tableSecretaire.getColumnModel().getColumnCount() > 0) {
            tableSecretaire.getColumnModel().getColumn(0).setResizable(false);
            tableSecretaire.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableSecretaire.getColumnModel().getColumn(1).setResizable(false);
            tableSecretaire.getColumnModel().getColumn(1).setPreferredWidth(60);
            tableSecretaire.getColumnModel().getColumn(2).setResizable(false);
            tableSecretaire.getColumnModel().getColumn(2).setPreferredWidth(60);
            tableSecretaire.getColumnModel().getColumn(3).setResizable(false);
            tableSecretaire.getColumnModel().getColumn(3).setPreferredWidth(30);
            tableSecretaire.getColumnModel().getColumn(4).setResizable(false);
            tableSecretaire.getColumnModel().getColumn(4).setPreferredWidth(70);
            tableSecretaire.getColumnModel().getColumn(5).setResizable(false);
            tableSecretaire.getColumnModel().getColumn(5).setPreferredWidth(50);
            tableSecretaire.getColumnModel().getColumn(6).setResizable(false);
            tableSecretaire.getColumnModel().getColumn(6).setPreferredWidth(80);
            tableSecretaire.getColumnModel().getColumn(7).setResizable(false);
            tableSecretaire.getColumnModel().getColumn(7).setPreferredWidth(70);
            tableSecretaire.getColumnModel().getColumn(8).setResizable(false);
            tableSecretaire.getColumnModel().getColumn(8).setPreferredWidth(45);
        }

        btSecretaireDelete.setBackground(new java.awt.Color(255, 0, 0));
        btSecretaireDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btSecretaireDelete.setForeground(new java.awt.Color(255, 255, 255));
        btSecretaireDelete.setText("DELETE");
        btSecretaireDelete.setToolTipText("");
        btSecretaireDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSecretaireDeleteActionPerformed(evt);
            }
        });

        btSecretaireUpdatePlanning.setText("Modif. Planning");
        btSecretaireUpdatePlanning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSecretaireUpdatePlanningActionPerformed(evt);
            }
        });

        btSecretaireUpdate.setText("Modification");
        btSecretaireUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSecretaireUpdateActionPerformed(evt);
            }
        });

        btSecretaireAdd.setText("Add a Secretary");

        javax.swing.GroupLayout panelSecretaireLayout = new javax.swing.GroupLayout(panelSecretaire);
        panelSecretaire.setLayout(panelSecretaireLayout);
        panelSecretaireLayout.setHorizontalGroup(
            panelSecretaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSecretaireLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSecretaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSecretaireLayout.createSequentialGroup()
                        .addComponent(scrollPaneSecretaire, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                        .addGap(117, 117, 117))
                    .addGroup(panelSecretaireLayout.createSequentialGroup()
                        .addComponent(btSecretaireUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btSecretaireUpdatePlanning)
                        .addGap(18, 18, 18)
                        .addComponent(btSecretaireAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btSecretaireDelete)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelSecretaireLayout.setVerticalGroup(
            panelSecretaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSecretaireLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneSecretaire, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelSecretaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSecretaireUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSecretaireUpdatePlanning, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSecretaireAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(btSecretaireDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(194, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Secretary", panelSecretaire);

        tableInfirmiere.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Birthdate", "Sex", "National Number", "Tel.", "Beginning work at", "Address", "Postal code"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPaneInfirmiere.setViewportView(tableInfirmiere);
        if (tableInfirmiere.getColumnModel().getColumnCount() > 0) {
            tableInfirmiere.getColumnModel().getColumn(0).setResizable(false);
            tableInfirmiere.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableInfirmiere.getColumnModel().getColumn(1).setResizable(false);
            tableInfirmiere.getColumnModel().getColumn(1).setPreferredWidth(60);
            tableInfirmiere.getColumnModel().getColumn(2).setResizable(false);
            tableInfirmiere.getColumnModel().getColumn(2).setPreferredWidth(60);
            tableInfirmiere.getColumnModel().getColumn(3).setResizable(false);
            tableInfirmiere.getColumnModel().getColumn(3).setPreferredWidth(30);
            tableInfirmiere.getColumnModel().getColumn(4).setResizable(false);
            tableInfirmiere.getColumnModel().getColumn(4).setPreferredWidth(70);
            tableInfirmiere.getColumnModel().getColumn(5).setResizable(false);
            tableInfirmiere.getColumnModel().getColumn(5).setPreferredWidth(50);
            tableInfirmiere.getColumnModel().getColumn(6).setResizable(false);
            tableInfirmiere.getColumnModel().getColumn(6).setPreferredWidth(80);
            tableInfirmiere.getColumnModel().getColumn(7).setResizable(false);
            tableInfirmiere.getColumnModel().getColumn(7).setPreferredWidth(70);
            tableInfirmiere.getColumnModel().getColumn(8).setResizable(false);
            tableInfirmiere.getColumnModel().getColumn(8).setPreferredWidth(45);
        }

        btInfirmiereUpdate.setText("Modification");
        btInfirmiereUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInfirmiereUpdateActionPerformed(evt);
            }
        });

        btInfirmiereUpdatePlanning.setText("Modif. Planning");
        btInfirmiereUpdatePlanning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInfirmiereUpdatePlanningActionPerformed(evt);
            }
        });

        btInfirmiereDelete.setBackground(new java.awt.Color(255, 0, 0));
        btInfirmiereDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btInfirmiereDelete.setForeground(new java.awt.Color(255, 255, 255));
        btInfirmiereDelete.setText("DELETE");
        btInfirmiereDelete.setToolTipText("");
        btInfirmiereDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInfirmiereDeleteActionPerformed(evt);
            }
        });

        btInfirmiereAdd.setText("Add a Nurse");

        javax.swing.GroupLayout panelInfirmiereLayout = new javax.swing.GroupLayout(panelInfirmiere);
        panelInfirmiere.setLayout(panelInfirmiereLayout);
        panelInfirmiereLayout.setHorizontalGroup(
            panelInfirmiereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfirmiereLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfirmiereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfirmiereLayout.createSequentialGroup()
                        .addComponent(scrollPaneInfirmiere, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                        .addGap(117, 117, 117))
                    .addGroup(panelInfirmiereLayout.createSequentialGroup()
                        .addComponent(btInfirmiereUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btInfirmiereUpdatePlanning)
                        .addGap(18, 18, 18)
                        .addComponent(btInfirmiereAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btInfirmiereDelete)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelInfirmiereLayout.setVerticalGroup(
            panelInfirmiereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfirmiereLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneInfirmiere, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelInfirmiereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btInfirmiereUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btInfirmiereUpdatePlanning, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btInfirmiereAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(btInfirmiereDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98))
        );

        tabbedPane.addTab("Nurse", panelInfirmiere);

        tableSpec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Label", "Delay"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPaneSpec.setViewportView(tableSpec);
        if (tableSpec.getColumnModel().getColumnCount() > 0) {
            tableSpec.getColumnModel().getColumn(0).setResizable(false);
            tableSpec.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableSpec.getColumnModel().getColumn(1).setResizable(false);
            tableSpec.getColumnModel().getColumn(1).setPreferredWidth(40);
            tableSpec.getColumnModel().getColumn(2).setResizable(false);
            tableSpec.getColumnModel().getColumn(2).setPreferredWidth(20);
        }

        btSpecUpdate.setText("Modification");
        btSpecUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSpecUpdateActionPerformed(evt);
            }
        });

        btSpecDelete.setBackground(new java.awt.Color(255, 0, 0));
        btSpecDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btSpecDelete.setForeground(new java.awt.Color(255, 255, 255));
        btSpecDelete.setText("DELETE");
        btSpecDelete.setToolTipText("");
        btSpecDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSpecDeleteActionPerformed(evt);
            }
        });

        paneSpecAdd.setBorder(javax.swing.BorderFactory.createTitledBorder("Add a new Specialization"));

        btSpecAdd.setText("Add");

        ztSpecDuree.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        lblSpecDuree.setText("Delay");

        ztSpecLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ztSpecLabelActionPerformed(evt);
            }
        });

        lblSpecLabel.setText("Label");

        javax.swing.GroupLayout paneSpecAddLayout = new javax.swing.GroupLayout(paneSpecAdd);
        paneSpecAdd.setLayout(paneSpecAddLayout);
        paneSpecAddLayout.setHorizontalGroup(
            paneSpecAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneSpecAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneSpecAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSpecAjout, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(paneSpecAddLayout.createSequentialGroup()
                        .addGroup(paneSpecAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblSpecLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ztSpecLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(paneSpecAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSpecDuree, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ztSpecDuree, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24)
                .addComponent(btSpecAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneSpecAddLayout.setVerticalGroup(
            paneSpecAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneSpecAddLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSpecAjout)
                .addGap(18, 18, 18)
                .addGroup(paneSpecAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSpecDuree)
                    .addComponent(lblSpecLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneSpecAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ztSpecLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSpecAdd)
                    .addComponent(ztSpecDuree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelSpecialisationLayout = new javax.swing.GroupLayout(panelSpecialisation);
        panelSpecialisation.setLayout(panelSpecialisationLayout);
        panelSpecialisationLayout.setHorizontalGroup(
            panelSpecialisationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSpecialisationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSpecialisationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSpecialisationLayout.createSequentialGroup()
                        .addComponent(btSpecUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btSpecDelete))
                    .addComponent(scrollPaneSpec, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paneSpecAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(494, Short.MAX_VALUE))
        );
        panelSpecialisationLayout.setVerticalGroup(
            panelSpecialisationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSpecialisationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneSpec, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelSpecialisationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSpecUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSpecDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(paneSpecAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Specialization", panelSpecialisation);

        menuActionFile.setText("File");
        menubar.add(menuActionFile);

        MenuActionEdit.setText("Edit");
        menubar.add(MenuActionEdit);

        setJMenuBar(menubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(tabbedPane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ztSpecLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ztSpecLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ztSpecLabelActionPerformed

    private void btMedecinUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMedecinUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btMedecinUpdateActionPerformed

    private void btMedecinUpdatePlanningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMedecinUpdatePlanningActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btMedecinUpdatePlanningActionPerformed

    private void btMedecinDeleteSpecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMedecinDeleteSpecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btMedecinDeleteSpecActionPerformed

    private void btMedecinDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMedecinDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btMedecinDeleteActionPerformed

    private void btSecretaireUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSecretaireUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSecretaireUpdateActionPerformed

    private void btSecretaireUpdatePlanningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSecretaireUpdatePlanningActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSecretaireUpdatePlanningActionPerformed

    private void btSecretaireDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSecretaireDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSecretaireDeleteActionPerformed

    private void btInfirmiereUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInfirmiereUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btInfirmiereUpdateActionPerformed

    private void btInfirmiereUpdatePlanningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInfirmiereUpdatePlanningActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btInfirmiereUpdatePlanningActionPerformed

    private void btInfirmiereDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInfirmiereDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btInfirmiereDeleteActionPerformed

    private void btSpecUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSpecUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSpecUpdateActionPerformed

    private void btSpecDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSpecDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSpecDeleteActionPerformed

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VueAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VueAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VueAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VueAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VueAdmin().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuActionEdit;
    private javax.swing.JButton btInfirmiereAdd;
    private javax.swing.JButton btInfirmiereDelete;
    private javax.swing.JButton btInfirmiereUpdate;
    private javax.swing.JButton btInfirmiereUpdatePlanning;
    private javax.swing.JButton btMedecinAdd;
    private javax.swing.JButton btMedecinAddSpec;
    private javax.swing.JButton btMedecinDelete;
    private javax.swing.JButton btMedecinDeleteSpec;
    private javax.swing.JButton btMedecinUpdate;
    private javax.swing.JButton btMedecinUpdatePlanning;
    private javax.swing.JButton btSecretaireAdd;
    private javax.swing.JButton btSecretaireDelete;
    private javax.swing.JButton btSecretaireUpdate;
    private javax.swing.JButton btSecretaireUpdatePlanning;
    private javax.swing.JButton btSpecAdd;
    private javax.swing.JButton btSpecDelete;
    private javax.swing.JButton btSpecUpdate;
    private javax.swing.JLabel lblSpecAjout;
    private javax.swing.JLabel lblSpecDuree;
    private javax.swing.JLabel lblSpecLabel;
    private javax.swing.JList listMedecinSpec;
    private javax.swing.JMenu menuActionFile;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JPanel paneSpecAdd;
    private javax.swing.JPanel panelInfirmiere;
    private javax.swing.JPanel panelMedecin;
    private javax.swing.JPanel panelMedecinListSpec;
    private javax.swing.JPanel panelSecretaire;
    private javax.swing.JPanel panelSpecialisation;
    private javax.swing.JScrollPane scrollPaneInfirmiere;
    private javax.swing.JScrollPane scrollPaneMedecin;
    private javax.swing.JScrollPane scrollPaneMedecinListSpec;
    private javax.swing.JScrollPane scrollPaneSecretaire;
    private javax.swing.JScrollPane scrollPaneSpec;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable tableInfirmiere;
    private javax.swing.JTable tableMedecin;
    private javax.swing.JTable tableSecretaire;
    private javax.swing.JTable tableSpec;
    private javax.swing.JFormattedTextField ztSpecDuree;
    private javax.swing.JTextField ztSpecLabel;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void update() {
        // TODO
    }
}
