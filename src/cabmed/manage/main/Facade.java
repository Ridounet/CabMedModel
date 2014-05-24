package cabmed.manage.main;

import cabmed.manage.ctrl.CtrlPrincipal;
import cabmed.ressources.Observer;
import java.util.List;
import cabmed.dao.*;
import cabmed.model.Administrateur;
import cabmed.model.Cp;
import cabmed.model.Infirmiere;
import cabmed.model.Medecin;
import cabmed.model.Patient;
import cabmed.model.Personnel;
import cabmed.model.Secretaire;
import cabmed.model.Specialisation;
import java.util.ArrayList;

public class Facade implements IPersonnelDAO, IMedecinDAO, ISpecialisationDAO, ICpDAO, IPatientDAO {
    
    private final CtrlPrincipal ctrl;
    
    public Facade(CtrlPrincipal ctrlPrincipal) { this.ctrl = ctrlPrincipal; }
    
    // Pattern Observer
    private static final List<Observer> listObservers = new ArrayList<>();
    private static void notifyObservers() {
        for (Observer o: listObservers) {
            o.update();
        }
    }
    public static void addObserver(Observer o) {
        listObservers.add(o);
    }
    
    // Généralités
    public void initDB() {
        DAOMySQL.getInstance();
    }
    
    public Administrateur loginAdmin(String login, String password) {
        return DAOMySQL.getInstance().loginAdmin(login, password);
    }
    
    public Medecin loginMedecin(String login, String password) {
        return DAOMySQL.getInstance().loginMedecin(login, password);
    }
    
    public Secretaire loginSecretaire(String login, String password) {
        return DAOMySQL.getInstance().loginSecretaire(login, password);
    }
    
    public Infirmiere loginInfirmiere(String login, String password) {
        return DAOMySQL.getInstance().loginInfirmiere(login, password);
    }
    
    public Patient loginPatient(String login, String password) {
        return DAOMySQL.getInstance().loginPatient(login, password);
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
    public List<Specialisation> getListSpecialisation() {
        return DAOMySQL.getInstance().getListSpecialisation();
    }
    
    // Medecin
    

    @Override
    public boolean saveMedecin(Medecin medecin) {
        // TODO
        return DAOMySQL.getInstance().saveMedecin(medecin);
    }

    
    
    
    
    
    
    // Pas pour cette façade
    @Override public boolean addInfirmiere(Infirmiere infirmiere) { return false; }
    @Override public boolean addSecretaire(Secretaire secretaire) { return false; }
    @Override public boolean deleteSecretaire(Secretaire secretaire) { return false; }
    @Override public boolean savePersonnel(Personnel personne) { return false; }
    @Override public List<Secretaire> getListSecretaire() { return null; }
    @Override public List<Infirmiere> getListInfirmiere() { return null; }
    @Override public boolean deleteMedecin(Medecin medecin) { return false; }
    @Override public boolean addMedecin(Medecin medecin) { return false; }

    @Override
    public boolean removeSpecialisationPourMedecin(Medecin med, int selectedIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addSpecialisationAMedecin(Medecin medecin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteInfirmiere(Infirmiere infirmiere) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteSpecialisation(Specialisation specialisation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean savePatient(Patient patient) {
        return DAOMySQL.getInstance().savePatient(patient);
    }

    @Override
    public Patient getPatientByRegistreNat(String registreNat) {
        return DAOMySQL.getInstance().getPatientByRegistreNat(registreNat);
    }
    
}
