package cabmed.dao;

import cabmed.model.Patient;
import javax.persistence.*;

public class PatientDAO implements IPatientDAO{
    
    @Override
    public boolean savePatient(Patient patient) {
        EntityTransaction tx = DAOMySQL.getEntityManager().getTransaction();
        try {
            tx.begin();
            DAOMySQL.getEntityManager().persist(patient);
            tx.commit();
            return true;
        } catch(Exception e) {
            tx.rollback();
            return false;
        }
    }

    @Override
    public Patient getPatientByRegistreNat(String registreNat) {
        try {
            return (Patient)DAOMySQL.getEntityManager().createQuery(
                    "SELECT p FROM Patient p WHERE p.registreNat = " + registreNat).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
}