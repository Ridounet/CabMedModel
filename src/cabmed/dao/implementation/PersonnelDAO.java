package cabmed.dao.implementation;

import cabmed.dao.IPersonnelDAO;
import cabmed.model.Infirmiere;
import cabmed.model.Personnel;
import cabmed.model.Secretaire;
import cabmed.ressources.Constantes;
import java.util.ArrayList;
import java.util.List;
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
        EntityTransaction tx = DAOMySQL.getEntityManager().getTransaction();
        tx.begin();
        try{
            DAOMySQL.getEntityManager().persist(personne);
            tx.commit();
            return true;
        } catch(Exception e) {
            tx.rollback();
            return false;
        }
    }

    @Override
    public boolean deleteSecretaire(Secretaire secretaire) {
        EntityTransaction tx = DAOMySQL.getEntityManager().getTransaction();
        secretaire.setVisible(false);
        tx.begin();
        try{
            tx.commit();
            return true;
        } catch(Exception e) {
            tx.rollback();
            return false;
        }
    }
    
    @Override
    public boolean deleteInfirmiere(Infirmiere infirmiere) {
        EntityTransaction tx = DAOMySQL.getEntityManager().getTransaction();
        infirmiere.setVisible(false);
        tx.begin();
        try{
            tx.commit();
            return true;
        } catch(Exception e) {
            tx.rollback();
            return false;
        }
    }

    @Override
    public List<Secretaire> getListSecretaire() {
        try {
            return DAOMySQL.getEntityManager().createQuery(
                    "SELECT s FROM Secretaire s WHERE s.visible = " + Constantes.VISIBLE).getResultList();
        } catch (Exception ex) {
            return new ArrayList<Secretaire>();
        }
    }

    @Override
    public List<Infirmiere> getListInfirmiere() {
        try {
            return DAOMySQL.getEntityManager().createQuery(
                    "SELECT i FROM Infirmiere i WHERE i.visible = " + Constantes.VISIBLE).getResultList();
        } catch (Exception ex) {
            return new ArrayList<Infirmiere>();
        }
    }

}
