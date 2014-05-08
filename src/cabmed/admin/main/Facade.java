package cabmed.admin.main;

import cabmed.ressources.Observer;
import java.util.List;
import cabmed.dao.*;
import cabmed.model.Administrateur;
import cabmed.model.Cp;
import cabmed.model.Infirmiere;
import cabmed.model.Medecin;
import cabmed.model.Personnel;
import cabmed.model.Secretaire;
import cabmed.model.Specialisation;
import java.util.ArrayList;
import java.util.LinkedList;

public class Facade implements IPersonnelDAO, IMedecinDAO, ISpecialisationDAO{
    
    public Facade() { }
    // Pattern Observer
    private static final List<Observer> listObservers = new ArrayList<>();
    private static void notifyObservers() {
        for (Observer ob : listObservers) {
            ob.update();
        }
    }
    public static void addObserver(Observer o) {
        listObservers.add(o);
    }
    
    // Généralités
    public void initDB() {
        DAOMySQL.getInstance();
    }
    
    public Administrateur login(String login, String password) {
        return DAOMySQL.getInstance().login(login, password);
    }

    public List<Cp> getListCp() {
        return DAOMySQL.getInstance().getListCp();
    }
    
    @Override
    public List<Medecin> getListMedecin() {
        return DAOMySQL.getInstance().getListMedecin();
    }
    
    public List<Secretaire> getListSecretaire() {
        return DAOMySQL.getInstance().getListSecretaire();
    }

    public List<Infirmiere> getListInfirmiere() {
        return DAOMySQL.getInstance().getListInfirmiere();
    }

    public List<Specialisation> getListSpecialisation() {
        return DAOMySQL.getInstance().getListSpecialisation();
    }
    
    // Medecin
    @Override
    public boolean deleteMedecin(Medecin med) {
        // TODO
        return DAOMySQL.getInstance().deleteMedecin(med);
    }

    @Override
    public boolean saveMedecin(Medecin medecin) {
        // TODO
        return DAOMySQL.getInstance().saveMedecin(medecin);
    }
    
    @Override
    public boolean addMedecin(Medecin medecin) {
        boolean result = DAOMySQL.getInstance().addMedecin(medecin);
        notifyObservers();
        return result;
    }

    // Personnel
    @Override
    public boolean addInfirmiere(Infirmiere infirmiere) {
        // TODO
        return DAOMySQL.getInstance().addInfirmiere(infirmiere);
    }

    @Override
    public boolean addSecretaire(Secretaire secretaire) {
        // TODO
        return DAOMySQL.getInstance().addSecretaire(secretaire);
    }

    @Override
    public boolean savePersonnel(Personnel personne) {
        // TODO
        return DAOMySQL.getInstance().savePersonnel(personne);
    }

    @Override
    public boolean deleteSecretaire(Secretaire secretaire) {
       return DAOMySQL.getInstance().deleteSecretaire(secretaire);
    }
}
