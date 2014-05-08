package cabmed.admin.ihm;

import cabmed.admin.ctrl.CtrlAdmin;
import cabmed.model.Adresse;
import cabmed.model.Infirmiere;
import cabmed.model.Medecin;
import cabmed.model.Secretaire;
import cabmed.model.Sexe;
import cabmed.model.Specialisation;
import cabmed.ressources.Observer;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

public class VueAdmin extends JFrame implements cabmed.ressources.Observer{

    private final CtrlAdmin ctrlAdmin;
    
    public VueAdmin(CtrlAdmin ctrlAdmin) {
        super("Cabmed - Administration");
        this.ctrlAdmin = ctrlAdmin;
        initComponents();
    }
    
    private void initAttributes() { // Initialise tous les attributs de cette classe
        sdf = ctrlAdmin.getSdf();
        actions = new Actions();
        listMedecin = ctrlAdmin.getListMedecin();
        listSecretaire = ctrlAdmin.getListSecretaire();
        listInfirmiere = ctrlAdmin.getListInfirmiere();
        listSpecialisation = ctrlAdmin.getListSpecialisation();
        entetePersonnel = new Vector();
        entetePersonnel.add("ID"); entetePersonnel.add("Name"); entetePersonnel.add("Birthdate");
        entetePersonnel.add("Sex"); entetePersonnel.add("National Number"); entetePersonnel.add("Tel.");
        entetePersonnel.add("Beginning work at"); entetePersonnel.add("Address"); entetePersonnel.add("Postal code");
        enteteSpecialisation = new Vector();
        enteteSpecialisation.add("ID"); enteteSpecialisation.add("Label"); enteteSpecialisation.add("Delay");
        tabbedPane = new JTabbedPane();
        panelMedecin = new JPanel();
        scrollPaneMedecin = new JScrollPane();
        tableMedecin = new JTable();
        btMedecinUpdate = new JButton();
        btMedecinUpdatePlanning = new JButton();
        btMedecinDelete = new JButton();
        btMedecinAdd = new JButton();
        panelMedecinListSpec = new JPanel();
        btMedecinDeleteSpec = new JButton();
        btMedecinAddSpec = new JButton();
        scrollPaneMedecinListSpec = new JScrollPane();
        listModelSpec = new DefaultListModel<Specialisation>();
        listMedecinSpec = new JList(listModelSpec);
        panelSecretaire = new JPanel();
        scrollPaneSecretaire = new JScrollPane();
        tableSecretaire = new JTable();
        btSecretaireDelete = new JButton();
        btSecretaireUpdate = new JButton();
        btSecretaireAdd = new JButton();
        panelInfirmiere = new JPanel();
        scrollPaneInfirmiere = new JScrollPane();
        tableInfirmiere = new JTable();
        btInfirmiereUpdate = new JButton();
        btInfirmiereDelete = new JButton();
        btInfirmiereAdd = new JButton();
        panelSpecialisation = new JPanel();
        scrollPaneSpec = new JScrollPane();
        tableSpec = new JTable();
        btSpecUpdate = new JButton();
        btSpecDelete = new JButton();
        paneSpecAdd = new JPanel();
        btSpecAdd = new JButton();
        ztSpecDuree = new JFormattedTextField();
        lblSpecDuree = new JLabel();
        ztSpecLabel = new JTextField();
        lblSpecLabel = new JLabel();
        lblSpecAjout = new JLabel();
        
        modeleMedecin = new ModeleJTableMedecin();
        modeleSecretaire = new ModeleJTableSecretaire();
        modeleInfirmiere = new ModeleJTableInfirmiere();
        modeleSpecialisation = new ModeleJTableSpecialisation();
    }
    
    private void initJTables() { // Initialise la taille et le non redimensionnement des colonnes
        if (tableMedecin.getColumnModel().getColumnCount() > 0) {
            tableMedecin.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableMedecin.getColumnModel().getColumn(1).setPreferredWidth(70);
            tableMedecin.getColumnModel().getColumn(2).setPreferredWidth(60);
            tableMedecin.getColumnModel().getColumn(3).setPreferredWidth(30);
            tableMedecin.getColumnModel().getColumn(4).setPreferredWidth(70);
            tableMedecin.getColumnModel().getColumn(5).setPreferredWidth(50);
            tableMedecin.getColumnModel().getColumn(6).setPreferredWidth(80);
            tableMedecin.getColumnModel().getColumn(7).setPreferredWidth(70);
            tableMedecin.getColumnModel().getColumn(8).setPreferredWidth(45);
        }
        
        if (tableSecretaire.getColumnModel().getColumnCount() > 0) {
            tableSecretaire.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableSecretaire.getColumnModel().getColumn(1).setPreferredWidth(70);
            tableSecretaire.getColumnModel().getColumn(2).setPreferredWidth(60);
            tableSecretaire.getColumnModel().getColumn(3).setPreferredWidth(30);
            tableSecretaire.getColumnModel().getColumn(4).setPreferredWidth(70);
            tableSecretaire.getColumnModel().getColumn(5).setPreferredWidth(50);
            tableSecretaire.getColumnModel().getColumn(6).setPreferredWidth(80);
            tableSecretaire.getColumnModel().getColumn(7).setPreferredWidth(70);
            tableSecretaire.getColumnModel().getColumn(8).setPreferredWidth(45);
        }
        
        if (tableInfirmiere.getColumnModel().getColumnCount() > 0) {
            tableInfirmiere.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableInfirmiere.getColumnModel().getColumn(1).setPreferredWidth(70);
            tableInfirmiere.getColumnModel().getColumn(2).setPreferredWidth(60);
            tableInfirmiere.getColumnModel().getColumn(3).setPreferredWidth(30);
            tableInfirmiere.getColumnModel().getColumn(4).setPreferredWidth(70);
            tableInfirmiere.getColumnModel().getColumn(5).setPreferredWidth(50);
            tableInfirmiere.getColumnModel().getColumn(6).setPreferredWidth(80);
            tableInfirmiere.getColumnModel().getColumn(7).setPreferredWidth(70);
            tableInfirmiere.getColumnModel().getColumn(8).setPreferredWidth(45);
        }
        
        if (tableSpec.getColumnModel().getColumnCount() > 0) {
            tableSpec.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableSpec.getColumnModel().getColumn(1).setPreferredWidth(40);
            tableSpec.getColumnModel().getColumn(2).setPreferredWidth(20);
        }
        
        for (int i = 0; i < tableMedecin.getColumnCount(); i++) {
            tableMedecin.getColumnModel().getColumn(i).setResizable(false);
        }
        
        for (int i = 0; i < tableSecretaire.getColumnCount(); i++) {
            tableSecretaire.getColumnModel().getColumn(i).setResizable(false);
        }
        
        for (int i = 0; i < tableInfirmiere.getColumnCount(); i++) {
            tableInfirmiere.getColumnModel().getColumn(i).setResizable(false);
        }
        
        for (int i = 0; i < tableSpec.getColumnCount(); i++) {
            tableSpec.getColumnModel().getColumn(i).setResizable(false);
        }
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
        initAttributes();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cabmed - Administration");
        setResizable(false);

        // -------------------- Debut Medecin --------------------
        tabbedPane.setName("Médecin");
        tableMedecin.setModel(modeleMedecin);
        tableMedecin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                actions.jTableClick();
            }
        });
        scrollPaneMedecin.setViewportView(tableMedecin);
        btMedecinUpdate.setText("Modification");
        btMedecinUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                actions.btMedecinUpdate(evt);
            }
        });
        btMedecinUpdatePlanning.setText("Modif. Planning");
        btMedecinUpdatePlanning.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                actions.btMedecinUpdatePlanning(evt);
            }
        });
        btMedecinDelete.setBackground(new java.awt.Color(255, 0, 0));
        btMedecinDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btMedecinDelete.setForeground(new java.awt.Color(255, 255, 255));
        btMedecinDelete.setText("DELETE");
        btMedecinDelete.setToolTipText("");
        btMedecinDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actions.btMedecinDelete(evt);
            }
        });
        btMedecinAdd.setText("Add a Physician");
        btMedecinAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                actions.btMedecinAdd(evt);
            }
        });
        panelMedecinListSpec.setBorder(BorderFactory.createTitledBorder("List of Specialization"));
        btMedecinDeleteSpec.setText("Delete Specialization");
        btMedecinDeleteSpec.setFocusable(false);
        btMedecinDeleteSpec.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btMedecinDeleteSpec.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btMedecinDeleteSpec.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actions.btMedecinDeleteSpec(evt);
            }
        });
        btMedecinAddSpec.setText("Add Specialization");
        listMedecinSpec.setBorder(BorderFactory.createEtchedBorder());
        listMedecinSpec.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listMedecinSpec.setToolTipText("");
        scrollPaneMedecinListSpec.setViewportView(listMedecinSpec);
        placementMedecin();
        tabbedPane.addTab("Physician", panelMedecin);

        // -------------------- Debut Secretaire --------------------
        tableSecretaire.setModel(modeleSecretaire);
        scrollPaneSecretaire.setViewportView(tableSecretaire);
        btSecretaireDelete.setBackground(new java.awt.Color(255, 0, 0));
        btSecretaireDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btSecretaireDelete.setForeground(new java.awt.Color(255, 255, 255));
        btSecretaireDelete.setText("DELETE");
        btSecretaireDelete.setToolTipText("");
        btSecretaireDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actions.btSecretaireDelete(evt);
            }
        });
        btSecretaireUpdate.setText("Modification");
        btSecretaireUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actions.btSecretaireUpdate(evt);
            }
        });
        btSecretaireAdd.setText("Add a Secretary");
        placementSecretaire();
        tabbedPane.addTab("Secretary", panelSecretaire);

        // -------------------- Debut Infirmiere --------------------
        tableInfirmiere.setModel(modeleInfirmiere);
        scrollPaneInfirmiere.setViewportView(tableInfirmiere);
        btInfirmiereUpdate.setText("Modification");
        btInfirmiereUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actions.btInfirmiereUpdate(evt);
            }
        });
        btInfirmiereDelete.setBackground(new java.awt.Color(255, 0, 0));
        btInfirmiereDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btInfirmiereDelete.setForeground(new java.awt.Color(255, 255, 255));
        btInfirmiereDelete.setText("DELETE");
        btInfirmiereDelete.setToolTipText("");
        btInfirmiereDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actions.btInfirmiereDelete(evt);
            }
        });
        btInfirmiereAdd.setText("Add a Nurse");
        placementInfirmiere();
        tabbedPane.addTab("Nurse", panelInfirmiere);

        // -------------------- Debut Specialisation --------------------
        tableSpec.setModel(modeleSpecialisation);
        scrollPaneSpec.setViewportView(tableSpec);
        btSpecUpdate.setText("Modification");
        btSpecUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actions.btSpecUpdate(evt);
            }
        });
        btSpecDelete.setBackground(new java.awt.Color(255, 0, 0));
        btSpecDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btSpecDelete.setForeground(new java.awt.Color(255, 255, 255));
        btSpecDelete.setText("DELETE");
        btSpecDelete.setToolTipText("");
        btSpecDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actions.btSpecDelete(evt);
            }
        });
        paneSpecAdd.setBorder(BorderFactory.createTitledBorder("Add a new Specialization"));
        btSpecAdd.setText("Add");
        btSpecAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actions.btSpecAdd(evt);
            }
        });
        ztSpecDuree.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        lblSpecDuree.setText("Delay");
        lblSpecLabel.setText("Label");
        placementSpecialisation();
        tabbedPane.addTab("Specialization", panelSpecialisation);

        initJTables();
        placementGeneral();
        pack();
    }

    @Override
    public void update() {
        ((Observer)tableMedecin.getModel()).update();
        ((Observer)tableSecretaire.getModel()).update();
        ((Observer)tableInfirmiere.getModel()).update();
        ((Observer)tableSpec.getModel()).update();
    }
    
    // Modeles JTable
    // ---------------- Modele Medecin ----------------
    public class ModeleJTableMedecin extends DefaultTableModel implements Observer {

        public ModeleJTableMedecin() {
            super(entetePersonnel, listMedecin.size());
        }

        @Override public int getRowCount() { return listMedecin.size(); }
        @Override public int getColumnCount() { return 9; }
        @Override public boolean isCellEditable(int row, int column) { return false; }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case ID: return listMedecin.get(rowIndex).getId();
                case NAME: return listMedecin.get(rowIndex).getPrenom() + " " + listMedecin.get(rowIndex).getNom();
                case BIRTHDATE: return sdf.format(listMedecin.get(rowIndex).getDateNaissance());
                case SEX: return listMedecin.get(rowIndex).getSexe().toString();
                case NATIONAL_NUMBER: return listMedecin.get(rowIndex).getRegistreNat();
                case TEL: return listMedecin.get(rowIndex).getTel();
                case BEGIN_WORK: return sdf.format(listMedecin.get(rowIndex).getDebutTravail());
                case ADDRESS: return listMedecin.get(rowIndex).getAdresse().getAdresse();
                case CP: return listMedecin.get(rowIndex).getAdresse().getCp().getCodePostal();
                default: return "NO DATA";
            }
        }
        
        public void update() {
            fireTableDataChanged();
        }

    }
    // ---------------- Modele Secretaire ----------------
    public class ModeleJTableSecretaire extends DefaultTableModel implements Observer {

        public ModeleJTableSecretaire() {
            super(entetePersonnel, listSecretaire.size());
        }

        @Override public int getRowCount() { return listSecretaire.size(); }
        @Override public int getColumnCount() { return 9; }
        @Override public boolean isCellEditable(int row, int column) { return false; }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case ID: return listSecretaire.get(rowIndex).getId();
                case NAME: return listSecretaire.get(rowIndex).getPrenom() + " " + listSecretaire.get(rowIndex).getNom();
                case BIRTHDATE: return sdf.format(listSecretaire.get(rowIndex).getDateNaissance());
                case SEX: return listSecretaire.get(rowIndex).getSexe().toString();
                case NATIONAL_NUMBER: return listSecretaire.get(rowIndex).getRegistreNat();
                case TEL: return listSecretaire.get(rowIndex).getTel();
                case BEGIN_WORK: return sdf.format(listSecretaire.get(rowIndex).getDebutTravail());
                case ADDRESS: return listSecretaire.get(rowIndex).getAdresse().getAdresse();
                case CP: return listSecretaire.get(rowIndex).getAdresse().getCp().getCodePostal();
                default: return "NO DATA";
            }
        }

        @Override
        public void update() {
            fireTableDataChanged();
        }

    }
    // ---------------- Modele Infirmiere ----------------
    public class ModeleJTableInfirmiere extends DefaultTableModel implements Observer {

        public ModeleJTableInfirmiere() {
            super(entetePersonnel, listInfirmiere.size());
        }

        @Override public int getRowCount() { return listInfirmiere.size(); }
        @Override public int getColumnCount() { return 9; }
        @Override public boolean isCellEditable(int row, int column) { return false; }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case ID: return listInfirmiere.get(rowIndex).getId();
                case NAME: return listInfirmiere.get(rowIndex).getPrenom() + " " + listInfirmiere.get(rowIndex).getNom();
                case BIRTHDATE: return sdf.format(listInfirmiere.get(rowIndex).getDateNaissance());
                case SEX: return listInfirmiere.get(rowIndex).getSexe().toString();
                case NATIONAL_NUMBER: return listInfirmiere.get(rowIndex).getRegistreNat();
                case TEL: return listInfirmiere.get(rowIndex).getTel();
                case BEGIN_WORK: return sdf.format(listInfirmiere.get(rowIndex).getDebutTravail());
                case ADDRESS: return listInfirmiere.get(rowIndex).getAdresse().getAdresse();
                case CP: return listInfirmiere.get(rowIndex).getAdresse().getCp().getCodePostal();
                default: return "NO DATA";
            }
        }
        
        @Override
        public void update() {
            fireTableDataChanged();
        }

    }
    // ---------------- Modele Specialisation ----------------
    public class ModeleJTableSpecialisation extends DefaultTableModel implements Observer {

        public ModeleJTableSpecialisation() {
            super(enteteSpecialisation, listSpecialisation.size());
        }

        @Override public int getRowCount() { return listSpecialisation.size(); }
        @Override public int getColumnCount() { return 3; }
        @Override public boolean isCellEditable(int row, int column) { return false; }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case ID: return listSpecialisation.get(rowIndex).getId();
                case LABEL: return listSpecialisation.get(rowIndex).getLabel();
                case DELAY: return listSpecialisation.get(rowIndex).getDuree();
                default: return "NO DATA";
            }
        }
        
        @Override
        public void update() {
            fireTableDataChanged();
        }

    }
    // ---------------- Modele Specialisation Medecin ----------------
    public class ModeleJTableSpecialisationMedecin extends DefaultTableModel implements Observer {
        
        public ModeleJTableSpecialisationMedecin() {
            super(enteteSpecialisation, listSpecialisation.size());
        }

        @Override public int getRowCount() { return 3; }
        @Override public int getColumnCount() { return 1; }
        @Override public boolean isCellEditable(int row, int column) { return false; }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (rowIndex == 1) {
                
            }
            
            switch (columnIndex) {
                case ID: return listSpecialisation.get(rowIndex).getId();
                case LABEL: return listSpecialisation.get(rowIndex).getLabel();
                case DELAY: return listSpecialisation.get(rowIndex).getDuree();
                default: return "NO DATA";
            }
        }
        
        @Override
        public void update() {
            fireTableDataChanged();
        }
        
    }
    
    // Placement des composants
    private void placementMedecin() {
        GroupLayout panelMedecinListSpecLayout = new GroupLayout(panelMedecinListSpec);
        panelMedecinListSpec.setLayout(panelMedecinListSpecLayout);
        panelMedecinListSpecLayout.setHorizontalGroup(
            panelMedecinListSpecLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelMedecinListSpecLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneMedecinListSpec, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelMedecinListSpecLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btMedecinDeleteSpec)
                    .addComponent(btMedecinAddSpec))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMedecinListSpecLayout.setVerticalGroup(
            panelMedecinListSpecLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelMedecinListSpecLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMedecinListSpecLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPaneMedecinListSpec, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelMedecinListSpecLayout.createSequentialGroup()
                        .addComponent(btMedecinAddSpec, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btMedecinDeleteSpec, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        GroupLayout panelMedecinLayout = new GroupLayout(panelMedecin);
        panelMedecin.setLayout(panelMedecinLayout);
        panelMedecinLayout.setHorizontalGroup(
            panelMedecinLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelMedecinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMedecinLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelMedecinLayout.createSequentialGroup()
                        .addComponent(scrollPaneMedecin, GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                        .addGap(117, 117, 117))
                    .addGroup(panelMedecinLayout.createSequentialGroup()
                        .addComponent(btMedecinUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btMedecinUpdatePlanning)
                        .addGap(18, 18, 18)
                        .addComponent(btMedecinAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btMedecinDelete)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelMedecinLayout.createSequentialGroup()
                        .addComponent(panelMedecinListSpec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelMedecinLayout.setVerticalGroup(
            panelMedecinLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelMedecinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneMedecin, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelMedecinLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btMedecinDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btMedecinAdd, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelMedecinLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btMedecinUpdate, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btMedecinUpdatePlanning, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(panelMedecinListSpec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }
    private void placementSecretaire() {
        GroupLayout panelSecretaireLayout = new GroupLayout(panelSecretaire);
        panelSecretaire.setLayout(panelSecretaireLayout);
        panelSecretaireLayout.setHorizontalGroup(
            panelSecretaireLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelSecretaireLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSecretaireLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, panelSecretaireLayout.createSequentialGroup()
                        .addComponent(scrollPaneSecretaire, GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                        .addGap(117, 117, 117))
                    .addGroup(panelSecretaireLayout.createSequentialGroup()
                        .addComponent(btSecretaireUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btSecretaireAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btSecretaireDelete)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelSecretaireLayout.setVerticalGroup(
            panelSecretaireLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelSecretaireLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneSecretaire, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelSecretaireLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btSecretaireUpdate, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSecretaireAdd, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(btSecretaireDelete, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(215, Short.MAX_VALUE))
        );
    }
    private void placementInfirmiere() {
        GroupLayout panelInfirmiereLayout = new GroupLayout(panelInfirmiere);
        panelInfirmiere.setLayout(panelInfirmiereLayout);
        panelInfirmiereLayout.setHorizontalGroup(
            panelInfirmiereLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelInfirmiereLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfirmiereLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfirmiereLayout.createSequentialGroup()
                        .addComponent(scrollPaneInfirmiere, GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                        .addGap(117, 117, 117))
                    .addGroup(panelInfirmiereLayout.createSequentialGroup()
                        .addComponent(btInfirmiereUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btInfirmiereAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btInfirmiereDelete)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelInfirmiereLayout.setVerticalGroup(
            panelInfirmiereLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelInfirmiereLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneInfirmiere, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelInfirmiereLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btInfirmiereUpdate, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btInfirmiereAdd, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(btInfirmiereDelete, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98))
        );
    }
    private void placementSpecialisation() {
        GroupLayout paneSpecAddLayout = new GroupLayout(paneSpecAdd);
        paneSpecAdd.setLayout(paneSpecAddLayout);
        paneSpecAddLayout.setHorizontalGroup(
            paneSpecAddLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(paneSpecAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneSpecAddLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblSpecAjout, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
                    .addGroup(paneSpecAddLayout.createSequentialGroup()
                        .addGroup(paneSpecAddLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblSpecLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ztSpecLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(paneSpecAddLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lblSpecDuree, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                            .addComponent(ztSpecDuree, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24)
                .addComponent(btSpecAdd, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneSpecAddLayout.setVerticalGroup(
            paneSpecAddLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(paneSpecAddLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSpecAjout)
                .addGap(18, 18, 18)
                .addGroup(paneSpecAddLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblSpecDuree)
                    .addComponent(lblSpecLabel, GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneSpecAddLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ztSpecLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSpecAdd)
                    .addComponent(ztSpecDuree, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout panelSpecialisationLayout = new GroupLayout(panelSpecialisation);
        panelSpecialisation.setLayout(panelSpecialisationLayout);
        panelSpecialisationLayout.setHorizontalGroup(
            panelSpecialisationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelSpecialisationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSpecialisationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelSpecialisationLayout.createSequentialGroup()
                        .addComponent(btSpecUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btSpecDelete))
                    .addComponent(scrollPaneSpec, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
                    .addComponent(paneSpecAdd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(494, Short.MAX_VALUE))
        );
        panelSpecialisationLayout.setVerticalGroup(
            panelSpecialisationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panelSpecialisationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneSpec, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelSpecialisationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btSpecUpdate, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSpecDelete, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(paneSpecAdd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
    }
    private void placementGeneral() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(tabbedPane)
                .addContainerGap())
        );
    }
    
    // Composants à afficher
    private JButton btInfirmiereAdd;
    private JButton btInfirmiereDelete;
    private JButton btInfirmiereUpdate;
    private JButton btMedecinAdd;
    private JButton btMedecinAddSpec;
    private JButton btMedecinDelete;
    private JButton btMedecinDeleteSpec;
    private JButton btMedecinUpdate;
    private JButton btMedecinUpdatePlanning;
    private JButton btSecretaireAdd;
    private JButton btSecretaireDelete;
    private JButton btSecretaireUpdate;
    private JButton btSpecAdd;
    private JButton btSpecDelete;
    private JButton btSpecUpdate;
    private JLabel lblSpecAjout;
    private JLabel lblSpecDuree;
    private JLabel lblSpecLabel;
    private DefaultListModel listModelSpec;
    private JList listMedecinSpec;
    private JPanel paneSpecAdd;
    private JPanel panelInfirmiere;
    private JPanel panelMedecin;
    private JPanel panelMedecinListSpec;
    private JPanel panelSecretaire;
    private JPanel panelSpecialisation;
    private JScrollPane scrollPaneInfirmiere;
    private JScrollPane scrollPaneMedecin;
    private JScrollPane scrollPaneMedecinListSpec;
    private JScrollPane scrollPaneSecretaire;
    private JScrollPane scrollPaneSpec;
    private JTabbedPane tabbedPane;
    private JTable tableInfirmiere;
    private JTable tableMedecin;
    private JTable tableSecretaire;
    private JTable tableSpec;
    private JFormattedTextField ztSpecDuree;
    private JTextField ztSpecLabel;
    private ModeleJTableMedecin modeleMedecin;
    private ModeleJTableSecretaire modeleSecretaire;
    private ModeleJTableInfirmiere modeleInfirmiere;
    private ModeleJTableSpecialisation modeleSpecialisation;
    
    // Colonnes dans les JTable
    private static final int ID = 0;
    private static final int NAME = 1;
    private static final int BIRTHDATE = 2;
    private static final int SEX = 3;
    private static final int NATIONAL_NUMBER = 4;
    private static final int TEL = 5;
    private static final int BEGIN_WORK = 6;
    private static final int ADDRESS = 7;
    private static final int CP = 8;
    private static final int LABEL = 1;
    private static final int DELAY = 2;
    
    // Autres attributs
    private List<Medecin> listMedecin;
    private List<Secretaire> listSecretaire;
    private List<Infirmiere> listInfirmiere;
    private List<Specialisation> listSpecialisation;

    private Vector<String> entetePersonnel;
    private Vector<String> enteteSpecialisation;
    private SimpleDateFormat sdf;
    private Actions actions;
    
    private class Actions {
        //----------------------------------------------------------------------
        //-----------------------------Medecin----------------------------------
        //----------------------------------------------------------------------
        public void btMedecinUpdate(ActionEvent evt) { // Bouton update Medecin
            if (tableMedecin.getSelectedRowCount() != 1) {
                JOptionPane.showMessageDialog(null, "Please select one and only one physician");
            } else {
                Medecin med = listMedecin.get(tableMedecin.getSelectedRow());
                ctrlAdmin.showViewModifPersonnel(CtrlAdmin.TYPE_MEDECIN, med);
            }
        }
        
        public void btMedecinAdd(ActionEvent evt) { // Affiche la fenêtre d'ajout d'un Medecin
            ctrlAdmin.showViewModifPersonnel(CtrlAdmin.TYPE_MEDECIN, null);
        }
        
        public void btMedecinUpdatePlanning(ActionEvent evt) { // Bouton update planning Medecin
            if (tableMedecin.getSelectedRowCount() != 1) {
                JOptionPane.showMessageDialog(null, "Please select one and only one physician");
            } else {
                Medecin med = listMedecin.get(tableMedecin.getSelectedRow());
                JOptionPane.showMessageDialog(null, "This physician called: " + med.getNom() + " " + med.getPrenom());
            }
        }
        
        public void btMedecinDeleteSpec(ActionEvent evt) { // Bouton suppression d'une spécialisation
            if (tableMedecin.getSelectedRowCount() != 1) {
                JOptionPane.showMessageDialog(null, "Please select one and only one physician");
            } else {
                Medecin med = listMedecin.get(tableMedecin.getSelectedRow());
                JOptionPane.showMessageDialog(null, "This physician called: " + med.getNom() + " " + med.getPrenom());
            }
        }
        
        public void btMedecinDelete(ActionEvent evt) { // Supprime un médecin de la DB
            if (tableMedecin.getSelectedRowCount() != 1) {
                JOptionPane.showMessageDialog(null, "Please select one and only one physician");
            } else {
                Medecin med = listMedecin.get(tableMedecin.getSelectedRow());
                ctrlAdmin.deleteMedecin(med);
            }
        }
        
        //----------------------------------------------------------------------
        //---------------------------Secretaire---------------------------------
        //----------------------------------------------------------------------
        public void btSecretaireUpdate(ActionEvent evt) {
            if (tableSecretaire.getSelectedRowCount() != 1) {
                JOptionPane.showMessageDialog(null, "Please select one and only one physician");
            } else {
                Secretaire sec = listSecretaire.get(tableSecretaire.getSelectedRow());
                ctrlAdmin.showViewModifPersonnel(CtrlAdmin.TYPE_SECRETAIRE, sec);
            }
        }
        
        public void btSecretaireAdd(ActionEvent evt) {
            ctrlAdmin.showViewModifPersonnel(CtrlAdmin.TYPE_SECRETAIRE, null);
        }

        public void btSecretaireUpdatePlanning(ActionEvent evt) {
            if (tableMedecin.getSelectedRowCount() != 1) {
                JOptionPane.showMessageDialog(null, "Please select one and only one physician");
            } else {
                Medecin med = listMedecin.get(tableMedecin.getSelectedRow());
                JOptionPane.showMessageDialog(null, "This physician called: " + med.getNom() + " " + med.getPrenom());
            }
        }
        
        public void btSecretaireDelete(ActionEvent evt) {
            if (tableSecretaire.getSelectedRowCount() != 1) {
                JOptionPane.showMessageDialog(null, "Please select one and only one physician");
            } else {
                Secretaire sec = listSecretaire.get(tableSecretaire.getSelectedRow());
                ctrlAdmin.deleteSecretaire(sec);
            }
        }
        
        //----------------------------------------------------------------------
        //---------------------------Infirmiere---------------------------------
        //----------------------------------------------------------------------
        public void btInfirmiereUpdate(ActionEvent evt) {
            if (tableInfirmiere.getSelectedRowCount() != 1) {
                JOptionPane.showMessageDialog(null, "Please select one and only one physician");
            } else {
                Infirmiere inf = listInfirmiere.get(tableInfirmiere.getSelectedRow());
                ctrlAdmin.showViewModifPersonnel(CtrlAdmin.TYPE_INFIRMIERE, inf);
            }
        }
        
        public void btInfirmiereAdd(ActionEvent evt) {
            ctrlAdmin.showViewModifPersonnel(CtrlAdmin.TYPE_INFIRMIERE, null);
        }

        public void btInfirmiereUpdatePlanning(ActionEvent evt) {
            if (tableMedecin.getSelectedRowCount() != 1) {
                JOptionPane.showMessageDialog(null, "Please select one and only one physician");
            } else {
                Medecin med = listMedecin.get(tableMedecin.getSelectedRow());
                JOptionPane.showMessageDialog(null, "This physician called: " + med.getNom() + " " + med.getPrenom());
            }
        }
        
        public void btInfirmiereDelete(ActionEvent evt) {
            if (tableMedecin.getSelectedRowCount() != 1) {
                JOptionPane.showMessageDialog(null, "Please select one and only one physician");
            } else {
                Medecin med = listMedecin.get(tableMedecin.getSelectedRow());
                JOptionPane.showMessageDialog(null, "This physician called: " + med.getNom() + " " + med.getPrenom());
            }
        }
        
        //----------------------------------------------------------------------
        //-------------------------Specialisation-------------------------------
        //----------------------------------------------------------------------
        public void btSpecUpdate(ActionEvent evt) {
            if (tableMedecin.getSelectedRowCount() != 1) {
                JOptionPane.showMessageDialog(null, "Please select one and only one physician");
            } else {
                Medecin med = listMedecin.get(tableMedecin.getSelectedRow());
                JOptionPane.showMessageDialog(null, "This physician called: " + med.getNom() + " " + med.getPrenom());
            }
        }

        public void btSpecDelete(ActionEvent evt) {
            if (tableMedecin.getSelectedRowCount() != 1) {
                JOptionPane.showMessageDialog(null, "Please select one and only one physician");
            } else {
                Medecin med = listMedecin.get(tableMedecin.getSelectedRow());
                JOptionPane.showMessageDialog(null, "This physician called: " + med.getNom() + " " + med.getPrenom());
            }
        }
        
        public void btSpecAdd(ActionEvent evt) {
            if (tableMedecin.getSelectedRowCount() != 1) {
                JOptionPane.showMessageDialog(null, "Please select one and only one physician");
            } else {
                Medecin med = listMedecin.get(tableMedecin.getSelectedRow());
                JOptionPane.showMessageDialog(null, "This physician called: " + med.getNom() + " " + med.getPrenom());
            }
        }

        private void jTableClick() {
            listModelSpec.removeAllElements();
            Medecin m = listMedecin.get(tableMedecin.getSelectedRow());
            if (m.getSpecialisation() != null) {
                for (Specialisation s : m.getSpecialisation()) {
                    listModelSpec.addElement(s);
                }
            }
        }
    }
}
