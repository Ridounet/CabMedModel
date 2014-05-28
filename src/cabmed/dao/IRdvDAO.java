package cabmed.dao;

import cabmed.model.Patient;
import cabmed.model.Rdv;
import java.util.List;

public interface IRdvDAO {
    public List<Rdv> getRdvPatient(Patient patient);
    public boolean updateRdv(Rdv rdv);
    public Rdv getRdvParId(int idRdv);
}
