package cabmed.dao;

import cabmed.model.Patient;
import javax.persistence.*;

public class PatientDAO implements IPatientDAO{
    
    @Override
    public boolean savePatient(Patient patient) {
        boolean result;
        try {
            EntityManager em = DAOMySQL.getEntityManager();
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