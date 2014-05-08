package cabmed.dao;

import cabmed.model.Infirmiere;
import cabmed.model.Personnel;
import cabmed.model.Secretaire;
import cabmed.model.Specialisation;
import cabmed.ressources.Constantes;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonnelDAO implements IPersonnelDAO {

    @Override
    public boolean addInfirmiere(Infirmiere infirmiere) {
        EntityTransaction tx = DAOMySQL.getEntityManager().getTransaction();
        tx.begin();
        try{
            DAOMySQL.getEntityManager().persist(infirmiere);
            tx.commit();
            return true;
        } catch(Exception e) {
            tx.rollback();
            return false;
        }
    }

    @Override
    public boolean addSecretaire(Secretaire secretaire) {
        EntityTransaction tx = DAOMySQL.getEntityManager().getTransaction();
        tx.begin();
        try{
            DAOMySQL.getEntityManager().persist(secretaire);
            tx.commit();
            return true;
        } catch(Exception e) {
            tx.rollback();
            return false;
        }
    }

    @Override
    public boolean savePersonnel(Personnel personne) {
        // TODO
        return true;
    }

    @Override
    public boolean deleteSecretaire(Secretaire secretaire) {
        // TODO
        return true;
    }

    @Override
    public List<Secretaire> getListSecretaire() {
        try {
            return DAOMySQL.getEntityManager().createQuery(
                    "SELECT s FROM Secretaire s WHERE s.visible = " + Constantes.VISIBLE).getResultList();
        } catch (Exception ex) {
            return new LinkedList<>();
        }
    }

    @Override
    public List<Infirmiere> getListInfirmiere() {
        try {
            return DAOMySQL.getEntityManager().createQuery(
                    "SELECT i FROM Infirmiere i WHERE i.visible = " + Constantes.VISIBLE).getResultList();
        } catch (Exception ex) {
            return new LinkedList<>();
        }
    }
    
}
