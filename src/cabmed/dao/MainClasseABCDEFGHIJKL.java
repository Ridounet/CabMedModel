package cabmed.dao;

import cabmed.model.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.*;

public class MainClasseABCDEFGHIJKL {
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("cabmed");
    private static EntityManager em = null;
    
    public static void main (String[] args) {
        em = emf.createEntityManager();
        setupDB();
        EntityTransaction tx = em.getTransaction();
        
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
        
        Medecin m2 = em.find(Medecin.class, m1.getId());
        //Medecin m2 = (Medecin) em.createQuery("SELECT m FROM Medecin m WHERE m.registreNat = " + REG_MED).getSingleResult();
        System.out.println(m2.getPlanning().toString());
        
        tx.begin();
        Rdv rdv1 = new Rdv(new Date(), p1, m2, sp1, StatutRdv.EN_COURS, Tranche.H0900, 2);
        em.persist(rdv1);
        tx.commit();
        
        Rdv rdv2 = (Rdv) em.createQuery("SELECT r FROM Rdv r WHERE r.patient.registreNat = " + REG_PAT).getSingleResult();
        System.out.println(rdv2);
        em.close();
        emf.close();
        
        EntityManager em1 = Persistence.createEntityManagerFactory("cabmed").createEntityManager();
        EntityTransaction tx1 = em1.getTransaction();
        Patient p2 = em1.find(Patient.class, p1.getId());
        //System.out.println(p2.getRdv().toString());
        
    }
    
    
    
    
    
    
    
    
    
    private static final String REG_MED = "58932409832";
    private static final String REG_PAT = "90032943524";
    
    // -------------------------------------------------------------------------
    // -------------------------------- @Entity --------------------------------
    // -------------------------------------------------------------------------
    private static Map<Jour,Disponibilite> mapDisponibilite = new HashMap<>();
    private static Disponibilite dis1 = new Disponibilite(Tranche.H0900, Tranche.H1400);
    private static Disponibilite dis2 = new Disponibilite(Tranche.H0900, Tranche.H1400);
    private static Disponibilite dis3 = new Disponibilite(Tranche.H0900, Tranche.H1400);
    private static Disponibilite dis4 = new Disponibilite(Tranche.H0900, Tranche.H1845);
    private static Disponibilite dis5 = new Disponibilite(Tranche.H1200, Tranche.H1545);
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
        new Date(),new Adresse("Rue Jan Bollen", cp2), "0484848849", Sexe.HOMME);
    private static Personnel i1 = new Infirmiere(new Date(), "87122274535", "Amar Ouaali", 
        "Mohamed", new Date(), new Adresse("Rue Fransman 122", cp2), "0472982610", Sexe.HOMME);
    private static Personnel i2 = new Infirmiere(new Date(), "19081052047", "Machin", "Chose", 
        new Date(), new Adresse("Avenue Louise 22", cp1), "0474727272", Sexe.FEMME);
    private static Personnel s1 = new Secretaire(new Date(), "91012335418", "Louise", "Marie", 
        new Date(), new Adresse("Rue Joseph Buedts 4", cp4), "0493673256", Sexe.FEMME);
    private static Personnel s2 = new Secretaire(new Date(), "63010124101", "Desaedeleer", 
        "Lionel", new Date(), new Adresse("Boulevard de la cambre 33", cp1), "0494093854", Sexe.HOMME);
    private static Medecin m1 = new Medecin(new Date(), REG_MED, "VO", "Didier",
        new Date(), new Adresse("Rue de la loi 453", cp5), "0498234109", Sexe.HOMME);
    
    private static List<Specialisation> listSpec = new ArrayList<>();
    private static Specialisation sp1 = new Specialisation(1, "Généraliste");
    private static Specialisation sp2 = new Specialisation(3, "Gynécologue");
    private static Specialisation sp3 = new Specialisation(2, "Obstétricien");
    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------
    
    private static void setupDB() {
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        em.persist(cp1); em.persist(cp2); em.persist(cp3); em.persist(cp4); em.persist(cp5);
        em.persist(cp6); em.persist(cp7); em.persist(cp8); em.persist(cp9); em.persist(cp10);
        tx.commit();
        em.close();
        boolean result = DAOMySQL.getInstance().savePatient(p1);
        em = emf.createEntityManager();
        tx.begin();
        //em.persist(p1);
        
        System.out.println("-------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Résultat du save: " + result);
        System.out.println("-------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------");
        em.persist(i1); em.persist(i2);
        em.persist(s1); em.persist(s2); em.persist(m1);
        tx.commit();

        tx.begin();
        listSpec.add(sp1);
        listSpec.add(sp2);
        listSpec.add(sp3);
        m1.setSpecialisation(listSpec);
        em.persist(sp1); em.persist(sp2); em.persist(sp3);
        tx.commit();
        
    }
}







        
        