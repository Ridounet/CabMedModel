package cabmed.dao;

import cabmed.model.*;
import java.util.List;


public abstract class CabMedAbstractDAO {
    
    // CRUD Personne
    public abstract boolean savePatient(Patient patient);
    public abstract boolean saveMedecin(Medecin medecin, Planning planning);
    public abstract boolean savePersonnel(Personnel personnel);
    
    // CRUD Cp
    public abstract List<Cp> getListCp();
    public abstract List<Cp> getListCpByCodePostal(int codePostal);
    
    // CRUD Planning
    public abstract boolean savePlanning(Planning planning);
    public abstract Planning getPlanningByMedecin(Medecin medecin);
    
}