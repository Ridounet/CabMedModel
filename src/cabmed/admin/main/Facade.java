package cabmed.admin.main;

import cabmed.ressources.Observer;
import java.util.List;
import cabmed.dao.*;
import cabmed.model.Cp;
import cabmed.model.Infirmiere;
import cabmed.model.Medecin;
import cabmed.model.Personnel;
import cabmed.model.Secretaire;
import java.util.ArrayList;
import java.util.LinkedList;

public class Facade implements IPersonnelDAO, IMedecinDAO, ISpecialisationDAO{
    
    private final List<Cp> listCp;
    
    public Facade() {
        listCp = new LinkedList<>();
        Cp c1 = new Cp(1000, "Bruxelles");
        c1.setId(1);
        Cp c2 = new Cp(1020, "Laeken");
        c2.setId(2);
        Cp c3 = new Cp(1030, "Schaerbeek");
        c3.setId(3);
        Cp c4 = new Cp(1040, "Etterbeek");
        c4.setId(4);
        Cp c5 = new Cp(1050, "Ixelles");
        c5.setId(5);
        
        listCp.add(c1);
        listCp.add(c2);
        listCp.add(c3);
        listCp.add(c4);
        listCp.add(c5);
    }
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
    public boolean login(String login, String password) {
        boolean result = false;
        if (login.equals("") && password.equals("")) {
            result = true;
        }
        return result;
    }

    public List<Cp> getListCp() {
        return listCp;
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

    // Personnel
    @Override
    public boolean saveInfirmiere(Infirmiere infirmiere) {
        // TODO
        return DAOMySQL.getInstance().saveInfirmiere(infirmiere);
    }

    @Override
    public boolean saveSecretaire(Secretaire secretaire) {
        // TODO
        return DAOMySQL.getInstance().saveSecretaire(secretaire);
    }

    @Override
    public boolean addPersonnel(Personnel personne) {
        // TODO
        return DAOMySQL.getInstance().addPersonnel(personne);
    }

    @Override
    public boolean deleteSecretaire(Secretaire secretaire) {
       return DAOMySQL.getInstance().deleteSecretaire(secretaire);
    }

    public void initDB() {
        DAOMySQL.getInstance();
    }

    @Override
    public List<Medecin> getListMedecin() {
        return DAOMySQL.getInstance().getListMedecin();
    }

    @Override
    public boolean addMedecin(Medecin medecin) {
        return DAOMySQL.getInstance().addMedecin(medecin);
    }

}
