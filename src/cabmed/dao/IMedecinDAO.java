package cabmed.dao;

import cabmed.model.Medecin;
import java.util.List;

public interface IMedecinDAO {
    public boolean deleteMedecin(Medecin medecin);
    public boolean saveMedecin(Medecin medecin);
    public boolean addMedecin(Medecin medecin);
    public List<Medecin> getListMedecin();
}
