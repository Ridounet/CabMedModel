package cabmed.dao.implementation;

import cabmed.dao.IRdvDAO;
import cabmed.model.Patient;
import cabmed.model.Rdv;
import java.util.List;
import javax.persistence.EntityTransaction;

public class RdvDAO implements IRdvDAO{
    
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

    @Override
    public Rdv getRdvParId(int idRdv) {
        try {
            return (Rdv) DAOMySQL.getEntityManager().createQuery(
                    "SELECT r FROM Rdv r WHERE r.id = " + idRdv).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
