package cabmed.dao;

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
import cabmed.model.Rdv;
import cabmed.model.Secretaire;
import cabmed.model.Sexe;
import cabmed.model.Specialisation;
import cabmed.model.StatutRdv;
import cabmed.model.Tranche;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DAOMySQL implements IMedecinDAO, IPersonnelDAO, ISpecialisationDAO, IPatientDAO, IPlanningDAO {
    
    private DAOMySQL() {
        cpDAO = new CpDAO();
        medecinDAO = new MedecinDAO();
        patientDAO = new PatientDAO();
        personnelDAO = new PersonnelDAO();
        planningDAO = new PlanningDAO();
        specialisationDAO = new SpecialisationDAO();
        initDB();
    }
    
    public static DAOMySQL getInstance() {
        if (instance == null) {
             instance = new DAOMySQL();
        }
        return instance;
    }
    
    private static DAOMySQL instance;
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("cabmed");
    private static EntityManager em = null;
    public static EntityManager getEntityManager() { if (em == null) em = emf.createEntityManager(); return em; }
    
    private final ICpDAO cpDAO;
    private final IMedecinDAO medecinDAO;
    private final IPatientDAO patientDAO;
    private final IPersonnelDAO personnelDAO;
    private final IPlanningDAO planningDAO;
    private final ISpecialisationDAO specialisationDAO;
    
    
    
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
    public Administrateur login(String login, String password) {
        Administrateur result;
        try {
            result = (Administrateur) getEntityManager().createQuery("SELECT a FROM Administrateur a "
                + "WHERE a.nom = '" + login + "' AND a.prenom = '" + password + "'").getSingleResult();
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
    public List<Medecin> getListMedecin() {
        return medecinDAO.getListMedecin();
    }
    
    public List<Secretaire> getListSecretaire() {
        return personnelDAO.getListSecretaire();
    }

    public List<Infirmiere> getListInfirmiere() {
        return personnelDAO.getListInfirmiere();
    }

    public List<Specialisation> getListSpecialisation() {
        return specialisationDAO.getListSpecialisation();
    }
    
    
    
    
    public static void initDB() {
        em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(cp1); em.persist(cp2); em.persist(cp3); em.persist(cp4); em.persist(cp5);
        em.persist(cp6); em.persist(cp7); em.persist(cp8); em.persist(cp9); em.persist(cp10);
        tx.commit();

        tx.begin();
        em.persist(i1); em.persist(m1); em.persist(i2); em.persist(m4); em.persist(a1);
        em.persist(p1); em.persist(s1); em.persist(m3); em.persist(s2); em.persist(m2);
        em.persist(s3); em.persist(i4); em.persist(i3); em.persist(s4);
        
        tx.commit();

        tx.begin();
        listSpec.add(sp1);
        listSpec.add(sp2);
        listSpec.add(sp3);
        em.persist(sp1); em.persist(sp2); em.persist(sp3);
        tx.commit();
        
        m1.setSpecialisation(listSpec);
//        m2.setSpecialisation(listSpec);
//        m3.setSpecialisation(listSpec);
//        m4.setSpecialisation(listSpec);
        
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
        Rdv rdv1 = new Rdv(new Date(), p1, m1, sp1, StatutRdv.EN_COURS, Tranche.H0900, 2);
        em.persist(rdv1);
        tx.commit();
        
    }
    
    private static final String REG_MED1 = "58932409832";
    private static final String REG_MED2 = "43892084309";
    private static final String REG_MED3 = "21384902454";
    private static final String REG_MED4 = "43909564258";
    
    private static final String REG_PAT = "90032943524";
    
    // -------------------------------------------------------------------------
    // -------------------------------- @Entity --------------------------------
    // -------------------------------------------------------------------------
    private static Map<Jour,Disponibilite> mapDisponibilite = new HashMap<>();
    private static Disponibilite dis1 = new Disponibilite(Tranche.H0900, Tranche.H1400);
    private static Disponibilite dis2 = new Disponibilite(Tranche.H0900, Tranche.H1400);
    private static Disponibilite dis3 = new Disponibilite(Tranche.H0900, Tranche.H1400);
    private static Disponibilite dis4 = new Disponibilite(Tranche.H0900, Tranche.H1830);
    private static Disponibilite dis5 = new Disponibilite(Tranche.H1200, Tranche.H1530);
    private static Cp cp1 = new Cp(1000, "Bruxelles");
    private static Cp cp2 = new Cp(1020, "Laeken");
    private static Cp cp3 = new Cp(1030, "Schaerbeek");
    private static Cp cp4 = new Cp(1040, "Etterbeek");
    private static Cp cp5 = new Cp(1050, "Ixelles");
    private static Cp cp6 = new Cp(1060, "Saint-Gilles");
    private static Cp cp7 = new Cp(1070, "Anderlecht");
    private static Cp cp8 = new Cp(1080, "Molenbeek");
    private static Cp cp9 = new Cp(1081, "Koekelberg");
    private static Cp cp10 = new Cp(1090, "Jette");
    
    private static Patient p1 = new Patient(Mutualite.PARTENAMUT, REG_PAT, "Amar Ouaali", "Riduan",
        new Date(),new Adresse("Rue Jan Bollen 62", cp2), "0484848849", Sexe.HOMME, "11414059330");
    private static Personnel a1 = new Administrateur(new Date(), REG_MED1, "Administrateur", "Moi",
            new Date(), new Adresse("Rue test 43", cp1), "0453945632", Sexe.HOMME);
    
    private static Personnel i1 = new Infirmiere(new Date(), "87122274535", "Amar Ouaali", 
        "Mohamed", new Date(), new Adresse("Rue Fransman 122", cp2), "0472982610", Sexe.HOMME);
    private static Personnel i2 = new Infirmiere(new Date(), "19081052047", "Machin", "Chose", 
        new Date(), new Adresse("Avenue Louise 22", cp1), "0474727272", Sexe.FEMME);
    private static Personnel i3 = new Infirmiere(new Date(), "91017335418", "Louise", "Marie", 
        new Date(), new Adresse("Rue Joseph Buedts 4", cp4), "0493673256", Sexe.FEMME);
    private static Personnel i4 = new Infirmiere(new Date(), "63010124101", "Desaedeleer", 
        "Lionel", new Date(), new Adresse("Boulevard de la cambre 33", cp1), "0494093854", Sexe.HOMME);
    
    private static Personnel s1 = new Secretaire(new Date(), "87123274535", "Amar Ouaali", 
        "Mohamed", new Date(), new Adresse("Rue Fransman 122", cp2), "0472982610", Sexe.HOMME);
    private static Personnel s2 = new Secretaire(new Date(), "19089052047", "Machin", "Chose", 
        new Date(), new Adresse("Avenue Louise 22", cp1), "0474727272", Sexe.FEMME);
    private static Personnel s3 = new Secretaire(new Date(), "91015335418", "Louise", "Marie", 
        new Date(), new Adresse("Rue Joseph Buedts 4", cp4), "0493673256", Sexe.FEMME);
    private static Personnel s4 = new Secretaire(new Date(), "63019124101", "Desaedeleer", 
        "Lionel", new Date(), new Adresse("Boulevard de la cambre 33", cp1), "0494093854", Sexe.HOMME);
    
    private static Medecin m1 = new Medecin(new Date(), REG_MED1, "VO", "Didier",
        new Date(), new Adresse("Rue de la loi 453", cp5), "0498234109", Sexe.HOMME);
    private static Medecin m2 = new Medecin(new Date(), REG_MED2, "Decamp", "Test",
        new Date(), new Adresse("Rue du test 74", cp10), "0488932094", Sexe.HOMME);
    private static Medecin m3 = new Medecin(new Date(), REG_MED3, "De Heneau", "Teste",
        new Date(), new Adresse("Rue Ici 982", cp8), "0494439092", Sexe.FEMME);
    private static Medecin m4 = new Medecin(new Date(), REG_MED4, "Amar", "Machin",
        new Date(), new Adresse("Avenue de Moi 429", cp9), "0478439089", Sexe.HOMME);
    
    private static List<Specialisation> listSpec = new ArrayList<>();
    private static Specialisation sp1 = new Specialisation(1, "Généraliste");
    private static Specialisation sp2 = new Specialisation(3, "Gynécologue");
    private static Specialisation sp3 = new Specialisation(2, "Obstétricien");

}