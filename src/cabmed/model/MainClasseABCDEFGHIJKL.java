package cabmed.model;

import java.util.Date;
import javax.persistence.*;

public class MainClasseABCDEFGHIJKL {
    
    public static void main (String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cabmed");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        Cp cp1 = new Cp(1000, "Bruxelles");
        Cp cp2 = new Cp(1020, "Laeken");
        Cp cp3 = new Cp(1030, "Schaerbeek");
        Cp cp4 = new Cp(1040, "Etterbeek");
        Cp cp5 = new Cp(1050, "Ixelles");
        em.persist(cp1); em.persist(cp2); em.persist(cp3); em.persist(cp4); em.persist(cp5);
        tx.commit();
        
        tx.begin();
        Patient p1 = new Patient(Mutualite.PARTENAMUT, "90032943524", 
                "Amar Ouaali", "Riduan", new Date(),
                new Adresse("Rue Jan Bollen", cp2), "0484848849", Sexe.HOMME);
        Personnel i1 = new Infirmiere(new Date(), "87122274535", "Amar Ouaali", 
                "Mohamed", new Date(), new Adresse("Rue Fransman 122", cp2), "0472982610", Sexe.HOMME);
        Personnel i2 = new Infirmiere(new Date(), "19081052047", "De Wever", "Bart", 
                new Date(), new Adresse("Avenue Louise 22", cp1), "0474727272", Sexe.FEMME);
        Personnel s1 = new Secretaire(new Date(), "91012335418", "Di Rupo", "Elio", 
                new Date(), new Adresse("Rue Joseph Buedts 4", cp4), "0493673256", Sexe.FEMME);
        Personnel s2 = new Secretaire(new Date(), "63010124101", "Desaedeleer", 
                "Lionel", new Date(), new Adresse("Boulevard de la cambre 33", cp1),
                "0494093854", Sexe.HOMME);
        Personnel a1 = new Medecin(new Date(), "58932409832", "VO", 
                "Didier", new Date(), new Adresse("Rue de la loi 453", cp5),
                "0498234109", Sexe.HOMME);
        
        em.persist(p1); em.persist(i1); em.persist(i2);
        em.persist(s1); em.persist(s2); em.persist(a1);
        tx.commit();

        tx.begin();
        Specialisation sp1 = new Specialisation(1, "Généraliste");
        Specialisation sp2 = new Specialisation(3, "Gynécologue");
        Specialisation sp3 = new Specialisation(2, "Obstétricien");
        
        Disponibilite dis1 = new Disponibilite(Tranche.H0900, Tranche.H1400);
        Disponibilite dis2 = new Disponibilite(Tranche.H0900, Tranche.H1845);
        Disponibilite dis3 = new Disponibilite(Tranche.H1200, Tranche.H1545);
        
        em.persist(sp1); em.persist(sp2); em.persist(sp3);
        em.persist(dis1); em.persist(dis2); em.persist(dis3); 
        tx.commit();
        
        em.close();
        emf.close();
    }
}







//        Cp cp6 = new Cp(1060, "Saint-Gilles");
//        Cp cp7 = new Cp(1070, "Anderlecht");
//        Cp cp8 = new Cp(1080, "Molenbeek");
//        Cp cp9 = new Cp(1081, "Koekelberg");
//        Cp cp10 = new Cp(1090, "Jette");
//        em.persist(cp6); em.persist(cp7); em.persist(cp8); em.persist(cp9); em.persist(cp10);