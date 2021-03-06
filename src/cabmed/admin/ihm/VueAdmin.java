package cabmed.admin.ihm;

import cabmed.admin.ctrl.CtrlAdmin;
import cabmed.model.Infirmiere;
import cabmed.model.Medecin;
import cabmed.model.Secretaire;
import cabmed.model.Specialisation;
import cabmed.ressources.Observer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Initialisation des attributs
        sdf = ctrlAdmin.getSdf();
        actions = new Actions();
        entetePersonnel = new Vector();
        entetePersonnel.add("ID"); entetePersonnel.add("Nom"); entetePersonnel.add("Date Naissance");
        entetePersonnel.add("Sexe"); entetePersonnel.add("Num. National"); entetePersonnel.add("Tel.");
        entetePersonnel.add("Début Travail"); entetePersonnel.add("Adresse"); entetePersonnel.add("CP");
        enteteSpecialisation = new Vector();
        enteteSpecialisation.add("ID"); enteteSpecialisation.add("Label"); enteteSpecialisation.add("Durée");
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
        listModelSpec = new DefaultListModel<>();
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
        
        // Initialisation de la vue
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setTitle("Cabmed - Administration");
        setResizable(false);

        // -------------------- Debut Medecin --------------------
        tabbedPane.setName("Médecin");
        tableMedecin.setModel(modeleMedecin);
        tableMedecin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                actions.jTableClick(evt);
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
            @Override
            public void actionPerformed(ActionEvent evt) {
                actions.btMedecinDelete(evt);
            }
        });
        btMedecinAdd.setText("Ajout Médecin");
        btMedecinAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                actions.btMedecinAdd(evt);
            }
        });
        panelMedecinListSpec.setBorder(BorderFactory.createTitledBorder("Liste des Specialisations"));
        btMedecinDeleteSpec.setText("Retirer Specialisation");
        btMedecinDeleteSpec.setFocusable(false);
        btMedecinDeleteSpec.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btMedecinDeleteSpec.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btMedecinDeleteSpec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                actions.btMedecinDeleteSpec(evt);
            }
        });
        btMedecinAddSpec.setText("Ajout Specialisation");
        btMedecinAddSpec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                actions.btMedecinAddSpec(evt);
            }
        });
        listMedecinSpec.setBorder(BorderFactory.createEtchedBorder());
        listMedecinSpec.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listMedecinSpec.setToolTipText("");
        scrollPaneMedecinListSpec.setViewportView(listMedecinSpec);
        
        // Placement des composants médecin
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
        
        tabbedPane.addTab("Médecins", panelMedecin);

        // -------------------- Debut Secretaire --------------------
        tableSecretaire.setModel(modeleSecretaire);
        scrollPaneSecretaire.setViewportView(tableSecretaire);
        btSecretaireDelete.setBackground(new java.awt.Color(255, 0, 0));
        btSecretaireDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btSecretaireDelete.setForeground(new java.awt.Color(255, 255, 255));
        btSecretaireDelete.setText("DELETE");
        btSecretaireDelete.setToolTipText("");
        btSecretaireDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                actions.btSecretaireDelete(evt);
            }
        });
        btSecretaireUpdate.setText("Modification");
        btSecretaireUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                actions.btSecretaireUpdate(evt);
            }
        });
        btSecretaireAdd.setText("Ajout Secrétaire");
        btSecretaireAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                actions.btSecretaireAdd(e);
            }
        });
        
        // Placement des composants secrétaire
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
        
        tabbedPane.addTab("Secrétaire", panelSecretaire);

        // -------------------- Debut Infirmiere --------------------
        tableInfirmiere.setModel(modeleInfirmiere);
        scrollPaneInfirmiere.setViewportView(tableInfirmiere);
        btInfirmiereUpdate.setText("Modification");
        btInfirmiereUpdate.addActionListener(new ActionListener() {
            @Override
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
            @Override
            public void actionPerformed(ActionEvent evt) {
                actions.btInfirmiereDelete(evt);
            }
        });
        btInfirmiereAdd.setText("Ajout Infirmière");
        btInfirmiereAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                actions.btInfirmiereAdd(e);
            }
        });
        
        // Placement des infirmières
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
        
        tabbedPane.addTab("Infirmière", panelInfirmiere);

        // -------------------- Debut Specialisation --------------------
        tableSpec.setModel(modeleSpecialisation);
        scrollPaneSpec.setViewportView(tableSpec);
        btSpecUpdate.setText("Modification");
        btSpecUpdate.addActionListener(new ActionListener() {
            @Override
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
            @Override
            public void actionPerformed(ActionEvent evt) {
                actions.btSpecDelete(evt);
            }
        });
        paneSpecAdd.setBorder(BorderFactory.createTitledBorder("Ajout Specialisation"));
        btSpecAdd.setText("Ajout");
        btSpecAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                actions.btSpecAdd(evt);
            }
        });
        ztSpecDuree.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        lblSpecDuree.setText("Durée");
        lblSpecLabel.setText("Label");
        
        // Placement des spécialisations
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
        
        tabbedPane.addTab("Specialisation", panelSpecialisation);

        // Initialisation des JTable
        if (tableMedecin.getColumnModel().getColumnCount() > 0) {
            tableMedecin.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableMedecin.getColumnModel().getColumn(1).setPreferredWidth(90);
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
            tableSecretaire.getColumnModel().getColumn(1).setPreferredWidth(90);
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
            tableInfirmiere.getColumnModel().getColumn(1).setPreferredWidth(90);
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
        
        // Placement général
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
        
        pack();
    }

    @Override
    public void update() {
        ((Observer)tableMedecin.getModel()).update();
        ((Observer)tableSecretaire.getModel()).update();
        ((Observer)tableInfirmiere.getModel()).update();
        ((Observer)tableSpec.getModel()).update();
    }

    public void updateListSpecPourMedecin() {
        listModelSpec.removeAllElements();
        for (Specialisation s : ctrlAdmin.getListMedecin().get(tableMedecin.getSelectedRow()).getSpecialisation()) {
            listModelSpec.addElement(s);
        }
    }
    
    // Modeles JTable
    // ---------------- Modele Medecin ----------------
    public class ModeleJTableMedecin extends DefaultTableModel implements Observer {

        public ModeleJTableMedecin() {
            super(entetePersonnel, ctrlAdmin.getListMedecin().size());
        }

        @Override public int getRowCount() { return ctrlAdmin.getListMedecin().size(); }
        @Override public int getColumnCount() { return 9; }
        @Override public boolean isCellEditable(int row, int column) { return false; }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case ID: return ctrlAdmin.getListMedecin().get(rowIndex).getId();
                case NAME: return ctrlAdmin.getListMedecin().get(rowIndex).getPrenom() + " " + ctrlAdmin.getListMedecin().get(rowIndex).getNom();
                case BIRTHDATE: return sdf.format(ctrlAdmin.getListMedecin().get(rowIndex).getDateNaissance());
                case SEX: return ctrlAdmin.getListMedecin().get(rowIndex).getSexe().toString();
                case NATIONAL_NUMBER: return ctrlAdmin.getListMedecin().get(rowIndex).getRegistreNat();
                case TEL: return ctrlAdmin.getListMedecin().get(rowIndex).getTel();
                case BEGIN_WORK: return sdf.format(ctrlAdmin.getListMedecin().get(rowIndex).getDebutTravail());
                case ADDRESS: return ctrlAdmin.getListMedecin().get(rowIndex).getAdresse().getAdresse();
                case CP: return ctrlAdmin.getListMedecin().get(rowIndex).getAdresse().getCp().getCodePostal();
                default: return "NO DATA";
            }
        }
        
        @Override
        public void update() {
            
            fireTableDataChanged();
        }

    }
    // ---------------- Modele Secretaire ----------------
    public class ModeleJTableSecretaire extends DefaultTableModel implements Observer {

        public ModeleJTableSecretaire() {
            super(entetePersonnel, ctrlAdmin.getListSecretaire().size());
        }

        @Override public int getRowCount() { return ctrlAdmin.getListSecretaire().size(); }
        @Override public int getColumnCount() { return 9; }
        @Override public boolean isCellEditable(int row, int column) { return false; }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case ID: return ctrlAdmin.getListSecretaire().get(rowIndex).getId();
                case NAME: return ctrlAdmin.getListSecretaire().get(rowIndex).getPrenom() + " " + ctrlAdmin.getListSecretaire().get(rowIndex).getNom();
                case BIRTHDATE: return sdf.format(ctrlAdmin.getListSecretaire().get(rowIndex).getDateNaissance());
                case SEX: return ctrlAdmin.getListSecretaire().get(rowIndex).getSexe().toString();
                case NATIONAL_NUMBER: return ctrlAdmin.getListSecretaire().get(rowIndex).getRegistreNat();
                case TEL: return ctrlAdmin.getListSecretaire().get(rowIndex).getTel();
                case BEGIN_WORK: return sdf.format(ctrlAdmin.getListSecretaire().get(rowIndex).getDebutTravail());
                case ADDRESS: return ctrlAdmin.getListSecretaire().get(rowIndex).getAdresse().getAdresse();
                case CP: return ctrlAdmin.getListSecretaire().get(rowIndex).getAdresse().getCp().getCodePostal();
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
            super(entetePersonnel, ctrlAdmin.getListInfirmiere().size());
        }

        @Override public int getRowCount() { return ctrlAdmin.getListInfirmiere().size(); }
        @Override public int getColumnCount() { return 9; }
        @Override public boolean isCellEditable(int row, int column) { return false; }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case ID: return ctrlAdmin.getListInfirmiere().get(rowIndex).getId();
                case NAME: return ctrlAdmin.getListInfirmiere().get(rowIndex).getPrenom() + " " + ctrlAdmin.getListInfirmiere().get(rowIndex).getNom();
                case BIRTHDATE: return sdf.format(ctrlAdmin.getListInfirmiere().get(rowIndex).getDateNaissance());
                case SEX: return ctrlAdmin.getListInfirmiere().get(rowIndex).getSexe().toString();
                case NATIONAL_NUMBER: return ctrlAdmin.getListInfirmiere().get(rowIndex).getRegistreNat();
                case TEL: return ctrlAdmin.getListInfirmiere().get(rowIndex).getTel();
                case BEGIN_WORK: return sdf.format(ctrlAdmin.getListInfirmiere().get(rowIndex).getDebutTravail());
                case ADDRESS: return ctrlAdmin.getListInfirmiere().get(rowIndex).getAdresse().getAdresse();
                case CP: return ctrlAdmin.getListInfirmiere().get(rowIndex).getAdresse().getCp().getCodePostal();
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
            super(enteteSpecialisation, ctrlAdmin.getListSpecialisation().size());
        }

        @Override public int getRowCount() { return ctrlAdmin.getListSpecialisation().size(); }
        @Override public int getColumnCount() { return 3; }
        @Override public boolean isCellEditable(int row, int column) { return false; }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case ID: return ctrlAdmin.getListSpecialisation().get(rowIndex).getId();
                case LABEL: return ctrlAdmin.getListSpecialisation().get(rowIndex).getLabel();
                case DELAY: return ctrlAdmin.getListSpecialisation().get(rowIndex).getDuree();
                default: return "NO DATA";
            }
        }
        
        @Override
        public void update() {
            fireTableDataChanged();
        }

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
    private Vector<String> entetePersonnel;
    private Vector<String> enteteSpecialisation;
    private SimpleDateFormat sdf;
    private Actions actions;
    
    private class Actions {
        
        private void medecinUnique() {
            JOptionPane.showMessageDialog(null, "Veuillez choisir un et un seul médecin");
        }
        
        private void specialisationUnique() {
            JOptionPane.showMessageDialog(null, "Veuillez choisir une et une seule spécialisation");
        }
        
        private void infirmiereUnique() {
            JOptionPane.showMessageDialog(null, "Veuillez choisir une et une seule infirmière");
        }
        
        private void secretaireUnique() {
            JOptionPane.showMessageDialog(null, "Veuillez choisir une et une seule secrétaire");
        }
        
        //----------------------------------------------------------------------
        //-----------------------------Medecin----------------------------------
        //----------------------------------------------------------------------
        public void btMedecinUpdate(ActionEvent evt) { // Bouton update Medecin
            if (tableMedecin.getSelectedRowCount() != 1) { // Si plus d'un élément selectionné dans la JTable
                medecinUnique();
            } else { // Si un seul élément selectionné
                Medecin med = ctrlAdmin.getListMedecin().get(tableMedecin.getSelectedRow());
                ctrlAdmin.showViewModifPersonnel(CtrlAdmin.TYPE_MEDECIN, med);
            }
        }
        
        public void btMedecinAdd(ActionEvent evt) { // Affiche la fenêtre d'ajout d'un Medecin
            ctrlAdmin.showViewModifPersonnel(CtrlAdmin.TYPE_MEDECIN, null);
        }
        
        public void btMedecinUpdatePlanning(ActionEvent evt) { // Bouton update planning Medecin
            if (tableMedecin.getSelectedRowCount() != 1) { // Si plus d'un élément selectionné dans la JTable
                medecinUnique();
            } else { // Si un seul élément selectionné
                Medecin med = ctrlAdmin.getListMedecin().get(tableMedecin.getSelectedRow());
                ctrlAdmin.showViewModifPlanning(med);
            }
        }
        
        public void btMedecinDeleteSpec(ActionEvent evt) { // Bouton suppression d'une spécialisation pour un médecin
            if (listMedecinSpec.getSelectedValuesList().size() != 1) { // Si plus d'un élément selectionné dans la JList
                specialisationUnique();
            } else { // Si un seul élément selectionné
                Medecin med = ctrlAdmin.getListMedecin().get(tableMedecin.getSelectedRow());
                int option = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir retirer cette spécialisation à ce médecin?",
                        "Retirer une spécialisation", JOptionPane.YES_NO_OPTION);
                if (option == 0) { // Si ok
                    ctrlAdmin.removeSpecialisationPourMedecin(med, listMedecinSpec.getSelectedIndex());
                    listModelSpec.removeAllElements();
                    for (Specialisation s : med.getSpecialisation()) {
                        listModelSpec.addElement(s);
                    }
                }
            }
        }
        
        public void btMedecinDelete(ActionEvent evt) { // Supprime un médecin de la DB
            if (tableMedecin.getSelectedRowCount() != 1) { // Si plus d'un élément selectionné dans la JTable
                medecinUnique();
            } else { // Si un seul élément selectionné
                int option = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer ce médecin?",
                        "Suppression d'un médecin", JOptionPane.YES_NO_OPTION);
                if (option == 0) {
                    Medecin med = ctrlAdmin.getListMedecin().get(tableMedecin.getSelectedRow());
                    if (ctrlAdmin.deleteMedecin(med)) {
                        listModelSpec.removeAllElements();
                    }
                }
            }
        }
        
        private void btMedecinAddSpec(ActionEvent evt) { // Pour ajouter une spécialisation à un médecin
            if (tableMedecin.getSelectedRowCount() != 1) { // Si plus ou moins d'un élément selectionné dans la JTable
                medecinUnique();
            } else { // Si un seul élément selectionné
                ctrlAdmin.showViewAddSpec(ctrlAdmin.getListMedecin().get(tableMedecin.getSelectedRow()));
            }
        }
        
        //----------------------------------------------------------------------
        //---------------------------Secretaire---------------------------------
        //----------------------------------------------------------------------
        public void btSecretaireUpdate(ActionEvent evt) {
            if (tableSecretaire.getSelectedRowCount() != 1) { // Si plus d'un élément selectionné dans la JTable
                secretaireUnique();
            } else { // Si un seul élément selectionné
                Secretaire sec = ctrlAdmin.getListSecretaire().get(tableSecretaire.getSelectedRow());
                ctrlAdmin.showViewModifPersonnel(CtrlAdmin.TYPE_SECRETAIRE, sec);
            }
        }
        
        public void btSecretaireAdd(ActionEvent evt) {
            ctrlAdmin.showViewModifPersonnel(CtrlAdmin.TYPE_SECRETAIRE, null);
        }
        
        public void btSecretaireDelete(ActionEvent evt) {
            if (tableSecretaire.getSelectedRowCount() != 1) { // Si plus d'un élément selectionné dans la JTable
                secretaireUnique();
            } else { // Si un seul élément selectionné
                int option = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer cette secrétaire?",
                        "Suppression d'une secrétaire", JOptionPane.YES_NO_OPTION);
                if (option == 0) {
                    Secretaire sec = ctrlAdmin.getListSecretaire().get(tableSecretaire.getSelectedRow());
                    ctrlAdmin.deleteSecretaire(sec);
                }
            }
        }
        
        //----------------------------------------------------------------------
        //---------------------------Infirmiere---------------------------------
        //----------------------------------------------------------------------
        public void btInfirmiereUpdate(ActionEvent evt) {
            if (tableInfirmiere.getSelectedRowCount() != 1) { // Si plus d'un élément selectionné dans la JTable
                infirmiereUnique();
            } else { // Si un seul élément selectionné
                Infirmiere inf = ctrlAdmin.getListInfirmiere().get(tableInfirmiere.getSelectedRow());
                ctrlAdmin.showViewModifPersonnel(CtrlAdmin.TYPE_INFIRMIERE, inf);
            }
        }
        
        public void btInfirmiereAdd(ActionEvent evt) {
            ctrlAdmin.showViewModifPersonnel(CtrlAdmin.TYPE_INFIRMIERE, null);
        }
        
        public void btInfirmiereDelete(ActionEvent evt) {
            if (tableInfirmiere.getSelectedRowCount() != 1) { // Si plus d'un élément selectionné dans la JTable
                infirmiereUnique();
            } else { // Si un seul élément selectionné
                int option = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer cette infirmière?",
                        "Suppression d'une infirmière", JOptionPane.YES_NO_OPTION);
                if (option == 0) {
                    Infirmiere inf = ctrlAdmin.getListInfirmiere().get(tableInfirmiere.getSelectedRow());
                    ctrlAdmin.deleteNurse(inf);
                }
                
            }
        }
        
        //----------------------------------------------------------------------
        //-------------------------Specialisation-------------------------------
        //----------------------------------------------------------------------
        public void btSpecUpdate(ActionEvent evt) {
            if (tableSpec.getSelectedRowCount() != 1) { // Si plus d'un élément selectionné dans la JTable
                specialisationUnique();
            } else { // Si un seul élément selectionné
                Specialisation spec = ctrlAdmin.getListSpecialisation().get(tableSpec.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Specialization selected: " + spec.getLabel());
            }
        }

        public void btSpecDelete(ActionEvent evt) {
            if (tableSpec.getSelectedRowCount() != 1) { // Si plus d'un élément selectionné dans la JTable
                specialisationUnique();
            } else { // Si un seul élément selectionné
                int option = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer cette spécialisation?",
                        "Suppression d'une specialisation", JOptionPane.YES_NO_OPTION);
                if (option == 0) {
                    Specialisation spec = ctrlAdmin.getListSpecialisation().get(tableSpec.getSelectedRow());
                    ctrlAdmin.deleteSpecialisation(spec);
                }
            }
        }
        
        public void btSpecAdd(ActionEvent evt) {
            if (tableSpec.getSelectedRowCount() != 1) { // Si plus d'un élément selectionné dans la JTable
                specialisationUnique();
            } else { // Si un seul élément selectionné
                Specialisation spec = ctrlAdmin.getListSpecialisation().get(tableSpec.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Specialisation choisie: " + spec.getLabel());
            }
        }

        //----------------------------------------------------------------------
        //------------------------------Autre-----------------------------------
        //----------------------------------------------------------------------
        private void jTableClick(MouseEvent evt) {
            listModelSpec.removeAllElements();
            Medecin m = ctrlAdmin.getListMedecin().get(tableMedecin.getSelectedRow());
            for (Specialisation s : m.getSpecialisation()) {
                listModelSpec.addElement(s);
            }
        }

    }
}