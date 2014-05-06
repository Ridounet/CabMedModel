package cabmed.dao;

import cabmed.model.Medecin;
import cabmed.model.Planning;
import cabmed.model.Specialisation;
import cabmed.ressources.Constantes;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;

public class MedecinDAO implements IMedecinDAO{

    @Override
    public boolean deleteMedecin(Medecin med) {
        boolean result = false;
        
        
        return result;
    }

    @Override
    public boolean saveMedecin(Medecin medecin) {
        // TODO
        return true;
    }
    
    

    @Override
    public List<Medecin> getListMedecin() {
        String sql = "SELECT m FROM Medecin m WHERE m.visible = " + Constantes.VISIBLE;
        List<Medecin> listMedecin = new LinkedList<>();
        try {
            return DAOMySQL.getEntityManager().createQuery(sql).getResultList();
        } catch (Exception ex) {
            return listMedecin;
        }
    }

    @Override
    public boolean addMedecin(Medecin medecin) {
        medecin.setPlanning(new Planning(medecin));
        medecin.setSpecialisation(new ArrayList<Specialisation>());
        EntityManager em = DAOMySQL.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(medecin);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            em.getTransaction().rollback();
            return false;
        }
    }
    
}