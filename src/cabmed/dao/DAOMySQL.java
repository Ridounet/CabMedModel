package cabmed.dao;

import cabmed.model.Cp;
import cabmed.model.Medecin;
import cabmed.model.Patient;
import cabmed.model.Personnel;
import cabmed.model.Planning;
import java.util.List;

public class DAOMySQL {

    // CRUD Personne
    public static boolean savePatient(Patient patient) {
        return getPatientDAO().savePatient(patient);
    }
    
    public static boolean saveMedecin(Medecin medecin, Planning planning) {
        
        return true;
    }
    
    public static boolean savePersonnel(Personnel personnel) {
        
        return true;
    }
    
    // CRUD Cp
    public static List<Cp> getListCp() {
        
        return null;
    }
    
    public static List<Cp> getListCpByCodePostal(int codePostal) {
        
        return null;
    }
    
    // CRUD Planning
    public static boolean savePlanning(Planning planning) {
        
        return true;
    }
    
    public static Planning getPlanningByMedecin(Medecin medecin) {
        
        return null;
    }
    
    
    
    
    
    
    
    
    
    private static CpDAO cpDAO = new CpDAO();
    private static MedecinDAO medecinDAO = new MedecinDAO();
    private static PatientDAO patientDAO = new PatientDAO();
    private static PersonnelDAO personnelDAO = new PersonnelDAO();
    private static PlanningDAO panningDAO = new PlanningDAO();
    
    private static CpDAO getCpDAO() { if (cpDAO == null) cpDAO = new CpDAO(); return cpDAO; }
    private static MedecinDAO getMedecinpDAO() { if (medecinDAO == null) medecinDAO = new MedecinDAO(); return medecinDAO; }
    private static PatientDAO getPatientDAO() { if (patientDAO == null) patientDAO = new PatientDAO(); return patientDAO; }
    private static PersonnelDAO getPersonnelDAO() { if (personnelDAO == null) personnelDAO = new PersonnelDAO(); return personnelDAO; }
    private static PlanningDAO getPlanningDAO() { if (panningDAO == null) panningDAO = new PlanningDAO(); return panningDAO; }
}