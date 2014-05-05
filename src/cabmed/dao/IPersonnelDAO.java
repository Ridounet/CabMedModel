package cabmed.dao;

import cabmed.model.Infirmiere;
import cabmed.model.Personnel;
import cabmed.model.Secretaire;

public interface IPersonnelDAO {
    public boolean saveInfirmiere(Infirmiere infirmiere);
    public boolean saveSecretaire(Secretaire secretaire);
    public boolean deleteSecretaire(Secretaire secretaire);
    public boolean addPersonnel(Personnel personne);
}
