package cabmed.dao.implementation;

import cabmed.dao.ISpecialisationDAO;
import cabmed.model.Specialisation;
import cabmed.ressources.Constantes;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityTransaction;

public class SpecialisationDAO implements ISpecialisationDAO{

    @Override
    public List<Specialisation> getListSpecialisation() {
        String sql = "SELECT s FROM Specialisation s WHERE s.visible = " + Constantes.VISIBLE;
        List<Specialisation> listSpecialisation = new LinkedList<>();
        try {
            return DAOMySQL.getEntityManager().createQuery(sql).getResultList();
        } catch (Exception ex) {
            return listSpecialisation;
        }
    }

    @Override
    public boolean deleteSpecialisation(Specialisation specialisation) {
        EntityTransaction tx = DAOMySQL.getEntityManager().getTransaction();
        tx.begin();
        specialisation.setVisible(false);
        try {
            DAOMySQL.getEntityManager().persist(specialisation);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            return false;
        }
    }
    
}
