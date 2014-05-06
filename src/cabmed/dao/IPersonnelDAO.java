package cabmed.dao;

import cabmed.model.Infirmiere;
import cabmed.model.Personnel;
import cabmed.model.Secretaire;
import java.util.List;

public interface IPersonnelDAO {
    public boolean addInfirmiere(Infirmiere infirmiere);
    public boolean addSecretaire(Secretaire secretaire);
    public boolean deleteSecretaire(Secretaire secretaire);
    public boolean savePersonnel(Personnel personne);
    public List<Secretaire> getListSecretaire();
    public List<Infirmiere> getListInfirmiere();
}
