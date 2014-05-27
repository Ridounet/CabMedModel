package cabmed.dao.implementation;

import cabmed.dao.IPatientDAO;
import cabmed.model.Patient;
import cabmed.model.Rdv;
import java.util.List;
import javax.persistence.*;

public class PatientDAO implements IPatientDAO{
    
    @Override
    public boolean savePatient(Patient patient) {
        EntityTransaction tx = DAOMySQL.getEntityManager().getTransaction();
        tx.begin();
        try {
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

    @Override
    public List<Rdv> getRdvPatient(Patient patient) {
        try {
            return (List<Rdv>) DAOMySQL.getEntityManager().createQuery(
                    "SELECT r FROM Rdv r WHERE r.patient.id = " + patient.getId()).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean updateRdv(Rdv rdv) {
        EntityTransaction tx = DAOMySQL.getEntityManager().getTransaction();
        tx.begin();
        try {
            DAOMySQL.getEntityManager().persist(rdv);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            return false;
        }
    }
    
}