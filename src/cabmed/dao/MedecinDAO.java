package cabmed.dao;

import cabmed.model.Disponibilite;
import cabmed.model.Jour;
import cabmed.model.Medecin;
import cabmed.model.Planning;
import cabmed.model.Specialisation;
import cabmed.ressources.Constantes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityTransaction;

public class MedecinDAO implements IMedecinDAO{

    @Override
    public boolean deleteMedecin(Medecin med) {
        EntityTransaction tx = DAOMySQL.getEntityManager().getTransaction();
        med.setVisible(false);
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
    public boolean saveMedecin(Medecin medecin) {
        // TODO
        return true;
    }
    
    

    @Override
    public List<Medecin> getListMedecin() {
        try {
            return DAOMySQL.getEntityManager().createQuery(
                    "SELECT m FROM Medecin m WHERE m.visible = " + Constantes.VISIBLE).getResultList();
        } catch (Exception ex) {
            return new ArrayList<Medecin>();
        }
    }

    @Override
    public boolean addMedecin(Medecin medecin) {
        Planning planning = new Planning(medecin);
        Map<Jour, Disponibilite> disponibilite = new HashMap<>();
        disponibilite.put(Jour.LUNDI, new Disponibilite());
        disponibilite.put(Jour.MARDI, new Disponibilite());
        disponibilite.put(Jour.MERCREDI, new Disponibilite());
        disponibilite.put(Jour.JEUDI, new Disponibilite());
        disponibilite.put(Jour.VENDREDI, new Disponibilite());
        disponibilite.put(Jour.SAMEDI, new Disponibilite());
        planning.setDisponibilite(disponibilite);
        medecin.setSpecialisation(new ArrayList<Specialisation>());
        EntityTransaction tx = DAOMySQL.getEntityManager().getTransaction();
        tx.begin();
        try {
            DAOMySQL.getEntityManager().persist(medecin);
            tx.commit();
            return true;
        } catch (Exception ex) {
            tx.rollback();
            return false;
        }
    }
    
}