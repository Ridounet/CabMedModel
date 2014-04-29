package cabmed.dao;

import cabmed.model.Patient;
import javax.persistence.*;

public class PatientDAO implements IPatientDAO{
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("cabmed");
    private EntityManager em = null;
    private EntityManager getEntityManager() { if (em == null) em = emf.createEntityManager(); return em; }

    @Override
    public boolean savePatient(Patient patient) {
        boolean result;
        try {
            EntityManager em = getEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(patient);
            tx.commit();
            result = true;
        } catch(Exception e) {
            
            result = false;
        }
        
        return result;
    }
    
}