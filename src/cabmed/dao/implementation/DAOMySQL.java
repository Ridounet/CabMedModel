package cabmed.dao.implementation;

import cabmed.dao.ICpDAO;
import cabmed.dao.IMedecinDAO;
import cabmed.dao.IPatientDAO;
import cabmed.dao.IPersonnelDAO;
import cabmed.dao.IPlanningDAO;
import cabmed.dao.IRdvDAO;
import cabmed.dao.ISpecialisationDAO;
import cabmed.model.Administrateur;
import cabmed.model.Adresse;
import cabmed.model.Cp;
import cabmed.model.Disponibilite;
import cabmed.model.Infirmiere;
import cabmed.model.Jour;
import cabmed.model.Medecin;
import cabmed.model.Mutualite;
import cabmed.model.Patient;
import cabmed.model.Personnel;
import cabmed.model.Planning;
import cabmed.model.Prescription;
import cabmed.model.Rdv;
import cabmed.model.Secretaire;
import cabmed.model.Sexe;
import cabmed.model.Specialisation;
import cabmed.model.StatutRdv;
import cabmed.model.Tranche;
import cabmed.ressources.Constantes;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DAOMySQL implements IMedecinDAO, IPersonnelDAO, ISpecialisationDAO, IPatientDAO, IPlanningDAO, IRdvDAO {
    
    private static DAOMySQL instance;
    
    public static DAOMySQL getInstance() {
        if (instance == null) {
             instance = new DAOMySQL();
        }
        return instance;
    }
    
    private DAOMySQL() {
        cpDAO = new CpDAO();
        medecinDAO = new MedecinDAO();
        patientDAO = new PatientDAO();
        personnelDAO = new PersonnelDAO();
        planningDAO = new PlanningDAO();
        specialisationDAO = new SpecialisationDAO();
        rdvDAO = new RdvDAO();
        initDB();
    }
    
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("cabmed");
    private static EntityManager em = null;
    public static EntityManager getEntityManager() { if (em == null) em = emf.createEntityManager(); return em; }
    
    private final ICpDAO cpDAO;
    private final IMedecinDAO medecinDAO;
    private final IPatientDAO patientDAO;
    private final IPersonnelDAO personnelDAO;
    private final IPlanningDAO planningDAO;
    private final ISpecialisationDAO specialisationDAO;
    private final IRdvDAO rdvDAO;
    
    
    
    // CRUD Personne
    @Override
    public boolean savePatient(Patient patient) {
        return patientDAO.savePatient(patient);
    }
    
    public static boolean saveMedecin(Medecin medecin, Planning planning) {
        
        return true;
    }
    
    // CRUD Cp
    public List<Cp> getListCp() {
        return cpDAO.getListCp();
    }
    
    public static List<Cp> getListCpByCodePostal(int codePostal) {
        
        return null;
    }
    
    // CRUD Planning
    public static boolean savePlanning(Planning planning) {
        
        return true;
    }
    
    // CRUD Général
    public Administrateur loginAdmin(String login, String password) {
        Administrateur result;
        try {
            result = (Administrateur) getEntityManager().createQuery("SELECT a FROM Administrateur a "
                + "WHERE a.email = '" + login + "' AND a.password = '" + password + "' AND a.visible = " + Constantes.VISIBLE).getSingleResult();
        } catch(Exception e) {
            result = null;
        }
        return result;
    }
    public Medecin loginMedecin(String login, String password) {
        try {
            System.out.println("début try dans login medecin");
            Medecin personne = (Medecin) getEntityManager().createQuery("SELECT m FROM Medecin m "
                + "WHERE m.email = '" + login + "' AND m.password = '" + password + "' AND m.visible = " + Constantes.VISIBLE).getSingleResult();
            System.out.println("après requete JPQL dans login medecin");
            return personne;
        } catch(Exception e) {
            System.out.println("dans catch dans login medecin");
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Secretaire loginSecretaire(String login, String password) {
        try {
            System.out.println("début try dans login secretaire");
            Secretaire personne = (Secretaire) getEntityManager().createQuery("SELECT s FROM Secretaire s "
                + "WHERE s.email = '" + login + "' AND s.password = '" + password + "' AND s.visible = " + Constantes.VISIBLE).getSingleResult();
            System.out.println("apres requete JPQL");
            return personne;
        } catch(Exception e) {
            System.out.println("dans catch dans login secretaire");
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Patient loginPatient(String login, String password) {
        Patient result;
        try {
            result = (Patient) getEntityManager().createQuery("SELECT p FROM Patient p "
                + "WHERE p.email = '" + login + "' AND p.password = '" + password + "' AND p.visible = " + Constantes.VISIBLE).getSingleResult();
        } catch(Exception e) {
            result = null;
        }
        return result;
    }
    public Infirmiere loginInfirmiere(String login, String password) {
        Infirmiere result;
        try {
            result = (Infirmiere) getEntityManager().createQuery("SELECT i FROM Infirmiere i "
                + "WHERE i.email = '" + login + "' AND i.password = '" + password + "' AND i.visible = " + Constantes.VISIBLE).getSingleResult();
        } catch(Exception e) {
            result = null;
        }
        return result;
    }
    
    @Override
    public boolean addMedecin(Medecin medecin) {
        return medecinDAO.addMedecin(medecin);
    }

    @Override
    public boolean deleteMedecin(Medecin med) {
        return medecinDAO.deleteMedecin(med);
    }

    @Override
    public boolean saveMedecin(Medecin medecin) {
        return medecinDAO.saveMedecin(medecin);
    }
    
    @Override
    public boolean addSpecialisationAMedecin(Medecin medecin) {
        return medecinDAO.addSpecialisationAMedecin(medecin);
    }
    
    @Override
    public boolean removeSpecialisationPourMedecin(Medecin med, int index) {
        return medecinDAO.removeSpecialisationPourMedecin(med, index);
    }

    @Override
    public boolean addInfirmiere(Infirmiere infirmiere) {
        return personnelDAO.addInfirmiere(infirmiere);
    }

    @Override
    public boolean addSecretaire(Secretaire secretaire) {
        return personnelDAO.addSecretaire(secretaire);
    }

    @Override
    public boolean savePersonnel(Personnel personne) {
        return personnelDAO.savePersonnel(personne);
    }

    @Override
    public boolean deleteSecretaire(Secretaire secretaire) {
        return personnelDAO.deleteSecretaire(secretaire);
    }
    
    @Override
    public boolean deleteInfirmiere(Infirmiere infirmiere) {
        return personnelDAO.deleteInfirmiere(infirmiere);
    }

    @Override
    public List<Medecin> getListMedecin() {
        return medecinDAO.getListMedecin();
    }
    
    @Override
    public List<Secretaire> getListSecretaire() {
        return personnelDAO.getListSecretaire();
    }

    @Override
    public List<Infirmiere> getListInfirmiere() {
        return personnelDAO.getListInfirmiere();
    }

    @Override
    public List<Specialisation> getListSpecialisation() {
        return specialisationDAO.getListSpecialisation();
    }
    
    @Override
    public boolean deleteSpecialisation(Specialisation specialisation) {
        return specialisationDAO.deleteSpecialisation(specialisation);
    }

    @Override
    public Patient getPatientByRegistreNat(String registreNat) {
        return patientDAO.getPatientByRegistreNat(registreNat);
    }
    
    @Override
    public List<Rdv> getRdvPatient(Patient patient) {
        return rdvDAO.getRdvPatient(patient);
    }
    
    @Override
    public boolean updateRdv(Rdv rdv) {
        return rdvDAO.updateRdv(rdv);
    }
    
    @Override
    public Rdv getRdvParId(int idRdv) {
        return rdvDAO.getRdvParId(idRdv);
    }
    
    @Override
    public void getRdvMedecin(List<Medecin> listMedecin) {
        medecinDAO.getRdvMedecin(listMedecin);
    }
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        initDB();
    }
    
    public static void initDB() {
        em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(cp1); em.persist(cp2); em.persist(cp3); em.persist(cp4); em.persist(cp5);
        em.persist(cp6); em.persist(cp7); em.persist(cp8); em.persist(cp9); em.persist(cp10);
        tx.commit();

        tx.begin();
        p1.setRemarques("Ce patient est atteint d'un cancer du cerveau\nCe patient suit régulièrement un psychologue pour sa phobie de l'eau...");
        em.persist(i1); em.persist(m1); em.persist(i2); em.persist(m4); em.persist(a1);
        em.persist(p1); em.persist(s1); em.persist(m3); em.persist(s2); em.persist(m2);
        em.persist(s3); em.persist(i4); em.persist(i3); em.persist(s4);
        tx.commit();
        
        tx.begin();
        em.persist(sp1); em.persist(sp2); em.persist(sp3);
        tx.commit();
        
        
        
//        tx.begin();
        mapDisponibilite.put(Jour.LUNDI, dis1);
        mapDisponibilite.put(Jour.MARDI, dis2);
        mapDisponibilite.put(Jour.MERCREDI, dis3);
        mapDisponibilite.put(Jour.JEUDI, dis4);
        mapDisponibilite.put(Jour.VENDREDI, dis5);
//        em.persist(dis1); em.persist(dis2); em.persist(dis3); em.persist(dis4); em.persist(dis5);
//        tx.commit();
        
        tx.begin();
        Planning planning = new Planning(m1);
        planning.setDisponibilite(mapDisponibilite);
        em.persist(planning);
        tx.commit();
        
        tx.begin();
        // Premier rdv clôturé mais sans prescription
        Rdv rdv1 = new Rdv(new Date("18/02/2014"), p1, m4, sp1, StatutRdv.CLOTURE, Tranche.H1130);
        // Deuxième rdv clôturé avec 3 prescriptions différentes
        Rdv rdv2 = new Rdv(new Date("20/05/2014"), p1, m3, sp3, StatutRdv.CLOTURE, Tranche.H1500);
        rdv2.setRemarque("Ce patient est Schysophrène");
        List<Prescription> listPres1 = new ArrayList<Prescription>();
        listPres1.add(new Prescription("Médicament 1", "Matin et soir", 4));
        listPres1.add(new Prescription("Médicament 3", "4x par jout", 10));
        listPres1.add(new Prescription("Médicament 7", "Avant de dormir", 2));
        rdv2.setPrescriptions(listPres1);
        // Troisième rdv clôturé avec 3 prescriptions différentes
        Rdv rdv3 = new Rdv(new Date("10/05/2014"), p1, m2, sp2, StatutRdv.CLOTURE, Tranche.H1230);
        rdv3.setRemarque("Maux de ventre");
        List<Prescription> listPres2 = new ArrayList<Prescription>();
        listPres2.add(new Prescription("Médicament 4", "2x/jour", 3));
        listPres2.add(new Prescription("Médicament 9", "4x/jout", 7));
        listPres2.add(new Prescription("Médicament 2", "Au réveil", 5));
        rdv3.setPrescriptions(listPres2);
        // Quatrième rdv en cours pour le jour au lancement de l'application
        Rdv rdv4 = new Rdv(new Date(), p1, m1, sp1, StatutRdv.EN_COURS, Tranche.H0900);
        
        em.persist(rdv1); em.persist(rdv2); em.persist(rdv3); em.persist(rdv4);
        tx.commit();
        
        tx.begin();
        m1.addSpecialisation(sp1);
        m1.addSpecialisation(sp2);
        m1.addSpecialisation(sp3);
        m2.addSpecialisation(sp1);
        m2.addSpecialisation(sp2);
        m3.addSpecialisation(sp2);
        m4.addSpecialisation(sp1);
        m4.addSpecialisation(sp3);
        tx.commit();
        
    }
    
    private static final String REG_MED1 = "58932409832";
    private static final String REG_MED2 = "43892084309";
    private static final String REG_MED3 = "21384902454";
    private static final String REG_MED4 = "43909564258";
    
    private static final String REG_PAT = "90032943325";
    
    // -------------------------------------------------------------------------
    // -------------------------------- @Entity --------------------------------
    // -------------------------------------------------------------------------
    private static final Map<Jour,Disponibilite> mapDisponibilite = new HashMap<Jour,Disponibilite>();
    private static final Disponibilite dis1 = new Disponibilite(Tranche.H0900, Tranche.H1400);
    private static final Disponibilite dis2 = new Disponibilite(Tranche.H0900, Tranche.H1400);
    private static final Disponibilite dis3 = new Disponibilite(Tranche.H0900, Tranche.H1400);
    private static final Disponibilite dis4 = new Disponibilite(Tranche.H0900, Tranche.H1830);
    private static final Disponibilite dis5 = new Disponibilite(Tranche.H1200, Tranche.H1530);
    private static final Cp cp1 = new Cp(1000, "Bruxelles");
    private static final Cp cp2 = new Cp(1020, "Laeken");
    private static final Cp cp3 = new Cp(1030, "Schaerbeek");
    private static final Cp cp4 = new Cp(1040, "Etterbeek");
    private static final Cp cp5 = new Cp(1050, "Ixelles");
    private static final Cp cp6 = new Cp(1060, "Saint-Gilles");
    private static final Cp cp7 = new Cp(1070, "Anderlecht");
    private static final Cp cp8 = new Cp(1080, "Molenbeek");
    private static final Cp cp9 = new Cp(1081, "Koekelberg");
    private static final Cp cp10 = new Cp(1090, "Jette");
    //********************************************************************************************************************************************
    private static final Patient p1 = new Patient(Mutualite.PARTENAMUT, REG_PAT, "Amar Ouaali", "Riduan",
        new Date(),new Adresse("Rue Jan Bollen 62", cp2), "0484847749", Sexe.HOMME, "19214079440", "ridouan-amar@hotmail.com", "MDPpatient");
    private static final Personnel a1 = new Administrateur(new Date(), REG_MED1, "Administrateur", "Moi",
            new Date(), new Adresse("Rue test 43", cp1), "0453945632", Sexe.HOMME, "admin@cabmed.be", "MDPadmin");
    //********************************************************************************************************************************************
    private static final Personnel i1 = new Infirmiere(new Date(), "87122274535", "Amar Ouaali", 
        "Mohamed", new Date(), new Adresse("Rue Fransman 122", cp2), "0472982610", Sexe.HOMME, "infirmiere1@cabmed.be", "MDPinfirmiere1");
    private static final Personnel i2 = new Infirmiere(new Date(), "19081052047", "Machin", "Chose", 
        new Date(), new Adresse("Avenue Louise 22", cp1), "0474727272", Sexe.FEMME, "infirmiere2@cabmed.be", "MDPinfirmiere2");
    private static final Personnel i3 = new Infirmiere(new Date(), "91017335418", "Louise", "Marie", 
        new Date(), new Adresse("Rue Joseph Buedts 4", cp4), "0493673256", Sexe.FEMME, "infirmiere3@cabmed.be", "MDPinfirmiere3");
    private static final Personnel i4 = new Infirmiere(new Date(), "63010124101", "Desaedeleer", 
        "Lionel", new Date(), new Adresse("Boulevard de la cambre 33", cp1), "0494093854", Sexe.HOMME, "infirmiere4@cabmed.be", "MDPinfirmiere4");
    //********************************************************************************************************************************************
    private static final Personnel s1 = new Secretaire(new Date(), "87123274535", "Login", 
        "Test", new Date(), new Adresse("Rue Fransman 122", cp2), "0472982610", Sexe.HOMME, "secretaire1@cabmed.be", "MDPsecretaire1");
    private static final Personnel s2 = new Secretaire(new Date(), "19089052047", "Machin", "Chose", 
        new Date(), new Adresse("Avenue Louise 22", cp1), "0474727272", Sexe.FEMME, "secretaire2@cabmed.be", "MDPsecretaire2");
    private static final Personnel s3 = new Secretaire(new Date(), "91015335418", "Louise", "Marie", 
        new Date(), new Adresse("Rue Joseph Buedts 4", cp4), "0493673256", Sexe.FEMME, "secretaire3@cabmed.be", "MDPsecretaire3");
    private static final Personnel s4 = new Secretaire(new Date(), "63019124101", "Desaedeleer", 
        "Lionel", new Date(), new Adresse("Boulevard de la cambre 33", cp1), "0494093854", Sexe.HOMME, "secretaire4@cabmed.be", "MDPsecretaire4");
    //********************************************************************************************************************************************
    private static final Medecin m1 = new Medecin(new Date(), REG_MED1, "VO", "Didier",
        new Date(), new Adresse("Rue de la loi 453", cp5), "0498234109", Sexe.HOMME, "medecin1@cabmed.be", "MDPmedecin1");
    private static final Medecin m2 = new Medecin(new Date(), REG_MED2, "Decamp", "Test",
        new Date(), new Adresse("Rue du test 74", cp10), "0488932094", Sexe.HOMME, "medecin2@cabmed.be", "MDPmedecin2");
    private static final Medecin m3 = new Medecin(new Date(), REG_MED3, "De Heneau", "Teste",
        new Date(), new Adresse("Rue Ici 982", cp8), "0494439092", Sexe.FEMME, "medecin3@cabmed.be", "MDPmedecin3");
    private static final Medecin m4 = new Medecin(new Date(), REG_MED4, "Amar", "Machin",
        new Date(), new Adresse("Avenue de Moi 429", cp9), "0478439089", Sexe.HOMME, "medecin4@cabmed.be", "MDPmedecin4");
    //********************************************************************************************************************************************
    private static final Specialisation sp1 = new Specialisation(1, "Généraliste");
    private static final Specialisation sp2 = new Specialisation(3, "Osthéopathe");
    private static final Specialisation sp3 = new Specialisation(2, "Obstétricien");

}