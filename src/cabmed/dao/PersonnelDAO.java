package cabmed.dao;

import cabmed.model.Infirmiere;
import cabmed.model.Personnel;
import cabmed.model.Secretaire;
import cabmed.model.Specialisation;
import cabmed.ressources.Constantes;
import java.util.LinkedList;
import java.util.List;

public class PersonnelDAO implements IPersonnelDAO {

    @Override
    public boolean addInfirmiere(Infirmiere infirmiere) {
        // TODO
        return true;
    }

    @Override
    public boolean addSecretaire(Secretaire secretaire) {
        // TODO
        return true;
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
        String sql = "SELECT s FROM Secretaire s WHERE s.visible = " + Constantes.VISIBLE;
        List<Secretaire> listSecretaire = new LinkedList<>();
        try {
            return DAOMySQL.getEntityManager().createQuery(sql).getResultList();
        } catch (Exception ex) {
            return listSecretaire;
        }
    }

    @Override
    public List<Infirmiere> getListInfirmiere() {
        String sql = "SELECT i FROM Infirmiere i WHERE i.visible = " + Constantes.VISIBLE;
        List<Infirmiere> listInfirmiere = new LinkedList<>();
        try {
            return DAOMySQL.getEntityManager().createQuery(sql).getResultList();
        } catch (Exception ex) {
            return listInfirmiere;
        }
    }
    
}
