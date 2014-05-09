package cabmed.admin.main;

import cabmed.admin.ctrl.CtrlPrincipal;
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

public class Facade implements IPersonnelDAO, IMedecinDAO, ISpecialisationDAO, ICpDAO {
    
    private final CtrlPrincipal ctrl;
    
    public Facade(CtrlPrincipal ctrlPrincipal) { this.ctrl = ctrlPrincipal; }
    
    // Pattern Observer
    private static final List<Observer> listObservers = new ArrayList<>();
    private static void notifyObservers() {
        listObservers.stream().forEach((ob) -> {
            ob.update();
        });
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

    @Override
    public List<Cp> getListCp() {
        return DAOMySQL.getInstance().getListCp();
    }
    
    @Override
    public List<Medecin> getListMedecin() {
        return DAOMySQL.getInstance().getListMedecin();
    }
    
    @Override
    public List<Secretaire> getListSecretaire() {
        return DAOMySQL.getInstance().getListSecretaire();
    }

    @Override
    public List<Infirmiere> getListInfirmiere() {
        return DAOMySQL.getInstance().getListInfirmiere();
    }

    @Override
    public List<Specialisation> getListSpecialisation() {
        return DAOMySQL.getInstance().getListSpecialisation();
    }
    
    // Medecin
    @Override
    public boolean deleteMedecin(Medecin med) {
        if (DAOMySQL.getInstance().deleteMedecin(med)) {
            ctrl.setListMedecin(getListMedecin());
            notifyObservers();
            return true;
        }
        return false;
    }

    @Override
    public boolean saveMedecin(Medecin medecin) {
        // TODO
        return DAOMySQL.getInstance().saveMedecin(medecin);
    }
    
    @Override
    public boolean addMedecin(Medecin medecin) {
        if (DAOMySQL.getInstance().addMedecin(medecin)) {
            ctrl.addMedecin(medecin);
            notifyObservers();
            return true;
        }
        return false;
    }

    // Personnel
    @Override
    public boolean addInfirmiere(Infirmiere infirmiere) {
        if (DAOMySQL.getInstance().addInfirmiere(infirmiere)) {
            ctrl.addInfirmiere(infirmiere);
            notifyObservers();
            return true;
        }
        return false;
    }

    @Override
    public boolean addSecretaire(Secretaire secretaire) {
        if (DAOMySQL.getInstance().addSecretaire(secretaire)) {
            ctrl.addSecretaire(secretaire);
            notifyObservers();
            return true;
        }
        return false;
    }

    @Override
    public boolean savePersonnel(Personnel personne) {
        // TODO
        return DAOMySQL.getInstance().savePersonnel(personne);
    }

    @Override
    public boolean deleteSecretaire(Secretaire secretaire) {
        if (DAOMySQL.getInstance().deleteSecretaire(secretaire)) {
            ctrl.setListSecretaire(getListSecretaire());
            notifyObservers();
            return true;
        }
        return false;
    }
}
